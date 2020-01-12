/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.manager;

import java.util.ArrayList;
import java.util.List;
import model.dao.AbstractDAOFactory;
import model.dao.Couple;
import model.dao.DAO;
import model.domain.User;
import model.domain.UserGroup;

/**
 *
 * @author pepito
 */
public class UserGroupManager {
	
	

    private static UserGroupManager instance = null;
    
	private static UserGroup selected;
	
	public UserGroup getSelected() {
		return selected;
	    }
	
    public static void setSelected(UserGroup userGroup) {
    		selected = userGroup;
        }
    

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
    
    public UserGroup getUserGroup(User user) {
    	DAO<UserGroup> dao = AbstractDAOFactory.getInstance().getUserGroupDAO();
    		for (UserGroup userGroup : dao.getAll()) {
    	    if (userGroup.getIdUser() == user.getId()) {
    	    	if(userGroup.getIdGroup() == this.getSelected().getIdGroup())
    	    		return userGroup;
    	    }
    	}
		return null;
    }
    
    
//    public List<Integer> getGroupId(int userId) {
//    	DAO<UserGroup> dao = AbstractDAOFactory.getInstance().getUserGroupDAO();
//    	List<Integer> GroupId = new ArrayList<>();
//    	for (UserGroup userGroup : dao.getAll()) {
//    	    if (userGroup.getIdUser() == userId) {
//    	    		GroupId.add(userGroup.getIdGroup());
//    	    		return GroupId;
//    	    }
//    	}
//		return GroupId;
//    }
    
    	
    
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
    

    public static  boolean removeUserGroup() {
    	DAO<UserGroup> dao = AbstractDAOFactory.getInstance().getUserGroupDAO();
    	return dao.delete(selected);
        }

}
