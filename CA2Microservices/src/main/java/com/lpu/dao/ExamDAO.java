package com.lpu.dao;

import com.lpu.entity.Exam;
import com.lpu.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class ExamDAO {

    // save exam

    public void saveExam(Exam exam)
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Transaction t = s.beginTransaction();

        s.persist(exam);

        t.commit();

        s.close();
    }

    // find all exams

    public void findAllExams()
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Query q = s.createQuery("FROM Exam", Exam.class);

        List<Exam> exams = q.getResultList();

        exams.forEach(System.out::println);

        s.close();
    }

    // find exam by id

    public Exam findExamById(int id)
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Optional<Exam> exam =
                Optional.ofNullable(s.find(Exam.class, id));

        s.close();

        if(exam.isEmpty())
        {
            System.out.println("Exam not found");

            return null;
        }

        return exam.get();
    }

    // update exam marks

    public void updateExamMarks(int id)
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Transaction t = s.beginTransaction();

        Exam oldExam = s.find(Exam.class, id);

        if(oldExam == null)
        {
            System.out.println("Exam not found");
        }
        else {

            oldExam.setMarks(95);

            s.merge(oldExam);

            System.out.println("Marks updated successfully");
        }

        t.commit();

        s.close();
    }

    // delete exam

    public void deleteExamById(int id)
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Transaction t = s.beginTransaction();

        Exam exam = s.find(Exam.class, id);

        if(exam == null)
        {
            System.out.println("Exam not found");
        }
        else {

            s.remove(exam);

            System.out.println("Exam deleted successfully");
        }

        t.commit();

        s.close();
    }

    // join query for student subject details

    public void joinQueryStudentSubjectDetails()
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Query q = s.createQuery(
                "select e.student.name , e.subjectName , e.marks from Exam e"
        );

        List<Object[]> list = q.getResultList();

        for(Object[] obj : list)
        {
            System.out.println(
                    obj[0] + " " + obj[1] + " " + obj[2]
            );
        }

        s.close();
    }

    // fetch toppers

    public void fetchToppersInExam()
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Query q = s.createQuery(
                "FROM Exam order by marks desc",
                Exam.class
        );

        q.setMaxResults(3);

        List<Exam> exams = q.getResultList();

        exams.forEach(System.out::println);

        s.close();
    }

    // fetch average marks subject wise

    public void fetchAverageMarksSubjectWise()
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Query q = s.createQuery(
                "select subjectName , avg(marks) from Exam group by subjectName"
        );

        List<Object[]> list = q.getResultList();

        for(Object[] obj : list)
        {
            System.out.println(
                    obj[0] + " Average Marks : " + obj[1]
            );
        }

        s.close();
    }
}