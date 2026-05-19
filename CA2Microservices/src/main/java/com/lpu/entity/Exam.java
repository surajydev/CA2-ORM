package com.lpu.entity;

import jakarta.persistence.*;

@Entity
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int examId;

    private String subjectName;

    private double marks;

    @ManyToOne
    private Student student;

    public Exam() {
    }

    public Exam(String subjectName, double marks, Student student) {
        this.subjectName = subjectName;
        this.marks = marks;
        this.student = student;
    }

    public int getExamId() {
        return examId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public double getMarks() {
        return marks;
    }

    public Student getStudent() {
        return student;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return examId + " " + subjectName + " " + marks;
    }
}