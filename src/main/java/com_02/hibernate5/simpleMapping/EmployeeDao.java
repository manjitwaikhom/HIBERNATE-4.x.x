package com_02.hibernate5.simpleMapping;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com_01.hibernate5.javaconfiguration.Student;

public class EmployeeDao {
	// to save student
	public void persistEmployee(Employee student) {
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

	// to get Employee
	public List<Employee> getEmployees() {
		Transaction transaction = null;
		List<Employee> employeeList=null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction=session.beginTransaction();
			
			Query<Employee> query = session.createQuery("from Employee", Employee.class);
			employeeList = query.list();
			
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		return employeeList;
	}

	//delete by name
	
	/*
	public int deleteEmployeeByFirstName(String firstName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete Employee where firstName = :fname");
		query.setParameter("fname", firstName);
		int result = query.executeUpdate();
		session.close();

		return result;
	}
	*/
	 
	 

}
