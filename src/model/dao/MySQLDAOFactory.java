package model.dao;

import model.domain.Group;
import model.domain.Stats;
import model.domain.User;
import model.domain.UserGroup;

/**
 * 
 */
public class MySQLDAOFactory extends AbstractDAOFactory {

    /**
     * @return
     */
    public DAO<User> getUserDAO() {
        return new UserDAO();
    }
    
    public DAOStatsInterface<Stats> getStatsDAO() {
        return new StatsDAO();
    }
    
    public DAO<Group> getGroupDAO() {
    	return new GroupDAO();
    }
    
    public DAO<UserGroup> getUserGroupDAO() {
    	return new UserGroupDAO();
    }

}