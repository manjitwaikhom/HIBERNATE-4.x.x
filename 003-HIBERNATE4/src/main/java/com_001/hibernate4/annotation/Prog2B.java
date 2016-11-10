package com_001.hibernate4.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Prog2B {

	public static void main(String[] args) {
		Transaction tx = null;

		try {
			SessionFactory sf = com_001.hibernate4.annotation.AHibernateUtil
					.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

			Customer customer = (Customer) session.load(Customer.class, 1);

			System.out.println(customer.getCid() + "\t" + customer.getCname()
					+ "\t" + customer.getEmail() + "\t" + customer.getPhone()
					+ "\t" + customer.getCity() + "\t" + customer.getBal());

			tx.commit();

			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();

		}
	}
}
