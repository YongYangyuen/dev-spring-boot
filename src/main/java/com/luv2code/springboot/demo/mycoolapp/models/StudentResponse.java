package com.luv2code.springboot.demo.mycoolapp.models;

import com.luv2code.springboot.demo.mycoolapp.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private List<Student> students;
}
