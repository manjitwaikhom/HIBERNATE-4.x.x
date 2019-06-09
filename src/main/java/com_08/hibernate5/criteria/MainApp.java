package com_08.hibernate5.criteria;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
   
        public static void main(String[] args) {
            ProductDao productDao = new ProductDao();
            
            Product product1 = new Product("oreo", "edibles", "required","no",true, 20,20,"solid",200);
            Product product2 = new Product("tyre", "automobiles", "not-required","no",false,30,40,"solid",300);
            Product product3 = new Product("Hcl", "chemicals", "not-required","yes",true,30,40,"liquid",400);
            Product product4 = new Product("Bisleri", "edibles", "not-required","no",false,20,20,"liquid",100);
		
            productDao.persistProduct(product1); 
            productDao.persistProduct(product2);
            productDao.persistProduct(product3);
            productDao.persistProduct(product4);
		 
            System.out.println("------------Records inserted--------------");
            
            
            //fetching using simple criteria Hibernate 4
            System.out.println("-------fetching using simple criteria-----------");
            List<Product> products1 = productDao.fetchProductUsingCriteria(Product.class);
            
            for(Product p:products1) {
        	System.out.println(p);
            }
            System.out.println("--------------------------------------------");
            
          //fetching using criteria restrictions eq()
            System.out.println("-------fetching  edibles only-----------");
            List<Product> products2 = productDao.fetchProductUsingCriteriaRestrictionsEq(Product.class,"edibles");
            
            for(Product p:products2) {
        	System.out.println(p);
            }
            System.out.println("--------------------------------------------");
            
          //fetching using criteria restrictions ne()
            System.out.println("-------fetching  non edibles only-----------");
            List<Product> products3 = productDao.fetchProductUsingCriteriaRestrictionsNe(Product.class,"edibles");
            
            for(Product p:products3) {
        	System.out.println(p);
            }
            System.out.println("--------------------------------------------");
            
            
          //fetching using simple criteria Hibernate 5.x
            System.out.println("-------fetching using UsingCriteriaBuilder Hibernate 5.x-----------");
            List<Product> products4 = productDao.fetchProductUsingCriteriaBuilder(Product.class);
            
            for(Product p:products4) {
        	System.out.println(p);
            }
            System.out.println("--------------------------------------------");
            
            
            //fetching using UsingCriteriaBuilder gt() Hibernate 5.x
            System.out.println("-------fetching using UsingCriteriaBuilder gt() Hibernate 5.x-----------");
            List<Product> products5 = productDao.fetchProductUsingCriteriaBuilderGreaterThanCondition(Product.class,2);

             for(Product p:products5) {
        	System.out.println(p);
            }
            System.out.println("--------------------------------------------");

            
            
            
		 
        }
}
