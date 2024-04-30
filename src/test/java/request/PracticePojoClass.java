package request;

import base_urls.BookerBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

/*
 Given
     1) https://restful-booker.herokuapp.com/booking
     2) {
             "firstname": "Jane",
             "lastname": "Doe",
             "totalprice": 111,
             "depositpaid": true,
             "bookingdates": {
                 "checkin": "2018-01-01",
                 "checkout": "2019-01-01"
             },
             "additionalneeds": "Extra pillows please"
         }
 When
     I send POST Request to the Url
 Then
     Status code is 200
     And response body should be like {
                                         "bookingid": 2243,
                                         "booking":{
                                                     "firstname": "Jane",
                                                     "lastname": "Doe",
                                                     "totalprice": 111,
                                                     "depositpaid": true,
                                                     "bookingdates": {
                                                         "checkin": "2018-01-01",
                                                         "checkout": "2019-01-01"
                                                     },
                                                     "additionalneeds": "Extra pillows please"
                                                 }
                                          }
*/
public class PracticePojoClass extends BookerBaseUrl {
    @Test
    void test01(){
        //Set the url
        spec.pathParams("first","booking");

        //Set the expected Data
        String strJson = """
                {
                             "firstname": "Jane",
                             "lastname": "Doe",
                             "totalprice": 111,
                             "depositpaid": true,
                             "bookingdates": {
                                 "checkin": "2018-01-01",
                                 "checkout": "2019-01-01"
                             },
                             "additionalneeds": "Extra pillows please"
                         }
                """;

        BookingPojo expectedData = ObjectMapperUtils.convertJsonToJava(strJson , BookingPojo.class);
        System.out.println("expectedData = " + expectedData);

        //Set the request and get the response
      Response response = given(spec).body(expectedData).post("{first}");
      response.prettyPrint();

      //Do Assertion
       BookingResponsePojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString() , BookingResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(),200);
        assertEquals(actualData.getBooking().getFirstname(), expectedData.getFirstname());
        assertEquals(actualData.getBooking().getLastname(), expectedData.getLastname());
        assertEquals(actualData.getBooking().getTotalprice(), expectedData.getTotalprice());
        assertEquals(actualData.getBooking().getDepositpaid(), expectedData.getDepositpaid());
        assertEquals(actualData.getBooking().getBookingdates().getCheckin(), expectedData.getBookingdates().getCheckin());
        assertEquals(actualData.getBooking().getBookingdates().getCheckout(), expectedData.getBookingdates().getCheckout());
        assertEquals(actualData.getBooking().getAdditionalneeds(), expectedData.getAdditionalneeds());


    }
}
