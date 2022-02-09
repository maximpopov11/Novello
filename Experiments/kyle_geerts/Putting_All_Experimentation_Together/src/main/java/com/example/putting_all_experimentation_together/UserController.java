package com.example.putting_all_experimentation_together;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
@RestController
public class UserController {
    int id = 0;

    HashMap<String, User> userList = new HashMap<>();

    @GetMapping("/user")
    public @ResponseBody HashMap<String,User> getAllUsers(){
        return userList;
    }

    @PostMapping("/user")
    public @ResponseBody String creatUser(@RequestBody User user){
        System.out.println(user);
        user.setUserId(String.valueOf(id));
        id++;
        userList.put(user.getUserId(), user);
        return "New User " + user.getFirstName() +  " Saved";
    }

    @GetMapping("/user/{id}")
    public @ResponseBody User getUser(@PathVariable String id) {
        User u = userList.get(id);
        return u;
    }

}
