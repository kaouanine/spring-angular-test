package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(value = "/articles")

@RestController
public class controler {

    @PostMapping()
    public void oddArticle(@RequestParam("image") MultipartFile f){
        System.out.print(f);

    }

}
