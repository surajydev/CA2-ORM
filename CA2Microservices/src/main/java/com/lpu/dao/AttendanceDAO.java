package com.lpu.dao;

import com.lpu.entity.Attendance;
import com.lpu.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class AttendanceDAO {

    // save attendance

    public void saveAttendance(Attendance attendance)
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Transaction t = s.beginTransaction();

        s.persist(attendance);

        t.commit();

        s.close();
    }

    // find all attendance records

    public void findAllAttendance()
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Query q = s.createQuery("FROM Attendance", Attendance.class);

        List<Attendance> attendanceList = q.getResultList();

        attendanceList.forEach(System.out::println);

        s.close();
    }

    // fetch attendance of student

    public void fetchAttendanceOfStudent(int id)
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Query q = s.createQuery(
                "FROM Attendance where student.studentId=:id",
                Attendance.class
        );

        q.setParameter("id", id);

        List<Attendance> attendanceList = q.getResultList();

        attendanceList.forEach(System.out::println);

        s.close();
    }

    // delete attendance record

    public void deleteAttendanceById(int id)
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Transaction t = s.beginTransaction();

        Attendance attendance = s.find(Attendance.class, id);

        if(attendance == null)
        {
            System.out.println("Attendance not found");
        }
        else {

            s.remove(attendance);

            System.out.println("Attendance deleted successfully");
        }

        t.commit();

        s.close();
    }

    // find students with low attendance

    public void findStudentsWithLowAttendance()
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Query q = s.createQuery(
                "select student.name , count(*) from Attendance " +
                        "where status='Absent' group by student.name"
        );

        List<Object[]> list = q.getResultList();

        for(Object[] obj : list)
        {
            System.out.println(obj[0] + " Absent Count : " + obj[1]);
        }

        s.close();
    }
}