package loginprototype;


import java.util.*;

/**
 * 
 */
public interface DAO<T> {

    /**
     * @return
     */
    public List<T> getAll();

    /**
     * @param int id 
     * @return
     */
    public T get(Object id);

    /**
     * @param obj
     */
    public void save(T obj);

    /**
     * @param obj
     */
    public void update(T obj);

    /**
     * @param obj
     */
    public void delete(T obj);

}