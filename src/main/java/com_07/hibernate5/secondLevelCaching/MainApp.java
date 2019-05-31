package com_07.hibernate5.secondLevelCaching;


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
            
            Student student = studentDao.fetchStudentById(1);
            
            System.out.println(student);
            
            System.out.println("--------------------------------------------");
            
		 
        }
}
