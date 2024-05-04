package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import static utilities.Authentication.generateToken;

public class UserListBaseUrl {

        protected RequestSpecification spec;//This is null in this line, setUp() method should run before using this.

        @BeforeMethod //Runs before each @Test
        public void setUp(){

            spec = new RequestSpecBuilder()
                    .setBaseUri("https://thinking-tester-contact-list.herokuapp.com")
                    .addHeader("Cookie","token="+generateToken())//generateToken() method will create a fresh token for each run.
                    .setContentType(ContentType.JSON)
                    .build();

            //We don't need to add all these in each request. Just once we add them in spec object and they will be added when we use spec object.
        }
    }

