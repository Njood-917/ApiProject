package homework;

import base_urls.HomeworkBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */
public class task08 extends HomeworkBaseUrl {
    @Test
    public void test(){

        //Set the Url
        spec.pathParams("first" , "api" , "second", "users");

       // create an empty map and assign values
        Map<String , Object> expectedData = new HashMap<>();
        expectedData.put("name" , "morpheus");
        expectedData.put("job" , "leader");

        //Send the request and post the response
        Response response = given(spec)
                .body(expectedData)
                .post("{first}/{second}/");
        response.prettyPrint();

        // Assertions
        response
                .then()
                .statusCode(201)
                .body("name", equalTo(expectedData.get("name"))
                        ,"job", equalTo(expectedData.get("job"))
                        );
    }

}
