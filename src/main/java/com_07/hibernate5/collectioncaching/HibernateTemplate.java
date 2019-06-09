package com_07.hibernate5.collectioncaching;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateTemplate {

    // save
    public static Object saveObject(Object obj) {
	Object id = null;
	try {
	    SessionFactory sf = HibernateUtil.getSessionFactory();
	    Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
	    id = session.save(obj);
	    tx.commit();
	    session.close();

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return id;
    }

    // update
    public static void updateObject(Object obj) {

	try {
	    SessionFactory sf = HibernateUtil.getSessionFactory();
	    Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
	    session.update(obj);
	    tx.commit();
	    session.close();

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    // delete
    public static void deleteObject(Class<Student> cls, Serializable s) {
	try {
	    SessionFactory sf = HibernateUtil.getSessionFactory();
	    Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
	    Object o = session.load(cls, s);
	    session.delete(o);
	    tx.commit();
	    session.close();

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    //get all students
    public static List<Student> listStudents() {
	List<Student> studentsList = null;
	try {
	    Session session = HibernateUtil.getSessionFactory().openSession();

	    CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<Student> cq = cb.createQuery(Student.class);
	    Root<Student> rootEntry = cq.from(Student.class);
	    CriteriaQuery<Student> all = cq.select(rootEntry);

	    TypedQuery<Student> allQuery = session.createQuery(all);
	    studentsList= allQuery.getResultList();
	    session.close();

	} catch (HibernateException e) {
	    e.printStackTrace();
	}

	return studentsList;
    }

    public static Object loadObject(Class<Student> cls, Serializable s) {
	Object o = null;
	try {
	    SessionFactory sf = HibernateUtil.getSessionFactory();
	    Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
	    o = session.load(cls, s);
	    // session.delete(o);
	    tx.commit();
	    session.close();

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return o;
    }

    public static void shutDown() {
	HibernateUtil.shutdown();
    }

}
