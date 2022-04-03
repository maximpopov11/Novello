package myProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;


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
        Person p = pdb.findById(pid).orElseThrow();
        Books b = bdb.findById(bid).orElseThrow();
        br.setBook(b);
        br.setPerson(p);
        //br.getRating() to find and make sure it is a correct amount
        db.save(br);
        return br;
    }
   @GetMapping("/getRating/{bid}/{pid}")
   BookRating  findAReview(@PathVariable Integer bid, @PathVariable Integer pid)
   {
       BookRatingKey brk = new BookRatingKey();
       brk.setBookId(bid);
       brk.setPersonId(pid);
       BookRating ratingToReturn = db.findById(brk).orElseThrow();
       return ratingToReturn;
   }
   @PutMapping("/addReview/{bid}/{pid}")
    BookRating creatReview(@PathVariable Integer bid, @PathVariable Integer pid, @RequestBody BookRating br) {
       BookRatingKey brk = new BookRatingKey();
       brk.setBookId(bid);
       brk.setPersonId(pid);
       BookRating oldRating = db.findById(brk).orElseThrow();
       if(oldRating.getRating() !=0)
       {
           br.setRating(oldRating.getRating());
       }
       Person p = pdb.findById(pid).orElseThrow();
       Books b = bdb.findById(bid).orElseThrow();
       br.setId(brk);
       br.setBook(b);
       br.setPerson(p);
       db.save(br);

       return br;
   }
//        //br.setBook(bdb.findById(bid).orElseThrow());
//        //br.setPerson(pdb.findById(pid).orElseThrow());
//
//        BookRatingKey brk = new BookRatingKey();
//        brk.setBookId(bid);
//        brk.setPersonId(pid);
//
//       //BookRating oldBR = db.findById(brk);
//       //Optional<BookRating> oldBR = frdb.findById(brk);
//
//
//
//        br.setId(brk);
//
//        db.save(br);
//        return br;
//    }

//    @GetMapping("/book/{bid}/person/{pid}")
//    Optional<BookRating> getBookRating(@PathVariable Integer bid, @PathVariable Integer pid) {
//        return db.findById(pid);
//
//    }
}
