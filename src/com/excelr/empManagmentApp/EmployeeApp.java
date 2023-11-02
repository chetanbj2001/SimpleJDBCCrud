package com.excelr.empManagmentApp;

import java.util.ArrayList;
import java.util.Scanner;

import com.excelr.empManagmentModel.Employee;
import com.excelr.managmentSystemDataBaseOperation.EmployeeCrud;

public class EmployeeApp {

	public static void main(String[] args) throws Exception {
		EmployeeCrud employeescCrud = new EmployeeCrud();

		try (Scanner scanner = new Scanner(System.in)) {
			String choice = "yes";

			while (choice.equalsIgnoreCase("yes")) {

				System.out.println("press 1.add employee \n 2.view all employees \n 3.update employee info \n 4.Delete employee");
				int ch = scanner.nextInt();
				if (ch == 1) {
					System.out.println("enter Employeeid ");
					int id = scanner.nextInt();

					System.out.println("enter name");
					String name = scanner.next();

					System.out.println("enter department");
					String department = scanner.next();

					System.out.println("enter salary ");
					double salary = scanner.nextDouble();

					Employee employee = new Employee(id, name, department, salary);

					System.out.println(employeescCrud.addEmployee(employee));

				}
				if (ch == 2) {

					ArrayList<Employee> employees = employeescCrud.reteriveAllEmployee();
					for (Employee employee : employees) {
						System.out.println(employee.getEmployeeID() + " " + employee.getName() + " "
								+ employee.getDepartment() + " " + employee.getSalary());
					}
				}
				if (ch == 3) {

					System.out.println(employeescCrud.updateData());

				}
				if(ch == 4) {
					System.out.println("Enter id");
					int id = scanner.nextInt();
					
					Employee employee = new Employee(id,null,null,0);
					
					System.out.println(employeescCrud.Delete(employee));
				}

				System.out.println("do you want to continue..type yes if not type No");
				choice = scanner.next();
			}
		}
	}
}
