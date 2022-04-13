package myProject;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Autowired
	UserInterface db;

    @Autowired
    UserInfoInterface userInfoInterfaceDB;

    @GetMapping("/user/{id}")
	User getUser(@PathVariable Integer id) {
        return db.findById(id).
                orElseThrow(RuntimeException::new);
    }

    @GetMapping("/login")
    JSONObject login(@RequestBody JSONObject json){

        User user;
        JSONObject jsonReturn = new JSONObject();
        int i;
        for(i = 1; i<=db.count(); i++){
            user = db.findById(i).orElseThrow(RuntimeException::new);
            if(user.username.equals(json.getAsString("username"))){
                if(user.password.equals(json.getAsString("password"))){
                    jsonReturn.put("userId",i);
                    return jsonReturn;
                }
            }
        }
        return null;
    }


    @PostMapping("/addAllUsers")
    void createAllPersons(@RequestBody User[] p) {
        db.saveAll(Arrays.asList(p));

    }

    @RequestMapping("/users")
    List<User> getPersons() {
        return db.findAll();
    }

    @PostMapping("/user")
	User createPerson(@RequestBody JSONObject jsonObject) {
        User u = new User();
        u.setAccountType((Integer) jsonObject.getAsNumber("accountType"));
        u.setUsername(jsonObject.getAsString("username"));
        u.setPassword(jsonObject.getAsString("password"));
        u.setSecurityQuestion(jsonObject.getAsString("securityQuestion"));
        u.setSecurityAnswer(jsonObject.getAsString("securityAnswer"));

        UserInfo ui = new UserInfo();
        ui.setUser(u);
        ui.setAge((Integer) jsonObject.getAsNumber("age"));
        ui.setEmail(jsonObject.getAsString("email"));
        ui.setName(jsonObject.getAsString("name"));

        u.setUserInfo(ui);


//        bookDataKey.setBookId((Integer) jsonObject.getAsNumber("bookId"));
//        bookDataKey.setUserId((Integer) jsonObject.getAsNumber("userId"));
        db.save(u);
        userInfoInterfaceDB.save(ui);
        return u;
    }

    @PutMapping("/user/{id}")
	User updatePerson(@RequestBody User p, @PathVariable Integer id) {
        User old_p = db.findById(id).orElseThrow(RuntimeException::new);
//        if (p.name != null)
//            old_p.setName(p.name);
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
//        if (p.email != null)
//            old_p.setEmail(p.email);
//        if (p.age != null)
//            old_p.setAge(p.age);
        db.save(old_p);
        return old_p;
    }

    @DeleteMapping("/user/{id}")
    String deletePerson(@PathVariable Integer id) {
        db.deleteById(id);
        return "deleted " + id;
    }



}
