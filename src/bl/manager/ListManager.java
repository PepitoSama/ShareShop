/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.dao.*;
import model.domain.GroupList;
import model.domain.products.PricedProduct;

/**
 *
 * @author fsmag
 */
public class ListManager {

    public List<GroupList> getShoppingList(int id) {
        DAO<GroupList> dao = AbstractDAOFactory.getInstance().getGroupListDAO();
        List<Couple> liste = new ArrayList<Couple>();
        liste.add(new Couple("idGroup", Integer.toString(id)));
        liste.add(new Couple("type", "S"));
        return dao.getWhere(liste);
    }

    private GroupList selected;

    public GroupList getSelected() {
        return selected;
    }

    public void setSelected(GroupList selected) {
        this.selected = selected;
    }

    public GroupList getFavoriteList(int id) {
        DAO<GroupList> dao = AbstractDAOFactory.getInstance().getGroupListDAO();
        List<Couple> liste = new ArrayList<Couple>();
        liste.add(new Couple("idGroup", Integer.toString(id)));
        liste.add(new Couple("type", "F"));
        return dao.getWhere(liste).get(0);
    }

    private static ListManager instance = null;

    public static ListManager getInstance() {
        if (instance == null) {
            instance = new ListManager();
        }
        return instance;
    }

    public boolean addShopList(String name, int id) {
        DAO<GroupList> dao = AbstractDAOFactory.getInstance().getGroupListDAO();
        return dao.save(new GroupList(0, id, name, new Date(), 'S'));
    }

    public boolean addFavorisList(int id) {
        DAO<GroupList> dao = AbstractDAOFactory.getInstance().getGroupListDAO();
        return dao.save(new GroupList(0, id, "Favoris", new Date(), 'F'));
    }

    public boolean addSuggestList(int id) {
        DAO<GroupList> dao = AbstractDAOFactory.getInstance().getGroupListDAO();
        return dao.save(new GroupList(0, id, "Suggest", new Date(), 'P'));
    }

    public boolean updateShopList(String name) throws SQLException {
        DAO<GroupList> dao = AbstractDAOFactory.getInstance().getGroupListDAO();
        selected.setName(name);
        return dao.update(selected);
    }

    public boolean removeList() {
        DAO<GroupList> dao = AbstractDAOFactory.getInstance().getGroupListDAO();
        return dao.delete(selected);
    }

    public String getNameSelected() {
        return selected.getName();
    }

    public void getBoughtProducts(GroupList selected) {
        DAO<PricedProduct> dao = AbstractDAOFactory.getInstance().getPricedProductDAO();
        List<Couple> liste = new ArrayList<Couple>();
        liste.add(new Couple("idGroupList", Integer.toString(selected.getIdGroupList())));
        liste.add(new Couple("p.idProduct", "t.idProduct"));
        selected.setBoughtProducts(dao.getWhere(liste));
    }

    public int getGroupListId(){
        return this.selected.getIdGroupList();
    }
    
}
