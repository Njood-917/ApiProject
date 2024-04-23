package homework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

//Write an automation test that will create, read, update, delete a 'pet' using the "https://petstore.swagger.io/" document
//(All actions must be done on same pet)
// (Use Pojo)
public class task12 {
    @Test
    public void createPetTest(){
        //Set the url
         String url = ("https://petstore.swagger.io/v2/pet");

        //Set the expected data --> With Pojo Class
        PetPojo expectedData = new PetPojo(15151515 , "pet1" , "available");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
       Response response=  given().contentType(ContentType.JSON).body(expectedData).post(url);
       response.prettyPrint();

       //Do Assertion
        PetPojo actualData = response.as(PetPojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.getName(), actualData.getName());

    }
    @Test
    public void updatePetTest(){
        //Set the url
        String url = ("https://petstore.swagger.io/v2/pet");

        //Set the expected data --> With Pojo Class
        PetPojo expectedData = new PetPojo(15 , "pet1" , "not available");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response=  given().contentType(ContentType.JSON).body(expectedData).put(url);
        response.prettyPrint();

        //Do Assertion
        PetPojo actualData = response.as(PetPojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.getStatus(), actualData.getStatus());

    }
    @Test
    public void deletePetTest(){
        //Set the url
        String url = ("https://petstore.swagger.io/v2/pet/15151515");

        //Send the request and get the response
        Response response=  given().delete(url);
        response.prettyPrint();

        //Do Assertion
        assertEquals(response.statusCode(),200);

    }
}
