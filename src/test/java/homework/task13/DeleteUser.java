package homework.task13;

import base_urls.UserBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class DeleteUser extends UserBaseUrl {

        @Test
        void testDeleteUser () {
            //Set the url
            spec.pathParams("first", "user", "second", "reema1");

            //Send DELETE request to delete the user
            Response response = given(spec).delete("{first}/{second}");

            //Do Assertion
            assertEquals(response.getStatusCode(), 200);
        }
    }
