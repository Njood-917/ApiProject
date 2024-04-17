package homework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;


/*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */
public class task03 {
@Test
    public void test(){
    Response response = RestAssured.get("https://reqres.in/api/users/3");
    response.prettyPrint();
    // Assertions
    response
            .then()
            .statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");
}
}
