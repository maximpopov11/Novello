package myProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.NoSuchElementException;




@RestController
public class BookRatingController {
    @Autowired
    RatingDB db;
    @Autowired
    BooksDB bdb;
    @Autowired
    PersonDB pdb;

    @PostMapping("/addRating/{bid}/{pid}")
    BookRating creatBookRating(@PathVariable Integer bid, @PathVariable Integer pid, @RequestBody BookRating br) {

        BookRatingKey brk = new BookRatingKey();
        brk.setBookId(bid);
        brk.setPersonId(pid);

        br.setId(brk);
        Person p = pdb.findById(pid).orElseThrow(() -> new NoSuchElementException());
        Books b = bdb.findById(bid).orElseThrow(() -> new NoSuchElementException());
        br.setBook(b);
        br.setPerson(p);
        db.save(br);
        return br;
    }

    @GetMapping("/getRating/{bid}/{pid}")
    BookRating findAReview(@PathVariable Integer bid, @PathVariable Integer pid) {
        BookRatingKey brk = new BookRatingKey();
        brk.setBookId(bid);
        brk.setPersonId(pid);
        BookRating ratingToReturn = db.findById(brk).orElseThrow(() -> new NoSuchElementException());
        return ratingToReturn;
    }

    @PutMapping("/addReview/{bid}/{pid}")
    BookRating creatReview(@PathVariable Integer bid, @PathVariable Integer pid, @RequestBody BookRating br) {
        BookRatingKey brk = new BookRatingKey();
        brk.setBookId(bid);
        brk.setPersonId(pid);
        BookRating oldRating = db.findById(brk).orElseThrow(() -> new NoSuchElementException());
        if (oldRating.getRating() != 0) {
            br.setRating(oldRating.getRating());
        }
        Person p = pdb.findById(pid).orElseThrow(() -> new NoSuchElementException());
        Books b = bdb.findById(bid).orElseThrow(() -> new NoSuchElementException());
        br.setId(brk);
        br.setBook(b);
        br.setPerson(p);
        db.save(br);

        return br;
    }

    @GetMapping("/getReviews/{bid}")
    Set<BookRating> getRatings(@PathVariable Integer bid){

        Books b = bdb.findById(bid).orElseThrow(() -> new NoSuchElementException());
        return b.getRatings();
    }
    @GetMapping("/getAllRatingsFromUser/{pid}")
    Set<BookRating> getAllratingsFromUser(@PathVariable Integer pid){

        Person p = pdb.findById(pid).orElseThrow(() -> new NoSuchElementException());
        return p.getRatings();
    }
//    Optional<Integer> op = Optional.of(9455);
//
//    // print supplier
//    System.out.println("Hi)")
//        System.out.println("Optional: + op");
//
//    // orElseThrow supplier
//        System.out.println("Value by orElseThrow("+ "ArithmeticException::new) method: "+ op.orElseThrow(ArithmeticException::new));

}
