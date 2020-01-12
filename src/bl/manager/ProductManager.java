/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import bl.facade.ShareShopFacade;
import javafx.scene.image.Image;
import model.dao.*;
import model.domain.Group;
import model.domain.GroupList;
import model.domain.products.CustomProduct;
import model.domain.products.GeneralProduct;
import model.domain.products.PricedProduct;
import model.domain.products.SubGeneralProduct;

/**
 *
 * @author fsmag
 */
public class ProductManager {

	private static ProductManager instance = null;

	public static ProductManager getInstance() {
		if (instance == null) {
			instance = new ProductManager();
		}
		return instance;
	}

	/**
	 * Add a Custom product. This product will be linked to the currently selected
	 * group in the groupManager
	 *
	 * @param name
	 *            The name of the product
	 * @param image
	 *            The image of the product
	 * @param description
	 *            The description of the product
	 * @param idFather
	 *            The id of the Parent Product. Give a negative number or 0 if this
	 *            product doen't have a parent Product
	 * @return true if the product has been created
	 */
	public boolean addCustomProduct(String name, Image image, String description, int idFather, Group group) {
		DAO<GeneralProduct> dao = AbstractDAOFactory.getInstance().getProductDAO();
		GeneralProduct p = new CustomProduct(-1, name, image, description, idFather, group);
		return dao.save(p);
	}

	/**
	 * Search products whose name is like the string given in parameter or is a
	 * child product of the former.
	 *
	 * @param name
	 *            The name or part of the name of the product or parent product
	 * @return the List of products found
	 */
	public List<GeneralProduct> searchProducts(String name) {
		DAO<GeneralProduct> dao = AbstractDAOFactory.getInstance().getProductDAO();

		Couple where = new Couple("name", "%" + name + "%");
		List<Couple> listWhere = new ArrayList<>();
		listWhere.add(where);
		List<GeneralProduct> products = dao.get(listWhere);

		Iterator itr = products.iterator();

		while (itr.hasNext()) {
			GeneralProduct p = (GeneralProduct) itr.next();
			if (p instanceof CustomProduct) {
				if (((CustomProduct) p).getGroup().getId() != ShareShopFacade.getInstance().getSelectedGroupID()) {
					itr.remove();
				}
			}
		}

		for (int i = 0; i < products.size(); i++) {
			GeneralProduct p = products.get(i);
			if (p instanceof SubGeneralProduct) {
				Couple w = new Couple("idFather", p.getIdProduct() + "");
				List<Couple> listCouple = new ArrayList<>();
				listCouple.add(w);
				List<GeneralProduct> children = dao.get(listCouple);

				for (GeneralProduct p2 : children) {

					if (!products.contains(p2)) {
						if (!(p2 instanceof CustomProduct) || (p2 instanceof CustomProduct && ((CustomProduct) p2)
								.getGroup().getId() == ShareShopFacade.getInstance().getSelectedGroupID())) {
							products.add(p2);
						}

					}
				}
			}
		}

		return products;
	}

	public GeneralProduct getProductById(int idProduct) {
		DAO<GeneralProduct> dao = AbstractDAOFactory.getInstance().getProductDAO();
		List<Couple> couple = new ArrayList<>();
		couple.add(new Couple("idProduct", Integer.toString(idProduct)));
		return dao.get(couple).get(0);
	}
	
	/**
	 * @return all the subgeneralProducts
	 */
	public List<GeneralProduct> getAllSubGeneralProducts() {
		DAO<GeneralProduct> dao = AbstractDAOFactory.getInstance().getProductDAO();
		List<GeneralProduct> l = dao.getAll();
		
		List<GeneralProduct> res = new ArrayList<>();
		
		for (GeneralProduct p : l) {
			if (p instanceof SubGeneralProduct) {
				res.add(p);
			}
		}
 
		return res;
	}

}
