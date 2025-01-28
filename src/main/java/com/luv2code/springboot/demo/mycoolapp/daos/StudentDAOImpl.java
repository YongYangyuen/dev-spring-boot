package com.luv2code.springboot.demo.mycoolapp.daos;

import com.luv2code.springboot.demo.mycoolapp.entities.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
