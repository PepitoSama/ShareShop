/*
 * To change this license header, choose License Headers in Project Properties.
 */
package ui.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import bl.facade.ShareShopFacade;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.domain.GroupList;

/**
 *
 * @author emma_cbrt
 */
public class AfficherListController extends GridPane {

    private ShareShopFacade facade;
    
    @FXML
    private Text nameList;
    
    @FXML
    private VBox shopListe;
    
    @FXML
    private ScrollPane scrollpaneShopList;
    
    @FXML
    private VBox BoughtProductListe;
    
    @FXML
    private ScrollPane scrollpaneBoughtProductList;



    public AfficherListController() throws IOException {
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/ShopListView.fxml"));
        leLoader.setController(this);
        leLoader.setRoot(this);
        leLoader.load();
        this.facade = ShareShopFacade.getInstance();
        shopListe = new VBox();
        BoughtProductListe = new VBox();
//        shopListe.getChildren().addAll(quantified product list);
//        shopListe.setAlignment(Pos.CENTER);
//        scrollpaneShopList.setContent(shopListe);
//        BoughtProductList.getChildren().addAll(priced product list);
//        BoughtProductList.setAlignment(Pos.CENTER);
//        scrollpaneBoughtProductList.setContent(BoughtProductListe);
    }

    
    @FXML
    void back(ActionEvent event) {
        try {
            super.getChildren().clear();
            super.getChildren().add(new ShopListController());
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    @FXML
    void ok(ActionEvent event) {
        try {
            super.getChildren().clear();
            super.getChildren().add(new AfficherListController());
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    @FXML
    void modify(ActionEvent event) {
        try {
            super.getChildren().clear();
            super.getChildren().add(new UpdateShopListController());
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    @FXML
    void validate(ActionEvent event) {
        try {
            super.getChildren().clear();
            super.getChildren().add(new AfficherListController());
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
