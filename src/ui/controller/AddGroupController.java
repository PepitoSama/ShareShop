/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import bl.facade.ShareShopFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author pepito
 */
public class AddGroupController extends GridPane {
	
    @FXML
    private TextField groupName;

    private final ShareShopFacade facade;

    public AddGroupController() throws IOException {
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/AddGroupView.fxml"));
        leLoader.setController(this);
        leLoader.setRoot(this);
        leLoader.load();    
        this.facade = ShareShopFacade.getInstance();
    }
    
    @FXML
    private void back(ActionEvent event) {
        try {
            super.getChildren().clear();
            super.getChildren().add(new MyGroupsController());
        } catch (IOException ex) {
            Logger.getLogger(MyGroupsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void createGroup(ActionEvent event) {
    	if (facade.createGroup(groupName.getText())) {
    		try {
                super.getChildren().clear();
                super.getChildren().add(new MyGroupsController());
            } catch (IOException ex) {
                Logger.getLogger(MyGroupsController.class.getName()).log(Level.SEVERE, null, ex);
            }
    	} else {
    		// Afficher message erreur
    	}
    }
    
    
    
}
