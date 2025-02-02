package com.luv2code.springboot.demo.mycoolapp.daos;

import com.luv2code.springboot.demo.mycoolapp.entities.Student;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);
}
