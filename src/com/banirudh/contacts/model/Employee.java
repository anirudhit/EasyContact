package com.banirudh.contacts.model;

public class Employee {
	private int empid;
	private String empname;
	private String salary;
	
	
	public Employee(int empid, String empname, String salary) {
		this.empid = empid;
		this.empname = empname;
		this.salary = salary;
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


	public String getSalary() {
		return salary;
	}


	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	
}