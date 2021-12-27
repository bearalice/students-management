package com.example.studentsmanagement.service;

import com.example.studentsmanagement.dao.StudentDao;
import com.example.studentsmanagement.dao.UniversityClassDao;
import com.example.studentsmanagement.exceptions.EmptyNameException;
import com.example.studentsmanagement.exceptions.InvalidClassException;
import com.example.studentsmanagement.exceptions.NotFoundException;
import com.example.studentsmanagement.model.Student;
import com.example.studentsmanagement.model.UniversityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.NotBoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentDao studentDao;
    private UniversityClassDao universityClassDao;

    public StudentService(StudentDao studentDao, UniversityClassDao universityClassDao) {
        this.studentDao = studentDao;
        this.universityClassDao = universityClassDao;
    }

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Student addStudent(Student student){
        if (student.getName().isEmpty()) {
            throw new EmptyNameException("Student name cannot be empty!");
        }
        return studentDao.save(student);
    }

    public Student updateStudent(Student student) {
        if (student.getId()==null || !studentDao.existsById(student.getId())) {
            throw new NotFoundException("Cannot find student ID!");
        }
        return studentDao.save(student);
    }

    public Student assignClass(Long studentId, Long classId) {
        if (!studentDao.existsById(studentId)) {
            throw new NotFoundException("No such student founded! " + studentId);
        }
        if (!universityClassDao.existsById(classId)) {
            throw new InvalidClassException("Cannot find class ID! " + classId);
        }
        Student student = getStudentById(studentId).get();
        UniversityClass universityClass = universityClassDao.findById(classId).get();
        student.setUniversityClass(universityClass);
        return studentDao.save(student);

    }

    public List<Student> getAllStudents(){
        return (List<Student>) studentDao.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentDao.findById(id);
    }


}
