package com_05.hibernate5.inheritanceMapping.tablePerClass;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;



@Entity
@Table(name="students_table")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="stuType",length=7)
@DiscriminatorValue(value="STU")
public class Student {
	
@Id
@GeneratedValue
@Column(name="sid")
private int sid;

@Column(name="sname")
private String sname;

@Column(name="city")
private String city;

@Column(name="status")
private String status;

@Column(name="totalfee")
private double totalfee;

@ElementCollection
@JoinTable(name="emails_table",joinColumns=@JoinColumn(name="sid"))
@Column(name="emailid_col")
@OrderColumn(name="emails_order")
@LazyCollection(LazyCollectionOption.FALSE)
private List<String> emails;


@ElementCollection
@JoinTable(name="phone_table",joinColumns=@JoinColumn(name="sid"))
@OrderColumn(name="phone_order")
@Column(name="phones_col")
@LazyCollection(LazyCollectionOption.FALSE)
private Set<Long> phones;


public Student(){}


public Student( String sname, String city, String status,
		double totalfee, List<String> emails, Set<Long> phones) {
	super();
	this.sname = sname;
	this.city = city;
	this.status = status;
	this.totalfee = totalfee;
	this.emails = emails;
	this.phones = phones;
}


public int getSid() {
	return sid;
}


public void setSid(int sid) {
	this.sid = sid;
}


public String getSname() {
	return sname;
}


public void setSname(String sname) {
	this.sname = sname;
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


public double getTotalfee() {
	return totalfee;
}


public void setTotalfee(double totalfee) {
	this.totalfee = totalfee;
}


public List<String> getEmails() {
	return emails;
}


public void setEmails(List<String> emails) {
	this.emails = emails;
}


public Set<Long> getPhones() {
	return phones;
}


public void setPhones(Set<Long> phones) {
	this.phones = phones;
}

}
