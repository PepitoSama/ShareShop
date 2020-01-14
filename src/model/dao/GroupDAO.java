package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.domain.Group;
import model.domain.UserGroup;
import model.domain.products.GeneralProduct;
import model.domain.products.SubGeneralProduct;

public class GroupDAO implements DAO<Group> {
	
	JDBCAccess jdbc;
	String tableName;

	public GroupDAO() {
		this.jdbc = JDBCAccess.getInstance();
		this.tableName = "`Group`";
	}

	@Override
	public List<Group> getAll() {
		String sql = "SELECT * FROM " + this.tableName;
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
					
					Group g = new Group(idGroup, name);
					groupList.add(g);
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
	public List<Group> get(List<Couple> where) {
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
		ArrayList<Group> groupList = new ArrayList<>();

		statement = jdbc.prepareStatement(sql);
		ResultSet result;
		try {
			result = statement.executeQuery(sql);
			if (result != null) {
				while (result.next()) {
					
					int idGroup = result.getInt("idGroup");
					String name = result.getString("name");
					
					Group g = new Group(idGroup, name);
					groupList.add(g);
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
	public boolean save(Group group) {
		String sql = "INSERT INTO " + this.tableName + " VALUES (default, ?)";
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
	public boolean update(Group obj) {
		// TODO complete update 
		
		// Update favorite products
		for (GeneralProduct p : obj.getFavoriteList()) {
			try {
				addFavorite(p, obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return true;
	}

	@Override
	public boolean delete(Group obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	/**
	 * Get the favorites list for this group
	 * @param obj
	 * @return
	 */
	public List<GeneralProduct> getFavorites(Group obj) {
		List<GeneralProduct> l = new ArrayList<>();
		
		String sql = "SELECT * FROM FavorisProductList WHERE idGroup = ?";
		
		PreparedStatement statement = jdbc.prepareStatement(sql);
		ResultSet result;
		try {
			statement.setString(1, obj.getId() + "");
			
			result = statement.executeQuery();
			
			if (result != null) {

				DAO<GeneralProduct> daoprod = AbstractDAOFactory.getInstance().getProductDAO();
				while (result.next()) {
					Couple where = new Couple("idProduct", result.getString("idProduct"));
					List<Couple> listWhere = new ArrayList<>();
					listWhere.add(where);
					GeneralProduct p = daoprod.get(listWhere).get(0);

					l.add(p);
				}
			} else {
				return l;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return l;
	}
	
	/**
	 * Add a favorite to this group
	 * 
	 * @param p
	 * @param obj
	 * @return
	 */
	public boolean addFavorite(GeneralProduct p, Group obj) {
		String sql = "INSERT INTO FavorisProductList VALUES (?, ?)";
		int rowsInserted = 0;
		PreparedStatement statement;

		statement = jdbc.prepareStatement(sql);
		try {
			statement.setString(1, obj.getId() + "");
			statement.setString(2, p.getIdProduct() + "");

			rowsInserted = statement.executeUpdate();

			if (rowsInserted > 0) {
				return true;
			}
		} catch(SQLIntegrityConstraintViolationException e) {
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
		
		
	}
	


}
