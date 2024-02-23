package com.jsp.model;

public class Employee {
	private int empid;
	private String empName;
	private double empSalary;
	private int empdeptno;

	public Employee() {

	}

	public Employee(int empid, String empName, double empSalary, int empdeptno) {

		this.empid = empid;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empdeptno = empdeptno;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public int getEmpdeptno() {
		return empdeptno;
	}

	public void setEmpdeptno(int empdeptno) {
		this.empdeptno = empdeptno;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empName=" + empName + ", empSalary=" + empSalary + ", empdeptno="
				+ empdeptno + "]";
	}

}
