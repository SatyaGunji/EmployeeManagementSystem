package com.jsp.dao;

import java.util.List;

import com.jsp.model.Employee;

public interface EmoloyeeDao {

	List<Employee> getAllEmployees();

	List<Employee> getEmplyeeDetailsBySalaryOrDeptno(int deptno);
	
	Employee getEmployeeById(int id);
	
	int updateEmpDetails(Employee emp);
}
