package request;


import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import testData.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

/*
    Given
        1) https://jsonplaceholder.typicode.com/todos/198
        2) {
             "title": "Read Books"
           }
    When
        I send PATCH Request to the Url
    Then
       Status code is 200
       And response body is like  {
                                        "userId": 10,
                                        "id": 198,
                                        "title": "Read Books",
                                        "completed": true
                                    }
*/
public class C14_PatchRequest extends JsonPlaceHolderBaseUrl{

    @Test
    public void PatchRequestTest(){
        //Set the url
        spec.pathParams("first", "todos", "second","198");

        //Set the expected Data
        Map<String ,Object> expectedData = JsonPlaceHolderTestData.expectedDataMap2(null , "Red Books" , null);
        System.out.println("expectedData = " + expectedData);

        // Send and get response
        Response response = given(spec).body(expectedData).patch("{first}/{second}");
        response.prettyPrint();

        //Do Assertions
        Map<String , Object> actualData = response.as(Map.class);// De-Serialization to convert json to map
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        // we only need to assert what we changed
        assertEquals(actualData.get("title"), expectedData.get("title"));



    }
}
