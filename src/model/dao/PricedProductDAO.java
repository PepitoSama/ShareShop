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
import model.domain.products.Product;

/**
 *
 * @author fsmag
 */
public class PricedProductDAO implements DAO<PricedProduct> {

    JDBCAccess jdbc;
    String tableName;
    String product;

    public PricedProductDAO() {
        this.jdbc = JDBCAccess.getInstance();
        this.tableName = "PricedProductList";
        this.product = "Product";
    }

    @Override
    public List<PricedProduct>  getWhere(List<Couple> where) {
        String sql = "SELECT * FROM " + this.tableName + " t, " + this.product + " p WHERE ";
        int rows = 0;
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
        ArrayList<PricedProduct> boughtList = new ArrayList<PricedProduct>();
        try {
            ResultSet result = statement.executeQuery();
            if (result != null) {
                while (result.next()) {
                    int idGroupList = result.getInt("idGroupList");
                    int idProduct = result.getInt("t.idProduct");
                    Double price = result.getDouble("price");
                    int quantity = result.getInt("quantity");
                    String name = result.getString("name");
                    int idFather = result.getInt("idFather");
                    String description = result.getString("description");
                    boughtList.add(new PricedProduct(price, new Product(idProduct, name, null, description, idFather), quantity));
                }
            } else {
                return null;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return boughtList;
    }

    @Override
    public List<PricedProduct> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PricedProduct get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(PricedProduct obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(PricedProduct obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(PricedProduct obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
