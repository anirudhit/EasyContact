package com.banirudh.employees.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.banirudh.db.connection.DbConnection;
import com.banirudh.employees.model.Employee;

public class EmployeesController {
	public static List<Employee> getEmployees() {
		List<Employee> empList = null;
		try {
			Connection con = DbConnection.getConnection();
			// Sql statements
			Statement stmt = con.createStatement();
			// Query
			String query = "SELECT * FROM employee";
			ResultSet res = stmt.executeQuery(query);
			
			empList = new ArrayList<>();
			
			while(res.next()) {
				int empId = Integer.parseInt(res.getString("empid"));
				String empName = res.getString("empname");
				String dateOfJoining = res.getString("dateofjoining");
				String dateOfBirth = res.getString("dateofbirth");
				String skillSet = res.getString("skillset");
				empList.add(new Employee(empId, empName, dateOfJoining, dateOfBirth, skillSet));
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return empList;
	}
}
