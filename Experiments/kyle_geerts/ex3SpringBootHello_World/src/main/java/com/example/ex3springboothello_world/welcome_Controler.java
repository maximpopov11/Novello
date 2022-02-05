package com.example.ex3springboothello_world;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcome_Controler {
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Spring boot world!";
    }
    @GetMapping("/help")
    public String help(){
        return "You Have been helped";
    }
}
