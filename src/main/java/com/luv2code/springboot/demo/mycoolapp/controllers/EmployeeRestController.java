package com.luv2code.springboot.demo.mycoolapp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.luv2code.springboot.demo.mycoolapp.entities.Employee;
import com.luv2code.springboot.demo.mycoolapp.models.employee.EmployeeRequest;
import com.luv2code.springboot.demo.mycoolapp.models.employee.EmployeeResponse;
import com.luv2code.springboot.demo.mycoolapp.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    private final ObjectMapper objectMapper;

    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public EmployeeResponse getEmployees() {
        List<Employee> employees = employeeService.findAll();

        return new EmployeeResponse(employees);
    }

    @GetMapping("/employees/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.findById(id); // No need to handle null: it's not null for sure because we handle it in the service layer instead.
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        return new EmployeeResponse(employees);
    }

    @PostMapping("/employees")
    public EmployeeResponse addEmployee(@RequestBody EmployeeRequest request) {
        Employee employee = new Employee(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail()
        );
        employee.setId(0);

        Employee dbEmployee = employeeService.save(employee);
        List<Employee> employees = new ArrayList<>();
        employees.add(dbEmployee);

        return new EmployeeResponse(employees);
    }

    @PutMapping("/employees")
    public EmployeeResponse updateEmployee(@RequestBody EmployeeRequest request) {
        Employee employee = new Employee(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail()
        );
        employee.setId(request.getId());

        Employee dbEmployee = employeeService.save(employee);
        List<Employee> employees = new ArrayList<>();
        employees.add(dbEmployee);

        return new EmployeeResponse(employees);
    }

    // Map<String, Object> is used for dynamic or unknown payload.
    @PatchMapping("/employees/{id}")
    public EmployeeResponse patchEmployee(@PathVariable int id, @RequestBody Map<String, Object> patchPayload) {
        Employee employee = employeeService.findById(id); // No need to handle null: it's not null for sure because we handle it in the service layer instead.
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee id is not allowed in request body - #" + id);
        }

        Employee patchedEmployee = apply(patchPayload, employee);
        Employee dbEmployee = employeeService.save(patchedEmployee);
        List<Employee> employees = new ArrayList<>();
        employees.add(dbEmployee);

        return new EmployeeResponse(employees);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id); // No need to handle null: it's not null for sure because we handle it in the service layer instead.

        employeeService.deleteById(id);

        return "Deleted employee #" + id;
    }

    private Employee apply(Map<String, Object> patchPayload, Employee employee) {
        // Convert employee object to a JSON object node.
        ObjectNode employeeNode = objectMapper.convertValue(employee, ObjectNode.class);

        // Convert the patchPayload map to a JSON object node.
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        // Merge the patch updates into the employee node.
        employeeNode.setAll(patchNode);

        // Convert JSON object node back to Employee object.
        return objectMapper.convertValue(employeeNode, Employee.class);
    }
}

