package com.excelr.managmentSystemDataBaseOperation;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
	public static Connection connect() throws Exception {

		Class.forName(DBProperties.DRIVER_CLASS);
		Connection con = DriverManager.getConnection(DBProperties.URL, DBProperties.USERNAME, DBProperties.PASSWORD);
		return con;

	}
}
