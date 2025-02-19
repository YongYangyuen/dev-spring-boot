package com.luv2code.springboot.demo.mycoolapp;

import com.luv2code.springboot.demo.mycoolapp.daos.StudentDAO;
import com.luv2code.springboot.demo.mycoolapp.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

// Can use 2 ways for all components scan
//@SpringBootApplication(scanBasePackages = {"com.luv2code.springboot.demo.mycoolapp", "com.luv2code.springboot.demo.utils"})
@SpringBootApplication(scanBasePackages = {"com.luv2code.springboot.demo"})
public class MyCoolAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCoolAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            System.out.println("==================================================");
            System.out.println("Hello World.");
            System.out.println("==================================================");

            // CREATE (C)
//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);

            // READ (R)
//            readStudent(studentDAO, 2);
            readAllStudents(studentDAO);
//            readStudentsByLastName(studentDAO, "Yangyuen");

            // UPDATE (U)
//            updateStudent(studentDAO);

            // DELETE (D)
            deleteStudent(studentDAO, 1);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        // Create the student object.
        System.out.println("Creating new Student object ...");
        Student student = new Student("Yong", "Yangyuen", "yong.yyy@outlook.com");

        // Save the student object.
        System.out.println("Saving the student ...");
        studentDAO.save(student);

        // Display id of the saved student.
        System.out.println("Saved student. Generated id: " + student.getId());
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        // Create multiple students.
        System.out.println("Creating 3 student objects ...");
        Student student1 = new Student("Kantika", "Sitdikovit", "kantika.s@outlook.com");
        Student student2 = new Student("Sakorn", "Yangyuen", "sakorn.y@outlook.com");
        Student student3 = new Student("Amnuai", "Yangyuen", "amnuai.y@outlook.com");

        // Save the students objects.
        System.out.println("Saving the students ...");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);

        // Display id of the saved students.
        System.out.println("Saved student1. Generated id: " + student1.getId());
        System.out.println("Saved student2. Generated id: " + student2.getId());
        System.out.println("Saved student3. Generated id: " + student3.getId());
    }

    private void readStudentById(StudentDAO studentDAO, Integer id) {
        // Read the student by id.
        System.out.println("Reading student id " + id + " ...");
        Student student = studentDAO.findById(id);

        System.out.println("The student #" + id + ": " + student);
    }

    private void readAllStudents(StudentDAO studentDAO) {
        // Read all students.
        System.out.println("Reading all students ...");
        List<Student> allStudents = studentDAO.findAll();

        System.out.println("Found " + allStudents.size() + " student(s).");
        for (Student student : allStudents) {
            System.out.println("The student #" + student.getId() + ": " + student);
        }
    }

    private void readStudentsByLastName(StudentDAO studentDAO, String lastName) {
        // Read all students by last name.
        System.out.println("Reading students whose last name is \"" + lastName + "\" ...");
        List<Student> students = studentDAO.findByLastName(lastName);

        if (students.isEmpty()) {
            System.out.println("No students with last name \"" + lastName + "\" found.");
        } else {
            System.out.println("Found " + students.size() + " student(s).");
            for (Student student : students) {
                System.out.println("The student #" + student.getId() + ": " + student);
            }
        }
    }

    private void updateStudent(StudentDAO studentDAO) {
        // Retrieve student based on the id: primary key.
        int studentId = 1;
        System.out.println("Getting student #" + studentId + " ...");
        Student student = studentDAO.findById(studentId);
        System.out.println("Found student #" + student.getId() + ": " + student);

        // Change last name to "Blossom".
        System.out.println("Updating student ...");
        student.setLastName("Yangyuen");

        // Update the student.
        studentDAO.update(student);

        // Display the updated student.
        System.out.println("Updated student #" + student.getId() + ": " + student);
    }

    private void deleteStudent(StudentDAO studentDAO, Integer id) {
        System.out.println("Deleting student #" + id + " ...");
        studentDAO.delete(id);

        System.out.println("Deleted student #" + id);
        readAllStudents(studentDAO);
    }

}
