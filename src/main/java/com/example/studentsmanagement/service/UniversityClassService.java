package com.example.studentsmanagement.service;

import com.example.studentsmanagement.dao.UniversityClassDao;
import com.example.studentsmanagement.exceptions.InvalidClassException;
import com.example.studentsmanagement.model.UniversityClass;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.List;

public class UniversityClassService {

    UniversityClassDao universityClassDao;

    @Autowired
    public UniversityClassService(UniversityClassDao universityClassDao) {
        this.universityClassDao = universityClassDao;
    }

    public List<UniversityClass> getAllClasses(){
        return (List<UniversityClass>) universityClassDao.findAll();
    }

    public UniversityClass addClass(UniversityClass universityClass) {
        int currenYear = Calendar.getInstance().get(Calendar.YEAR);

        if (universityClass.getYear() < currenYear) {
            throw new InvalidClassException("Cannot add class!");
        }
        if (universityClass.getYear() > currenYear + 1) {
            throw new InvalidClassException("Cannot add class in future years!");
        }

        return universityClassDao.save(universityClass);
    }

}
