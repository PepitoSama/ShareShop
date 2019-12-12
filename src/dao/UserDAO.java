package dao;

import dao.DAO;
import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAO<User> {
	JDBCAccess jdbc;
	String tableName;
	
	public UserDAO() {
		this.jdbc = new JDBCAccess();
		this.jdbc.openConnection();
		this.tableName = "User";
	}

	@Override
	public List<User> getAll() {
		String sql = "SELECT * FROM " + this.tableName;
		Statement statement;
		ArrayList<User> userList = new ArrayList<User>();

		statement = jdbc.prepareStatement(sql);
		ResultSet result;
		try {
			result = statement.executeQuery(sql);
			if (result != null) {
				while (result.next()) {
					int idUser = result.getInt("idUser");
					String nickname = result.getString("nickname");
					String firstname = result.getString("firstname");
					String lastname = result.getString("lastname");
					String email = result.getString("email");
					String birthdate = result.getString("birthdate");
					String password = result.getString("password");
					userList.add(new User(nickname, password, firstname, lastname, birthdate, email, idUser));
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return userList;
	}

	@Override
	public User get(String nickname) {
		String sql = "SELECT * FROM " + this.tableName + " WHERE nickname=?";
		int rows = 0;
		PreparedStatement statement;

		statement = jdbc.prepareStatement(sql);
		try {
			statement.setString(1, nickname);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet != null) {
				resultSet.next();

				return new User(resultSet.getString("Nickname"), resultSet.getString("password"),
						resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("birthdate"), resultSet.getString("password"), resultSet.getInt("idUser"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public boolean save(User user) {

		String sql = "INSERT INTO " + this.tableName + " VALUES (default, ?, ?, ?, ?, ?, ?)";
		int rowsInserted = 0;
		PreparedStatement statement;

		statement = jdbc.prepareStatement(sql);
		try {
			statement.setString(1, user.getNickname());
			statement.setString(2, user.getFistname());
			statement.setString(3, user.getLastname());
			statement.setString(4, user.getEmail());
			statement.setDate(5, new java.sql.Date(2009, 12, 11));
			statement.setString(6, user.getPassword());

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
	public boolean update(User user) {
		String sql = "UPDATE " + this.tableName + " SET nickname=?, firstname=?, lastname=?, email=?, birthdate=?, password=? WHERE idUser=?";

		PreparedStatement statement = jdbc.prepareStatement(sql);

		try {
			statement.setString(1, user.getNickname());
			statement.setString(2, user.getFistname());
			statement.setString(3, user.getLastname());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getBirthdate());
			statement.setString(6, user.getPassword());
			statement.setInt(7, user.getId());

			int rowsUpdated = statement.executeUpdate();

			if (rowsUpdated > 0) {
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
	public boolean delete(User user) {
		String sql = "DELETE FROM " + this.tableName + " WHERE idUser=?";

		PreparedStatement statement = jdbc.prepareStatement(sql);
		try {
			statement.setInt(1, user.getId());
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

}
