package com.team.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.team.JDBC.JDBCConnection;
import com.team.dao.UserDao;
import com.team.model.User;

public class UserDaoImpl extends JDBCConnection implements UserDao<User> {
	private Connection connect;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet result;

	@Override
	public List<User> getAll() {
		connect = super.getConnectionJDBC();
		String sql = "select*from user;";
		List<User> listUser = new ArrayList<User>();
		try {
			statement = connect.createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {
				String name = result.getString("name");
				String email = result.getString("email");
				String phone = result.getString("phone");
				String dateOfBirth = result.getString("dob");
				String address = result.getString("address");
				LocalDateTime created = result.getTimestamp("created").toLocalDateTime();
				String password = result.getString("password");
				listUser.add(new User(name, email, phone, dateOfBirth, address, created, password));
			}
			statement.close();
			result.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUser;
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(String email) {
		connect = super.getConnectionJDBC();
		String sql = "select*from user where email like ?";
		try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, email);
			result = preparedStatement.executeQuery();
			System.out.println("profile!");
			while (result.next()) {
				int user_id = result.getInt("user_id");
				String name = result.getString("name");
				String emailTemp = result.getString("email");
				String phone = result.getString("phone");
				String dateOfBirth = result.getString("dob");
				String address = result.getString("address");
				LocalDateTime created = result.getTimestamp("created").toLocalDateTime();
				String password = result.getString("password");
				return new User(user_id, name, emailTemp, phone, dateOfBirth, address, created, password);
			}

			preparedStatement.close();
			result.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void edit(User user) {
		connect = super.getConnectionJDBC();
		String sql = "update user set name = ?, phone = ?, dob = ?, address = ? where email like ?;";
		try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPhone());
			preparedStatement.setString(3, user.getDateOfBirth());
			preparedStatement.setString(4, user.getAddress());
			preparedStatement.setString(5, user.getEmail());
			System.out.println("Edit profile success!");
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void insert(User t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String email) {
		connect = super.getConnectionJDBC();
		String sql = "delete from user where email = ?";
		try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.executeUpdate();
			System.out.println("Delete User success!");
			preparedStatement.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public User login(String email, String password) {
		connect = super.getConnectionJDBC();
		String sql = "select email, password from user where email like ? and password like ?;";
		try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				String emailTemp = result.getString("email");
				String passwordTemp = result.getString("password");
				return new User(emailTemp, passwordTemp);
			}
			preparedStatement.close();
			result.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void changePassword(String email, String password) {
		connect = super.getConnectionJDBC();
		String sql = "update user set password = ? where email = ?;";
		try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, email);
			preparedStatement.executeUpdate();
			System.out.println("Update password for user successfully!");
			preparedStatement.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
