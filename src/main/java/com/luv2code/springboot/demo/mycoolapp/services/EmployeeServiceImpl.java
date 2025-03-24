package com.luv2code.springboot.demo.mycoolapp.services;

import com.luv2code.springboot.demo.mycoolapp.daos.EmployeeDAO;
import com.luv2code.springboot.demo.mycoolapp.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
