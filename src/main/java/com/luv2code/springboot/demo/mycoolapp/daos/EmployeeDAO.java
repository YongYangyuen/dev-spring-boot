package com.luv2code.springboot.demo.mycoolapp.daos;

import com.luv2code.springboot.demo.mycoolapp.entities.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
