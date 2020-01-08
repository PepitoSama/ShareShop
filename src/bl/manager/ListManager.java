/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.manager;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import model.dao.AbstractDAOFactory;
import model.dao.DAOGroupListInterface;
import model.dao.DAOProductsInterface;
import model.domain.GroupList;
import model.domain.products.PricedProduct;

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

    public GroupList getFavoriteList(int id) {
        DAOGroupListInterface<GroupList> dao = AbstractDAOFactory.getInstance().getGroupListDAO();
        return dao.getFavoriteList(id);
    }

    private static ListManager instance = null;

    public static ListManager getInstance() {
        if (instance == null) {
            instance = new ListManager();
        }
        return instance;
    }

    public boolean addShopList(String name, int id) {
        DAOGroupListInterface<GroupList> dao = AbstractDAOFactory.getInstance().getGroupListDAO();
        return dao.save(new GroupList(0, id, name, new Date(), 'S'));
    }

    public boolean addFavorisList(int id) {
        DAOGroupListInterface<GroupList> dao = AbstractDAOFactory.getInstance().getGroupListDAO();
        return dao.save(new GroupList(0, id, "Favoris", new Date(), 'F'));
    }

    public boolean addSuggestList(int id) {
        DAOGroupListInterface<GroupList> dao = AbstractDAOFactory.getInstance().getGroupListDAO();
        return dao.save(new GroupList(0, id, "Suggest", new Date(), 'P'));
    }

    public boolean updateShopList(String name) throws SQLException {
        DAOGroupListInterface<GroupList> dao = AbstractDAOFactory.getInstance().getGroupListDAO();
        selected.setName(name);
        return dao.update(selected);
    }

    public boolean removeList() {
        DAOGroupListInterface<GroupList> dao = AbstractDAOFactory.getInstance().getGroupListDAO();
        return dao.delete(selected);
    }

    public String getNameSelected() {
        return selected.getName();
    }

    public void getBoughtProducts(GroupList selected) {
        DAOProductsInterface<PricedProduct> dao = AbstractDAOFactory.getInstance().getPricedProductDAO();
        selected.setBoughtProducts(dao.getProducts(selected.getIdGroupList()));
    }

}
