package request;
/*
        Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
            "Abhaidev Kaur", "Fr. Deenabandhu Adiga", "Akshita Singh DC" are among the users -> Bu data değişken
        And
            The female users are less than or equals to male users -> Bu data değişken
*/

import base_urls.GetRestBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;

public class C29_GroovyGetRequest extends GetRestBaseUrl {
    @Test
    void test(){
        //Set the url
        spec.pathParams("first", "users");

        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //Do Assertion
        response
                .then()
                .statusCode(200)//Satus code is 200
                .body(
                        "meta.pagination.limit", equalTo(10),//The value of "pagination limit" is 10
                        "meta.pagination.links.current", equalTo("https://gorest.co.in/public/v1/users?page=1"), //"https://gorest.co.in/public/v1/users?page=1"
                        "data", hasSize(10),//The number of users should  be 10
                        "data.status", hasItem("active"),//We have at least one "active" status
                        "data.name", hasItems("Vasudev Mehra", "Kanishka Banerjee", "Girindra Pilla")// Vasudev Mehra, Kanishka Banerjee, Girindra Pilla, Purnima Joshi DVM are among the users
                );

        List<String> femaleList = response.jsonPath().getList("data.findAll{it.gender=='female'}.name");//Use findAll{} where the list starts. It starts as 'data' key's value
        List<String> maleList = response.jsonPath().getList("data.findAll{it.gender=='male'}.name");
        System.out.println("femaleList = " + femaleList);
        System.out.println("maleList = " + maleList);

        assertTrue(femaleList.size() <= maleList.size());//The female users are less than or equals to male users -> This may change


    }

    }


