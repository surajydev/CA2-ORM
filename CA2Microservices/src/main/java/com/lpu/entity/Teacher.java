package com.lpu.entity;

import jakarta.persistence.*;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;

    private String teacherName;

    private String department;

    public Teacher() {
    }

    public Teacher(String teacherName, String department) {
        this.teacherName = teacherName;
        this.department = department;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getDepartment() {
        return department;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    @Override
    public String toString() {
        return teacherId + " " + teacherName + " " + department;
    }
}