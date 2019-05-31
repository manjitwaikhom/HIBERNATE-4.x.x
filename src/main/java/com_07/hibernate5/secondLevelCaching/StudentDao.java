package com_07.hibernate5.secondLevelCaching;

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
	public Student fetchStudentById(int id) {
		Student student=null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			student = (Student) session.get(Student.class,id);
			session.close();
			
			
			Session session2 = HibernateUtil.getSessionFactory().openSession();
			student = (Student) session2.get(Student.class,id);
			session2.close();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return student;
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
