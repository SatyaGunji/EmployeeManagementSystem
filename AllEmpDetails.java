package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.EmoloyeeDao;
import com.jsp.dao.EmployeeDaoimpl;
import com.jsp.model.Employee;

@WebServlet("/alltheemployees")
public class AllEmpDetails extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmoloyeeDao dao = new EmployeeDaoimpl();
		List<Employee> employee = dao.getAllEmployees();
		PrintWriter write = response.getWriter();
		write.println(employee);

		HttpSession session = request.getSession();
		session.setAttribute("listofEmp", employee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AllEmployeeDetails.jsp");
		dispatcher.forward(request, response);
	}
}
