package com.example.demo.student;

import jdk.jfr.Enabled;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;
    private String name;
    @Transient
    private Integer age;
    private LocalDate date;
    private String email;


    public Student() {
    }

    public Student(long id, String name, LocalDate date, String email) {
        this.id = id;
        this.name = name;
//        this.age = age;
        this.date = date;
        this.email = email;
    }

    public Student(String name, LocalDate date, String email) {
        this.name = name;
//        this.age = age;
        this.date = date;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return Period.between(date, LocalDate.now()).getYears();
    }

    public LocalDate getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
