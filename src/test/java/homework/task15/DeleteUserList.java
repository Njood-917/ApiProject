package homework.task15;

import base_urls.UserListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DeleteUserList extends UserListBaseUrl {
    @Test
    void updateBookingTest() {
        spec.pathParams("first", "users", "second", "me");

        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();

        assertEquals(200, response.statusCode());
        assertTrue(response.asString().isEmpty());

    }
}
