package com.team.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	private final String USER = "root";
	private final String PASSWORD = "54935620tQ.";
	private final String URL = "jdbc:mysql://localhost:3306/project_sad";

	public Connection getConnectionJDBC() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Access to DB successfully!");
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
