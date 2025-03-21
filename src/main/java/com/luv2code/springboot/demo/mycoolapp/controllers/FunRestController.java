package com.luv2code.springboot.demo.mycoolapp.controllers;

import com.luv2code.springboot.demo.mycoolapp.components.Coach;
import com.luv2code.springboot.demo.utils.Student;
import com.luv2code.springboot.demo.utils.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/king")
public class FunRestController {
    private final Coach mainCoach;

    private final Coach breakingCoach;

    private final Coach anotherBreakingCoach;

    private final Coach swimmingCoach;

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
    public FunRestController(Coach mainCoach,
                             @Qualifier("breakingCoach") Coach breakingCoach,
                             @Qualifier("breakingCoach") Coach anotherBreakingCoach,
                             @Qualifier("aquaticCoach") Coach swimmingCoach, // The Bean ID is the method name "swimmingCoach" in the @Configuration by default if you don't configure Bean ID after @Bean "aquaticCoach".
                             Teacher teacher) {
        System.out.println("In constructor " + getClass().getSimpleName());

        this.mainCoach = mainCoach;
        this.breakingCoach = breakingCoach;
        this.anotherBreakingCoach = anotherBreakingCoach;
        this.swimmingCoach = swimmingCoach;
        this.teacher = teacher;
    }

    // Setter Injection (for optional dependencies): @Autowired is needed for every setter method, and setter method name can be any name for Setter Injection.
    @Autowired
    public void setStudent(Student student) {
        this.student = student;
    }

    // Expose "/" that return "Hello World!"
    @GetMapping("/hello")
    public String sayHello() {
        return "<h1>Hello World!</h1>" + "<br>HTTP Status Code: " + HttpStatus.OK;
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

    @GetMapping("/dailyExercise")
    public String getDailyExercise() {
        return mainCoach.getDailyWorkout();
    }

    @GetMapping("/dailyBreaking")
    public String getDailyBreaking() {
        return breakingCoach.getDailyWorkout();
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

    @GetMapping("/isTheSameBreakingCoach")
    public String isTheSameBreakingCoachBean() {
        // Singleton: true (The same Bean, shared Memories by default.)
        // Prototype: false (Not the same Bean, not shared memories.)
        return "Comparing Beans: breakingCoach == anotherBreakingCoach, " + (breakingCoach == anotherBreakingCoach);
    }

    @GetMapping("/dailySwimming")
    public String getDailySwimming() {
        return swimmingCoach.getDailyWorkout();
    }
}
