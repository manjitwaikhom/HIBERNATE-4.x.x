package com_07.hibernate5.secondLevelCaching;

import static org.hibernate.cfg.AvailableSettings.CACHE_REGION_FACTORY;
import static org.hibernate.cfg.AvailableSettings.DIALECT;
import static org.hibernate.cfg.AvailableSettings.DRIVER;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.PASS;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.URL;
import static org.hibernate.cfg.AvailableSettings.USER;
import static org.hibernate.cfg.AvailableSettings.USE_QUERY_CACHE;
import static org.hibernate.cfg.AvailableSettings.USE_SECOND_LEVEL_CACHE;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
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

		/*// Hibernate settings equivalent to hibernate.cfg.xml's properties
		Properties settings = new Properties();
		settings.put(AvailableSettings.DRIVER, "com.mysql.cj.jdbc.Driver");
		settings.put(AvailableSettings.URL, "jdbc:mysql://localhost:3306/hibernate5_caching_db?useSSL=false");
		settings.put(AvailableSettings.USER, "root");
		settings.put(AvailableSettings.PASS, "admin");
		settings.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		settings.put(AvailableSettings.SHOW_SQL, "true");
		settings.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, "thread");
		settings.put(AvailableSettings.HBM2DDL_AUTO, "create-drop");
		
		//enabling second level cache
		settings.setProperty(AvailableSettings.USE_SECOND_LEVEL_CACHE, "true");//enabled by default to true you can disable by setting to false
		settings.setProperty(AvailableSettings.CACHE_REGION_FACTORY,
			"org.hibernate.cache.ehcache.EhCacheRegionFactory");
		
		Configuration configuration = new Configuration();
		configuration.setProperties(settings);
		configuration.addAnnotatedClass(Student.class);
		
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		serviceRegistryBuilder.applySettings(settings);
		ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();*/
		
		Configuration configuration = new Configuration();
		configuration.setProperty(DRIVER, "com.mysql.cj.jdbc.Driver");
		configuration.setProperty(URL, "jdbc:mysql://localhost:3306/hibernate5_secondlevelcache_db?useSSL=false");
		configuration.setProperty(USER, "root");
		configuration.setProperty(PASS, "admin");
		configuration.setProperty(DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		configuration.setProperty(SHOW_SQL, "true");
		configuration.setProperty(HBM2DDL_AUTO, "create-drop");
		configuration.setProperty(USE_SECOND_LEVEL_CACHE, "true");
		configuration.setProperty(CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.EhCacheRegionFactory");
		configuration.setProperty(USE_QUERY_CACHE, "true");
		configuration.addAnnotatedClass(Student.class);

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
			.applySettings(configuration.getProperties()).build();


		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return sessionFactory;
    }

}