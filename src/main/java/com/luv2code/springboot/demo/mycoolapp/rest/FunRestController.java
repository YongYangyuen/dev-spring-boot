package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${my.firstname}")
    private String firstname;

    @Value("${my.lastname}")
    private String lastname;

    // Expose "/" that return "Hello World!"
    @GetMapping("/")
    public String sayHello() {
        return "<h1>Hello World!</h1>";
    }

    // Expose "/name" that return "Hello World! My name is Yong Yangyuen."
    @GetMapping("/name")
    public String introduce() {
        return sayHello() + "My name is " + firstname + " " + lastname + ".";
    }

}
