package com.example.putting_all_experimentation_together;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class BooksController {
    ArrayList<Books> panda = new ArrayList<Books>();
    @GetMapping("/books")
    public @ResponseBody ArrayList<Books> creatABook()
    {
        return panda;

    }

}
