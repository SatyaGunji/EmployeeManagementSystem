package com.jsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jsp.model.Employee;

public class EmployeeDaoimpl implements EmoloyeeDao {

	String url = "jdbc:mysql://localhost:3306/teca53?user=root&password=12345";
	List<Employee> listEmp = new ArrayList<Employee>();

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);

			Statement st = connection.createStatement();// pass the Statement
			ResultSet res = st.executeQuery("select * from employee");
			if (res.isBeforeFirst()) {
				while (res.next()) {
					Employee emp = new Employee();
					emp.setEmpid(res.getInt(1));
					emp.setEmpName(res.getString(2));
					emp.setEmpSalary(res.getInt(3));
					emp.setEmpdeptno(res.getInt(4));
					listEmp.add(emp);
				}
			} else {
				System.out.println("No data found");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listEmp;

	}

	public List<Employee> getEmplyeeDetailsBySalaryOrDeptno(int deptno) {
		String select = "select * from employee where emp_sal=? or emp_deptno=?";
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(select);
			ps.setInt(1, deptno);
			ps.setInt(2, deptno);
			ps.executeQuery();
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.isBeforeFirst()) {
				while (resultSet.next()) {
					Employee emp = new Employee();
					emp.setEmpid(resultSet.getInt(1));
					emp.setEmpName(resultSet.getString(2));
					emp.setEmpSalary(resultSet.getInt(3));
					emp.setEmpdeptno(resultSet.getInt(4));
					listEmp.add(emp);

				}
				return listEmp;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getEmployeeById(int id) {

		String select = "select * from employee where emp_id=?";
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(select);
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {

				Employee employee = new Employee();
				employee.setEmpid(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setEmpSalary(resultSet.getDouble("emp_sal"));
				employee.setEmpdeptno(resultSet.getInt("emp_deptno"));

				return employee;

			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateEmpDetails(Employee emp) {
		
		String update="update employee set emp_name=?,emp_sal=?,emp_deptno=? where emp_id=?";
		
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement ps=connection.prepareStatement(update);
			
			ps.setString(1, emp.getEmpName());
			ps.setDouble(2, emp.getEmpSalary());
			ps.setInt(3, emp.getEmpdeptno());
			ps.setInt(4, emp.getEmpid());
			
			int result=ps.executeUpdate();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
