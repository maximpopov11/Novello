package myProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Set;


@RestController
public class EvaluationController {

    @Autowired
    EvaluationInterface db;
    @Autowired
    BookInterface bdb;
    @Autowired
    UserInterface pdb;

    @PostMapping("/addRating/{bid}/{pid}")
    Evaluation creatEvaluation(@PathVariable Integer bid, @PathVariable Integer pid, @RequestBody Evaluation br) {

        EvaluationKey brk = new EvaluationKey();
        brk.setBookId(bid);
        brk.setPersonId(pid);

        br.setId(brk);
        User p = pdb.findById(pid).orElseThrow(() -> new NoSuchElementException());
        Book b = bdb.findById(bid).orElseThrow(() -> new NoSuchElementException());
        br.setBook(b);
        br.setPerson(p);

        db.save(br);
        return br;
    }

    @GetMapping("/getRating/{bid}/{pid}")
    Evaluation findAReview(@PathVariable Integer bid, @PathVariable Integer pid) {
        EvaluationKey brk = new EvaluationKey();
        brk.setBookId(bid);
        brk.setPersonId(pid);
        Evaluation ratingToReturn = db.findById(brk).orElseThrow(() -> new NoSuchElementException());
        return ratingToReturn;
    }

    @PutMapping("/addReview/{bid}/{pid}")
    Evaluation creatReview(@PathVariable Integer bid, @PathVariable Integer pid, @RequestBody Evaluation br) {
        EvaluationKey brk = new EvaluationKey();
        brk.setBookId(bid);
        brk.setPersonId(pid);
        Evaluation oldRating = db.findById(brk).orElseThrow(() -> new NoSuchElementException());
        if (oldRating.getRating() != 0) {
            br.setRating(oldRating.getRating());
        }
        User p = pdb.findById(pid).orElseThrow(() -> new NoSuchElementException());
        Book b = bdb.findById(bid).orElseThrow(() -> new NoSuchElementException());
        br.setId(brk);
        br.setBook(b);
        br.setPerson(p);
        db.save(br);

        return br;
    }

    @GetMapping("/getReviews/{bid}")
    Set<Evaluation> getRatings(@PathVariable Integer bid) {

        Book b = bdb.findById(bid).orElseThrow(() -> new NoSuchElementException());
        return b.getEvaluation();
    }

    @GetMapping("/getAllRatingsFromUser/{pid}")
    Set<Evaluation> getAllratingsFromUser(@PathVariable Integer pid) {

        User p = pdb.findById(pid).orElseThrow(() -> new NoSuchElementException());
        return p.getEvaluation();
    }
}
