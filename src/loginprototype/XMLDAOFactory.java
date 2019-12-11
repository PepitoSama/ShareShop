package loginprototype;


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
    public DAO<User> getUserDAO() {
        // TODO implement here
        return new UserXMLDAO();
    }

}