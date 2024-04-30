package request;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ObjectMapperUtils;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Practice_monitoring {
    private RequestSpecification spec;
    @BeforeMethod
    public void setUp() {
         spec = new RequestSpecBuilder().setContentType(ContentType.JSON)
                .addHeader("X-RapidAPI-Key", "193fe7b932mshd018473dd984abbp13ba61jsn7f8835a09401")
                        .addHeader("X-RapidAPI-Host", "community-zippopotamus.p.rapidapi.com")
                .setBaseUri("https://community-zippopotamus.p.rapidapi.com")
                .build();
    }
    @Test
    void test(){
        String strJson = """
                {
                    "post code": "90210",
                    "country": "United States",
                    "country abbreviation": "US",
                    "places": [
                        {
                            "place name": "Beverly Hills",
                            "longitude": "-118.4065",
                            "state": "California",
                            "state abbreviation": "CA",
                            "latitude": "34.0901"
                        }
                    ]
                    }
                """;

     HashMap<String, Object>expectedData= ObjectMapperUtils.convertJsonToJava(strJson, HashMap.class);
        System.out.println("expectedData = " + expectedData);

        //Set the request and get the response
        Response response = given(spec).get("https://community-zippopotamus.p.rapidapi.com/us/90210");
        response.prettyPrint();
        //Do assertion
        HashMap<String, Object> actualData= ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.get("post code"), actualData.get("post code"));
        



    }



    }

