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
import model.domain.User;
import model.domain.UserGroup;

/**
 *
 * @author pepito
 */
public class GroupManager {

    private static GroupManager instance = null;
    private Group selected;

    public Group getSelected() {
        return selected;
    }

    public static GroupManager getInstance() {
        if (instance == null) {
            instance = new GroupManager();
        }
        return instance;
    }

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

    public void checkExisting(String groupName) throws Exception {
        DAO<Group> dao = AbstractDAOFactory.getInstance().getGroupDAO();
        List<Group> groups = dao.getAll();
        for (Group g : groups) {
            if (g.getGroupName().equals(groupName)) {
                throw new Exception("Group Name already use");
            }
        }
    }

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
    
    public List<User> getMembers(Group group){
    	DAO<UserGroup> dao = AbstractDAOFactory.getInstance().getUserGroupDAO();
    	DAO<User> daoU = AbstractDAOFactory.getInstance().getUserDAO();
        List<User> membersList = new ArrayList<>();
        for (User user : daoU.getAll()) {
        	for (UserGroup userGroup : dao.getAll()) {
                if (userGroup.getIdGroup() == group.getId() && userGroup.getIdUser() == user.getId()) {
                    membersList.add(user);
                }
            }
        }
        return membersList;
    }

    public void setSelected(Group group) {
        this.selected = group;
    }

    public int getGroupId(String groupName) {
        DAO<Group> dao = AbstractDAOFactory.getInstance().getGroupDAO();
        Couple where = new Couple("name", groupName);
        List<Couple> listWhere = new ArrayList<>();
        listWhere.add(where);
        List<Group> listGroup = dao.get(listWhere);
        return listGroup.get(0).getId();
    }

    public int getSelectedGroupId() {
        return getSelected().getId();
    }

}
