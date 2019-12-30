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
public class GroupListDAO implements DAOGroupListInterface<GroupList> {

    JDBCAccess jdbc;
    String tableName;
    String quantified;

    public GroupListDAO() {
        this.jdbc = JDBCAccess.getInstance();
        this.jdbc.openConnection();
        this.tableName = "GroupList";
        this.quantified = "QuantifiedProductList";
    }

    @Override
    public List<GroupList> getShoppingList(int id) {
        String sql = "SELECT * FROM " + this.tableName + " WHERE idGroup=? and type='S'";
        int rows = 0;
        PreparedStatement statement;
        statement = jdbc.prepareStatement(sql);
        ArrayList<GroupList> shoppingList = new ArrayList<GroupList>();
        try {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result != null) {
                while (result.next()) {
                    int idGroupList = result.getInt("idGroupList");
                    int idGroup = result.getInt("idGroup");
                    Date date = result.getDate("date");
                    String name = result.getString("name");
                    char type = result.getString("type").charAt(0);
                    shoppingList.add(new GroupList(idGroupList, idGroup, name, new java.util.Date(date.getTime()),type));
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GroupList get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public boolean update(GroupList obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(GroupList obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
