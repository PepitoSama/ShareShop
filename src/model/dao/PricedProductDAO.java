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
import model.domain.products.PricedProduct;
import model.domain.products.SubGeneralProduct;

/**
 *
 * @author fsmag
 */
public class PricedProductDAO implements DAO<PricedProduct> {

    String tableName;
    JDBCAccess jdbc;

    public PricedProductDAO() {
	this.jdbc = JDBCAccess.getInstance();
	this.tableName = "`PricedProductList`";
    }

    @Override
    public List<PricedProduct> getAll() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PricedProduct> get(List<Couple> where) {
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
	ArrayList<PricedProduct> pricedProducts = new ArrayList<PricedProduct>();
	try {
	    ResultSet result = statement.executeQuery();
	    if (result != null) {
		while (result.next()) {
		    int idGroupList = result.getInt("idGroupList");
		    int idProduct = result.getInt("idProduct");
		    int quantity = result.getInt("quantity");
		    Double price = result.getDouble("price");
		    pricedProducts.add(new PricedProduct(price, idGroupList, idProduct, quantity));
		}
	    } else {
		return null;
	    }

	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return null;
	}
	return pricedProducts;
    }

    @Override
    public boolean save(PricedProduct obj) {
	String sql = "INSERT INTO " + this.tableName + " VALUES (?, ?, ?,?)";
	int rowsInserted = 0;
	PreparedStatement statement;

	statement = jdbc.prepareStatement(sql);
	try {
	    statement.setInt(1, obj.getIdGroupList());
	    statement.setInt(2, obj.getIdProduct());
	    statement.setDouble(3, obj.getPrice());
	    statement.setInt(4, obj.getQuantity());
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
    public boolean update(PricedProduct obj) {
	String sql = "UPDATE " + this.tableName + " SET quantity=? , price = ? WHERE idProduct=? and idGroupList=?";

	PreparedStatement statement = jdbc.prepareStatement(sql);
	try {
	    statement.setInt(1, obj.getQuantity());
	    statement.setDouble(2, obj.getPrice());
	    statement.setInt(3, obj.getIdProduct());
	    statement.setInt(4, obj.getIdGroupList());
	    int rowsUpdated = statement.executeUpdate();

	    if (rowsUpdated > 0) {
		return true;
	    }
	    return false;
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return false;

    }

    @Override
    public boolean delete(PricedProduct obj) {
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
