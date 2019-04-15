package com_02.hibernate5.collectionMapping;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;




@Entity
@Proxy(lazy=false)
@Table(name="students")
@Inheritance(strategy=InheritanceType.JOINED)
public class Student {
	
	@Id
	@GeneratedValue
	@Column(name="studentid")
	private int sid;
	
	@Column(name="firstname")
	private String fname;
	
	@Column(name="lastname")
	private String lname;
	
	@Column(name="city")
	private String city;
	
	@Column(name="status")
	private String status;
	
	@ElementCollection
	@CollectionTable(name="emails", joinColumns=@JoinColumn(name="studentid"))
	@Column(name="emailid")
	@OrderColumn(name="emails_index")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List <String> emails;
	
	@ElementCollection
	@OrderColumn(name="marks_index")
	@CollectionTable(name="marks", joinColumns=@JoinColumn(name="studentid"))
	@Column(name="marks")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List <Integer> marks;
	
	@ElementCollection
	@CollectionTable(name="courses", joinColumns=@JoinColumn(name="studentid"))
	@OrderColumn(name="course_index")
	@Column(name="courses")
	@LazyCollection(LazyCollectionOption.FALSE)
	private String[] courses;
	
	@ElementCollection
	@OrderColumn(name="phones_index")
	@CollectionTable(name="phones", joinColumns=@JoinColumn(name="studentid"))
	@Column(name="phones")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set <Long> phones;
	
	

	@ElementCollection
	@OrderColumn(name="background_index")
	@CollectionTable(name="background", joinColumns=@JoinColumn(name="studentid"))
	@Column(name="background")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Map <String,String> background;


	public Student(){}
	public Student(String fname, String lname, String city,
			String status, List<String> emails, List<Integer> marks,
			String[] courses, Set<Long> phones, Map<String, String> background) {
		super();
		
		this.fname = fname;
		this.lname = lname;
		this.city = city;
		this.status = status;
		this.emails = emails;
		this.marks = marks;
		this.courses = courses;
		this.phones = phones;
		this.background = background;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<String> getEmails() {
		return emails;
	}
	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	public List<Integer> getMarks() {
		return marks;
	}
	public void setMarks(List<Integer> marks) {
		this.marks = marks;
	}
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
	public Set<Long> getPhones() {
		return phones;
	}
	public void setPhones(Set<Long> phones) {
		this.phones = phones;
	}
	public Map<String, String> getBackground() {
	    return background;
	}
	public void setBackground(Map<String, String> background) {
	    this.background = background;
	}
	
}
