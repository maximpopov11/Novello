package myProject;


import static io.restassured.RestAssured.post;
import static org.junit.jupiter.api.Assertions.assertEquals;


import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import javax.swing.text.html.parser.Parser;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@RunWith(SpringRunner.class)

public class BookTest {
    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }
    @Test
    public void serverUp() {
        Response response = RestAssured.given().
                when().
                get("/");

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);

        String returnString = response.getBody().asString();
        assertEquals("HELLO", returnString);
    }

    @Test
    public void addBook(){
String json = "{\"isbn\":\"0000000000001\",\"title\":\"Pride and Prejudice\",\"author\":\"Jane Austen\",\"publicationYear\":1813,\"overallRating\":5.0,\"msrp\":9.99,\"genre\":\"Literature\",\"description\":\"Pride and Prejudice is an 1813 novel of manners written by Jane Austen. The novel follows the character development of Elizabeth Bennet, the dynamic protagonist of the book who learns about the repercussions of hasty judgments and comes to appreciate the difference between superficial goodness and actual goodness.\",\"readingUrl\":\"https://www.gutenberg.org/files/1342/1342-h/1342-h.htm\",\"imageUrl\":\"https://www.gutenberg.org/cache/epub/1342/pg1342.cover.medium.jpg\"}";
        Response response = RestAssured.given().header("Content-Type", "application/json").
                body(json).
                when().
                post("/book");

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);

        String returnString = response.getBody().asString();


        assertEquals(json,returnString);


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