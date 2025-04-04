package com.luv2code.springboot.demo.mycoolapp.repositories;

import com.luv2code.springboot.demo.mycoolapp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// JPA Repository is used to minimize the boilerplate code in dao files (both interface and implementation files are not needed anymore).
// JpaRepository<Employee, Integer> => Employee: Entity type, Integer: Primary key.
// Using @RepositoryRestResource to change default path (Entity name in plural: employees) for Spring Data REST.
//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // JPA Repository has CRUD methods (findAll, findById, save, deleteById, and others) by default, so we don't need to implement CRUD methods by ourselves.
}
