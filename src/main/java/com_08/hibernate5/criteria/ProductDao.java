package com_08.hibernate5.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class ProductDao {
    // to save student
    public void persistProduct(Product product) {
	Transaction transaction = null;
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	    // start a transaction
	    transaction = session.beginTransaction();
	    // save the student object
	    session.persist(product);
	    // commit transaction
	    transaction.commit();
	} catch (Exception e) {
	    if (transaction != null) {
		transaction.rollback();
	    }
	    e.printStackTrace();
	}
    }

    public Product fetchProductById(int id) {
	Product student = null;
	try {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    student = session.get(Product.class, id);
	    session.close();

	} catch (HibernateException e) {
	    e.printStackTrace();
	}
	return student;
    }

    // to get product fetchProductUsingCriteria
    public List<Product> fetchProductUsingCriteria(Class<?> className) {
	List<Product> productsList = null;
	try {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Criteria criteria = session.createCriteria(className);
	    productsList = criteria.list();
	    session.close();

	} catch (HibernateException e) {
	    e.printStackTrace();
	}

	return productsList;
    }

    // to get product fetchProductUsingCriteria restrictions eq()
    public List<Product> fetchProductUsingCriteriaRestrictionsEq(Class<?> className, String conditions) {
	List<Product> productsList = null;
	try {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Criteria criteria = session.createCriteria(className);
	    criteria.add(Restrictions.eq("category", conditions));
	    productsList = criteria.list();
	    session.close();

	} catch (HibernateException e) {
	    e.printStackTrace();
	}

	return productsList;
    }

    // to get product fetchProductUsingCriteria restrictions ne()
    public List<Product> fetchProductUsingCriteriaRestrictionsNe(Class<?> className, String conditions) {
	List<Product> productsList = null;
	try {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Criteria criteria = session.createCriteria(className);
	    criteria.add(Restrictions.ne("category", conditions));
	    productsList = criteria.list();
	    session.close();

	} catch (HibernateException e) {
	    e.printStackTrace();
	}

	return productsList;
    }

}
