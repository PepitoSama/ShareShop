package model.dao;

import java.util.List;

public interface DAO<T> {

	public List<T> getAll();
	public List<T> get(List<Couple> where);
	public boolean save(T obj);
	public boolean update(T obj);
	public boolean delete(T obj);
}
