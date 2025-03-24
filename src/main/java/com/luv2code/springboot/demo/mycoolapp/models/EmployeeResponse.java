package com.luv2code.springboot.demo.mycoolapp.models;

import com.luv2code.springboot.demo.mycoolapp.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private List<Employee> employees;
}
