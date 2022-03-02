package myProject;

import java.util.List;
import java.util.Optional;

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

//    @GetMapping("/book/{id}")
//    Books getBook(@PathVariable String id){
//        return db.findById(id);//how to find a column
//    }

    @GetMapping("/book/{id}")
    Optional<Books> getBook(@PathVariable Integer id){
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
