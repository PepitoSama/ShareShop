/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain.products;

/**
 *
 * @author fsmag
 */
public class PricedProduct {

    private Double price;
    private int idGroupList;
    private int	idProduct;
    private int quantity;

    public PricedProduct(Double price, int idGroupList, int idProduct, int quantity) {
	this.price = price;
	this.idGroupList = idGroupList;
	this.idProduct = idProduct;
	this.quantity = quantity;
    }

    public Double getPrice() {
	return price;
    }

    public void setPrice(Double price) {
	this.price = price;
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
