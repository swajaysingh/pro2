package com.niit.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="job_s180133")
public class Job {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String jobTitle;
private String jobDescription;
private String skillsRequired;
private String location;
private String companyname;
private String salary;
private String yrsOfExp;
private Date postedOn;
@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
private List<User> notifiedUser;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getJobTitle() {
	return jobTitle;
}
public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
}
public String getJobDescription() {
	return jobDescription;
}
public void setJobDescription(String jobDescription) {
	this.jobDescription = jobDescription;
}
public String getSkillsRequired() {
	return skillsRequired;
}
public void setSkillsRequired(String skillsRequired) {
	this.skillsRequired = skillsRequired;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getCompanyname() {
	return companyname;
}
public void setCompanyname(String companyname) {
	this.companyname = companyname;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
public String getYrsOfExp() {
	return yrsOfExp;
}
public void setYrsOfExp(String yrsOfExp) {
	this.yrsOfExp = yrsOfExp;
}
public Date getPostedOn() {
	return postedOn;
}
public void setPostedOn(Date postedOn) {
	this.postedOn = postedOn;
}

}
