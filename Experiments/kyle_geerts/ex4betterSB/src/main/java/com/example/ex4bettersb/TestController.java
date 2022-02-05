package com.example.ex4bettersb;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/getTest")
    public String getTest(@RequestParam(value = "username", defaultValue = "World") String message) {
        return String.format("Hello, %s! You sent a get request with a parameter!", message);
    }

    @PostMapping("/postTest1")
    public String postTest1(@RequestParam(value = "username", defaultValue = "World") String message) {
        //TODO

        return String.format("Hello, %s! You sent a post request with a parameter!", message);
    }

    @PostMapping("/postTest2")
    public String postTest2(@RequestBody TestData testData) {
        //TODO

        return String.format("Hello, %s! welcome to this nightmare. Your Uid is:%d", testData.getMessage(), testData.getUid());
    }
    @PostMapping("/postTest3")
    public void postTest3(@RequestBody TestData testData)
    {
        System.out.print("Does this work");
    }

    @DeleteMapping("/deleteTest")
    public void deleteTest() {
        //TODO
    }

    @PutMapping("/putTest")
    public void putTest() {
        //TODO
    }
}
