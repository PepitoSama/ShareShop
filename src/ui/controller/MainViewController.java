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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author fsmag
 */
public class MainViewController {

    @FXML
    private GridPane elements;

    @FXML
    private TextField pwd;

    private final ShareShopFacade manager = ShareShopFacade.getInstance();

    public void initialize() throws IOException {
        try {
            elements.getChildren().add(new LoginController());
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
