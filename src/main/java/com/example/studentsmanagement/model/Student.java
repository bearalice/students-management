package com.example.studentsmanagement.model;

import javax.persistence.*;

//produce a table
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="university_class_id")
    private UniversityClass universityClass;

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUniversityClass(UniversityClass universityClass) {
        this.universityClass = universityClass;
    }

    public UniversityClass getUniversityClass() {
        return universityClass;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String studentInfo="";
        studentInfo += "Primary ID:" + getId();
        studentInfo += " Name: "+ getName();
        return studentInfo;
    }
}
