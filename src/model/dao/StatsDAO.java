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
import java.util.Date;
import java.util.List;
import model.domain.Stats;
import model.domain.User;

/**
 *
 * @author fsmag
 */
public class StatsDAO implements DAOStatsInterface<Stats> {

    JDBCAccess jdbc;
    String tableName;

    public StatsDAO() {
        this.jdbc = JDBCAccess.getInstance();
        this.jdbc.openConnection();
        this.tableName = "`Stats`";
    }

    @Override
    public List<Stats> getAll() {
        String sql = "SELECT * FROM " + this.tableName;
        Statement statement;
        ArrayList<Stats> statsList = new ArrayList<Stats>();

        statement = jdbc.prepareStatement(sql);
        ResultSet result;
        try {
            result = statement.executeQuery(sql);
            if (result != null) {
                while (result.next()) {
                    int idUser = result.getInt("idUser");
                    Date date = result.getDate("date");
                    float amount = result.getFloat("amount");
                    statsList.add(new Stats(idUser, new java.util.Date(date.getTime()), amount));
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        return statsList;
    }

    @Override
    public List<Stats> getUser(int id) {
        String sql = "SELECT * FROM " + this.tableName + " WHERE idUser=?";
        int rows = 0;
        PreparedStatement statement;
        statement = jdbc.prepareStatement(sql);
        ArrayList<Stats> statsList = new ArrayList<Stats>();
        System.out.println(id);
        try {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result != null) {
                while (result.next()) {
                    int idUser = result.getInt("idUser");
                    Date date = result.getDate("date");
                    float amount = result.getFloat("amount");
                    statsList.add(new Stats(idUser, new java.util.Date(date.getTime()), amount));
                }
            } else {
                return null;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return statsList;
    }

    public List<Stats> getDate(int id, Date d, Date f) {
        String sql = "";
        if (d != null && f != null) {
            sql = "SELECT * FROM " + this.tableName + " WHERE idUser=? and date>=? and date<=?";
        } else if (d != null) {
            sql = "SELECT * FROM " + this.tableName + " WHERE idUser=? and date>=? ";
        } else {
            sql = "SELECT * FROM " + this.tableName + " WHERE idUser=? and date<=?";
        }

        int rows = 0;
        PreparedStatement statement;

        statement = jdbc.prepareStatement(sql);
        ArrayList<Stats> statsList = new ArrayList<Stats>();
        try {
            statement.setInt(1, id);
            if (d != null && f != null) {
                statement.setDate(2, new java.sql.Date(d.getTime()));
                statement.setDate(3, new java.sql.Date(f.getTime()));
            } else if (d != null) {
                statement.setDate(2, new java.sql.Date(d.getTime()));
            } else {
                statement.setDate(2, new java.sql.Date(f.getTime()));
            }
            
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idUser = resultSet.getInt("idUser");
                Date date = resultSet.getDate("date");
                float amount = resultSet.getFloat("amount");
                statsList.add(new Stats(idUser, new java.util.Date(date.getTime()), amount));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return statsList;
    }
    
    public List<Stats> getDate( Date d, Date f) {
        String sql = "";
        if (d != null && f != null) {
            sql = "SELECT * FROM " + this.tableName + " WHERE date>=? and date<=?";
        } else if (d != null) {
            sql = "SELECT * FROM " + this.tableName + " WHERE date>=? ";
        } else {
            sql = "SELECT * FROM " + this.tableName + " WHERE date<=?";
        }

        int rows = 0;
        PreparedStatement statement;

        statement = jdbc.prepareStatement(sql);
        ArrayList<Stats> statsList = new ArrayList<Stats>();
        try {
            if (d != null && f != null) {
                statement.setDate(1, new java.sql.Date(d.getTime()));
                statement.setDate(2, new java.sql.Date(f.getTime()));
            } else if (d != null) {
                statement.setDate(1, new java.sql.Date(d.getTime()));
            } else {
                statement.setDate(1, new java.sql.Date(f.getTime()));
            }
            
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idUser = resultSet.getInt("idUser");
                Date date = resultSet.getDate("date");
                float amount = resultSet.getFloat("amount");
                statsList.add(new Stats(idUser, new java.util.Date(date.getTime()), amount));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return statsList;
    }

    @Override
    public boolean save(Stats stat) {

        String sql = "INSERT INTO " + this.tableName + " VALUES ( ?, ?, ?)";
        int rowsInserted = 0;
        PreparedStatement statement;

        statement = jdbc.prepareStatement(sql);
        try {
            statement.setInt(1, stat.getIdUser());
            statement.setDate(2, new java.sql.Date(stat.getDate().getTime()));
            statement.setFloat(3, stat.getAmount());
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
    public boolean update(Stats stat) {
        String sql = "UPDATE " + this.tableName
                + " SET amount=? WHERE idUser=? and date=?";

        PreparedStatement statement = jdbc.prepareStatement(sql);

        try {
            statement.setDate(3, new java.sql.Date(stat.getDate().getTime()));
            statement.setFloat(1, stat.getAmount());
            statement.setInt(2, stat.getIdUser());

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

    public boolean delete(Stats stat) {
        String sql = "DELETE FROM " + this.tableName + " WHERE idUser=? and date=?";

        PreparedStatement statement = jdbc.prepareStatement(sql);
        try {
            statement.setInt(1, stat.getIdUser());
            statement.setDate(2, new java.sql.Date(stat.getDate().getTime()));
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
    public Stats get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumber() {
        String sql = "SELECT DISTINCT(idUser) FROM " + this.tableName;
        Statement statement;
        ArrayList<Stats> statsList = new ArrayList<Stats>();
        int res = 0;
        statement = jdbc.prepareStatement(sql);
        ResultSet result;
        try {
            result = statement.executeQuery(sql);
            while (result.next()) {
                res += 1;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }
    
	@Override
	public List<Stats> getWhere(List<Couple> where) {
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
        ArrayList<Stats> statsList = new ArrayList<Stats>();

        statement = jdbc.prepareStatement(sql);
        ResultSet result;
        try {
            result = statement.executeQuery(sql);
            if (result != null) {
                while (result.next()) {
                    int idUser = result.getInt("idUser");
                    Date date = result.getDate("date");
                    float amount = result.getFloat("amount");
                    statsList.add(new Stats(idUser, new java.util.Date(date.getTime()), amount));
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        return statsList;
	}
}
