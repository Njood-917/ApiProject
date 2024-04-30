package homework.task13;

import base_urls.UserBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class CreateUser extends UserBaseUrl {
    @Test
    void test(){
        //Set the url
        spec.pathParams("first" , "user");
        //Set expected Data
        String strJson = """
                {
                  "id": 11,
                  "username": "reema1",
                  "firstName": "reema",
                  "lastName": "meshael",
                  "email": "rm@gmail.com",
                  "password": "123456",
                  "phone": "556688",
                  "userStatus": 0
                }
                """;

        UserPojo expectedData = ObjectMapperUtils.convertJsonToJava(strJson , UserPojo.class);
        System.out.println("expectedData = " + expectedData);
        //Set the request and get the response
       Response response = given(spec).body(expectedData).post("{first}");
       response.prettyPrint();
       //Do Assertion
        assertEquals(response.statusCode(),200);
        assertEquals(response.path("message"), "11");
        assertEquals(response.path("type"), "unknown");

    }
}
