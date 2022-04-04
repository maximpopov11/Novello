package myProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
	UserInterface db;

    @GetMapping("/person/{id}")
	User getPerson(@PathVariable Integer id) {
        return db.findById(id).
                orElseThrow(RuntimeException::new);
    }

    //getmapping person {json: username and password}
    //user id
    //0 if failed


    @PostMapping("/addAllPersons")
    void createAllPersons(@RequestBody User[] p) {
        for (int i = 0; i < p.length; i++) {
            db.save(p[i]);
        }

    }

    @RequestMapping("/persons")
    List<User> getPersons() {
        return db.findAll();
    }

    @PostMapping("/person")
	User createPerson(@RequestBody User p) {
        db.save(p);
        return p;
    }

    @PutMapping("/person/{id}")
	User updatePerson(@RequestBody User p, @PathVariable Integer id) {
        User old_p = db.findById(id).orElseThrow(RuntimeException::new);
        if (p.name != null)
            old_p.setName(p.name);
        if (p.accountType != null)
            old_p.setAccountType(p.accountType);
        if (p.username != null)
            old_p.setUsername(p.username);
        if (p.password != null)
            old_p.setPassword(p.password);
        if (p.securityAnswer != null)
            old_p.setSecurityAnswer(p.securityAnswer);
        if (p.securityQuestion != null)
            old_p.setSecurityQuestion(p.securityQuestion);
        if (p.email != null)
            old_p.setEmail(p.email);
        if (p.age != null)
            old_p.setAge(p.age);
        db.save(old_p);
        return old_p;
    }

    @DeleteMapping("/person/{id}")
    String deletePerson(@PathVariable Integer id) {
        db.deleteById(id);
        return "deleted " + id;
    }

}
