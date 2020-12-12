package com.team.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.team.JDBC.JDBCConnection;
import com.team.model.User;

public class RegisterDao extends JDBCConnection {
	private Connection connect;

	public boolean registerUser(User user) {
		connect = super.getConnectionJDBC();
		String sql = "Insert into user (name,email,phone,dob,address,created,password)value(?,?,?,?,?,?,?)";

		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPhone());
			statement.setString(4, user.getDateOfBirth());
			statement.setString(5, user.getAddress());
			statement.setTimestamp(6, Timestamp.valueOf(user.getCreated()));
			statement.setString(7, user.getPassword());
			statement.executeUpdate();
			System.out.println("Successfully!");
			statement.close();
			connect.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
