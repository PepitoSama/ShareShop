/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.manager;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.*;
import model.domain.GroupList;
import model.domain.products.GeneralProduct;
import model.domain.products.PricedProduct;
import model.domain.products.QuantifiedProduct;

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
	return dao.get(liste);
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
	return dao.get(liste).get(0);
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

    public boolean updateShopList(String name) {
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
	selected.setBoughtProducts(dao.get(liste));
    }

    public int getGroupListId() {
	return this.selected.getIdGroupList();
    }

    public boolean addProductsToShopList(List<GeneralProduct> selectedProducts) {
	DAO<QuantifiedProduct> dao = AbstractDAOFactory.getInstance().getQuantifiedProductDAO();
	boolean b = true;
	for (GeneralProduct selectedProduct : selectedProducts) {
	    if (!dao.save(new QuantifiedProduct(selected.getIdGroupList(), selectedProduct.getIdProduct(), 1))) {
		b = false;
	    }
	}
	return b;
    }

    public void getShopList(GroupList selectedGroupList) {
	DAO<QuantifiedProduct> dao = AbstractDAOFactory.getInstance().getQuantifiedProductDAO();
	List<Couple> liste = new ArrayList<Couple>();
	liste.add(new Couple("idGroupList", Integer.toString(selected.getIdGroupList())));
	selected.setShoppinglist(dao.get(liste));
    }

    public void buyProduct(QuantifiedProduct p, Double price) {
	DAO<QuantifiedProduct> dao = AbstractDAOFactory.getInstance().getQuantifiedProductDAO();
	dao.delete(p);
	DAO<PricedProduct> daoPP = AbstractDAOFactory.getInstance().getPricedProductDAO();
	List<Couple> where = new ArrayList<Couple>();
	where.add(new Couple("idGroupList", Integer.toString(p.getIdGroupList())));
	where.add(new Couple("idProduct", Integer.toString(p.getIdProduct())));
	List<PricedProduct> res = daoPP.get(where);
	if (!res.isEmpty()) {
	    PricedProduct product = res.get(0);
	    Double prix = (price * p.getQuantity() + product.getQuantity() * product.getPrice()) / (p.getQuantity()+product.getQuantity());
	    DecimalFormat df = new DecimalFormat("#.##");
	    String aff = (df.format(prix)).replace(",", ".");
	    prix = Double.parseDouble(aff);
	    product.setPrice(prix);
	    product.setQuantity(p.getQuantity()+product.getQuantity());
	    daoPP.update(product);
	} else {
	    daoPP.save(new PricedProduct(price, p.getIdGroupList(), p.getIdProduct(), p.getQuantity()));
	}

    }

}
