package com_07.hibernate5.collectioncaching;

import static org.hibernate.cfg.AvailableSettings.*;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {

	if (sessionFactory == null) {
	    try {
		
		Configuration configuration = new Configuration();
		configuration.setProperty(DRIVER, "com.mysql.cj.jdbc.Driver");
		configuration.setProperty(URL, "jdbc:mysql://localhost:3306/hibernate5_collection_caching_db?useSSL=false");
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
	    } catch (HibernateException e) {
		e.printStackTrace();
	    }
	}
	return sessionFactory;
    }

    public static void shutdown() {
	if (registry != null) {
	    StandardServiceRegistryBuilder.destroy(registry);
	    System.out.println("registry destroyed....");
	}
    }
}
