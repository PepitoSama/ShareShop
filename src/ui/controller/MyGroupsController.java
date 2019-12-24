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
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author fsmag
 */
public class MyGroupsController extends GridPane {

    private final ShareShopFacade facade;

    public MyGroupsController() throws IOException {
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/MyGroupsView.fxml"));
        leLoader.setController(this);
        leLoader.setRoot(this);
        leLoader.load();    
        this.facade = ShareShopFacade.getInstance();
    }

    /*
     * TODO
     * Il faut rajouter une fonction pour clear la face des infos du user + de la connection JDBC
     */
    @FXML
    private void disconnect(ActionEvent event) {

        try {
            super.getChildren().clear();
            super.getChildren().add(new LoginController());
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void profil(ActionEvent event) {
        try {
            super.getChildren().clear();
            super.getChildren().add(new ProfilController());
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
