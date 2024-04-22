package homework;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

//Using the https://petstore.swagger.io/ document,
// write an automation test that finds the number of "pets" with the status "available"
// and asserts that there are more than 100.
public class task10 {
    @Test
    public void statusTest(){

        //Set the url and get the response
        Response response = RestAssured.get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
        response.prettyPrint();

        // Convert the response to json path
        JsonPath jsonPath = response.jsonPath();

        // Get the list of availablePets
        List<String> availablePets = jsonPath.getList("name");
        System.out.println("availablePets = " + availablePets);

        //Do Assertion
        int numberOfList = availablePets.size();
        System.out.println("numberOfList = " + numberOfList);

        assertTrue(numberOfList >100 ,"Expected more than 100 available pets, but found " + numberOfList);






    }
}
