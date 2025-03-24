package com.luv2code.springboot.demo.mycoolapp.controllers;

import com.luv2code.springboot.demo.mycoolapp.daos.EmployeeDAO;
import com.luv2code.springboot.demo.mycoolapp.entities.Employee;
import com.luv2code.springboot.demo.mycoolapp.models.EmployeeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeDAO employeeDAO;

    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employees")
    public EmployeeResponse getEmployees() {
        List<Employee> employees = employeeDAO.findAll();

        return new EmployeeResponse(employees);
    }
}
