package com.lpu;

import com.lpu.dao.AttendanceDAO;
import com.lpu.dao.ExamDAO;
import com.lpu.dao.StudentDAO;
import com.lpu.dao.SubjectDAO;
import com.lpu.dao.TeacherDAO;
import com.lpu.entity.Attendance;
import com.lpu.entity.Exam;
import com.lpu.entity.Student;
import com.lpu.entity.Subject;
import com.lpu.entity.Teacher;

public class Main {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();

        TeacherDAO teacherDAO = new TeacherDAO();

        SubjectDAO subjectDAO = new SubjectDAO();

        AttendanceDAO attendanceDAO = new AttendanceDAO();

        ExamDAO examDAO = new ExamDAO();


        // SAVE TEACHERS


        Teacher t1 = new Teacher(
                "Rahul Sharma",
                "Computer Science"
        );

        Teacher t2 = new Teacher(
                "Anita Verma",
                "Mathematics"
        );

        teacherDAO.saveTeacher(t1);

        teacherDAO.saveTeacher(t2);


        // SAVE SUBJECTS


        Subject s1 = new Subject(
                "Java",
                t1
        );

        Subject s2 = new Subject(
                "DBMS",
                t1
        );

        Subject s3 = new Subject(
                "Mathematics",
                t2
        );

        subjectDAO.saveSubject(s1);

        subjectDAO.saveSubject(s2);

        subjectDAO.saveSubject(s3);


        // SAVE STUDENTS


        Student st1 = new Student(
                "Aman",
                "BTech CSE",
                20
        );

        Student st2 = new Student(
                "Priya",
                "BTech CSE",
                21
        );

        Student st3 = new Student(
                "Karan",
                "BTech IT",
                22
        );

        studentDAO.saveStudent(st1);

        studentDAO.saveStudent(st2);

        studentDAO.saveStudent(st3);


        // SAVE ATTENDANCE


        Attendance a1 = new Attendance(
                "2026-05-19",
                "Present",
                st1
        );

        Attendance a2 = new Attendance(
                "2026-05-19",
                "Absent",
                st2
        );

        Attendance a3 = new Attendance(
                "2026-05-19",
                "Present",
                st3
        );

        attendanceDAO.saveAttendance(a1);

        attendanceDAO.saveAttendance(a2);

        attendanceDAO.saveAttendance(a3);


        // SAVE EXAMS


        Exam e1 = new Exam(
                "Java",
                92,
                st1
        );

        Exam e2 = new Exam(
                "DBMS",
                78,
                st2
        );

        Exam e3 = new Exam(
                "Mathematics",
                88,
                st3
        );

        examDAO.saveExam(e1);

        examDAO.saveExam(e2);

        examDAO.saveExam(e3);


        // FETCH ALL DATA

        System.out.println("\n===== ALL STUDENTS =====");

        studentDAO.findAllStudents();

        System.out.println("\n===== ALL TEACHERS =====");

        teacherDAO.findAllTeachers();

        System.out.println("\n===== ALL SUBJECTS =====");

        subjectDAO.findAllSubjects();

        System.out.println("\n===== ALL EXAMS =====");

        examDAO.findAllExams();


        // HQL QUERIES


        System.out.println("\n===== ATTENDANCE OF STUDENT =====");

        attendanceDAO.fetchAttendanceOfStudent(1);

        System.out.println("\n===== TEACHERS TEACHING JAVA =====");

        teacherDAO.findTeachersTeachingSubject("Java");

        System.out.println("\n===== COUNT STUDENTS IN EACH CLASS =====");

        studentDAO.countStudentsInEachClass();

        System.out.println("\n===== UPDATE EXAM MARKS =====");

        examDAO.updateExamMarks(1);

        System.out.println("\n===== DELETE ATTENDANCE =====");

        attendanceDAO.deleteAttendanceById(2);

        System.out.println("\n===== JOIN QUERY =====");

        examDAO.joinQueryStudentSubjectDetails();

        System.out.println("\n===== TOPPERS =====");

        examDAO.fetchToppersInExam();

        System.out.println("\n===== LOW ATTENDANCE =====");

        attendanceDAO.findStudentsWithLowAttendance();

        System.out.println("\n===== SEARCH STUDENTS BY CLASS =====");

        studentDAO.searchStudentsByClass("BTech CSE");

        System.out.println("\n===== AVERAGE MARKS SUBJECT WISE =====");

        examDAO.fetchAverageMarksSubjectWise();

        System.out.println("\n===== PROJECT EXECUTED SUCCESSFULLY =====");
    }
}