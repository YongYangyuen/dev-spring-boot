//package com.luv2code.springboot.demo.mycoolapp.services;
//
//import com.luv2code.springboot.demo.mycoolapp.entities.Employee;
//import com.luv2code.springboot.demo.mycoolapp.exceptions.DataNotFoundException;
//import com.luv2code.springboot.demo.mycoolapp.repositories.EmployeeRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//// Use Repository instead of DAO in mvp20.
//@Service
//public class EmployeeServiceImpl implements EmployeeService {
//    // ==================== DAO using part ====================
////    public final EmployeeDAO employeeDAO;
////
////    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
////        this.employeeDAO = employeeDAO;
////    }
////
////    @Override
////    public List<Employee> findAll() {
////        return employeeDAO.findAll();
////    }
////
////    @Override
////    public Employee findById(int id) {
////        return employeeDAO.findById(id);
////    }
////
////    @Override
////    @Transactional
////    public Employee save(Employee employee) {
////        return employeeDAO.save(employee);
////    }
////
////    @Override
////    @Transactional
////    public void deleteById(int id) {
////        employeeDAO.deleteById(id);
////    }
//    // ==================== DAO using part ====================
//
//    // ==================== Repository using part ====================
//    private final EmployeeRepository employeeRepository;
//
//    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        return employeeRepository.findAll();
//    }
//
//    // "Optional": Different pattern instead of having to check for nulls. Feature introduced in Java 8.
//    @Override
//    public Employee findById(int id) {
//        Optional<Employee> employee = employeeRepository.findById(id);
//        if (employee.isEmpty()) {   // Able to use .isPresent() as well which is the opposite method for null check.
//            throw new DataNotFoundException("The employee #" + id + " was not found.");
//        }
//
//        return employee.get(); // .get() is used to get the real value of that specific object type.
//    }
//
//    // Remove @Transactional since JpaRepository provides this functionality.
//    @Override
//    public Employee save(Employee employee) {
//        return employeeRepository.save(employee);
//    }
//
//    // Remove @Transactional since JpaRepository provides this functionality.
//    @Override
//    public void deleteById(int id) {
//        employeeRepository.deleteById(id);
//    }
//    // ==================== Repository using part ====================
//}
// This file is no need because of using Spring Data REST instead.
