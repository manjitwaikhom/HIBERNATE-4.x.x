package com_08.hibernate5.criteria;

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

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

	if (sessionFactory == null) {
	    try {

		Configuration configuration = new Configuration();
		configuration.setProperty(DRIVER, "com.mysql.cj.jdbc.Driver");
		configuration.setProperty(URL, "jdbc:mysql://localhost:3306/hibernate5_criteria_db?useSSL=false");
		configuration.setProperty(USER, "root");
		configuration.setProperty(PASS, "admin");
		configuration.setProperty(DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		configuration.setProperty(SHOW_SQL, "true");
		configuration.setProperty(HBM2DDL_AUTO, "create-drop");
		configuration.setProperty(USE_SECOND_LEVEL_CACHE, "true");
		configuration.setProperty(CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.EhCacheRegionFactory");
		configuration.setProperty(USE_QUERY_CACHE, "true");
		configuration.addAnnotatedClass(Product.class);
		/*configuration.addAnnotatedClass(Supplier.class);
		*/
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