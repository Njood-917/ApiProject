package petstore_pet;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

/*
     Given
       1) https://petstore.swagger.io/v2/pet
       2)  {
              "id": 98765432,
              "category": {
                "id": 0,
                "name": "Cat"
              },
              "name": "Cotton",
              "photoUrls": [
                "string"
              ],
              "tags": [
                {
                  "id": 0,
                  "name": "Kitty"
                }
              ],
              "status": "available"
            }
    When
        I send POST Request to the Url

    Then
        Status code is 200
    And
        response body is like {
                          "id": 98765432,
                          "category": {
                            "id": 0,
                            "name": "Cat"
                          },
                          "name": "Cotton",
                          "photoUrls": [
                            "string"
                          ],
                          "tags": [
                            {
                              "id": 0,
                              "name": "Kitty"
                            }
                          ],
                          "status": "available"
                        }
*/
public class R01_CreatePet extends PetStoreBaseUrl {

    @Test
    void postTest(){
        //Set the url
        spec.pathParams("first", "pet");

        //Set the expected Data
        String strJson = """
                {
                              "id": 98765432,
                              "category": {
                                "id": 0,
                                "name": "Cat"
                              },
                              "name": "Cotton",
                              "photoUrls": [
                                "string"
                              ],
                              "tags": [
                                {
                                  "id": 0,
                                  "name": "Kitty"
                                }
                              ],
                              "status": "available"
                            }
                """;

      PetPojo expectedData = ObjectMapperUtils.convertJsonToJava(strJson, PetPojo.class);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do Assertion
        PetPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),PetPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(),200);
        assertEquals(actualData.getId(),expectedData.getId());
        assertEquals(actualData.getName(),expectedData.getName());
        assertEquals(actualData.getPhotoUrls(),expectedData.getPhotoUrls());
        assertEquals(actualData.getTags().getFirst().getName(),expectedData.getTags().getFirst().getName());
    }
}
