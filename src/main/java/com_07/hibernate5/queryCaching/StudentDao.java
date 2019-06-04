package com_07.hibernate5.queryCaching;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class StudentDao {
    // to save student
    public void persistStudent(Student student) {
	Transaction transaction = null;
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	    // start a transaction
	    transaction = session.beginTransaction();
	    // save the student object
	    session.persist(student);
	    // commit transaction
	    transaction.commit();
	} catch (Exception e) {
	    if (transaction != null) {
		transaction.rollback();
	    }
	    e.printStackTrace();
	}
    }

    // to get student
    public List<Student> getStudents() {
	List<Student> studentsList = null;
	
	try {
	    //session 1
	    Session session1 = HibernateUtil.getSessionFactory().openSession();
	    Query<Student> query1 = session1.createQuery("from Student", Student.class).setCacheable(true);
	    studentsList = query1.list();
	    session1.close();

	    //session 2
	    Session session2 = HibernateUtil.getSessionFactory().openSession();
	    Query<Student> query2 = session2.createQuery("from Student", Student.class).setCacheable(true);
	    studentsList = query2.list();
	    session2.close();
	    
	} catch (HibernateException e) {
	    e.printStackTrace();
	}

	return studentsList;
    }

    //delete by name
    public int deleteStudentByFirstName(String firstName) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();
	Query query = session.createQuery("delete Student where firstName = :fname");
	query.setParameter("fname", firstName);
	int result = query.executeUpdate();
	session.close();

	return result;
    }

}
