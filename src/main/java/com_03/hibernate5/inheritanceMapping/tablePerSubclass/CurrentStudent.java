package com_03.hibernate5.inheritanceMapping.tablePerSubclass;

import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="CurrentStudent_table")
@PrimaryKeyJoinColumn(name="sid")
public class CurrentStudent extends Student{
	
@Column(name="feebal")
private double feebal;

@Column(name="timings")
private String timings;

@Column(name="branch")
private String branch;
public CurrentStudent(int sid, String sname, String city, String status,
		double totalfee, List<String> emails, Set<Long> phones, double feebal,
		String timings, String branch) {
	super(sname, city, status, totalfee, emails, phones);
	this.feebal = feebal;
	this.timings = timings;
	this.branch = branch;
}
public double getFeebal() {
	return feebal;
}
public void setFeebal(double feebal) {
	this.feebal = feebal;
}
public String getTimings() {
	return timings;
}
public void setTimings(String timings) {
	this.timings = timings;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}


}
