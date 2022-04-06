package myProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookInterface db;

    @PostMapping("/addBooks")
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


    @RequestMapping("/books")
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

}
