package myProject;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Api(value = "BookController")
@RestController
public class BookController {

    @Autowired
    BookInterface db;

    @ApiOperation(value = "Add a book to the system", response = Iterable.class)
    @PostMapping("/book")
    Book addBook(@RequestBody Book b) {
        db.save(b);
        return b;
    }

    @ApiOperation(value = "Add all books to the system", response = Iterable.class)
    @PostMapping("/addAllBooks")
    void addAllBooks(@RequestBody Book[] b) {
        db.saveAll(Arrays.asList(b));
    }

    @ApiOperation(value = "Get a book from the system", response = Iterable.class)
    @GetMapping("/book/{id}")
    Optional<Book> getBook(@PathVariable Integer id) {
        return db.findById(id);
    }

    @ApiOperation(value = "Get all books from the system", response = Iterable.class)
    @RequestMapping("/book")
    List<Book> getAllBooks() {
        return db.findAll();
    }

    @ApiOperation(value = "Update a book in the system", response = Iterable.class)
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


    @ApiOperation(value = "Delete a book in the system", response = Iterable.class)
    @DeleteMapping("/book/{id}")
    String deleteBook(@PathVariable Integer id) {
        db.deleteById(id);
        return "deleted " + id;
    }

    @ApiOperation(value = "Get the duck screen", response = Iterable.class)
    @GetMapping("/duck")
    String duckScreen(){
        return "https://i.pinimg.com/originals/62/37/d4/6237d416dec1d84c8afbb9dce847e2bc.jpg";
    }

}
