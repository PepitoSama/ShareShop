package loginprototype;


import java.util.*;

/**
 * 
 */
public abstract class AbstractDAOFactory {

    /**
     * Default constructor
     */
    public AbstractDAOFactory() {
    }

    /**
     * @return
     */
    public DAO<User> getUserDAO() {
        return new UserXMLDAO();
    }

}