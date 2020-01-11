package model.domain.products;

import javafx.scene.image.Image;

public class CustomProduct extends SpecificProduct {

	public CustomProduct(int idProduct, String name, Image image, String description, int idFather) {
		super(idProduct, name, image, description, idFather);
	}

}
