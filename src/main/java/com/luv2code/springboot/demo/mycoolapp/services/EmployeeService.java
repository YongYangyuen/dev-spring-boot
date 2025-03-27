package com.luv2code.springboot.demo.mycoolapp.services;

import com.luv2code.springboot.demo.mycoolapp.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
