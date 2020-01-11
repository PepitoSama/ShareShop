package model.domain.products;

import javafx.scene.image.Image;

public class ExistingProduct extends SpecificProduct {
	
	private String barcode;
	
	private String marque;

	public ExistingProduct(int idProduct, String name, Image image, String description, int idFather) {
		super(idProduct, name, image, description, idFather);
		// TODO Auto-generated constructor stub
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}



}
