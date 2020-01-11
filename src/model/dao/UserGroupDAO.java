package model.dao;

import model.dao.DAO;
import model.domain.UserGroup;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserGroupDAO implements DAO<UserGroup> {

	JDBCAccess jdbc;
	String tableName;

	public UserGroupDAO() {
		this.jdbc = JDBCAccess.getInstance();
		this.tableName = "`UserGroup`";
	}

	@Override
	public List<UserGroup> getAll() {
		String sql = "SELECT * FROM " + this.tableName;
		Statement statement;
		ArrayList<UserGroup> userGroupList = new ArrayList<>();

		statement = jdbc.prepareStatement(sql);
		ResultSet result;
		try {
			result = statement.executeQuery(sql);
			if (result != null) {
				while (result.next()) {
					int idUser = result.getInt("idUser");
					int idGroup = result.getInt("idGroup");
					userGroupList.add(new UserGroup(idUser, idGroup));
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return userGroupList;
	}
	
	@Override
	public UserGroup get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(UserGroup userGroup) {
		String sql = "INSERT INTO " + this.tableName + " VALUES (?, ?)";
		int rowsInserted = 0;
		PreparedStatement statement;

		statement = jdbc.prepareStatement(sql);
		try {
			statement.setInt(1, userGroup.getIdUser());
			statement.setInt(2, userGroup.getIdGroup());
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
	public boolean update(UserGroup obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UserGroup obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserGroup> getWhere(List<Couple> where) {
		String sql = "SELECT * FROM " + this.tableName + " WHERE ";
		boolean first = true;
		for (Couple couple : where) {
			if (first != true) {
				sql += " AND ";
			}
			sql += couple.getName();
			sql += " LIKE ";
			sql += couple.getValue();
			first = false;
		}
		Statement statement;
		ArrayList<UserGroup> userGroupList = new ArrayList<>();

		statement = jdbc.prepareStatement(sql);
		ResultSet result;
		try {
			result = statement.executeQuery(sql);
			if (result != null) {
				while (result.next()) {
					int idUser = result.getInt("idUser");
					int idGroup = result.getInt("idGroup");
					userGroupList.add(new UserGroup(idUser, idGroup));
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return userGroupList;
	}

	
}
