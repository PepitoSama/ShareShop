/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.domain.GroupList;

/**
 *
 * @author fsmag
 */
public class GroupListDAO implements DAO<GroupList> {

	JDBCAccess jdbc;
	String tableName;
	String quantified;

	public GroupListDAO() {
		this.jdbc = JDBCAccess.getInstance();
		this.tableName = "GroupList";
		this.quantified = "QuantifiedProductList";
	}

	@Override
	public List<GroupList> getWhere(List<Couple> where) {
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
		PreparedStatement statement;
		statement = jdbc.prepareStatement(sql);
		ArrayList<GroupList> shoppingList = new ArrayList<GroupList>();
		try {
			ResultSet result = statement.executeQuery();
			if (result != null) {
				while (result.next()) {
					int idGroupList = result.getInt("idGroupList");
					int idGroup = result.getInt("idGroup");
					Date date = result.getDate("date");
					String name = result.getString("name");
					char type = result.getString("type").charAt(0);
					shoppingList
							.add(new GroupList(idGroupList, idGroup, name, new java.util.Date(date.getTime()), type));
				}
			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return shoppingList;
	}

	@Override
	public List<GroupList> getAll() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public GroupList get(String id) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public boolean save(GroupList obj) {
		String sql = "INSERT INTO " + this.tableName + " VALUES (default, ?, ?, ?, ?)";
		int rowsInserted = 0;
		PreparedStatement statement;

		statement = jdbc.prepareStatement(sql);
		try {
			statement.setInt(1, obj.getIdGroup());
			statement.setString(2, obj.getName());
			statement.setDate(3, new java.sql.Date(obj.getDate().getTime()));
			statement.setString(4, Character.toString(obj.getType()));
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
    public boolean update(GroupList obj) {
        String sql = "UPDATE " + this.tableName
                + " SET name=? WHERE idGroup=? and idGroupList=?";

        PreparedStatement statement = jdbc.prepareStatement(sql);
        try {
			statement.setString(1, obj.getName());
			 statement.setInt(2, obj.getIdGroup());
		        statement.setInt(3, obj.getIdGroupList());
		        int rowsUpdated = statement.executeUpdate();
		        if (rowsUpdated > 0) {
		            return true;
		        }
		        return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return false;
       
    }

	@Override
	public boolean delete(GroupList obj) {
		String sql = "DELETE FROM " + this.tableName + " WHERE idGroupList=?";
		PreparedStatement statement = jdbc.prepareStatement(sql);
		try {
			statement.setInt(1, obj.getIdGroupList());
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
