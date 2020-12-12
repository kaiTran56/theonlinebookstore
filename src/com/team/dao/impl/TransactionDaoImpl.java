package com.team.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.team.JDBC.JDBCConnection;
import com.team.dao.TransactionDao;
import com.team.model.Ordered;
import com.team.model.Transactions;
import com.team.model.User;

public class TransactionDaoImpl extends JDBCConnection implements TransactionDao<Transactions> {
	private Connection connect;
	private PreparedStatement statement;
	private ResultSet result;

	@Override
	public List<Transactions> getAll() {
		connect = super.getConnectionJDBC();
		List<Transactions> listTransaction = new ArrayList<Transactions>();
		String sql = "select t.transaction_id, u.user_id, u.name, u.email, u.phone, u.address, t.message, t.payment, t.status, p.name, o.amount, t.created from user as u "
				+ " inner join transactions as t " + " on u.user_id = t.user_id " + " inner join ordered as o "
				+ " on o.transaction_id = t.transaction_id " + " inner join product as p "
				+ " on p.product_id = o.product_id order by t.created desc;";
		try {
			statement = connect.prepareStatement(sql);
			result = statement.executeQuery();
			while (result.next()) {

				int transaction_id = result.getInt("transaction_id");
				int user_id = result.getInt("u.user_id");
				String name = result.getString("name");
				String email = result.getString("email");
				String phone = result.getString("phone");
				String address = result.getString("address");
				String message = result.getString("message");
				double payment = result.getDouble("payment");
				String status = result.getString("status");
				String nameProduct = result.getString("p.name");
				int amount = result.getInt("amount");
				LocalDateTime created = result.getTimestamp("created").toLocalDateTime();
				User user = new User(user_id, name, email, phone, address);
				Ordered ordered = new Ordered(amount, nameProduct);
				Transactions transactions = new Transactions(transaction_id, user, message, payment, status, ordered,
						created);
				listTransaction.add(transactions);
			}
			System.out.println("List transactions successfully!");
			result.close();
			statement.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listTransaction;
	}

	@Override
	public void insert(Transactions t) {
		connect = super.getConnectionJDBC();
		String sql = "insert into transactions ( user_id, message, payment, status, created) " + "value (?,?,?,?,?);";
		try {
			statement = connect.prepareStatement(sql);

			statement.setInt(1, t.getUser().getUser_id());
			statement.setString(2, t.getMessage());
			statement.setDouble(3, t.getPayment());
			statement.setString(4, t.getStatus());
			statement.setTimestamp(5, Timestamp.valueOf(t.getCreated()));
			statement.executeUpdate();
			System.out.println("Insert Transaction success!");
			statement.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Transactions t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		connect = super.getConnectionJDBC();
		String sql = "delete from transactions where transaction_id = ?";
		try {
			statement = connect.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
			System.out.println("Delete transaction successfully!");
			statement.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		System.out.println("Run");
		System.out.println("Test: " + new TransactionDaoImpl().getAll().toString());
	}

	@Override
	public List<Transactions> get(int id) {
		connect = super.getConnectionJDBC();
		List<Transactions> listTransaction = new ArrayList<Transactions>();
		String sql = "select t.transaction_id,u.user_id, u.name, u.email, u.phone, u.address, t.message, t.payment, t.status, p.name, o.amount, t.created from user as u "
				+ " inner join transactions as t " + " on u.user_id = t.user_id " + " inner join ordered as o "
				+ " on o.transaction_id = t.transaction_id " + " inner join product as p "
				+ " on p.product_id = o.product_id where u.user_id = ?;";
		try {
			statement = connect.prepareStatement(sql);
			statement.setInt(1, id);
			result = statement.executeQuery();
			while (result.next()) {
				int transaction_id = result.getInt("transaction_id");
				int user_id = result.getInt("u.user_id");
				String name = result.getString("name");
				String email = result.getString("email");
				String phone = result.getString("phone");
				String address = result.getString("address");
				String message = result.getString("message");
				double payment = result.getDouble("payment");
				String status = result.getString("status");
				String nameProduct = result.getString("p.name");
				int amount = result.getInt("amount");
				LocalDateTime created = result.getTimestamp("created").toLocalDateTime();
				User user = new User(user_id, name, email, phone, address);
				Ordered ordered = new Ordered(amount, nameProduct);
				listTransaction.add(new Transactions(transaction_id, user, message, payment, status, ordered, created));

			}
			System.out.println("transactions successfully!");
			result.close();
			statement.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listTransaction;
	}

	@Override
	public Transactions getTheLastest() {
		connect = super.getConnectionJDBC();
		String sql = "select transaction_id from transactions order by created desc limit 1";
		try {
			statement = connect.prepareStatement(sql);
			result = statement.executeQuery();
			while (result.next()) {
				int transaction_id = result.getInt("transaction_id");
				return new Transactions(transaction_id);
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
	public void changeStatus(Transactions t) {
		connect = super.getConnectionJDBC();
		String sql = "update transactions set status = ? where transaction_id = ?;";
		try {
			statement = connect.prepareStatement(sql);
			statement.setString(1, t.getStatus());
			statement.setInt(2, t.getTransaction_id());
			statement.executeUpdate();
			statement.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
