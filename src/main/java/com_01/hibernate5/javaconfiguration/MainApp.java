package com_01.hibernate5.javaconfiguration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp {
   
        public static void main(String[] args) {
            StudentDao studentDao = new StudentDao();
            Student student1 = new Student("manjit", "Singh", "manjit@gmail.com");
            Student student2 = new Student("Abhishek", "Kumar", "abhishek@gmail.com");
            Student student3 = new Student("Waikhom", "Singh", "singh@gmail.com");
		
		  studentDao.persistStudent(student1); 
		  studentDao.persistStudent(student2);
		  studentDao.persistStudent(student3);
		 
            System.out.println("------------Records inserted--------------");
            
            List <Student> students = studentDao.getStudents();
            students.forEach(s -> System.out.println("First Name: "+s.getFirstName()+"  Last Name: "+s.getLastName()+"  Email: "+s.getEmail()));
            
            System.out.println("--------------------------------------------");
            
		
		  int res=studentDao.deleteStudentByFirstName("Manjit"); 
		  System.out.println("No of records deleted:"+ res);
		 
        }
}
