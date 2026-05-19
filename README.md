School Management System

A Hibernate-based Java project developed using Maven and MySQL for managing school operations such as students, teachers, subjects, attendance, and examinations.

Technologies Used
Java 21
Hibernate ORM
Apache Maven
MySQL
IntelliJ IDEA
Project Description

This project is designed to manage school-related data using Hibernate ORM.
It performs CRUD operations and HQL queries on multiple entities.

The system manages:

Students
Teachers
Subjects
Attendance
Exams
Features
Add Students
Add Teachers
Add Subjects
Record Attendance
Add Exam Marks
Update Exam Marks
Delete Attendance Records
Search Students by Class
Fetch Student Attendance
Find Teachers Teaching Specific Subjects
Fetch Toppers
Calculate Average Marks Subject Wise
Project Structure
src
 └── main
      ├── java
      │    └── com
      │         └── lpu
      │              ├── Main.java
      │              │
      │              ├── entity
      │              │      ├── Student.java
      │              │      ├── Teacher.java
      │              │      ├── Subject.java
      │              │      ├── Attendance.java
      │              │      └── Exam.java
      │              │
      │              ├── dao
      │              │      ├── StudentDAO.java
      │              │      ├── TeacherDAO.java
      │              │      ├── SubjectDAO.java
      │              │      ├── AttendanceDAO.java
      │              │      └── ExamDAO.java
      │              │
      │              └── util
      │                     └── HibernateUtil.java
      │
      └── resources
             └── hibernate.cfg.xml
Database Configuration

Database Name:

school_db

Create database manually before running project:

CREATE DATABASE school_db;
Hibernate Configuration

The project uses:

hibernate.hbm2ddl.auto = update

This automatically creates tables.

Relationships Used
One Teacher → Many Subjects
One Student → Many Attendance Records
One Student → Many Exams
HQL Queries Implemented
Fetch attendance of student
Find teachers teaching a subject
Count students in each class
Update exam marks
Delete attendance records
Join query for student-subject details
Fetch toppers in exams
Find students with low attendance
Search students by class
Fetch average marks subject-wise
How to Run
Step 1

Create database in MySQL:

CREATE DATABASE school_db;
Step 2

Open project in IntelliJ IDEA.

Step 3

Reload Maven dependencies.

Step 4

Run:

Main.java
Output

The application:

Creates tables automatically
Inserts records
Executes HQL queries
Displays results in console
Learning Outcomes

Through this project:

Understood Hibernate ORM
Learned CRUD operations
Implemented HQL queries
Learned entity relationships
Used Maven dependency management
Connected Java with MySQL database
Author

Suraj Yadav
B.Tech CSE Student
