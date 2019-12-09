package loginprototype;


import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;


/**
 * 
 */
public class UserXMLDAO implements DAO<User> {
	
	File f;
	Document doc;

    /**
     * Default constructor
     */
    public UserXMLDAO() {
    	users = new ArrayList<>();
    	
    	File f = new File("./XMLData/users.xml");
    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(f);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("User");
            
            for (int i = 0; i < nodeList.getLength(); i++) {
            	Element element = (Element) nodeList.item(i) ;
            	
            	String pseudo = element.getElementsByTagName("Pseudo").item(0).getTextContent();
            	String mdp = element.getElementsByTagName("Password").item(0).getTextContent();
            	
            	users.add(new User(pseudo, mdp));
            }
        }  catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 
     */
    private List<User> users;

    /**
     * @return
     */
    public List<User> getAll() {
        // TODO implement here
        return null;
    }

    /**
     * @param Object id 
     * @return
     */
    public User get(Object id) {
        if (id instanceof String) {
        	String idStr = (String) id;
        	for (User u : users) {
        		if (u.getPseudo().equals(id)) {
        			return u;
        		}
        	}
        }
        return null;
    }

    /**
     * @param obj
     */
    public void save(User obj) {
        // TODO implement here
    }

    /**
     * @param obj
     */
    public void update(User obj) {
        // TODO implement here
    }

    /**
     * @param obj
     */
    public void delete(User obj) {
        // TODO implement here
    }



}