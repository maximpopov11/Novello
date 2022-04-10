package myProject;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.*;


@RestController
public class BookDataController {

    @Autowired
    BookDataInterface db;
    @Autowired
    BookInterface bdb;
    @Autowired
    UserInterface pdb;

    @PostMapping ("/bookData")
    BookData createBookData(@RequestBody JSONObject jsonObject) {

        BookDataKey bookDataKey = new BookDataKey();
        bookDataKey.setBookId((Integer) jsonObject.getAsNumber("bookId"));
        bookDataKey.setUserId((Integer) jsonObject.getAsNumber("userId"));

        BookData bookData = new BookData();


        bookData.setId(bookDataKey);
        User p = pdb.findById(bookDataKey.userId).orElseThrow(NoSuchElementException::new);
        Book b = bdb.findById(bookDataKey.bookId).orElseThrow(NoSuchElementException::new);

        bookData.setBook(b);
        bookData.setUser(p);

        if(jsonObject.getAsNumber("rating")!=null){
            bookData.setRating((Integer) jsonObject.getAsNumber("rating"));
        }
        if(jsonObject.getAsNumber("review")!=null){
            bookData.setRating((Integer) jsonObject.getAsNumber("review"));
        }
        if(jsonObject.getAsNumber("category")!=null){
            bookData.setRating((Integer) jsonObject.getAsNumber("category"));
        }
        if(jsonObject.getAsNumber("page")!=null){
            bookData.setRating((Integer) jsonObject.getAsNumber("page"));
        }

        db.save(bookData);
        return bookData;
    }

    @PutMapping("/bookData")
    BookData creatBookData(@RequestBody JSONObject jsonObject) {

        BookDataKey bookDataKey = new BookDataKey();
        bookDataKey.setBookId((Integer) jsonObject.getAsNumber("bookId"));
        bookDataKey.setUserId((Integer) jsonObject.getAsNumber("userId"));

        BookData bookData = db.findById(bookDataKey).orElseThrow(NoSuchElementException::new);

        if(jsonObject.getAsNumber("rating")!=null){
            bookData.setRating((Integer) jsonObject.getAsNumber("rating"));
        }
        if(jsonObject.getAsNumber("review")!=null){
            bookData.setRating((Integer) jsonObject.getAsNumber("review"));
        }
        if(jsonObject.getAsNumber("category")!=null){
            bookData.setRating((Integer) jsonObject.getAsNumber("category"));
        }
        if(jsonObject.getAsNumber("page")!=null){
            bookData.setRating((Integer) jsonObject.getAsNumber("page"));
        }

        db.save(bookData);
        return bookData;
    }


    @GetMapping("/bookData")
    BookData findAReview(@RequestBody JSONObject jsonObject) {
        BookDataKey bookDataKey = new BookDataKey();
        bookDataKey.setBookId((Integer) jsonObject.getAsNumber("bookId"));
        bookDataKey.setUserId((Integer) jsonObject.getAsNumber("userId"));
        return db.findById(bookDataKey).orElseThrow(NoSuchElementException::new);
    }


    @DeleteMapping("/bookData")
    void delete(@RequestBody JSONObject jsonObject){
        BookDataKey bookDataKey = new BookDataKey();
        bookDataKey.setBookId((Integer) jsonObject.getAsNumber("bookId"));
        bookDataKey.setUserId((Integer) jsonObject.getAsNumber("userId"));

        db.deleteById(bookDataKey);

    }

    @GetMapping("/bookData/{bid}")
    Set<BookData> getRatings(@PathVariable Integer bid) {

        Book b = bdb.findById(bid).orElseThrow(NoSuchElementException::new);
        return b.getBookData();
    }
//
//    @GetMapping("/userBookData/{pid}")
//    Set<BookData> getAllRatingsFromUser(@PathVariable Integer pid) {
//
//        User p = pdb.findById(pid).orElseThrow(NoSuchElementException::new);
//        return p.getBookData();
//    }
}
