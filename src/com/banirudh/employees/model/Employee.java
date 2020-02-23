package com.banirudh.employees.model;

public class Employee {
	private int empid;
	private String empname;
	private String dateOfJoining;
	private String dateOfBirth;
	private String skillSet;
	
	public Employee(int empid, String empname, String dateOfJoining, String dateOfBirth, String skillSet) {
		this.empid = empid;
		this.empname = empname;
		this.dateOfJoining = dateOfJoining;
		this.dateOfBirth = dateOfBirth;
		this.skillSet = skillSet;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}
	
}