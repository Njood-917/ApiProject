package request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class C03_AssertHeaderAndBody {

/*
   Given
       https://restful-booker.herokuapp.com/booking/0
   When
       User sends a GET Request to the URL
   Then
       HTTP Status code should be 404
   And
       Status Line should be HTTP/1.1 404 Not Found
   And
       Response body contains "Not Found"
   And
       Response body does not contain "Clarusway"
   And
       Server is "Cowboy"
*/

    @Test
    public void assertionMethod() {
//        https://restful-booker.herokuapp.com/booking/0

//        User sends a GET Request to the URL
        Response response = RestAssured.get(" https://restful-booker.herokuapp.com/booking/0");
        response.prettyPrint();


//        HTTP Status code should be 404
        // first way
        response
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server", "Cowboy");

//        Status Line should be HTTP/1.1 404 Not Found

//        Response body contains "Not Found"
        // second way
        String stringBody = response.asString();
        System.out.println("stringBody = " + stringBody);
      boolean isContain = stringBody.contains("Not Found");
      assertTrue(isContain);

//        Response body does not contain "Clarusway"
    assertFalse(stringBody.contains("Clarusway"));

//        Server is "Cowboy"
        //second way
        String server = response.header("Server");
        assertEquals(server , "Cowboy");


    }


}