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
import model.domain.Group;
import model.domain.UserGroup;

/**
 *
 * @author pepito
 */
public class GroupManager {

	private static GroupManager instance = null;
	private Group selected;

	/**
	 * Return, if created the GroupManager instance. Else, instantiate GroupManager
	 * and return it.
	 * 
	 * @return GroupManager
	 */
	public static GroupManager getInstance() {
		if (instance == null) {
			instance = new GroupManager();
		}
		return instance;
	}

	/**
	 * Return the selected Group
	 * 
	 * @return Group
	 */
	public Group getSelected() {
		return selected;
	}

	/**
	 * Return the id of selected Group
	 * @return int
	 */
	public int getSelectedGroupId() {
		return getSelected().getId();
	}

	/**
	 * Set the selected Group
	 * 
	 * @param selected Group
	 */
	public void setSelected(Group group) {
		this.selected = group;
	}

	/**
	 * Create a new Group
	 * 
	 * @param groupName String
	 * @return true if the group was succefully created
	 */
	public boolean createGroup(String groupName) {
		// Create the Group
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

	/**
	 * Check if a Group name is not already used
	 * 
	 * @param groupName String
	 * @throws Exception Exception("Group Name already use")
	 */
	public void checkExisting(String groupName) throws Exception {
		DAO<Group> dao = AbstractDAOFactory.getInstance().getGroupDAO();
		List<Group> groups = dao.getAll();
		for (Group g : groups) {
			if (g.getGroupName().equals(groupName)) {
				throw new Exception("Group Name already use");
			}
		}
	}

	/**
	 * Get all group from a List of UserGroup
	 * 
	 * @param userGroupList List<UserGroup>
	 * @return List<Group>
	 */
	public List<Group> getGroupList(List<UserGroup> userGroupList) {
		DAO<Group> dao = AbstractDAOFactory.getInstance().getGroupDAO();
		List<Group> groupList = new ArrayList<>();
		for (Group group : dao.getAll()) {
			for (UserGroup userGroup : userGroupList) {
				if (group.getId() == userGroup.getIdGroup()) {
					groupList.add(group);
				}
			}
		}
		return groupList;
	}

	/**
	 * Get a group id from it name
	 * 
	 * @param groupName String
	 * @return int
	 */
	public int getGroupId(String groupName) {
		DAO<Group> dao = AbstractDAOFactory.getInstance().getGroupDAO();
		Couple where = new Couple("name", groupName);
		List<Couple> listWhere = new ArrayList<>();
		listWhere.add(where);
		List<Group> listGroup = dao.get(listWhere);
		return listGroup.get(0).getId();
	}
}
