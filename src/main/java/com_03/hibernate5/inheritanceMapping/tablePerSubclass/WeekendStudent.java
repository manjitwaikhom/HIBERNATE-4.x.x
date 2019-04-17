package com_03.hibernate5.inheritanceMapping.tablePerSubclass;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="WeekendStudent_table")
@PrimaryKeyJoinColumn(name="sid")
public class WeekendStudent extends CurrentStudent {
	
	@Column(name="company")
	private String company;
	
	@Column(name="cemail")
	private String cemail;
	
	@Column(name="ctc")
	private double ctc;
	public WeekendStudent(int sid, String sname, String city, String status,
			double totalfee, List<String> emails, Set<Long> phones,
			double feebal, String timings, String branch, String company,
			String cemail, double ctc) {
		super(sid, sname, city, status, totalfee, emails, phones, feebal,
				timings, branch);
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
