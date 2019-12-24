package model.dao;

import model.domain.Stats;
import model.domain.User;

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

}