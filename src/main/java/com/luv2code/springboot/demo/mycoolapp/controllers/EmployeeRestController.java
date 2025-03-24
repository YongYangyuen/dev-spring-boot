package com.luv2code.springboot.demo.mycoolapp.controllers;

import com.luv2code.springboot.demo.mycoolapp.entities.Employee;
import com.luv2code.springboot.demo.mycoolapp.models.EmployeeResponse;
import com.luv2code.springboot.demo.mycoolapp.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public EmployeeResponse getEmployees() {
        List<Employee> employees = employeeService.findAll();

        return new EmployeeResponse(employees);
    }
}
