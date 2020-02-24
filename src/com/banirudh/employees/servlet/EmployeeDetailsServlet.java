package com.banirudh.employees.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banirudh.employees.controller.EmployeesController;
import com.banirudh.employees.model.Employee;
import com.banirudh.util.EmployeeResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EmployeeDetailsServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Employee> empList = new ArrayList<Employee>();
		empList = EmployeesController.getEmployees();
		
		Gson gson = new Gson();
		String jsonEmployees = gson.toJson(empList);
        System.out.println("jsonEmployees = " + jsonEmployees);
		
		response.getWriter().append(jsonEmployees);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Employee emp = new Employee();
		emp.setEmpName(request.getParameter("empName"));
		emp.setDateOfJoining(request.getParameter("dateOfJoining"));
		emp.setDateOfBirth(request.getParameter("dateOfBirth"));
		emp.setSkillSet(request.getParameter("skillSet"));
		
		int result = EmployeesController.addEmployee(emp);
		String responseMessage = null;
		if(result == 0) {
			String json = "{ \"message\": \"Please check employee details.\"}";
			responseMessage = EmployeeResponse.responseMapper(json);
		}else {
			String json = "{ \"message\": \"Employee added successfully.\"}";
			responseMessage = EmployeeResponse.responseMapper(json);
		}
		
		response.getWriter().append(responseMessage);
	}

}
