package com.jsp.servlet;

import java.io.IOException;

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
@WebServlet("/getempid")
public class GetEmployeesById extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tempempid=request.getParameter("empid");
		int empid = Integer.parseInt(tempempid);
		
		EmoloyeeDao dao=new EmployeeDaoimpl();
		
		HttpSession session=request.getSession();
		Employee employee =dao.getEmployeeById(empid);
		if(employee!=null) {
			session.setAttribute("employeedetails", employee);
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateDetails.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("Null.html");
			rd.forward(request, response);
		
		}
	}

}
