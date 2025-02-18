package com.luv2code.springboot.demo.mycoolapp.daos;

import com.luv2code.springboot.demo.mycoolapp.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    // Define field for Entity Manager.
    private final EntityManager entityManager;

    // Inject Entity Manager using Constructor Injection.
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Implement save method.
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // Create query.
        // Student is the JPA Entity class name, not the database table name.
        // lastname is the JPA Entity field name, not the database field name.
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // Return query results.
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // Create query.
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName = :theLastName", Student.class);

        // Set query parameters.
        theQuery.setParameter("theLastName", lastName);

        // Return query results.
        return theQuery.getResultList();
    }
}
