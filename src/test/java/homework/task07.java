package homework;

import base_urls.HomeworkBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

/*
      Given
             https://reqres.in/api/unknown/
      When
           I send GET Request to the URL
      Then

           1)Status code is 200
           2)Print all pantone_values
           3)Print all ids greater than 3 on the console
             Assert that there are 3 ids greater than 3
           4)Print all names whose ids are less than 3 on the console
             Assert that the number of names whose ids are less than 3 is 2
   */
public class task07 extends HomeworkBaseUrl {
    @Test
    public void test() {
        //Set the Url
        spec.pathParams("first", "api", "second", "unknown");

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}/");
        response.prettyPrint();

        // Assertions
        JsonPath jsonPath = response.jsonPath();

        //1)Status code is 200
        response.then().statusCode(200);

        //2)Print all pantone_values
        List<Object> pantonevaluesList = jsonPath.getList("data.findAll{it.pantone_value}.pantone_value");
        System.out.println("pantonevaluesList = " + pantonevaluesList);

        //3)Print all ids greater than 3 on the console,Assert that there are 3 ids greater than 3
        List<Integer> idsGreaterThan3 = jsonPath.getList("data.findAll{it.id>3}.id");
        System.out.println("idsGreaterThan3 = " + idsGreaterThan3);
        assertEquals(idsGreaterThan3.size(),3);

        //Print all names whose ids are less than 3 on the console,Assert that the number of names whose ids are less than 3 is 2
        List<String> listNames = jsonPath.getList("data.findAll{it.id<3}.name");
        System.out.println("listNames = " + listNames);
        assertEquals(listNames.size(), 2);


    }
}
