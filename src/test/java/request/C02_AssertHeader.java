package request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
/*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
*/
public class C02_AssertHeader {
    @Test
    public void assertHeaderMethod(){
        // User sends a GET Request to the url
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");
        response.prettyPrint();

        //HTTP Status Code should be 200
        response.then().statusCode(200);
        //        Content Type should be JSON
        response.then().contentType("application/json");

//        Status Line should be HTTP/1.1 200 OK
        response.then().statusLine("HTTP/1.1 200 OK");

//        Connection should be keep-alive
        response.then().header("Connection","keep-alive");

    }
    }

