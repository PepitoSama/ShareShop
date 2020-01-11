/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.domain.UserDebt;

/**
 *
 * @author fsmag
 */
public class UserDebtDAO implements DAO<UserDebt> {

    JDBCAccess jdbc;
    String tableName;

    public UserDebtDAO() {
	this.jdbc = JDBCAccess.getInstance();
	this.tableName = "`UserDebt`";
    }

    @Override
    public List<UserDebt> getAll() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserDebt get(String id) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(UserDebt obj) {
	String sql = "INSERT INTO " + this.tableName + " VALUES (default, ?, ?, ?)";
	int rowsInserted = 0;
	PreparedStatement statement;

	statement = jdbc.prepareStatement(sql);
	try {
	    statement.setDouble(1, obj.getAmount());
	    statement.setInt(2, obj.getIdFrom());
	    statement.setInt(3, obj.getIdTo());
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
    public boolean update(UserDebt obj) {
	try {
	    String sql = "UPDATE " + this.tableName
		    + " SET amount=? WHERE idDebt = ?";

	    PreparedStatement statement = jdbc.prepareStatement(sql);
	    statement.setDouble(1, obj.getAmount());
	    statement.setInt(2, obj.getIdDebt());
	    int rowsUpdated = statement.executeUpdate();
	    if (rowsUpdated > 0) {
		return true;
	    }
	    return false;
	} catch (SQLException ex) {
	    Logger.getLogger(UserDebtDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	return false;
    }

    @Override
    public boolean delete(UserDebt obj) {
	String sql = "DELETE FROM " + this.tableName + " WHERE idDebt=?";
	PreparedStatement statement = jdbc.prepareStatement(sql);
	try {
	    statement.setInt(1, obj.getIdDebt());
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

    @Override
    public List<UserDebt> getWhere(List<Couple> where) {
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
	ArrayList<UserDebt> userDebt = new ArrayList<UserDebt>();
	statement = jdbc.prepareStatement(sql);
	ResultSet result;
	try {
	    result = statement.executeQuery(sql);
	    if (result != null) {
		while (result.next()) {
		    int idDebt = result.getInt("idDebt");
		    int idFrom = result.getInt("idFrom");
		    int idTo = result.getInt("idTo");
		    Double amount = result.getDouble("amount");
		    userDebt.add(new UserDebt(idDebt, amount, idFrom, idTo));
		}
	    } else {
		return null;
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return null;
	}

	return userDebt;
    }

}
