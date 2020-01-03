package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.domain.Group;

public class GroupDAO implements DAO<Group> {
	
	JDBCAccess jdbc;
	String tableName;

	public GroupDAO() {
		this.jdbc = new JDBCAccess();
		this.jdbc.openConnection();
		this.tableName = "Group";
	}

	@Override
	public List<Group> getAll() {
		String sql = "SELECT * FROM `" + this.tableName + "`";
		Statement statement;
		ArrayList<Group> groupList = new ArrayList<>();

		statement = jdbc.prepareStatement(sql);
		ResultSet result;
		try {
			result = statement.executeQuery(sql);
			if (result != null) {
				while (result.next()) {
					int idGroup = result.getInt("idGroup");
					String name = result.getString("name");
					groupList.add(new Group(idGroup, name));
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return groupList;
	}

	@Override
	public Group get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Group group) {
		String sql = "INSERT INTO `" + this.tableName + "` VALUES (default, ?)";
		int rowsInserted = 0;
		PreparedStatement statement;

		statement = jdbc.prepareStatement(sql);
		try {
			statement.setString(1, group.getGroupName());
			
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
	public boolean update(Group obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Group obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
