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
public class Product extends GeneralProduct {

    public Product(int idProduct, String name, Image image, String description, int idFather) {
        super(idProduct, name, image, description, idFather);
    }

}
