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
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@RunWith(SpringRunner.class)

public class BookDataTest {
    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    public void createBookData() {
        String json = "{\n" +
                "    \"userId\":1,\n" +
                "    \"bookId\":1,\n" +
                "    \"rating\":9.5,\n" +
                "    \"review\":\"This book was kinda good\",\n" +
                "    \"category\": 1,\n" +
                "    \"page\": 3\n" +
                "}";
        Response response = RestAssured.given().header("Content-Type", "application/json").
                body(json).
                when().
                post("/bookData");

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);

        String returnString = response.getBody().asString();
        assertEquals(returnString, "{\"id\":{\"userId\":1,\"bookId\":1},\"user\":{\"id\":1,\"accountType\":1,\"username\":\"IChangedMyName\",\"password\":\"5760\",\"securityQuestion\":\"Favorite animal\",\"securityAnswer\":\"panda\"},\"book\":{\"isbn\":\"0000000000001\",\"title\":\"Pride and Prejudice\",\"author\":\"Jane Austen\",\"publicationYear\":1813,\"overallRating\":5.0,\"msrp\":9.99,\"genre\":\"Literature\",\"description\":\"Pride and Prejudice is an 1813 novel of manners written by Jane Austen. The novel follows the character development of Elizabeth Bennet, the dynamic protagonist of the book who learns about the repercussions of hasty judgments and comes to appreciate the difference between superficial goodness and actual goodness.\",\"readingUrl\":\"https://www.gutenberg.org/files/1342/1342-h/1342-h.htm\",\"imageUrl\":\"https://www.gutenberg.org/cache/epub/1342/pg1342.cover.medium.jpg\"},\"rating\":9.5,\"review\":\"This book was kinda good\",\"category\":1,\"page\":3}");
    }

    @Test
    public void getBookData() {
        Response response = RestAssured.given().
                when().
                get("/bookData/1/1");
        Response response1 = RestAssured.given().
                when().
                get("/bookData/user/1");
        Response response2 = RestAssured.given().
                when().
                get("/bookData/book/1");
        Response response3 = RestAssured.given().
                when().
                get("/bookData");


        assertNotEquals("", response.getBody().asString());
    }

    @Test
    public void addAllBookData() {
        String json = "[{\n" +
                "    \"userId\":1,\n" +
                "    \"bookId\":1,\n" +
                "    \"rating\":9.5,\n" +
                "    \"review\":\"This book was kinda good\",\n" +
                "    \"category\": 1,\n" +
                "    \"page\": 3\n" +
                "},{\n" +
                "    \"userId\":1,\n" +
                "    \"bookId\":2,\n" +
                "    \"rating\":4.0,\n" +
                "    \"review\":\"I didn't really like it\",\n" +
                "    \"category\": 2,\n" +
                "    \"page\": 45\n" +
                "},{\n" +
                "    \"userId\":1,\n" +
                "    \"bookId\":3,\n" +
                "    \"rating\":5.5,\n" +
                "    \"review\":\"THIS WAS THE BEST BOOK EVER!!!!\",\n" +
                "    \"category\": 3,\n" +
                "    \"page\": 56\n" +
                "},{\n" +
                "    \"userId\":1,\n" +
                "    \"bookId\":4,\n" +
                "    \"rating\":6.5,\n" +
                "    \"review\":\"The ending was bad\",\n" +
                "    \"category\": 4,\n" +
                "    \"page\": 124\n" +
                "},{\n" +
                "    \"userId\":1,\n" +
                "    \"bookId\":7,\n" +
                "    \"rating\":7.5,\n" +
                "    \"review\":\"I wish it was a shorter book\",\n" +
                "    \"category\": 5,\n" +
                "    \"page\": 420\n" +
                "},{\n" +
                "    \"userId\":1,\n" +
                "    \"bookId\":6,\n" +
                "    \"rating\":6.0,\n" +
                "    \"review\":\"This was really cool\",\n" +
                "    \"category\": 1,\n" +
                "    \"page\": 69\n" +
                "},{\n" +
                "    \"userId\":1,\n" +
                "    \"bookId\":7,\n" +
                "    \"rating\":9.0,\n" +
                "    \"review\":\"Captain America was better\",\n" +
                "    \"category\": 2,\n" +
                "    \"page\": 265\n" +
                "},{\n" +
                "    \"userId\":1,\n" +
                "    \"bookId\":8,\n" +
                "    \"rating\":8.0,\n" +
                "    \"review\":\"The second one was better\",\n" +
                "    \"category\": 3,\n" +
                "    \"page\": 200\n" +
                "},{\n" +
                "    \"userId\":1,\n" +
                "    \"bookId\":9,\n" +
                "    \"rating\":3.0,\n" +
                "    \"review\":\"Did a kindergartener write this?\",\n" +
                "    \"category\": 4,\n" +
                "    \"page\": 4\n" +
                "},{\n" +
                "    \"userId\":1,\n" +
                "    \"bookId\":10,\n" +
                "    \"rating\":4.0,\n" +
                "    \"review\":\"BUY IT BUY IT BUY IT\",\n" +
                "    \"category\": 5,\n" +
                "    \"page\": 323\n" +
                "}]";
        Response response = RestAssured.given().header("Content-Type", "application/json").
                body(json).
                when().
                post("/addAllBookData");


        String json2 = "{\n" +
                "    \"bookId\":1,\n" +
                "    \"userId\":1\n" +
                "}";

        Response response2 = RestAssured.given().header("Content-Type", "application/json").
                body(json2).
                when().
                get("/bookData");
        assertEquals("{\"id\":{\"userId\":1,\"bookId\":1},\"user\":{\"id\":1,\"accountType\":1,\"username\":\"IChangedMyName\",\"password\":\"5760\",\"securityQuestion\":\"Favorite animal\",\"securityAnswer\":\"panda\"},\"book\":{\"isbn\":\"0000000000001\",\"title\":\"Pride and Prejudice\",\"author\":\"Jane Austen\",\"publicationYear\":1813,\"overallRating\":5.0,\"msrp\":9.99,\"genre\":\"Literature\",\"description\":\"Pride and Prejudice is an 1813 novel of manners written by Jane Austen. The novel follows the character development of Elizabeth Bennet, the dynamic protagonist of the book who learns about the repercussions of hasty judgments and comes to appreciate the difference between superficial goodness and actual goodness.\",\"readingUrl\":\"https://www.gutenberg.org/files/1342/1342-h/1342-h.htm\",\"imageUrl\":\"https://www.gutenberg.org/cache/epub/1342/pg1342.cover.medium.jpg\"},\"rating\":9.5,\"review\":\"This book was kinda good\",\"category\":1,\"page\":3}", response2.getBody().asString());

        String json3 = "{\n" +
                "    \"userId\":1,\n" +
                "    \"bookId\":9,\n" +
                "    \"category\":4\n" +
                "}";
        Response response3 = RestAssured.given().header("Content-Type", "application/json").
                body(json3).
                when().
                put("/bookData");

        assertEquals("{\"id\":{\"userId\":1,\"bookId\":9},\"user\":{\"id\":1,\"accountType\":1,\"username\":\"IChangedMyName\",\"password\":\"5760\",\"securityQuestion\":\"Favorite animal\",\"securityAnswer\":\"panda\"},\"book\":{\"isbn\":\"0000000000009\",\"title\":\"War and Peace\",\"author\":\"Leo Tolstoy\",\"publicationYear\":1869,\"overallRating\":1.5,\"msrp\":9.99,\"genre\":\"Historical Fiction\",\"description\":\"The novel chronicles the French invasion of Russia and the impact of the Napoleonic era on Tsarist society through the stories of five Russian aristocratic families. Portions of an earlier version, titled The Year 1805,[4] were serialized in The Russian Messenger from 1865 to 1867 before the novel was published in its entirety in 1869.[5]\",\"readingUrl\":\"https://www.gutenberg.org/files/2600/2600-h/2600-h.htm\",\"imageUrl\":\"https://www.gutenberg.org/cache/epub/2600/pg2600.cover.medium.jpg\"},\"rating\":3.0,\"review\":\"Did a kindergartener write this?\",\"category\":4,\"page\":4}", response3.getBody().asString());


        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }
}