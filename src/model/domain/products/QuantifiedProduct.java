/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain.products;

import javafx.scene.image.Image;

/**
 *
 * @author
 */
public class QuantifiedProduct {
    private int idGroupList;
    private int	idProduct;
    private int quantity;

    public QuantifiedProduct(int idGroupList, int idProduct, int quantity) {
	this.idGroupList = idGroupList;
	this.idProduct = idProduct;
	this.quantity = quantity;
    }

    public int getIdGroupList() {
	return idGroupList;
    }

    public void setIdGroupList(int idGroupList) {
	this.idGroupList = idGroupList;
    }

    public int getIdProduct() {
	return idProduct;
    }

    public void setIdProduct(int idProduct) {
	this.idProduct = idProduct;
    }

    public int getQuantity() {
	return quantity;
    }

    public void setQuantity(int quantity) {
	this.quantity = quantity;
    }
    
}
