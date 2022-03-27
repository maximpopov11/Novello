package myProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRatingController {
    @Autowired
    RatingDB db;

    @PostMapping("/addRating")
    BookRating creatBookRating(@RequestBody BookRating br) {

        db.save(br);
        return br;
    }
}
