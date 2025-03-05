package com.luv2code.springboot.demo.mycoolapp.controllers;

import com.luv2code.springboot.demo.mycoolapp.daos.StudentDAO;
import com.luv2code.springboot.demo.mycoolapp.entities.Student;
import com.luv2code.springboot.demo.mycoolapp.models.StudentResponse;
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

    public StudentRestController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    // Define endpoint for "/students": return a list of students.
    @GetMapping("/students")
    public StudentResponse getStudents() {
        List<Student> students = studentDAO.findAll();

        return new StudentResponse(students);
    }

    @GetMapping("/students/{id}")
    public StudentResponse getStudentById(@PathVariable Integer id) {
        Student student = studentDAO.findById(id);
        List<Student> students = new ArrayList<>();
        students.add(student);

        return new StudentResponse(students);
    }
}
