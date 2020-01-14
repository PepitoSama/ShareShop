package model.dao;

import java.util.List;

public interface DAO<T> {
	
	/**
	 * Get all lines from a table
	 * 
	 * @return List<T>
	 * 		A List containing all result
	 */
	public List<T> getAll();
	
	/**
	 * Get all the corresponding objects
	 * 
	 * @param where A List<Couple> with the column name and it value
	 * @return List<T>
	 * 		A List containing all objects
	 */
	public List<T> get(List<Couple> where);
	
	/**
	 * Save an object in database
	 * 
	 * @param obj The object you want to store
	 * @return True if the object was succefully saved in database
	 */
	public boolean save(T obj);
	
	/**
	 * Update an existing object in database
	 * 
	 * @param obj The object you want to update
	 * @return True if the object was succefully updated in database
	 */
	public boolean update(T obj);
	
	/**
	 * delete an existing object in database
	 * 
	 * @param obj The object you want to delete
	 * @return True if the object was succefully removed from database
	 */
	public boolean delete(T obj);
}
