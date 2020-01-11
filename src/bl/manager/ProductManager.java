/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.image.Image;
import model.dao.*;
import model.domain.Group;
import model.domain.GroupList;
import model.domain.products.PricedProduct;

/**
 *
 * @author fsmag
 */
public class ProductManager {

    private static ProductManager instance = null;

    public static ProductManager getInstance() {
        if (instance == null) {
            instance = new ProductManager();
        }
        return instance;
    }

    public boolean addCustomProduct(String name, Image image, String description, int idFather, Group group) {
        return false;
    }

   
    
}
