package com.team.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.team.JDBC.JDBCConnection;
import com.team.dao.AdminDao;
import com.team.model.Admin;

public class AdminDaoImpl extends JDBCConnection implements AdminDao<Admin> {
	private Connection connect;

	@Override
	public Admin getLogin(String username, String password) {

		String sql = "select * from admin where username like ? and password like ?;";
		connect = super.getConnectionJDBC();
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				String usernameJDBC = result.getString("username");
				String passwordJDBC = result.getString("password");
				Admin admin = new Admin(usernameJDBC, passwordJDBC);
				return admin;
			}
			statement.close();
			result.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Admin> getAll() {
		List<Admin> listAdmin = new ArrayList<Admin>();
		this.connect = super.getConnectionJDBC();
		String sql = "select username, password from admin;";
		try {
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				String username = result.getString("username");
				String password = result.getString("password");
				listAdmin.add(new Admin(username, password));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAdmin;

	}

	@Override
	public Admin get(String usernameTemp) {
		connect = super.getConnectionJDBC();
		String sql = "select username, password from admin where username like ?";
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, usernameTemp);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				String username = result.getString("username");
				String password = result.getString("password");
				return new Admin(username, password);
			}
			System.out.println("Get Admin successfully!");
			statement.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(Admin t) {
		connect = super.getConnectionJDBC();
		String sql = "Insert into admin (username, password) value(?,?);";
		PreparedStatement statement;
		try {
			statement = connect.prepareStatement(sql);

			statement.setString(1, t.getUsername());
			statement.setString(2, t.getPassword());

			statement.executeUpdate();
			System.out.println("Add new admin successfull");
			statement.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(String username) {
		String sql = "delete from admin where username like ?;";
		connect = super.getConnectionJDBC();
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, username);
			statement.executeUpdate();
			System.out.println("delete admin successfully!");
			statement.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void Edit(Admin admin) {
		connect = super.getConnectionJDBC();
		String sql = "update admin set username =? , password = ? where username like ?;";
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, admin.getUsername());
			statement.setString(2, admin.getPassword());
			statement.setString(3, admin.getUsername());
			statement.executeUpdate();
			System.out.println("Edit successfully!");
			statement.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
