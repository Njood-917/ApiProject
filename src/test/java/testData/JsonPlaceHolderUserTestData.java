package testData;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderUserTestData {
    public static Map<String , Object> expectedDataMap(Integer id , String username ,String firstName , String lastName,
                                                       String email , String password ,   String phone   , Integer userStatus            ) {
        Map<String , Object> expectedData = new HashMap<>();
        expectedData.put("id", id);
        expectedData.put("username", username);
        expectedData.put("firstName", firstName);
        expectedData.put("lastName", lastName);
        expectedData.put("email", email);
        expectedData.put("password", password);
        expectedData.put("phone", phone);
        expectedData.put("userStatus", userStatus);
        return expectedData;

    }
}
