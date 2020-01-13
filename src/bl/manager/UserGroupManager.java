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
import model.dao.Couple;
import model.dao.DAO;
import model.dao.StatsDAO;
import model.domain.Group;
import model.domain.GroupList;
import model.domain.Stats;
import model.domain.User;
import model.domain.UserGroup;

/**
 *
 * @author pepito
 */
public class UserGroupManager {

	private static UserGroupManager instance = null;

	private User selected;

	public User getSelected() {
		return selected;
	}

	public static UserGroupManager getInstance() {
		if (instance == null) {
			instance = new UserGroupManager();
		}
		return instance;
	}

	
	/**
	 * Add a user tot a group
	 * @param idUser	the id of the user
	 * @param idGroup	the id of the group
	 * @return	true if the operation as suceeded
	 */
	public boolean createUserGroup(int idUser, int idGroup) {
		DAO<UserGroup> dao = AbstractDAOFactory.getInstance().getUserGroupDAO();
		UserGroup userGroup = new UserGroup(idUser, idGroup);
		return dao.save(userGroup);
	}

	
	/**
	 * Get the list of UserGroup for the user
	 * 
	 * @param userId
	 *            the id of the user
	 * @return The list of UserGroup
	 */
	public List<UserGroup> getUserGroupList(int userId) {
		DAO<UserGroup> dao = AbstractDAOFactory.getInstance().getUserGroupDAO();
		List<UserGroup> userGroupList = new ArrayList<>();
		for (UserGroup userGroup : dao.getAll()) {
			if (userGroup.getIdUser() == userId) {
				userGroupList.add(userGroup);
			}
		}
		return userGroupList;
	}

	
	/**
	 * Get the ids of the users for a group
	 * @param groupId	the id of the group
	 * @return	a list of User id
	 */
	public List<Integer> getUsersIdGroupList(int groupId) {
		DAO<UserGroup> dao = AbstractDAOFactory.getInstance().getUserGroupDAO();
		Couple where = new Couple("idGroup", Integer.toString(groupId));
		List<Couple> listWhere = new ArrayList<>();
		listWhere.add(where);
		List<UserGroup> listGroup = dao.get(listWhere);
		List<Integer> users = new ArrayList<>();
		for (UserGroup userGroup : listGroup) {
			users.add(userGroup.getIdUser());
		}
		return users;
	}
	
	/**
	 * Set the user selected in this manager
	 * @param user
	 */
	public void setSelected(User user) {
		this.selected = user;
	}

	/** 
	 * TODO
	 * Remove a member from the group
	 * @return
	 */
	public static boolean removeMember() {
		DAO<UserGroup> dao = AbstractDAOFactory.getInstance().getUserGroupDAO();
		// return dao.delete(selected);
		return true;
	}

}
