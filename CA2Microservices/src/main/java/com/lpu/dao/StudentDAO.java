package com.lpu.dao;

import com.lpu.entity.Student;
import com.lpu.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class StudentDAO {

    // save student

    public void saveStudent(Student student)
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Transaction t = s.beginTransaction();

        s.persist(student);

        t.commit();

        s.close();
    }

    // find all students

    public void findAllStudents()
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Query q = s.createQuery("FROM Student", Student.class);

        List<Student> students = q.getResultList();

        students.forEach(System.out::println);

        s.close();
    }

    // find student by id

    public Student findStudentById(int id)
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Optional<Student> student =
                Optional.ofNullable(s.find(Student.class, id));

        s.close();

        if(student.isEmpty())
        {
            System.out.println("Student not found");

            return null;
        }

        return student.get();
    }

    // update student

    public void updateStudentById(int id)
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Transaction t = s.beginTransaction();

        Student oldStudent = s.find(Student.class, id);

        if(oldStudent == null)
        {
            System.out.println("Student not found");
        }
        else {

            oldStudent.setName("Rahul");

            oldStudent.setStudentClass("BTech CSE");

            oldStudent.setAge(22);

            s.merge(oldStudent);

            System.out.println("Student updated successfully");
        }

        t.commit();

        s.close();
    }

    // delete student

    public void deleteStudentById(int id)
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Transaction t = s.beginTransaction();

        Student student = s.find(Student.class, id);

        if(student == null)
        {
            System.out.println("Student not found");
        }
        else {

            s.remove(student);

            System.out.println("Student deleted successfully");
        }

        t.commit();

        s.close();
    }

    // search students by class

    public void searchStudentsByClass(String cls)
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Query q = s.createQuery(
                "FROM Student where studentClass = :cls",
                Student.class
        );

        q.setParameter("cls", cls);

        List<Student> students = q.getResultList();

        students.forEach(System.out::println);

        s.close();
    }

    // count students in each class

    public void countStudentsInEachClass()
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Query q = s.createQuery(
                "select studentClass , count(*) from Student group by studentClass"
        );

        List<Object[]> list = q.getResultList();

        for(Object[] obj : list)
        {
            System.out.println(obj[0] + " : " + obj[1]);
        }

        s.close();
    }
}