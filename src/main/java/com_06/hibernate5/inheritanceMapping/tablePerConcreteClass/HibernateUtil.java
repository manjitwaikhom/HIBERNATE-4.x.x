package com_06.hibernate5.inheritanceMapping.tablePerConcreteClass;

import static org.hibernate.cfg.AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS;
import static org.hibernate.cfg.AvailableSettings.DIALECT;
import static org.hibernate.cfg.AvailableSettings.DRIVER;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.PASS;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.URL;
import static org.hibernate.cfg.AvailableSettings.USER;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class HibernateUtil {

    private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			try {
				
				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(URL, "jdbc:mysql://localhost:3306/hibernate5inheritanceMappingtablePerConcreteClass_db?useSSL=false");
				settings.put(USER, "root");
				settings.put(PASS, "admin");
				settings.put(DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(SHOW_SQL, "true");
				settings.put(CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(HBM2DDL_AUTO, "create-drop");
				
				Configuration configuration = new Configuration();
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Student.class);
				configuration.addAnnotatedClass(CurrentStudent.class);
				configuration.addAnnotatedClass(OldStudent.class);
				configuration.addAnnotatedClass(RegularStudent.class);
				configuration.addAnnotatedClass(WeekendStudent.class);
				
				StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
				serviceRegistryBuilder.applySettings(settings);
				ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

}
