package dao;

import dao.DAO;
import model.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDAO implements DAO<User> {
	JDBCAccess jdbc;
	
	public UserDAO() {
		this.jdbc = new JDBCAccess();
		this.jdbc.openConnection();
	}
	
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean save(User user) {
		
		String sql = "INSERT INTO User VALUES (default, ?, ?, ?, ?, ?, ?)";
		int rowsInserted = 0;
		PreparedStatement statement;
		try {
			statement = jdbc.prepareStatement(sql);
			statement.setString(1, user.getNickname());
			statement.setString(2, user.getFistname());
			statement.setString(3, user.getLastname());
			statement.setString(4, user.getEmail());
			statement.setDate(5, new java.sql.Date(2009, 12, 11));
			statement.setString(6, user.getPassword());
			 
			rowsInserted = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rowsInserted > 0) {
		    return true;
		}
		System.out.println(user.getNickname() + "Inserted !");
		return false;
	}

	@Override
	public boolean update(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
