/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.manager;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import model.dao.AbstractDAOFactory;
import model.dao.DAO;
import model.dao.DAOStatsInterface;
import model.dao.StatsDAO;
import model.domain.Group;
import model.domain.Stats;
import model.domain.User;

/**
 *
 * @author pepito
 */
public class GroupManager {

    private static GroupManager instance = null;

    public static GroupManager getInstance() {
        if (instance == null) {
            instance = new GroupManager();
        }
        return instance;
    }

	public boolean createGroup(String groupName) {
		DAO<Group> dao = AbstractDAOFactory.getInstance().getGroupDAO();
		Group g;
        try {
			checkExisting(groupName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        g = new Group(groupName);
		return dao.save(g);
	}
	
	public void checkExisting(String groupName) throws Exception {
        DAO<Group> dao = AbstractDAOFactory.getInstance().getGroupDAO();
        List<Group> groups = dao.getAll();
        boolean res = false;
        for (Group g : groups) {
            if (g.getGroupName().equals(groupName)) {
                throw new Exception("Group Name already use");
            }
        }
    }
    
}
