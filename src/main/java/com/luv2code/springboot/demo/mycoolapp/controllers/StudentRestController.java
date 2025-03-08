package com.luv2code.springboot.demo.mycoolapp.controllers;

import com.luv2code.springboot.demo.mycoolapp.daos.StudentDAO;
import com.luv2code.springboot.demo.mycoolapp.entities.Student;
import com.luv2code.springboot.demo.mycoolapp.models.StudentResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private final StudentDAO studentDAO;

    private List<Student> students;

    public StudentRestController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    // Define @PostConstruct to load the secret student data ... only once!
    @PostConstruct
    public void loadSecretStudentData() {
        students = new ArrayList<>();
        students.add(new Student("XXX", "YYY", "ZZZ"));
    }

    // Define endpoint for "/students": return a list of students.
    @GetMapping("/students")
    public StudentResponse getStudents() {
        List<Student> students = studentDAO.findAll();

        return new StudentResponse(students);
    }

    @GetMapping("/students/{id}")
    public StudentResponse getStudentById(@PathVariable int id) {
        Student student = studentDAO.findById(id);
        List<Student> students = new ArrayList<>();
        students.add(student);

        return new StudentResponse(students);
    }

    @GetMapping("/students/secret")
    public StudentResponse getSecretStudent() {
        return new StudentResponse(students);
    }
}
