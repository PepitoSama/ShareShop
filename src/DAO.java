import java.util.List;

public interface DAO<T> {
	public List<T> getAll();
	public T get(int id);
	public boolean save(T obj);
	public boolean update(T obj);
	public boolean delete(T obj);
}
