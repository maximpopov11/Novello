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
        for(int i = 0; i < p.length; i++)
        {

        }
        db.saveAll(Arrays.asList(p));

    }

    @GetMapping("/users")//was request mapping
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

        db.save(u);
        userInfoInterfaceDB.save(ui);
        return u;
    }

    @PutMapping("/user/{id}")
	User updatePerson(@RequestBody JSONObject jsonObject, @PathVariable Integer id) {
        User old_u = db.findById(id).orElseThrow(RuntimeException::new);
        UserInfo old_ui = old_u.getUserInfo();
        if (jsonObject.getAsString("name") != null)
            old_ui.setName(jsonObject.getAsString("name"));
        if ((Integer) jsonObject.getAsNumber("accountType") != null)
            old_u.setAccountType((Integer) jsonObject.getAsNumber("accountType"));
        if (jsonObject.getAsString("username") != null)
            old_u.setUsername(jsonObject.getAsString("username"));
        if (jsonObject.getAsString("password") != null)
            old_u.setPassword(jsonObject.getAsString("password"));
        if (jsonObject.getAsString("securityAnswer")!= null)
            old_u.setSecurityAnswer(jsonObject.getAsString("securityAnswer"));
        if (jsonObject.getAsString("securityQuestion") != null)
            old_u.setSecurityQuestion(jsonObject.getAsString("securityQuestion"));
        if (jsonObject.getAsString("email") != null)
            old_ui.setEmail(jsonObject.getAsString("email"));
        if ((Integer) jsonObject.getAsNumber("age") != null)
            old_ui.setAge((Integer) jsonObject.getAsNumber("age"));
        db.save(old_u);
        userInfoInterfaceDB.save((old_ui));
        return old_u;
    }

    @DeleteMapping("/user/{id}")
    String deletePerson(@PathVariable Integer id) {
        db.deleteById(id);
        return "deleted " + id;
    }



}
