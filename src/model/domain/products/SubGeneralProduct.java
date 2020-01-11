package model.domain.products;

import java.util.List;

import javafx.scene.image.Image;

public class SubGeneralProduct extends GeneralProduct {
	
	private List<GeneralProduct> children;

	public SubGeneralProduct(int idProduct, String name, Image image, String description, int idFather) {
		super(idProduct, name, image, description, idFather);
	}

	public List<GeneralProduct> getChildren() {
		return children;
	}

	public void setChildren(List<GeneralProduct> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "SubGeneralProduct [children=" + children + ", getChildren()=" + getChildren() + ", getIdProduct()="
				+ getIdProduct() + ", getName()=" + getName() + ", getImage()=" + getImage() + ", getDescription()="
				+ getDescription() + ", getIdFather()=" + getIdFather() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
