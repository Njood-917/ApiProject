package request;

/*
    Given
       https://restful-booker.herokuapp.com/booking
    When
       User sends a GET request to the URL
    Then
       Status code is 200
    And
       Among the data, there should be someone whose first name is "Mark" and last name is "Brown"
*/

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C08_Practice {
    @Test
    public void  test01(){
        //   1. Set the URL

        String url = "https://restful-booker.herokuapp.com/booking";

//        2. Set the expected data


//        3. Send the request and get the response
        Response response = given().get(url);
        response.prettyPrint();


//        4. Do Assertion
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                ;

    }
}
