package com.banirudh.employees.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public static int addEmployee(Employee emp) {
		int addedEmp = 0;
		try {
			Connection con = DbConnection.getConnection();
			
			// Query
			String query = "INSERT INTO employee (empname,dateofjoining,dateofbirth,skillset) VALUES(?,?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, emp.getEmpName());
			ps.setString(2, emp.getDateOfJoining());
			ps.setString(3, emp.getDateOfBirth());
			ps.setString(4, emp.getSkillSet());
			addedEmp = ps.executeUpdate();
			System.out.println(addedEmp);
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return addedEmp;
	}
}
