package model.domain.products;

import javafx.scene.image.Image;
import model.domain.Group;

public class CustomProduct extends SpecificProduct {
	
	private Group group;


	public CustomProduct(int idProduct, String name, Image image, String description, int idFather) {
		super(idProduct, name, image, description, idFather);
	}

	public CustomProduct(int idProduct, String name, Image image, String description, int idFather, Group group) {
		super(idProduct, name, image, description, idFather);
		setGroup(group);
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "CustomProduct [group=" + group + ", getGroup()=" + getGroup() + ", getIdProduct()=" + getIdProduct()
				+ ", getName()=" + getName() + ", getImage()=" + getImage() + ", getDescription()=" + getDescription()
				+ ", getIdFather()=" + getIdFather() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
