package model.dao;

import java.util.List;

public interface DAO<T> {

	public List<T> getAll();
	public T get(String id);
	public boolean save(T obj);
	public boolean update(T obj);
	public boolean delete(T obj);
	public List<T> getWhere(List<Couple> where);
}
