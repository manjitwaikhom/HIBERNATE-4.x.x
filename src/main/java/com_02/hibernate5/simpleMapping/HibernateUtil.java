package com_02.hibernate5.simpleMapping;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
//static import
import static org.hibernate.cfg.Environment.*;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
	
	
	// Hibernate 3.x.x style creating session factory : will not work in Hibernate 4.x.x and 5.x.x
	/*
	 try {

		Configuration config=new Configuration();
		config=config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

     } catch (Exception e) {
	    System.err.println("Initial SessionFactory creation failed" + e);
     }
	 */
	
	// Hibernate 4.x.x style creating session factory :  will not work in  5.x.x
	/*
	private static SessionFactory sessionFactory4;
	 
    public static SessionFactory getSessionFactory() {
        if (sessionFactory4 == null) {
            Configuration configuration = new Configuration();
            configuration=configuration.configure();
            ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
            registry.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
             
            sessionFactory4 = configuration.buildSessionFactory(serviceRegistry);           
        }
         
        return sessionFactory4;
    }
	*/
	
	/*
	  Hibernate 5.x.x session factory creation 
	  
	private static SessionFactory sessionFactory5;
    public static SessionFactory getSessionFactory5() {
        if (sessionFactory5 == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration();
            configuration=configuration.configure();
            
            Properties settings=configuration.getProperties();
            
            StandardServiceRegistryBuilder stdServiceRegBuilder=new StandardServiceRegistryBuilder();
            
            stdServiceRegBuilder=stdServiceRegBuilder.applySettings(settings);
            StandardServiceRegistry stdServiceReg=stdServiceRegBuilder.build();
           
            // builds a session factory from the service registry
            sessionFactory5 = configuration.buildSessionFactory(stdServiceReg);           
        }
         
        return sessionFactory5;
    }
	*/
	
	// Hibernate 5.x.x session factory creation working code
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			try {
				
				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(URL, "jdbc:mysql://localhost:3306/hibernate5_db?useSSL=false");
				settings.put(USER, "root");
				settings.put(PASS, "admin");
				settings.put(DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(SHOW_SQL, "true");
				settings.put(CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(HBM2DDL_AUTO, "create-drop");
				
				Configuration configuration = new Configuration();
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Employee.class);

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