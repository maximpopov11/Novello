package myProject;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

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
            bookData.setRating((Double) jsonObject.getAsNumber("rating"));
        }
        if(jsonObject.getAsString("review")!=null){
            bookData.setReview(jsonObject.getAsString("review"));
        }
        if(jsonObject.getAsNumber("category")!=null){
            bookData.setCategory((Integer) jsonObject.getAsNumber("category"));
        }
        if(jsonObject.getAsNumber("page")!=null){
            bookData.setPage((Integer) jsonObject.getAsNumber("page"));
        }

        db.save(bookData);
        return bookData;
    }

    @PostMapping ("/addAllBookData")
    void addAllBookData(@RequestBody JSONObject[] jsonObjectIn) {

        JSONObject jsonObject;
        for(int i = 0 ; i < jsonObjectIn.length; i++){
            jsonObject = jsonObjectIn[i];
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
            bookData.setRating((Double) jsonObject.getAsNumber("rating"));
        }
        if(jsonObject.getAsString("review")!=null){
            bookData.setReview(jsonObject.getAsString("review"));
        }
        if(jsonObject.getAsNumber("category")!=null){
            bookData.setCategory((Integer) jsonObject.getAsNumber("category"));
        }
        if(jsonObject.getAsNumber("page")!=null){
            bookData.setPage((Integer) jsonObject.getAsNumber("page"));
        }

        db.save(bookData);
        }
    }

    @PutMapping("/bookData")
    BookData creatBookData(@RequestBody JSONObject jsonObject) {

        BookDataKey bookDataKey = new BookDataKey();
        bookDataKey.setBookId((Integer) jsonObject.getAsNumber("bookId"));
        bookDataKey.setUserId((Integer) jsonObject.getAsNumber("userId"));

        BookData bookData = db.findById(bookDataKey).orElseThrow(NoSuchElementException::new);

        if(jsonObject.getAsNumber("rating")!=null){
            bookData.setRating((Double) jsonObject.getAsNumber("rating"));
        }
        if(jsonObject.getAsString("review")!=null){
            bookData.setReview(jsonObject.getAsString("review"));
        }
        if(jsonObject.getAsNumber("category")!=null){
            bookData.setCategory((Integer) jsonObject.getAsNumber("category"));
        }
        if(jsonObject.getAsNumber("page")!=null){
            bookData.setPage((Integer) jsonObject.getAsNumber("page"));
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

    @GetMapping("/bookData/book/{bid}")
    Set<BookData> getRatings(@PathVariable Integer bid) {
        Book b = bdb.findById(bid).orElseThrow(NoSuchElementException::new);
        return b.getBookData();
    }

    @GetMapping("/bookData/{pid}/{category}")
    Set<BookData> getAllBooksFromUserCategory(@PathVariable Integer pid, @PathVariable Integer category) {
        //return by category
        User p = pdb.findById(pid).orElseThrow(NoSuchElementException::new);
        Set<BookData> library = p.getBookData();

        Set<BookData> librarySet = new HashSet<>();

        Iterator<BookData> libraryIterator = library.iterator();

        BookData l;

        int c;
        while (libraryIterator.hasNext()) {
            l = libraryIterator.next();
            c = l.getCategory();
            if (c == category) {
                librarySet.add(l);
            }
        }
        return librarySet;
    }

    @GetMapping("/bookData/user/{pid}")
    Set<BookData> getAllRatingsFromUser(@PathVariable Integer pid) {

        User p = pdb.findById(pid).orElseThrow(NoSuchElementException::new);
        return p.getBookData();
    }
}
