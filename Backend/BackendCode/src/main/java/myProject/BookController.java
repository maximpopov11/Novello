package myProject;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Api(value = "Swagger2DemoRestController", description = "REST APIs related to Student Entity!!!!")
@RestController
public class BookController {

    @Autowired
    BookInterface db;

    @ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getStudents")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @PostMapping("/book")
    Book creatBooks(@RequestBody Book b) {
        db.save(b);
        return b;
    }

    @PostMapping("/addAllBooks")
    void createAllBooks(@RequestBody Book[] b) {
        db.saveAll(Arrays.asList(b));
    }

    @GetMapping("/book/{id}")
    Optional<Book> getBook(@PathVariable Integer id) {
        return db.findById(id);
    }

    @RequestMapping("/book")
    List<Book> showMeTheBooks() {
        return db.findAll();
    }

    @PutMapping("/book/{id}")
    Book updateBook(@RequestBody Book b, @PathVariable Integer id) {
        Book old_b = db.findById(id).orElseThrow(RuntimeException::new);
        if (b.isbn != null)
            old_b.setIsbn(b.isbn);
        if (b.title != null)
            old_b.setTitle(b.title);
        if (b.author != null)
            old_b.setAuthor(b.author);
        if (b.publicationYear != null)
            old_b.setPublicationYear(b.publicationYear);
        if (b.overallRating != null)
            old_b.setOverallRating(b.overallRating);
        if (b.msrp != null)
            old_b.setMsrp(b.msrp);
        if (b.genre != null)
            old_b.setGenre(b.genre);
        db.save(old_b);
        return old_b;
    }


    @DeleteMapping("/book/{id}")
    String deleteBook(@PathVariable Integer id) {
        db.deleteById(id);
        return "deleted " + id;
    }

    @GetMapping("/duck")
    String getDuck(){
        return "https://i.pinimg.com/originals/62/37/d4/6237d416dec1d84c8afbb9dce847e2bc.jpg";
    }

}
