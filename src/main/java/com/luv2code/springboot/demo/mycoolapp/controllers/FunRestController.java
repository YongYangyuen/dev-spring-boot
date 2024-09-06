package com.luv2code.springboot.demo.mycoolapp.controllers;

import com.luv2code.springboot.demo.mycoolapp.components.CoachComponent;
import com.luv2code.springboot.demo.utils.Student;
import com.luv2code.springboot.demo.utils.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    private final CoachComponent coachComponent;

    private final Teacher teacher;

    // Setter Injection: can't assign field as a final like Constructor Injection.
    private Student student;

    @Value("${my.firstname}")
    private String firstname;

    @Value("${my.lastname}")
    private String lastname;

    @Value("${learning.topic}")
    private String learningTopic;

    // Constructor Injection (for required dependencies): @Autowired is optional (no need) if you have only one constructor.
//    @Autowired
    public FunRestController(CoachComponent coachComponent, Teacher teacher) {
        this.coachComponent = coachComponent;
        this.teacher = teacher;
    }

    // Setter Injection (for optional dependencies): @Autowired is needed for every setter method, and setter method name can be any name for Setter Injection.
    @Autowired
    public void setStudent(Student student) {
        this.student = student;
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

    @GetMapping("/study/math")
    public String studyMath() {
        return student.studyMath();
    }

    @GetMapping("/study/comp")
    public String studyComp() {
        return student.studyComp();
    }
}
