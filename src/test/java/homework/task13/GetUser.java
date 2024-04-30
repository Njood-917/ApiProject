package homework.task13;

import base_urls.UserBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetUser extends UserBaseUrl {
    @Test
    void test(){
        //Set the url
        spec.pathParams("first", "user" , "second", "reema1");
        //Set expected Data
        String strJSON = """
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

        UserPojo expectedData = ObjectMapperUtils.convertJsonToJava(strJSON , UserPojo.class);
        System.out.println("expectedData = " + expectedData);
        //Set the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();
        //Do Assertion
        UserPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), UserPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(expectedData.getUsername(), actualData.getUsername());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
    }
}
