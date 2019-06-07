package com_08.hibernate5.criteria;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

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
    
    //fetch using Hibernate 5 JPA style
    public List<Product> fetchProductUsingCriteriaBuilder(Class<Product> resultClass) {
	List<Product> productsList = null;
	try {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    
	    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	    CriteriaQuery<Product> criteriaQuery=criteriaBuilder.createQuery(resultClass);
	    Root<Product> root=criteriaQuery.from(resultClass);
	    criteriaQuery.select(root);
	    
	    Query<Product> query = session.createQuery(criteriaQuery);
	    productsList = query.getResultList();
	    session.close();

	} catch (HibernateException e) {
	    e.printStackTrace();
	}

	return productsList;
    }

}
