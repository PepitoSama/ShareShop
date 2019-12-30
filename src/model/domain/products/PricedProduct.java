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
    private int quantity;
    private GeneralProduct product;

    public PricedProduct(Double price, GeneralProduct product, int quantity) {
        this.price = price;
        this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public GeneralProduct getProduct() {
        return product;
    }

    public void setProduct(GeneralProduct product) {
        this.product = product;
    }

}
