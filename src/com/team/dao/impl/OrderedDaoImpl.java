package com.team.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team.JDBC.JDBCConnection;
import com.team.dao.OrderedDao;
import com.team.model.Ordered;

public class OrderedDaoImpl extends JDBCConnection implements OrderedDao<Ordered> {
	private Connection connect;
	private PreparedStatement statement;
	private ResultSet result;

	@Override
	public List<Ordered> getAll() {

		return null;
	}

	@Override
	public Ordered get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ordered> getProduct(int id) {
		connect = super.getConnectionJDBC();
		List<Ordered> listProduct = new ArrayList<Ordered>();
		String sql = "select u.name, p.name, p.price, o.amount from user as u "
				+ "inner join transactions as t on u.user_id = t.user_id "
				+ "inner join ordered as o on t.transaction_id = o.transaction_id "
				+ "inner join product as p on p.product_id = o.product_id where u.user_id = ?;";
		;
		try {
			statement = connect.prepareStatement(sql);
			statement.setInt(1, id);
			result = statement.executeQuery();
			while (result.next()) {
				String username = result.getString("u.name");
				String name = result.getString("p.name");
				double price = result.getDouble("p.price");
				int amount = result.getInt("o.amount");

				listProduct.add(new Ordered(username, name, amount, price));
			}
			statement.close();
			result.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listProduct;
	}

	@Override
	public void insert(Ordered t) {
		connect = super.getConnectionJDBC();
		String sql = "insert into ordered (ordered_id, product_id, transaction_id, amount) value (?,?,?,?);";
		try {
			statement = connect.prepareStatement(sql);
			statement.setInt(1, t.getOrdered_id());
			statement.setInt(2, t.getProduct_id());
			statement.setInt(3, t.getTransaction_id());
			statement.setInt(4, t.getAmount());
			statement.executeUpdate();
			System.out.println("Insert into Ordered success!");
			statement.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Ordered t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {

	}

	@Override
	public Ordered getMaxId() {
		connect = super.getConnectionJDBC();
		String sql = "select max(ordered_id) as max from ordered;";
		try {
			statement = connect.prepareStatement(sql);
			result = statement.executeQuery();
			while (result.next()) {
				return new Ordered(result.getInt("max"));
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
	public List<Ordered> getQuantityOrdered(int id) {
		List<Ordered> listQuantity = new ArrayList<Ordered>();
		connect = super.getConnectionJDBC();
		String sql = "select product_id, transaction_id, amount from ordered where transaction_id = ?;";
		try {
			statement = connect.prepareStatement(sql);
			statement.setInt(1, id);
			result = statement.executeQuery();
			while (result.next()) {
				int product_id = result.getInt("product_id");
				int transaction_id = result.getInt("transaction_id");
				int amount = result.getInt("amount");
				listQuantity.add(new Ordered(product_id, transaction_id, amount));
			}
			statement.close();
			result.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listQuantity;
	}

	@Override
	public List<Ordered> getBestSeller() {
		List<Ordered> listBestSeller = new ArrayList<Ordered>();
		connect = super.getConnectionJDBC();
		String sql = " select  o.product_id ,p.name, count(o.product_id) as total_purchase, sum(o.amount) as total_product, p.image_link as link from ordered o inner join product p on o.product_id = p.product_id group by product_id order by ( total_product) desc limit 10;";
		try {
			statement = connect.prepareStatement(sql);
			result = statement.executeQuery();
			while (result.next()) {
				int product_id = result.getInt("product_id");
				String name = result.getString("name");
				int totalPurchase = result.getInt("total_purchase");
				int totalProduct = result.getInt("total_product");
				String image_link = result.getString("link");
				listBestSeller.add(new Ordered(product_id, name, totalPurchase, totalProduct, image_link));
			}
			statement.close();
			result.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listBestSeller;
	}

}
