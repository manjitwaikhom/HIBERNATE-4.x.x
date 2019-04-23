package com_04.hibernate5.inheritanceMapping.tablePerSubclass;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="RegularStudent_table")
@PrimaryKeyJoinColumn(name="sid")
public class RegularStudent extends CurrentStudent {
	
@Column(name="qualification")
private String qualification;

@Column(name="percentage")
private String percentage;

@Column(name="yoe")
private int yoe;

public RegularStudent(int sid, String sname, String city, String status,
		double totalfee, List<String> emails, Set<Long> phones, double feebal,
		String timings, String branch, String qualification, String percentage,
		int yoe) {
	super(sid, sname, city, status, totalfee, emails, phones, feebal, timings,
			branch);
	this.qualification = qualification;
	this.percentage = percentage;
	this.yoe = yoe;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public String getPercentage() {
	return percentage;
}
public void setPercentage(String percentage) {
	this.percentage = percentage;
}
public int getYoe() {
	return yoe;
}
public void setYoe(int yoe) {
	this.yoe = yoe;
}


}
