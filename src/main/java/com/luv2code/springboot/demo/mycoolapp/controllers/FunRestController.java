package com.luv2code.springboot.demo.mycoolapp.controllers;

import com.luv2code.springboot.demo.mycoolapp.components.CoachComponent;
import com.luv2code.springboot.demo.utils.Teacher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    private final CoachComponent coachComponent;

    private final Teacher teacher;

    @Value("${my.firstname}")
    private String firstname;

    @Value("${my.lastname}")
    private String lastname;

    @Value("${learning.topic}")
    private String learningTopic;

    // @Autowired is no need if you have only one constructor.
//    @Autowired
    public FunRestController(CoachComponent coachComponent, Teacher teacher) {
        this.coachComponent = coachComponent;
        this.teacher = teacher;
    }

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

    @GetMapping("/topic")
    public String getTopic() {
        return "Learning Topic: " + "<h1>" + learningTopic + "</h1>";
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return coachComponent.getDailyWorkout();
    }

    @GetMapping("/teach/math")
    public String teachMath() {
        return teacher.teachMath();
    }

    @GetMapping("/teach/comp")
    public String teachComp() {
        return teacher.teachComp();
    }
}
