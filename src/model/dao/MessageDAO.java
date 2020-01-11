package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.domain.Group;
import model.domain.Message;
import model.domain.User;

public class MessageDAO implements DAO<Message> {

	JDBCAccess jdbc;
	String tableName;

	public MessageDAO() {
		this.jdbc = JDBCAccess.getInstance();
		this.tableName = "`MessageSent`";
	}

	@Override
	public List<Message> getAll() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public Message get(String id) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public boolean save(Message message) {
		String sql = "INSERT INTO " + this.tableName + " VALUES (default, ?, ?, ?, ?)";
		int rowsInserted = 0;
		PreparedStatement statement;

		statement = jdbc.prepareStatement(sql);
		try {
			statement.setInt(1, message.getSentBy().getId());
			statement.setInt(2, message.getGroup().getId());
			statement.setString(3, message.getText());
			statement.setDate(4, message.getDate());

			rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean update(Message obj) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public boolean delete(Message obj) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public List<Message> getWhere(List<Couple> where) {
		String sql = "SELECT * FROM " + this.tableName + ", `User`, `Group` WHERE ";

		// JOINS
		sql += " `User`.`idUser` = `MessageSent`.`idUser` ";
		sql += " AND `MessageSent`.`idGroup` = `Group`.`idGroup` ";

		for (Couple couple : where) {
			sql += " AND ";
			sql += couple.getName();
			sql += " LIKE ";
			sql += couple.getValue();
		}

		// ORDER BY DATE
		sql += " ORDER BY `MessageSent`.`date`";

		Statement statement;
		ArrayList<Message> messageList = new ArrayList<>();

		statement = jdbc.prepareStatement(sql);
		ResultSet result;
		try {
			System.out.println(statement.toString());
			result = statement.executeQuery(sql);
			if (result != null) {
				while (result.next()) {
					String sentBy = result.getString("nickname");
					String text = result.getString("text");
					Date date = result.getDate("date");

					// Construct User
					User user = new User(
							result.getString("nickname"),
							result.getString("firstname"),
							result.getString("lastname"),
							result.getDate("birthdate"),
							result.getString("email"),
							result.getInt("idUser"));
					// Construct Group
					Group group = new Group(result.getInt("idGroup"), result.getString("name"));
					// Construct Message
					Message message = new Message(user, group, result.getString("text"));
					messageList.add(message);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return messageList;
	}

}
