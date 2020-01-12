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
import java.util.List;
import model.domain.products.QuantifiedProduct;

/**
 *
 * @author fsmag
 */
public class QuantifiedProductDAO implements DAO<QuantifiedProduct> {

    String tableName;
    JDBCAccess jdbc;

    public QuantifiedProductDAO() {
	this.jdbc = JDBCAccess.getInstance();
	this.tableName = "`QuantifiedProductList`";
    }

    @Override
    public List<QuantifiedProduct> getAll() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<QuantifiedProduct> get(List<Couple> where) {
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
	ArrayList<QuantifiedProduct> quantifiedProducts = new ArrayList<QuantifiedProduct>();
	try {
	    ResultSet result = statement.executeQuery();
	    if (result != null) {
		while (result.next()) {
		    int idGroupList = result.getInt("idGroupList");
		    int idProduct = result.getInt("idProduct");
		    int quantity = result.getInt("quantity");
		    quantifiedProducts.add(new QuantifiedProduct(idGroupList, idProduct, quantity));
		}
	    } else {
		return null;
	    }

	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return null;
	}
	return quantifiedProducts;
    }

    @Override
    public boolean save(QuantifiedProduct obj) {
	String sql = "INSERT INTO " + this.tableName + " VALUES (?, ?, ?)";
	int rowsInserted = 0;
	PreparedStatement statement;

	statement = jdbc.prepareStatement(sql);
	try {
	    statement.setInt(1, obj.getIdGroupList());
	    statement.setInt(2, obj.getIdProduct());
	    statement.setInt(3, obj.getQuantity());
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
    public boolean update(QuantifiedProduct obj) {
	String sql = "UPDATE " + this.tableName+ " SET quantity=? WHERE idProduct=? and idGroupList=?";

	PreparedStatement statement = jdbc.prepareStatement(sql);
	try {
	    statement.setInt(1, obj.getQuantity());
	    statement.setInt(2, obj.getIdProduct());
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
    public boolean delete(QuantifiedProduct obj) {
	String sql = "DELETE FROM " + this.tableName + " WHERE idGroupList=? and idProduct = ?";
	PreparedStatement statement = jdbc.prepareStatement(sql);
	try {
	    statement.setInt(1, obj.getIdGroupList());
	    statement.setInt(2, obj.getIdProduct());
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
