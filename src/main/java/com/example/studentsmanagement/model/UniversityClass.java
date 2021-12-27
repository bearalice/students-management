package com.example.studentsmanagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="university_class")
public class UniversityClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    Integer year;

    @Column(nullable = false)
    Integer classNumber;

    @OneToMany(mappedBy = "universityClass")
    List<Student> students;

    public UniversityClass(Long id, Integer year, Integer classNumber) {
        this.id = id;
        this.year = year;
        this.classNumber = classNumber;
    }

    public UniversityClass() {}

    public void setId(Long id) {
        this.id = id;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public Long getId() {
        return id;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getClassNumber() {
        return classNumber;
    }

    @Override
    public String toString() {
        String classInfo="";
        classInfo += "Primary ID: " + getId();
        classInfo += " year: " + getYear();
        classInfo += " class number: " + getClassNumber();
        return classInfo;
    }
}
