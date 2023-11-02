package com.excelr.empManagmentModel;

public class Employee {

	private int employeeID;
	private String name;
	private String department;
	private double salary;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Employee(int employeeID, String name, String department, double salary) {
		super();
		this.employeeID = employeeID;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}



	public int getEmployeeID() {
		return employeeID;
	}



	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}

 

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", name=" + name + ", department=" + department + ", salary="
				+ salary + "]";
	}



	
}
