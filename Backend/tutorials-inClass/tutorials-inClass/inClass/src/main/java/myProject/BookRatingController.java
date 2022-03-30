package myProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;



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
        //br.setBook(bdb.findById(bid).orElseThrow());
        //br.setPerson(pdb.findById(pid).orElseThrow());

        BookRatingKey brk = new BookRatingKey();
        brk.setBookId(bid);
        brk.setPersonId(pid);

        br.setId(brk);
        //br.getRating() to find and make sure it is a correct amount
        db.save(br);
        return br;
    }
    @PutMapping("/addReview/{bid}/{pid}")
    BookRating creatReview(@PathVariable Integer bid, @PathVariable Integer pid, @RequestBody BookRating br) {
        //br.setBook(bdb.findById(bid).orElseThrow());
        //br.setPerson(pdb.findById(pid).orElseThrow());

        BookRatingKey brk = new BookRatingKey();
        brk.setBookId(bid);
        brk.setPersonId(pid);

//        Optional<BookRating> oldReview =  db.findById(bid);
//        oldReview.pid = pid// how do I find the embedded Id
//        if (br.rating!= null)
//            br.setRating(brk.rating);

        br.setId(brk);

        db.save(br);
        return br;
    }

//    @GetMapping("/book/{bid}/person/{pid}")
//    Optional<BookRating> getBookRating(@PathVariable Integer bid, @PathVariable Integer pid) {
//        return db.findById(pid);
//
//    }
}
