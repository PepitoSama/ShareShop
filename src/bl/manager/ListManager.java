/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.manager;

import java.util.List;
import model.dao.AbstractDAOFactory;
import model.dao.DAOGroupListInterface;
import model.domain.GroupList;

/**
 *
 * @author fsmag
 */
public class ListManager {

    public List<GroupList> getShoppingList(int id) {
        DAOGroupListInterface<GroupList> dao = AbstractDAOFactory.getInstance().getGroupListDAO();
        return dao.getShoppingList(id);
    }
    
    private GroupList selected;

    public GroupList getSelected() {
        return selected;
    }

    public void setSelected(GroupList selected) {
        this.selected = selected;
    }


    public GroupList getFavoriteList() {
        return null;
    }

    public List<GroupList> getBoughtProductList() {
        return null;
    }

    
    private static ListManager instance = null;
    
    
    public static ListManager getInstance(){
        if (instance == null) {
            instance = new ListManager();
        }
        return instance;
    }

    public boolean addShopList(GroupList groupList) {
        DAOGroupListInterface<GroupList> dao = AbstractDAOFactory.getInstance().getGroupListDAO();
        return dao.save(groupList);
    }
}
