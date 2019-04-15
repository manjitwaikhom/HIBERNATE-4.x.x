package com_02.hibernate5.collectionMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainApp{

	
	public static void main(String[] args) {
	       //--------------First set of data
		List<String> emails1=new ArrayList<String>();
		emails1.add("mjt@gmail.com");
		emails1.add("wkm@gmail.com");
		emails1.add("singh@gmail.com");
		
		List<Integer> marks1=new ArrayList<Integer>();
		marks1.add(69);
		marks1.add(80);
		marks1.add(90);
		
		String[] courses1={"JAVA","JSF","JDBC","SPRING"};
		
		Set<Long> phones1=new HashSet<Long>();
		phones1.add(new Long(997231764));
		phones1.add(new Long(956029113));
		phones1.add(new Long(906069267));
		
		Map<String,String> background1=new HashMap<>();
		background1.put("SCHOOL10", "Sawan Public School-CBSE");
		background1.put("SCHOOL12", "Sawan Public School-CBSE");
		background1.put("BACHELORS", "REC-VTU");
		background1.put("MASTERS", "N-A");
		background1.put("PHD", "N-A");
		
		//--------------Second set of data
		
		List<String> emails2=new ArrayList<String>();
		emails2.add("jordan@gmail.com");
		emails2.add("peterson@gmail.com");
		emails2.add("clinical@gmail.com");
		
		List<Integer> marks2=new ArrayList<Integer>();
		marks2.add(69);
		marks2.add(80);
		marks2.add(90);
		
		String[] courses2={"Psychology","SpeechTherapy","PublicSpeaking","RulesForLife"};
		
		Set<Long> phones2=new HashSet<Long>();
		phones2.add(new Long(997231764));
		phones2.add(new Long(956029113));
		phones2.add(new Long(906069267));
		
		Map<String,String> background2=new HashMap<>();
		background2.put("SCHOOL10", "N-A");
		background2.put("SCHOOL12", " FAIRVIEW HIGH SCHOOL");
		background2.put("BACHELORS", "UNIVERSITY OF ALBERTA");
		background2.put("MASTERS", "N-A");
		background2.put("PHD", "MCGILL UNIVERSITY");
		
		
		Student stu1=new Student("manjit","waikhom","bangalore","active",emails1,marks1,courses1,phones1,background1);
		Student stu2=new Student("Jordan","Peterson","Toronto","active",emails2,marks2,courses2,phones2,background2);
	        HibernateTemplate.saveObject(stu1);
	        HibernateTemplate.saveObject(stu2);
	        System.out.println("Records Inserted");
			
		
			List<Student> studentList=HibernateTemplate.listStudents();
			
			for(Student s:studentList) {
				System.out.println("-------------------------");
				System.out.println(s.getSid());
				System.out.println(s.getFname());
				System.out.println(s.getLname());
				System.out.println(s.getCity());
				System.out.println(s.getStatus());
				System.out.println(s.getEmails());
				System.out.println(s.getMarks());
				for (String c:s.getCourses()) {
					System.out.print(c+" ");
				}
				System.out.println();
				System.out.println(s.getPhones());
				System.out.println(s.getBackground());
				
			}

	}

}
