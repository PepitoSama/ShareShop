package model.dao;

import model.domain.Group;
import model.domain.Stats;
import model.domain.User;

/**
 * 
 */
public abstract class AbstractDAOFactory {
	
	private static AbstractDAOFactory instance = null;

    /**
     * Default constructor
     */
    protected AbstractDAOFactory() {
    }
    
    public static AbstractDAOFactory getInstance() {
    	
    	if (instance == null) {
    		instance = new MySQLDAOFactory();
    	}
    	return instance;
    }

    /**
     * @return
     */
    public abstract DAO<User> getUserDAO();
    public abstract DAOStatsInterface<Stats> getStatsDAO();
    public abstract DAO<Group> getGroupDAO();

}