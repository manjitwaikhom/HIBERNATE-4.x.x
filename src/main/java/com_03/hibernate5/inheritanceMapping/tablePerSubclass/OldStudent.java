package com_03.hibernate5.inheritanceMapping.tablePerSubclass;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="OldStudent_table")
@PrimaryKeyJoinColumn(name="sid")
public class OldStudent extends Student{
	
@Column(name="company")
private String company;

@Column(name="cemail")
private String cemail;

@Column(name="feebal")
private double ctc;
public OldStudent(int sid, String sname, String city, String status,
		double totalfee, List<String> emails, Set<Long> phones, String company,
		String cemail, double ctc) {
	super(sname, city, status, totalfee, emails, phones);
	this.company = company;
	this.cemail = cemail;
	this.ctc = ctc;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getCemail() {
	return cemail;
}
public void setCemail(String cemail) {
	this.cemail = cemail;
}
public double getCtc() {
	return ctc;
}
public void setCtc(double ctc) {
	this.ctc = ctc;
}


}
