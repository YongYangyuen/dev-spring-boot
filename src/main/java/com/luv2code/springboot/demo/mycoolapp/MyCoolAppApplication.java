package com.luv2code.springboot.demo.mycoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Can use 2 ways for all components scan
//@SpringBootApplication(scanBasePackages = {"com.luv2code.springboot.demo.mycoolapp", "com.luv2code.springboot.demo.utils"})
@SpringBootApplication(scanBasePackages = {"com.luv2code.springboot.demo"})
public class MyCoolAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCoolAppApplication.class, args);
    }

}
