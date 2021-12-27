package com.example.studentsmanagement.dao;

import com.example.studentsmanagement.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentDao extends CrudRepository<Student, Long> {

}
