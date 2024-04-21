package testData;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {
    public static Map<String , Object> expectedDataMap(String name , String job) {
        Map<String , Object> expectedData = new HashMap<>();
        expectedData.put("name", "name");
        expectedData.put("job", "job");
         return expectedData;


    }
}
