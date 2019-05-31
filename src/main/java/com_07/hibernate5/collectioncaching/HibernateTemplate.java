package com_07.hibernate5.collectioncaching;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


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
	public static List<Student> listStudents(){
		List<Student> studentsList=null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query<Student> query = session.createQuery("from Student", Student.class);
			studentsList = query.list();
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
	
	public static void shutDown(){
	    HibernateUtil.shutdown();
	}
	

}
