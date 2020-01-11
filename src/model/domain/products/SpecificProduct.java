package model.domain.products;

import javafx.scene.image.Image;
import model.domain.Group;

public class SpecificProduct extends GeneralProduct {
	

	public SpecificProduct(int idProduct, String name, Image image, String description, int idFather) {
		super(idProduct, name, image, description, idFather);
	}



}
