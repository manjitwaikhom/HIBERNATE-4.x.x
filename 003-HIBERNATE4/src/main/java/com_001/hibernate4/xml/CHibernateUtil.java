package com_001.hibernate4.xml;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CHibernateUtil {

	static SessionFactory factory;
	static {
		try {
			Configuration cfg = new Configuration();
			cfg.configure("com_001/hibernate4/xml/hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}
}
