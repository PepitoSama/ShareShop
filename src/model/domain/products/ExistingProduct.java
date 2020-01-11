package model.domain.products;

import javafx.scene.image.Image;

public class ExistingProduct extends SpecificProduct {

	private String barcode;

	private double estimatedPrice;

	public ExistingProduct(int idProduct, String name, Image image, String description, int idFather) {
		super(idProduct, name, image, description, idFather);
	}

	public ExistingProduct(int idProduct, String name, Image image, String description, int idFather, String barcode,
			double estimatedPrice) {
		super(idProduct, name, image, description, idFather);
		setBarcode(barcode);
		setEstimatedPrice(estimatedPrice);
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public double getEstimatedPrice() {
		return estimatedPrice;
	}

	public void setEstimatedPrice(double estimatedPrice) {
		this.estimatedPrice = estimatedPrice;
	}

	@Override
	public String toString() {
		return "ExistingProduct [barcode=" + barcode + ", estimatedPrice=" + estimatedPrice + ", getBarcode()="
				+ getBarcode() + ", getEstimatedPrice()=" + getEstimatedPrice() + ", getIdProduct()=" + getIdProduct()
				+ ", getName()=" + getName() + ", getImage()=" + getImage() + ", getDescription()=" + getDescription()
				+ ", getIdFather()=" + getIdFather() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
