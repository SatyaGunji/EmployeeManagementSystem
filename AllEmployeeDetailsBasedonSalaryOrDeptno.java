package com.jsp.servlet;

import java.io.IOException;
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

@WebServlet("/allemployeesBySalaryOrDeptno")
public class AllEmployeeDetailsBasedonSalaryOrDeptno extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tempdeptno = request.getParameter("dept");
		int deptno = Integer.parseInt(tempdeptno);
		EmoloyeeDao dao = new EmployeeDaoimpl();
		List<Employee> SalaryOrDeptno = dao.getEmplyeeDetailsBySalaryOrDeptno(deptno);
		HttpSession session = request.getSession();

		if (SalaryOrDeptno != null) {

			session.setAttribute("listofEmp", SalaryOrDeptno);
			RequestDispatcher dispatcher = request.getRequestDispatcher("AllEmployeeDetails.jsp");
			dispatcher.forward(request, response);
		} else {
			session.setAttribute("listofEmp", SalaryOrDeptno);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Null.html");
			dispatcher.forward(request, response);

		}
	}

}
