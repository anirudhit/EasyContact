package com.banirudh.employees.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.banirudh.db.connection.DbConnection;

public class EmployeesController {
	public static void getContacts() {
		try {
			Connection con = DbConnection.getConnection();
			// Sql statements
			Statement stmt = con.createStatement();
			// Query
			String query = "SELECT * FROM employee";
			ResultSet res = stmt.executeQuery(query);
			
			while(res.next()) {
				String empid = res.getString("empid");
				String empname = res.getString("empname");
				String salary = res.getString("salary");
				System.out.println(empid+ " "+ empname+ " " + salary);		
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
