package request;


import base_urls.GetRestBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.GoRestPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C30_PojoGenerator extends GetRestBaseUrl {

    /*
Given
    https://gorest.co.in/public/v1/users?id=6880236
When
    User sends GET request
Then
    HTTP Status Code should be 200
And
    Response body should be like:
        {
            "meta": {
                "pagination": {
                    "total": 1,
                    "pages": 1,
                    "page": 1,
                    "limit": 10,
                    "links": {
                        "previous": null,
                        "current": "https://gorest.co.in/public/v1/users?page=1",
                        "next": null
                    }
                }
            },
            "data": [
                {
                    "id": 6880236,
                    "name": "Pres. Abhaya Sinha",
                    "email": "pres_sinha_abhaya@kovacek.test",
                    "gender": "male",
                    "status": "inactive"
                }
            ]
        }
 */
// To use Object Mapper with pojo is the best practice
    @Test
    void pojoGeneratorTest(){
        //Set the url
        spec.pathParams("first" , "users").queryParams("id" ,"6880236");

        //Set the expected Data

        String strJson = """
                    {
                            "meta": {
                                "pagination": {
                                    "total": 1,
                                    "pages": 1,
                                    "page": 1,
                                    "limit": 10,
                                    "links": {
                                        "previous": null,
                                        "current": "https://gorest.co.in/public/v1/users?page=1",
                                        "next": null
                                    }
                                }
                            },
                            "data": [
                                {
                                    "id": 6880236,
                                    "name": "Pres. Abhaya Sinha",
                                    "email": "pres_sinha_abhaya@kovacek.test",
                                    "gender": "male",
                                    "status": "inactive"
                                }
                            ]
                        }
                
                """;


      GoRestPojo expectedData = ObjectMapperUtils.convertJsonToJava(strJson , GoRestPojo.class);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get Response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //Do Assertion
        GoRestPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),GoRestPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);

        assertEquals(actualData.getMeta().getPagination().getLimit(), expectedData.getMeta().getPagination().getLimit());
        assertEquals(actualData.getMeta().getPagination().getLinks().getCurrent(), expectedData.getMeta().getPagination().getLinks().getCurrent());

        assertEquals(actualData.getData().getFirst().getId(), expectedData.getData().getFirst().getId());
        assertEquals(actualData.getData().getFirst().getName(), expectedData.getData().getFirst().getName());
        assertEquals(actualData.getData().getFirst().getEmail(), expectedData.getData().getFirst().getEmail());
        assertEquals(actualData.getData().getFirst().getGender(), expectedData.getData().getFirst().getGender());
        assertEquals(actualData.getData().getFirst().getStatus(), expectedData.getData().getFirst().getStatus());






    }

}





