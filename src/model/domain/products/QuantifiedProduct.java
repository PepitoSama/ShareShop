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
public class QuantifiedProduct extends GeneralProduct {

    private int quantite;

    public int getQuantite() {
        return this.quantite;
    }
    
    public void setQuantite(int quantite) {
    	this.quantite = quantite;
    }

	public QuantifiedProduct(int idProduct, String name, Image image, String description, GeneralProduct idFather, int quantite) {
		super(idProduct, name, image, description, idFather);
		this.quantite = quantite;
	}
}
