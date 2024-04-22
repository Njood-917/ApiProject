package testData;

import java.util.HashMap;
import java.util.Map;

public class BookerTestData {

    // this method creates a map for bookingDates . inner map
    public static Map<String, String> bookingDatesMethod(String checkin, String checkout) {
        Map<String, String> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin", checkin);
        bookingDatesMap.put("checkout", checkout);
        return bookingDatesMap;


    }


    //this method creates the expected data for booker , outer map
    public static Map<String, Object> expectedDataMethod(String firstname, String lastname, Integer totalprice, Boolean depositpaid, Map<String, String> bookingDatesMap, String additionalneeds) {
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", firstname);
        expectedData.put("lastname", lastname);
        expectedData.put("totalprice", totalprice);
        expectedData.put("depositpaid", depositpaid);
        expectedData.put("bookingdates", bookingDatesMap);
        expectedData.put("additionalneeds", additionalneeds);

        return expectedData;

    }
}