/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain.products;

import javafx.scene.image.Image;

/**
 *
 * @author fsmag
 */
public abstract class GeneralProduct {

	private int idProduct;
	private String name;
	private Image image;
	private String description;
	private int idFather;

	public GeneralProduct(int idProduct, String name, Image image, String description, int idFather) {
		this.idProduct = idProduct;
		this.name = name;
		this.image = image;
		this.description = description;
		this.idFather = idFather;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdFather() {
		return idFather;
	}

	public void setIdFather(int idFather) {
		this.idFather = idFather;
	}

	@Override
	public boolean equals(Object arg0) {
		if (arg0 != null) {
			return this.getIdProduct() == ((GeneralProduct) arg0).getIdProduct();
		}
		return false;
	}

}
