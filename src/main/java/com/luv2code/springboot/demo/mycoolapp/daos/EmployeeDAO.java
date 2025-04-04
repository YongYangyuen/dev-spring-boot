package com.luv2code.springboot.demo.mycoolapp.daos;

import com.luv2code.springboot.demo.mycoolapp.entities.Employee;

import java.util.List;

// Make use of Spring Data JPA instead of DAO in mvp20.
public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
