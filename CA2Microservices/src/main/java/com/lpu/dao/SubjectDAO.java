package com.lpu.dao;

import com.lpu.entity.Subject;
import com.lpu.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class SubjectDAO {

    // save subject

    public void saveSubject(Subject subject)
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Transaction t = s.beginTransaction();

        s.persist(subject);

        t.commit();

        s.close();
    }

    // find all subjects

    public void findAllSubjects()
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Query q = s.createQuery("FROM Subject", Subject.class);

        List<Subject> subjects = q.getResultList();

        subjects.forEach(System.out::println);

        s.close();
    }

    // find subject by id

    public Subject findSubjectById(int id)
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Optional<Subject> subject =
                Optional.ofNullable(s.find(Subject.class, id));

        s.close();

        if(subject.isEmpty())
        {
            System.out.println("Subject not found");

            return null;
        }

        return subject.get();
    }

    // delete subject

    public void deleteSubjectById(int id)
    {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Transaction t = s.beginTransaction();

        Subject subject = s.find(Subject.class, id);

        if(subject == null)
        {
            System.out.println("Subject not found");
        }
        else {

            s.remove(subject);

            System.out.println("Subject deleted successfully");
        }

        t.commit();

        s.close();
    }
}