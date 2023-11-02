package com.excelr.managmentSystemDataBaseOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.excelr.empManagmentModel.Employee;

public class EmployeeCrud {

	public String addEmployee(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DBConnection.connect();
		PreparedStatement prs = con.prepareStatement("insert into employee values(?,?,?,?)");
		prs.setInt(1, employee.getEmployeeID());
		prs.setString(2, employee.getName());
		prs.setString(3, employee.getDepartment());
		prs.setDouble(4, employee.getSalary());

		prs.execute();

		return "employee add";

	}

	public ArrayList<Employee> reteriveAllEmployee() throws Exception {
		ArrayList<Employee> employees = new ArrayList<>();

		Connection con = DBConnection.connect();
		PreparedStatement prs = con.prepareStatement("select * from employee ");
		ResultSet rs = prs.executeQuery();

		while (rs.next()) {
			employees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
		}

		return employees;
	}

	public String updateData() throws Exception {

		Connection con = DBConnection.connect();

		try (Scanner scanner = new Scanner(System.in)) {
			int c;
			System.out
					.println("Update Based On EmployeeID\n 1. update name base\n 2. update department\n3. update salary");
			c = scanner.nextInt();

			if (c == 1) {

				System.out.println("enter name ");
				String name = scanner.next();

				System.out.println("enter id ");
				int id = scanner.nextInt();

				Employee employee = new Employee(id, name, null, 0);

				PreparedStatement ps = con.prepareStatement("update employee set name=? where employeeid=?");

				ps.setString(1, employee.getName());
				ps.setInt(2, employee.getEmployeeID());

				ps.execute();
			}
			if (c == 2) {

				System.out.println("enter department ");
				String department = scanner.next();

				System.out.println("enter id ");
				int id = scanner.nextInt();

				Employee employee = new Employee(id, null, department, 0);

				PreparedStatement ps = con.prepareStatement("update employee set department=? where employeeid=?");

				ps.setString(1, employee.getDepartment());
				ps.setInt(2, employee.getEmployeeID());

				ps.execute();
			}
			if (c == 3) {

				System.out.println("enter salary ");
				Double salary = scanner.nextDouble();

				System.out.println("enter id ");
				int id = scanner.nextInt();

				Employee employee = new Employee(id, null, null, salary);

				PreparedStatement ps = con.prepareStatement("update employee set salary=? where employeeid=?");

				ps.setDouble(1, employee.getSalary());
				ps.setInt(2, employee.getEmployeeID());

				ps.execute();
			}
		}
//		System.out.println("data updated");
		
		return "data updated";

	}

	public String Delete(Employee employee) throws Exception {

		Connection con = DBConnection.connect();

		PreparedStatement ps = con.prepareStatement("Delete from employee where employeeid=?");

		ps.setInt(1, employee.getEmployeeID());

		ps.execute();

		return "Delete successfully";

	}

}
