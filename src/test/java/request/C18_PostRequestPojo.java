package request;

import base_urls.JsonPlaceHolderBaseUrl;
import org.testng.annotations.Test;
import pojos.JsonPlaceHolderPojo;

public class C18_PostRequestPojo extends JsonPlaceHolderBaseUrl {
    /*
     Given
        https://jsonplaceholder.typicode.com/todos
        {
        "userId": 55,
        "title": "Tidy your room",
        "completed": false
        }
    When
        I send POST Request to the Url
    Then
        Status code is 201
    And
        response body is like {
                                "userId": 55,
                                "title": "Tidy your room",
                                "completed": false,
                                "id": 201
                                }
*/

    @Test
    public void postRequestPojoTest(){
        //Set the Url
        spec.pathParams("first" , "todos");

        //Set expected Data -- with pojo class
       JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(55 ,"Tidy your room" , false);
        System.out.println("expectedData = " + expectedData);






    }


}

