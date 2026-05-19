package com.lpu.dao;

import com.lpu.entity.Teacher;
import com.lpu.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class TeacherDAO {

    // save teacher

    public void saveTeacher(Teacher teacher)
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Transaction t = s.beginTransaction();

        s.persist(teacher);

        t.commit();

        s.close();
    }

    // find all teachers

    public void findAllTeachers()
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Query q = s.createQuery("FROM Teacher", Teacher.class);

        List<Teacher> teachers = q.getResultList();

        teachers.forEach(System.out::println);

        s.close();
    }

    // find teacher by id

    public Teacher findTeacherById(int id)
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Optional<Teacher> teacher =
                Optional.ofNullable(s.find(Teacher.class, id));

        s.close();

        if(teacher.isEmpty())
        {
            System.out.println("Teacher not found");

            return null;
        }

        return teacher.get();
    }

    // update teacher

    public void updateTeacherById(int id)
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Transaction t = s.beginTransaction();

        Teacher oldTeacher = s.find(Teacher.class, id);

        if(oldTeacher == null)
        {
            System.out.println("Teacher not found");
        }
        else {

            oldTeacher.setTeacherName("Amit Sharma");

            oldTeacher.setDepartment("Computer Science");

            s.merge(oldTeacher);

            System.out.println("Teacher updated successfully");
        }

        t.commit();

        s.close();
    }

    // delete teacher

    public void deleteTeacherById(int id)
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Transaction t = s.beginTransaction();

        Teacher teacher = s.find(Teacher.class, id);

        if(teacher == null)
        {
            System.out.println("Teacher not found");
        }
        else {

            s.remove(teacher);

            System.out.println("Teacher deleted successfully");
        }

        t.commit();

        s.close();
    }

    // find teachers teaching subject

    public void findTeachersTeachingSubject(String subjectName)
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Query q = s.createQuery(
                "select sub.teacher from Subject sub where sub.subjectName=:name",
                Teacher.class
        );

        q.setParameter("name", subjectName);

        List<Teacher> teachers = q.getResultList();

        teachers.forEach(System.out::println);

        s.close();
    }
}