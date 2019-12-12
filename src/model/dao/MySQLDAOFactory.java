package model.dao;

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

}