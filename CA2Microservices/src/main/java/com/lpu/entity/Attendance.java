package com.lpu.entity;

import jakarta.persistence.*;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attendanceId;

    private String attendanceDate;

    private String status;

    @ManyToOne
    private Student student;

    public Attendance() {
    }

    public Attendance(String attendanceDate, String status, Student student) {
        this.attendanceDate = attendanceDate;
        this.status = status;
        this.student = student;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public String getStatus() {
        return status;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return attendanceId + " " + attendanceDate + " " + status;
    }
}