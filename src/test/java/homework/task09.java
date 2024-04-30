package homework;

import base_urls.UserBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import testData.JsonPlaceHolderTestData;
import testData.JsonPlaceHolderUserTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/*
        Given
            1) https://petstore.swagger.io/v2/user

        When
            I send POST Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                               {
  "id": 1,
  "username": "john01",
  "firstName": "John",
  "lastName": "Doe",
  "email": "John101@gmail.com",
  "password": "123456",
  "phone": "654321",
  "userStatus": 1
}
                                              }
     */
public class task09 extends UserBaseUrl {
    @Test
    public void test(){
        //Set the Url
        spec.pathParams("first", "user");

        // create an empty map and assign values
        Map<String , Object> expectedData = JsonPlaceHolderUserTestData.expectedDataMap(1,"john01" ,"John" , "Doe" ,
              "John101@gmail.com" ,"123456" ,  "654321" ,1  );

        //Send the request and post the response
        Response response = given(spec)
                .body(expectedData)
                .post("{first}");
        response.prettyPrint();
   // Assertions
        response
                .then()
                .statusCode(200)
                .body("message", equalTo("1")
                        );

    }

}
