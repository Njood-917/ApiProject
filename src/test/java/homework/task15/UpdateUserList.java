package homework.task15;

import base_urls.UserListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.ContactListUsers.UsersPojo;
import pojos.UserPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class UpdateUserList extends UserListBaseUrl {
    @Test
    void test() {
        //Set the url
        spec.pathParams("first", "users", "second", "me");

        //Set expected Data
        String strJson = """
                 {
                    "firstName": "updated",
                    "lastName": "User",
                    "email": "tiop55566###23$$3@hotm.com",
                    "password": "myPassword"
                }
                """;


        UsersPojo expectedData = ObjectMapperUtils.convertJsonToJava(strJson, UsersPojo.class);
        System.out.println("expectedData = " + expectedData);
        //Set the request and get the response
        Response response = given(spec).body(expectedData).patch("{first}/{second}/");
        response.prettyPrint();
        //Do Assertion

        UsersPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), UsersPojo.class);
        assertEquals(response.statusCode(), 200);
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());

    }
}