package com.bookclub.club.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWolrd {
    
    @GetMapping("/")
    public String helloWord(){
        return "Hello World, this is my final project with GA";
    }
}
