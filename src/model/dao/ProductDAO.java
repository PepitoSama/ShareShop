package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.domain.products.GeneralProduct;


public class ProductDAO implements DAO<GeneralProduct> {

	@Override
	public List<GeneralProduct> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralProduct get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(GeneralProduct obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(GeneralProduct obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(GeneralProduct obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<GeneralProduct> getWhere(List<Couple> where) {
		// TODO Auto-generated method stub
		return null;
	}



}
