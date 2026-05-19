package com.lpu.entity;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String name;

    private String studentClass;

    private int age;

    public Student() {
    }

    public Student(String name, String studentClass, int age) {
        this.name = name;
        this.studentClass = studentClass;
        this.age = age;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return studentId + " " + name + " " + studentClass;
    }
}