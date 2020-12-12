package com.team.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.team.JDBC.JDBCConnection;
import com.team.dao.BoardnewDao;
import com.team.model.Boardnew;

public class BoardnewDaoImpl extends JDBCConnection implements BoardnewDao<Boardnew> {
	private Connection connect;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet result;

	@Override
	public List<Boardnew> getAll() {
		connect = super.getConnectionJDBC();
		List<Boardnew> listBoardnew = new ArrayList<Boardnew>();
		String sql = "select * from boardnew;";
		try {
			statement = connect.createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {
				int boardnew_id = result.getInt("boardnew_id");
				String title = result.getString("title");

				String image_link = result.getString("image_link");
				String author = result.getString("author");
				LocalDateTime created = result.getTimestamp("created").toLocalDateTime();
				listBoardnew.add(new Boardnew(boardnew_id, title, image_link, author, created));
			}
			statement.close();
			result.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listBoardnew;
	}

	@Override
	public Boardnew get(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boardnew get(int id) {
		connect = super.getConnectionJDBC();
		String sql = "select * from boardnew where boardnew_id = ?;";
		Boardnew boardnew = null;
		try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				int boardnew_id = result.getInt("boardnew_id");
				String title = result.getString("title");
				String content = result.getString("content");
				String image_link = result.getString("image_link");
				String author = result.getString("author");
				LocalDateTime created = result.getTimestamp("created").toLocalDateTime();
				boardnew = new Boardnew(boardnew_id, title, content, image_link, author, created);
			}
			preparedStatement.close();
			result.close();
			connect.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return boardnew;
	}

	@Override
	public void insert(Boardnew t) {
		connect = super.getConnectionJDBC();
		String sql = "insert into boardnew (title, content, image_link, author, created) value (?,?,?,?,?);";
		try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, t.getTitle());
			preparedStatement.setString(2, t.getContent());
			preparedStatement.setString(3, t.getImage_link());
			preparedStatement.setString(4, t.getAuthor());
			preparedStatement.setTimestamp(5, Timestamp.valueOf(t.getCreated()));
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		connect = super.getConnectionJDBC();
		String sql = "delete from boardnew where boardnew_id = ?;";
		try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("Delete boardnew succcessfully!");
			preparedStatement.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void edit(Boardnew t) {
		connect = super.getConnectionJDBC();
		String sql = "update boardnew set title = ?, content = ?, author = ?,image_link = ?, created = ? where boardnew_id = ?;";
		try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, t.getTitle());
			preparedStatement.setString(2, t.getContent());
			preparedStatement.setString(3, t.getAuthor());
			preparedStatement.setString(4, t.getImage_link());
			preparedStatement.setTimestamp(5, Timestamp.valueOf(t.getCreated()));
			preparedStatement.setInt(6, t.getBoardnew_id());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
