package homework.task15;

import base_urls.UserListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.ContactListUsers.UsersPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class CreateUserList extends UserListBaseUrl {

    @Test
    void test(){
        //Set the url
        spec.pathParams("first", "users");

        //Set the expected Data
        String strJson = """
                {
                    "firstName": "Test",
                    "lastName": "User",
                    "email": "tiop5559966###23$$3@hotm.com",
                    "password": "myPassword"
                }
                """;

        UsersPojo expectedData = ObjectMapperUtils.convertJsonToJava(strJson,UsersPojo.class);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}");

        response.prettyPrint();

        //Do Assertion
        UsersPojo actualData = ObjectMapperUtils.convertJsonToJava(response.getBody().asString(),UsersPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201, response.statusCode());
        assertEquals(actualData.getFirstName(), expectedData.getFirstName());

    }
}
