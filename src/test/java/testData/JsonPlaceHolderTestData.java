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
    public static Map<String, Object> expectedDataMap2(Integer userId, String title, Boolean completed) {

        Map<String, Object> expectedData2 = new HashMap<>();
        if (userId!=null){
            expectedData2.put("userId", userId);
        }
        if (title!=null){
            expectedData2.put("title", title);
        }
        if (completed!=null){
            expectedData2.put("completed", completed);
        }

        return expectedData2;

    }
}
