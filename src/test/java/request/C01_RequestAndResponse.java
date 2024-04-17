package request;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
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

         Print connection and Date headers on Console

      Print all headers on console
*/
public class C01_RequestAndResponse {
    public static void main(String[] args) {
//        https://restful-booker.herokuapp.com/booking

//        User sends a GET Request to the url
        // RestAssured library is used to send request and get the response
        Response response =  RestAssured.get("https://restful-booker.herokuapp.com/booking");
//        response.prettyPrint();

//        HTTP Status Code should be 200
       int statusCode =  response.statusCode();
        System.out.println("statusCode" + statusCode);

//        Content Type should be JSON
       String contentType=  response.contentType();
        System.out.println("contentType = " + contentType);

//        Status Line should be HTTP/1.1 200 OK
        String statusLine = response.statusLine();
        System.out.println("statusLine = " + statusLine);

        // Print connection and Date headers on Console
       String Connection =  response.header("Connection");
       String Date =  response.header("Date");
        System.out.println("\nConnection = " + Connection);
        System.out.println("\nDate = " + Date);

        // Print all headers on console
       Headers headers =  response.headers();
        System.out.println("\nheaders = " + headers);

    }
}
