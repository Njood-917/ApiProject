package homework.task15;


import base_urls.UserListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.ContactListUsers.UsersPojo;

import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetUserList extends UserListBaseUrl {

        @Test
        void test(){
            //Set the url
            spec.pathParams("first", "users" , "second", "me");


            UsersPojo expectedData = new UsersPojo("firstname", "lastname",null, "email");
            System.out.println("expectedData = " + expectedData);
            //Set the request and get the response
            Response response = given(spec).get("{first}/{second}");
            response.prettyPrint();
            //Do Assertion
            UsersPojo actualData = response.as( UsersPojo.class);
            System.out.println("actualData = " + actualData);
            assertEquals(200, response.statusCode());
            assertEquals(actualData.getFirstName(),expectedData.getFirstName());


        }
    }


