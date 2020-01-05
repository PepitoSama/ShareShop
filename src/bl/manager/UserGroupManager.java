/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.manager;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.dao.AbstractDAOFactory;
import model.dao.DAO;
import model.dao.DAOStatsInterface;
import model.dao.StatsDAO;
import model.domain.Group;
import model.domain.Stats;
import model.domain.User;
import model.domain.UserGroup;

/**
 *
 * @author pepito
 */
public class UserGroupManager {

    private static UserGroupManager instance = null;

    public static UserGroupManager getInstance() {
        if (instance == null) {
            instance = new UserGroupManager();
        }
        return instance;
    }

	public boolean createUserGroup(int idUser, int idGroup) {
		DAO<UserGroup> dao = AbstractDAOFactory.getInstance().getUserGroupDAO();
		UserGroup userGroup = new UserGroup(idUser, idGroup);
		return dao.save(userGroup);
	}

	public List<UserGroup> getUserGroupList(int userId) {
		DAO<UserGroup> dao = AbstractDAOFactory.getInstance().getUserGroupDAO();
		List<UserGroup> userGroupList = new ArrayList<>();
		for (UserGroup userGroup : dao.getAll()) {
			if(userGroup.getIdUser() == userId) {
				userGroupList.add(userGroup);
			}
		}
		return userGroupList;
	}

    
}
