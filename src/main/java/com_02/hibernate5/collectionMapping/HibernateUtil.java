package com_02.hibernate5.collectionMapping;

import static org.hibernate.cfg.AvailableSettings.*;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			try {
				Properties settings = new Properties();
				settings.put(DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(URL, "jdbc:mysql://localhost:3306/hibernate5_db?useSSL=false");
				settings.put(USER, "root");
				settings.put(PASS, "admin");
				settings.put(DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(HBM2DDL_AUTO, "create-drop");
				settings.put(SHOW_SQL, "true");
				
				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
				registryBuilder.applySettings(settings);
				StandardServiceRegistry registry = registryBuilder.build();
				
				Configuration config = new Configuration();
				config.setProperties(settings);
				config.addAnnotatedClass(Student.class);
				sessionFactory = config.buildSessionFactory(registry);
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
