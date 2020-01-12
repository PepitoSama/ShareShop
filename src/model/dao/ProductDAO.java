package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.domain.Group;
import model.domain.products.*;

public class ProductDAO implements DAO<GeneralProduct> {

	String tableName;
	JDBCAccess jdbc;

	public ProductDAO() {
		this.jdbc = JDBCAccess.getInstance();
		this.tableName = "`Product`";
	}

	@Override
	public List<GeneralProduct> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public GeneralProduct get(String id) {
//		String sql = "SELECT * FROM " + this.tableName + " WHERE idProduct=?";
//		PreparedStatement statement;
//
//		statement = jdbc.prepareStatement(sql);
//		try {
//			statement.setString(1, id);
//			ResultSet resultSet = statement.executeQuery();
//
//			return makeProducts(resultSet).get(0);
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//
//	}

	@Override
	public boolean save(GeneralProduct obj) {
		String sql;

		try {
			int rowsInserted = 0;
			PreparedStatement statement;
			sql = "INSERT INTO " + this.tableName + "(name, description, idFather";

			if (obj instanceof SubGeneralProduct) {
				sql += ") VALUES (?, ?, ?)";
			} else if (obj instanceof ExistingProduct) {
				sql += ", barcode, estimatedPrice) VALUES (?, ?, ?, ?, ?)";
			} else if (obj instanceof CustomProduct) {
				sql += ", idGroup) VALUES (?, ?, ?, ?)";
			}

			statement = jdbc.prepareStatement(sql);

			statement.setString(1, obj.getName());
			statement.setString(2, obj.getDescription());

			if (obj.getIdFather() > 0) {
				statement.setInt(3, obj.getIdFather());
			} else {
				statement.setString(3, null);
			}

			if (obj instanceof ExistingProduct) {
				statement.setString(4, ((ExistingProduct) obj).getBarcode());
				statement.setDouble(5, ((ExistingProduct) obj).getEstimatedPrice());
			} else if (obj instanceof CustomProduct) {
				statement.setInt(4, ((CustomProduct) obj).getGroup().getId());
			}

			rowsInserted = statement.executeUpdate();

			if (rowsInserted > 0) {
				PreparedStatement st = jdbc.prepareStatement("SELECT LAST_INSERT_ID()");

				ResultSet rs = st.executeQuery();

				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setIdProduct(id);
				}

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
	public boolean update(GeneralProduct obj) {
		String sql;

		try {
			PreparedStatement statement;
			sql = "UPDATE " + this.tableName + " SET name = ?, description = ?, idFather = ?";

			if (obj instanceof ExistingProduct) {
				sql += ", barcode = ?, estimatedPrice = ?";
			} else if (obj instanceof CustomProduct) {
				sql += ", idGroup = ?";
			}
			sql += " WHERE idProduct = ?";
			
			statement = jdbc.prepareStatement(sql);

			statement.setString(1, obj.getName());
			statement.setString(2, obj.getDescription());

			if (obj.getIdFather() > 0) {
				statement.setInt(3, obj.getIdFather());
			} else {
				statement.setString(3, null);
			}

			if (obj instanceof ExistingProduct) {
				statement.setString(4, ((ExistingProduct) obj).getBarcode());
				statement.setDouble(5, ((ExistingProduct) obj).getEstimatedPrice());
			} else if (obj instanceof CustomProduct) {
				statement.setInt(4, ((CustomProduct) obj).getGroup().getId());
			}
			
			if (obj instanceof ExistingProduct) {
				statement.setInt(6, obj.getIdProduct());
			} else {
				statement.setInt(5, obj.getIdProduct());
			}

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

	@Override
	public boolean delete(GeneralProduct obj) {
		String sql = "DELETE FROM " + this.tableName + " WHERE idProduct=`?`";

        PreparedStatement statement = jdbc.prepareStatement(sql);
        try {
            statement.setInt(1, obj.getIdProduct());
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
	public List<GeneralProduct> get(List<Couple> where) {
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

		statement = jdbc.prepareStatement(sql);
		ResultSet result;
		try {
			result = statement.executeQuery(sql);
			if (result != null) {
				return makeProducts(result);
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Make the list of GeneralProduct based on the data the object has on the base : 
	 * - If there is an group id, then the Object is a CustomProduct 
	 * - If there is a barcode, the Object is an ExistingProduct 
	 * - Else, the Object is a subGeneralProduct
	 * 
	 * @param rs
	 *            The ResultSet of the query
	 * @return The list of GeneralProduct from the ResultSet rs
	 * @throws SQLException
	 */
	private List<GeneralProduct> makeProducts(ResultSet rs) throws SQLException {
		List<GeneralProduct> l = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt("idProduct");
			String name = rs.getString("name");
			// TODO Image
			String description = rs.getString("description");
			String barcode = rs.getString("barcode");
			int idFather = rs.getInt("idFather");
			double estimatedPrice = rs.getDouble("EstimatedPrice");
			int idGroup = rs.getInt("idGroup");

			GeneralProduct p;
			if (idGroup > 0) { // Custom
				Couple where = new Couple("idGroup", String.valueOf(idGroup));
				List<Couple> listWhere = new ArrayList<>();
				listWhere.add(where);
				Group g = new GroupDAO().get(listWhere).get(0);
				p = new CustomProduct(id, name, null, description, idFather, g);
			} else if (barcode != null) { // Existing
				p = new ExistingProduct(id, name, null, description, idFather, barcode, estimatedPrice);
			} else { // Subcategory
				p = new SubGeneralProduct(id, name, null, description, idFather);
			}

			l.add(p);

		}
		return l;
	}

	public static void main(String[] args) {
		DAO<GeneralProduct> dao = new ProductDAO();

		GeneralProduct subgen = new SubGeneralProduct(-1, "SubGeneralProduct", null, "description", 1);

		GeneralProduct existing = new ExistingProduct(-1, "Existing", null, "description", 0, "CodeBarre", 15.2);

		GeneralProduct custom = new CustomProduct(-1, "Custom", null, "description", 1, new Group(1, ""));

		//System.out.println(dao.save(subgen));
		// System.out.println(dao.save(existing));
		// System.out.println(dao.save(custom));

		// System.out.println(dao.get("12"));
		// System.out.println(dao.get("13"));
		// System.out.println(dao.get("14"));
		//
		Couple c = new Couple("name", "Existing");
		List<Couple> l = new ArrayList<>();
		l.add(c);
		System.out.println(dao.get(l));

		c = new Couple("idFather", "1");
		l = new ArrayList<>();
		l.add(c);
		for (GeneralProduct p : dao.get(l)) {
			System.out.println(p);
		}
		
		Couple where = new Couple("idProduct", "13");
		List<Couple> listWhere = new ArrayList<>();
		listWhere.add(where);
		GeneralProduct prod = dao.get(listWhere).get(0);
		prod.setDescription("Une description");
		
		System.out.println(dao.update(prod));
		
		dao.save(subgen);
		System.out.println(subgen);
		System.out.println(dao.delete(subgen));
		
	}

}
