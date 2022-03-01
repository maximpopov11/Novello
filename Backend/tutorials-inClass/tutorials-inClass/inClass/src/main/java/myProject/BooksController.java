package myProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BooksController {

    @Autowired
    BooksDB db;

    @PostMapping("/addBooks")
    Books creatBooks(@RequestBody Books b)
    {
        db.save(b);
        return b;
    }

//    @GetMapping("/book/{title}")
//    Books getBook(@PathVariable String title){
//        return db.findById().equals(title);//how to find a column
//
//    }


    @RequestMapping("/books")
    List<Books> showMeTheBooks() {
        return db.findAll();
    }

//    @RequestMapping("/pandas")
//    List<Books> showMeThebandas() {
//        return db.findAll();
//    }


    @DeleteMapping("/book/{id}")
    String deleteBook(@PathVariable Integer id) {
        db.deleteById(id);
        return "deleted " + id;
    }
}
