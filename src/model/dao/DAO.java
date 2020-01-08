package model.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

	public List<T> getAll();
	public T get(String id);
	public boolean save(T obj);
	public boolean update(T obj) throws SQLException;
	public boolean delete(T obj);
	public List<T> getWhere(List<Couple> where);
}
