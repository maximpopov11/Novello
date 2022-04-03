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

    @PutMapping("/setCatagory/{bid}/{pid}/{category}")
    int setCatagory(@PathVariable Integer bid, @PathVariable Integer pid,@PathVariable Integer catagory){

        LibraryKey lk = new LibraryKey();
            lk.setBookId(bid);
            lk.setPersonId(pid);
        Library l = db.findById(lk).orElseThrow(() -> new NoSuchElementException());
        l.setCategory(catagory);
        return l.getCategory();
    }

    @DeleteMapping("/deleteBookFromUser/{bid}/{pid}")
    void deleteBook(@PathVariable Integer bid, @PathVariable Integer pid){

        LibraryKey lk = new LibraryKey();
        lk.setBookId(bid);
        lk.setPersonId(pid);
        db.deleteById(lk);
//        l.setCatagory(catagory);
//        return l.getCatagory();
    }
    @GetMapping("/library/{pid}/{category}")
    Set<Library> getAllBooksFromUser(@PathVariable Integer pid,@PathVariable Integer category){
        //return by category
        Person p = pdb.findById(pid).orElseThrow(() -> new NoSuchElementException());
        return p.getLibrary();
    }

    @GetMapping("/library/{pid}")
    Set<Library> getAllBooksFromUser(@PathVariable Integer pid){
        Person p = pdb.findById(pid).orElseThrow(() -> new NoSuchElementException());
        return p.getLibrary();
    }



    @GetMapping("/getAllUsersFromBook/{bid}")
    Set<Library> getAllBooksFromBook(@PathVariable Integer bid){

        Books p = bdb.findById(bid).orElseThrow(() -> new NoSuchElementException());
        return p.getLibrary();
    }







}
