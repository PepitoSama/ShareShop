package dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
	public List<T> getAll();
	public T get(String id);
	public boolean save(T obj);
	public boolean update(T obj);
	public boolean delete(T obj);
}
