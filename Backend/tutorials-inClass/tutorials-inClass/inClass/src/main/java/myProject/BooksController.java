package myProject;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BooksController {

    @Autowired
    BooksDB db;

    @PostMapping("/addBooks")
    Books creatBooks(@RequestBody Books b) {
        db.save(b);
        return b;
    }
    @PostMapping("/addAllBooks")
    void createAllBooks(@RequestBody Books[] b){
        for(int i = 0; i<b.length;i++){
        db.save(b[i]);
        }

    }

//    @GetMapping("/book/{id}")
//    Books getBook(@PathVariable String id){
//        return db.findById(id);//how to find a column
//    }

    @GetMapping("/book/{id}")
    Optional<Books> getBook(@PathVariable Integer id) {
        return db.findById(id);
    }

//    @PutMapping("/book/{id}")
//    Books updateBook(@PathVariable Integer id, @RequestBody Books b){
//        Optional<Books> bk = db.findById(id);
//        if (bk == null){
//            return null;
//        }
//        db.save
//        return b;
//    }


    @RequestMapping("/books")
    List<Books> showMeTheBooks() {
        return db.findAll();
    }

    @PutMapping("/book/{id}")
    Books updateBook(@RequestBody Books b, @PathVariable Integer id) {
        Books old_b = db.findById(id).orElseThrow(RuntimeException::new);
        if (b.isbn != null)
            old_b.setIsbn(b.isbn);
        if (b.title != null)
            old_b.setTitle(b.title);
        if (b.author != null)
            old_b.setAuthor(b.author);
        if (b.publicationYear != null)
            old_b.setPublicationYear(b.publicationYear);
        if (b.rating != null)
            old_b.setRating(b.rating);
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

    @GetMapping("/getUrl/{bid}")
    String getUrl(@PathVariable Integer bid){

        Books b = db.findById(bid).orElseThrow(RuntimeException::new);
        return b.getReadingUrl();
    }
}
