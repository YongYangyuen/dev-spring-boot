package com.luv2code.springboot.demo.mycoolapp;

import com.luv2code.springboot.demo.mycoolapp.daos.StudentDAO;
import com.luv2code.springboot.demo.mycoolapp.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
            System.out.println("Hello World.");

            createStudent(studentDAO);
            createMultipleStudents(studentDAO);
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
        Student student2 = new Student("Sakorn", "Yangyuen", "kantika.y@outlook.com");
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

}
