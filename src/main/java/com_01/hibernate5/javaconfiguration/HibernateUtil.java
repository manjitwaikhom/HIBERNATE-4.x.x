package com_01.hibernate5.javaconfiguration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	//Old style of creating session 
	/*
	 * Configuration configuration = new Configuration();
	 * configuration.configure(); 
	 * SessionFactory sessionFactory = configuration.buildSessionFactory(); 
	 * Session session = sessionFactory.openSession();
	 */
	
	// Hibernate 4.x.x style creating session factory will not work in Hibernate 5.x.x
	/*
	 * try { Configuration configuration = new Configuration(); Properties
	 * properties=configuration.getProperties() configuration.configure();
	 * 
	 * ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
	 * registry.applySettings(properties); ServiceRegistry serviceRegistry =
	 * registry.buildServiceRegistry(); SessionFactory sessionFactory =
	 * configuration.buildSessionFactory(serviceRegistry);
	 * 
	 * } catch (Throwable th) {
	 * System.err.println("Enitial SessionFactory creation failed" + th); throw new
	 * ExceptionInInitializerError(th); }
	 */

	
	// Hibernate 5.x.x session factory creation
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate5_db?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "admin");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "create-drop");
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Student.class);
				
				StandardServiceRegistryBuilder serviceRegistryBuilder=new StandardServiceRegistryBuilder();
				serviceRegistryBuilder.applySettings(settings);
				ServiceRegistry serviceRegistry=serviceRegistryBuilder.build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}