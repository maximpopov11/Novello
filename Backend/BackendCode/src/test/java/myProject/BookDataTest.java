package myProject;


import static io.restassured.RestAssured.post;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


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

public class BookDataTest {
	@LocalServerPort
	int port;

	@Before
	public void setUp() {
		RestAssured.port = port;
		RestAssured.baseURI = "http://localhost";
	}

	@Test
	public void createBookData(){
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
		assertEquals(returnString,"{\"id\":{\"userId\":1,\"bookId\":1},\"user\":{\"id\":1,\"accountType\":1,\"username\":\"IChangedMyName\",\"password\":\"5760\",\"securityQuestion\":\"Favorite animal\",\"securityAnswer\":\"panda\"},\"book\":{\"isbn\":\"0000000000001\",\"title\":\"Pride and Prejudice\",\"author\":\"Jane Austen\",\"publicationYear\":1813,\"overallRating\":5.0,\"msrp\":9.99,\"genre\":\"Literature\",\"description\":\"Pride and Prejudice is an 1813 novel of manners written by Jane Austen. The novel follows the character development of Elizabeth Bennet, the dynamic protagonist of the book who learns about the repercussions of hasty judgments and comes to appreciate the difference between superficial goodness and actual goodness.\",\"readingUrl\":\"https://www.gutenberg.org/files/1342/1342-h/1342-h.htm\",\"imageUrl\":\"https://www.gutenberg.org/cache/epub/1342/pg1342.cover.medium.jpg\"},\"rating\":9.5,\"review\":\"This book was kinda good\",\"category\":1,\"page\":3}");
	}

	@Test
	public void getBookData(){
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


		assertNotEquals("",response.getBody().asString());
	}

	@Test
	public void addAllBookData(){
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
		assertEquals("{\"id\":{\"userId\":1,\"bookId\":1},\"user\":{\"id\":1,\"accountType\":1,\"username\":\"IChangedMyName\",\"password\":\"5760\",\"securityQuestion\":\"Favorite animal\",\"securityAnswer\":\"panda\"},\"book\":{\"isbn\":\"0000000000001\",\"title\":\"Pride and Prejudice\",\"author\":\"Jane Austen\",\"publicationYear\":1813,\"overallRating\":5.0,\"msrp\":9.99,\"genre\":\"Literature\",\"description\":\"Pride and Prejudice is an 1813 novel of manners written by Jane Austen. The novel follows the character development of Elizabeth Bennet, the dynamic protagonist of the book who learns about the repercussions of hasty judgments and comes to appreciate the difference between superficial goodness and actual goodness.\",\"readingUrl\":\"https://www.gutenberg.org/files/1342/1342-h/1342-h.htm\",\"imageUrl\":\"https://www.gutenberg.org/cache/epub/1342/pg1342.cover.medium.jpg\"},\"rating\":9.5,\"review\":\"This book was kinda good\",\"category\":1,\"page\":3}",response2.getBody().asString());

		String json3 = "{\n" +
				"    \"userId\":1,\n" +
				"    \"bookId\":9,\n" +
				"    \"category\":4\n" +
				"}";
		Response response3 = RestAssured.given().header("Content-Type", "application/json").
				body(json3).
				when().
				put("/bookData");

		assertEquals("{\"id\":{\"userId\":1,\"bookId\":9},\"user\":{\"id\":1,\"accountType\":1,\"username\":\"IChangedMyName\",\"password\":\"5760\",\"securityQuestion\":\"Favorite animal\",\"securityAnswer\":\"panda\"},\"book\":{\"isbn\":\"0000000000008\",\"title\":\"Ulysses\",\"author\":\"James Joyce\",\"publicationYear\":1922,\"overallRating\":2.0,\"msrp\":9.99,\"genre\":\"Literature\",\"description\":\"Ulysses chronicles the appointments and encounters of the itinerant Leopold Bloom in Dublin in the course of an ordinary day, 16 June 1904.[4][5] Ulysses is the Latinised name of Odysseus, the hero of Homer's epic poem the Odyssey, and the novel establishes a series of parallels between the poem and the novel, with structural correspondences between the characters and experiences of Bloom and Odysseus, Molly Bloom and Penelope, and Stephen Dedalus and Telemachus, in addition to events and themes of the early 20th-century context of modernism, Dublin, and Ireland's relationship to Britain. The novel is highly allusive and also imitates the styles of different periods of English literature.\",\"readingUrl\":\"https://www.gutenberg.org/files/4300/4300-h/4300-h.htm\",\"imageUrl\":\"https://www.gutenberg.org/cache/epub/4300/pg4300.cover.medium.jpg\"},\"rating\":3.0,\"review\":\"Did a kindergartener write this?\",\"category\":4,\"page\":4}",response3.getBody().asString());


		int statusCode = response.getStatusCode();
		assertEquals(200, statusCode);
	}
}