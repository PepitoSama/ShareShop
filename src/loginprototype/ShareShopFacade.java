package loginprototype;


import java.util.*;

/**
 * 
 */
public class ShareShopFacade {

    /**
     * Default constructor
     */
    public ShareShopFacade() {
    }

    /**
     * 
     */
    public AbstractDAOFactory userDAOFactory;

    /**
     * 
     */
    public DAO userDAO;

    /**
     * 
     */
    private User user;

    /**
     * @param pseudo 
     * @param mdp 
     * @return
     */
    public boolean login(String pseudo, String mdp) {
    	
    	userDAOFactory = new XMLDAOFactory();
    	
    	userDAO = userDAOFactory.getUserDAO();
    	
    	user = (User) (userDAO.get(pseudo));
    	
    	return user != null && user.getPassword().equals(mdp);
    	

    }
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Entrer pseudo : ");
    	String pseudo = sc.nextLine();
    	
    	System.out.println("Entrer mdp : ");
    	String mdp = sc.nextLine();
    	
    	
    	ShareShopFacade f = new ShareShopFacade();
    	
    	System.out.println(f.login(pseudo, mdp));
    }

}