package com.luv2code.springboot.demo.utils;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class TeacherImpl implements Teacher {
    public TeacherImpl() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // Define our init method.
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
    }

    // Define our destroy method.
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
    }

    @Override
    public String teachMath() {
        return "1 + 1 = 2";
    }

    @Override
    public String teachComp() {
        return "1 + 1 = 0 (In binary)";
    }
}
