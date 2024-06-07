package com.middleware2.middleware2.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class BasicController {
    @GetMapping("/")
    public String sayWelcome(){
        return "Welcome";
    }
}
