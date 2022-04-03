package myProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Set;


@RestController
public class LibraryController {
    @Autowired
    LibraryDB db;
    @Autowired
    BooksDB bdb;
    @Autowired
    PersonDB pdb;

@PostMapping("/addToLibrary/{bid}/{pid}")
    void addToLibrary(@PathVariable Integer bid, @PathVariable Integer pid){

    LibraryKey lk = new LibraryKey();
        lk.setBookId(bid);
        lk.setPersonId(pid);
    Library l = new Library();
    l.setId(lk);
    Person p = pdb.findById(pid).orElseThrow(() -> new NoSuchElementException());
    Books b = bdb.findById(bid).orElseThrow(() -> new NoSuchElementException());

    l.setBook(b);
    l.setPerson(p);
    db.save(l);

}
@GetMapping("/getPage/{bid}/{pid}")
    int getPage(@PathVariable Integer bid, @PathVariable Integer pid){

    LibraryKey lk = new LibraryKey();
        lk.setBookId(bid);
        lk.setPersonId(pid);
    Library l = db.findById(lk).orElseThrow(() -> new NoSuchElementException());
    return l.getPage();
}

    @PutMapping("/setPage/{bid}/{pid}/{page}")
    int getPage(@PathVariable Integer bid, @PathVariable Integer pid,@PathVariable Integer page){

        LibraryKey lk = new LibraryKey();
            lk.setBookId(bid);
            lk.setPersonId(pid);
        Library l = db.findById(lk).orElseThrow(() -> new NoSuchElementException());
        l.setPage(page);
        return l.getPage();
    }

    @PutMapping("/setCatagory/{bid}/{pid}/{catagory}")
    int setCatagory(@PathVariable Integer bid, @PathVariable Integer pid,@PathVariable Integer catagory){

        LibraryKey lk = new LibraryKey();
            lk.setBookId(bid);
            lk.setPersonId(pid);
        Library l = db.findById(lk).orElseThrow(() -> new NoSuchElementException());
        l.setCatagory(catagory);
        return l.getCatagory();
    }

    @DeleteMapping("/deleteBookFromUser/{bid}/{pid}}")
    void setCatagory(@PathVariable Integer bid, @PathVariable Integer pid){

        LibraryKey lk = new LibraryKey();
        lk.setBookId(bid);
        lk.setPersonId(pid);
        db.deleteById(lk);
//        l.setCatagory(catagory);
//        return l.getCatagory();
    }






}
