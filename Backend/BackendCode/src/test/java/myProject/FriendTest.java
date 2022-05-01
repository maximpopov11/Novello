package myProject;


import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@RunWith(SpringRunner.class)

public class FriendTest {

    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    public void reverseTest() {
        // Send request and receive response
//        JSONObject test = new JSONObject();
//        JSONObject requestParams = new JSONObject();
//        requestParams.put("id", 1);
//        Map<String,String> requestHeaders = new HashMap<>();
//        requestHeaders.put("id", "1");
//        RestAssured.given().headers(requestHeaders);

        Response response = RestAssured
        .given()
                .log()
                .headers()
                .get("http://coms-309-013.class.las.iastate.edu:8080/friends/3");


        // Check status code
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);

        // Check response body for correct response
        String returnString = response.getBody().asString();
        //            JSONArray returnArr = new JSONArray(returnString);
//            JSONObject returnObj = returnArr.getJSONObject(returnArr.length()-1);
        assertEquals("[{\"id\":{\"senderId\":3,\"receiverId\":2},\"receiver\":{\"id\":2,\"accountType\":1,\"username\":\"Scottie\",\"password\":\"6969\",\"securityQuestion\":\"Favorite animal\",\"securityAnswer\":\"dog\"},\"friendshipStatus\":2}]", returnString);
    }

//    @Test
//    public void capitalizeTest() {
//        // Send request and receive response
//        Response response = RestAssured.given().
//                header("Content-Type", "text/plain").
//                header("charset","utf-8").
//                body("hello").
//                when().
//                post("/capitalize");
//
//
//        // Check status code
//        int statusCode = response.getStatusCode();
//        assertEquals(200, statusCode);
//
//        // Check response body for correct response
//        String returnString = response.getBody().asString();
//        try {
//            JSONArray returnArr = new JSONArray(returnString);
//            JSONObject returnObj = returnArr.getJSONObject(returnArr.length()-1);
//            assertEquals("HELLO", returnObj.get("data"));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }




}