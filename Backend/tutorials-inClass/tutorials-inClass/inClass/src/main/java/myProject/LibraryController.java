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


}
