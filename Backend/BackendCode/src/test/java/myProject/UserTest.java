package myProject;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@RunWith(SpringRunner.class)

public class UserTest {
    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    public void makeAllUsers(){
        String json = "[\n" +
                "    \n" +
                "{\n" +
                "    \"name\":\"Goben\",\n" +
                "    \"accountType\":1,\n" +
                "    \"username\":\"Idontknowpickone\",\n" +
                "    \"password\":\"8493\",\n" +
                "    \"securityQuestion\":\"Favorite animal\",\n" +
                "    \"securityAnswer\":\"penguin\",\n" +
                "    \"email\":\"thisisanemail@gmail.com\",\n" +
                "    \"age\":21\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "    \"name\":\"scottg\",\n" +
                "    \"accountType\":1,\n" +
                "    \"username\":\"Scottie\",\n" +
                "    \"password\":\"6969\",\n" +
                "    \"securityQuestion\":\"Favorite animal\",\n" +
                "    \"securityAnswer\":\"dog\",\n" +
                "    \"email\":\"myemail@gmail.com\",\n" +
                "    \"age\":22\n" +
                "},\n" +
                "{\n" +
                "    \"name\":\"Maxim\",\n" +
                "    \"accountType\":1,\n" +
                "    \"username\":\"Maxim\",\n" +
                "    \"password\":\"5760\",\n" +
                "    \"securityQuestion\":\"Favorite animal\",\n" +
                "    \"securityAnswer\":\"Cat\",\n" +
                "    \"email\":\"thisisanemail@gmail.com\",\n" +
                "    \"age\":20\n" +
                "}\n" +
                "\n" +
                "]";
        Response response = RestAssured.given().header("Content-Type", "application/json").
                body(json).
                when().
                post("/addAllUsers");

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);

        String returnString = response.getBody().asString();


        assertEquals("",returnString);


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