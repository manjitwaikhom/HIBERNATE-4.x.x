package com_02.hibernate5.simpleMapping;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp {
   
        public static void main(String[] args) {
            EmployeeDao employeeDao = new EmployeeDao();
            Employee employee1 = new Employee("manjit", "Singh", "manjit@gmail.com", "java", 5);
            Employee employee2 = new Employee("Abhishek", "Kumar", "abhishek@gmail.com", ".net",9);
            Employee employee3 = new Employee("Victoria", "Waikhom", "singh@gmail.com", "angular", 3);
		
            employeeDao.persistEmployee(employee1); 
            employeeDao.persistEmployee(employee2);
            employeeDao.persistEmployee(employee3);
		 
            System.out.println("------------Records inserted--------------");
            
            List <Employee> employees = employeeDao.getEmployees();
            employees.forEach(s -> System.out.println("First Name: "+s.getFirstName()
            +"  Last Name: "+s.getLastName()
            +"  Email: "+s.getEmail()
            +"  Skill: "+s.getSkill()
            +"  Experience: "+s.getExp()
            		));
            
            System.out.println("--------------------------------------------");
		 
        }
}
