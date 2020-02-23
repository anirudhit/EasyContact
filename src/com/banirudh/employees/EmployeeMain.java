package com.banirudh.employees;

import java.util.ArrayList;
import java.util.List;

import com.banirudh.employees.controller.EmployeesController;
import com.banirudh.employees.model.Employee;

public class EmployeeMain {

	public static void main(String[] args) {
		
		List<Employee> empList = new ArrayList<Employee>();
		
		empList = EmployeesController.getEmployees();
		System.out.println(empList);
		
	}

}
