package com.luv2code.springboot.demo.mycoolapp.controllers;

import com.luv2code.springboot.demo.mycoolapp.daos.StudentDAO;
import com.luv2code.springboot.demo.mycoolapp.entities.Student;
import com.luv2code.springboot.demo.mycoolapp.exceptions.StudentNotFoundException;
import com.luv2code.springboot.demo.mycoolapp.models.StudentErrorResponse;
import com.luv2code.springboot.demo.mycoolapp.models.StudentResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("students/secret/{id}")
    public StudentResponse getSecretStudentById(@PathVariable int id) {
        try {
            return new StudentResponse(List.of(students.get(id)));
        } catch (IndexOutOfBoundsException ex) {
            throw new StudentNotFoundException("The student #" + id + " was not found.", ex);
        }
    }

    // Add an exception handler using @ExceptionHandler.
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
        return new ResponseEntity<>(new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis()), HttpStatus.NOT_FOUND);
    }

    // Add another exception handler to catch any exception (catch all).
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAllException(Exception ex) {
        return new ResponseEntity<>(new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }
}
