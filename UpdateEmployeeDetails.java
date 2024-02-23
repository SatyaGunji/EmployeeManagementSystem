package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.jsp.dao.EmoloyeeDao;
import com.jsp.dao.EmployeeDaoimpl;
import com.jsp.model.Employee;
@WebServlet("/update")
public class UpdateEmployeeDetails extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("empname");
		String tempsalary = request.getParameter("empsalary");
		String tempdeptno = request.getParameter("empdeptno");
		String tempid=request.getParameter("empid");
//		System.out.println(name);
//		System.out.println(tempdeptno);
//		System.out.println(tempsalary);
		
		
		Employee employee = new Employee();
		employee.setEmpid(Integer.parseInt(tempid));
		employee.setEmpName(name);
		employee.setEmpSalary(Double.parseDouble(tempsalary));
		employee.setEmpdeptno(Integer.parseInt(tempdeptno));
		
		EmoloyeeDao dao= new EmployeeDaoimpl();
		int details =dao.updateEmpDetails(employee);
		PrintWriter pr= response.getWriter();
		response.setContentType("text/html");
		if(details!=0) {
			RequestDispatcher rd= request.getRequestDispatcher("/alltheemployees");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd= request.getRequestDispatcher("Null.html");
			rd.forward(request, response);
		}
	}

}
