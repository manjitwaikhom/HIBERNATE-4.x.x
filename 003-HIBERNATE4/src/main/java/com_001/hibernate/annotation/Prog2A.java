package com_001.hibernate.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Prog2A {

	public static void main(String[] args) {
		Transaction tx = null;

		try {
			SessionFactory sf = com_001.hibernate.annotation.AHibernateUtil
					.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

			Customer customer = new Customer("Manjit",
					"manjitsinghwk@gmail.com", 18001234, "Frankfurt", 200000.0);

			session.save(customer);

			tx.commit();

			session.close();
			System.out.println("records inserted");
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}
}
