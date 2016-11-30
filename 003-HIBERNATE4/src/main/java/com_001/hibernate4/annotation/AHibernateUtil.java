package com_001.hibernate4.annotation;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class AHibernateUtil {

	static SessionFactory factory;
	static {
		try {

			Configuration cfg = new Configuration();
			cfg = cfg
					.configure("com_001/hibernate4/annotation/hibernate.cfg.xml");

			Properties settings = cfg.getProperties();
			/*
			 * for (String key : settings.stringPropertyNames()) { String value
			 * = settings.getProperty(key); System.out.println(key + " => " +
			 * value); }
			 */
			StandardServiceRegistryBuilder ssrBuilder = new StandardServiceRegistryBuilder();
			ssrBuilder = ssrBuilder.applySettings(settings);

			StandardServiceRegistry ssRegistry = ssrBuilder.build();
			factory = cfg.buildSessionFactory(ssRegistry);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}
}
