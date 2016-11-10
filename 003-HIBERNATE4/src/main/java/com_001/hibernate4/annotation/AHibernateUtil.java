package com_001.hibernate4.annotation;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class AHibernateUtil {

	static SessionFactory factory;
	static {
		try {
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg = (AnnotationConfiguration) cfg
					.configure("com_001/hibernate4/annotation/hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}
}
