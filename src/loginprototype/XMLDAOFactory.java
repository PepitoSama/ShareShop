package loginprototype;


import java.util.*;

/**
 * 
 */
public class XMLDAOFactory extends AbstractDAOFactory {

    /**
     * Default constructor
     */
    public XMLDAOFactory() {
    }


    /**
     * @return
     */
    public DAO getUserDAO() {
        // TODO implement here
        return new UserXMLDAO();
    }

}