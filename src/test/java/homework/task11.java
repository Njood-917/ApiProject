package homework;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12

    Note: Print using JsonPath: response.jsonPath().prettyPrint();

*/
public class task11 {
    @Test
    public void test() {
        // Send a GET request to the API endpoint
        Response response = RestAssured.get("https://automationexercise.com/api/productsList");
        // Print the JSON response
        response.jsonPath().prettyPrint();
        // Convert the response to JSON path
        JsonPath jsonPath = response.jsonPath();

        // Get the list and Do assertion
        int numberOfWomenUserType = jsonPath.getList("products.findAll{it.category.usertype.usertype=='Women'}").size();
        System.out.println("numberOfWomenUserType = " + numberOfWomenUserType);

        assertEquals(numberOfWomenUserType , 12);
    }
}