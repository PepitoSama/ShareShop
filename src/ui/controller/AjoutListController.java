/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import bl.facade.ShareShopFacade;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import model.domain.GroupList;

/**
 *
 * @author fsmag
 */
public class AjoutListController extends GridPane {

    private ShareShopFacade facade;

    @FXML
    private TextField name;

    @FXML
    private Text res;

    public AjoutListController() throws IOException {
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/AjoutShopList.fxml"));
        leLoader.setController(this);
        leLoader.setRoot(this);
        leLoader.load();
        this.facade = ShareShopFacade.getInstance();
    }

    @FXML
    void add(ActionEvent event) {
        if (facade.addShopList(new GroupList(0, 1, name.getText(), new Date(), 'S'))) {
            try {
                super.getChildren().clear();
                super.getChildren().add(new ShopListController());
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

            }
        } else {
            res.setText("Echec lors de l'ajout");
            res.setFill(Paint.valueOf("red"));
        }
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

}