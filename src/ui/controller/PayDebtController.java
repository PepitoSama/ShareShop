/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import bl.facade.ShareShopFacade;
import java.util.Optional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.domain.GroupList;
import model.domain.User;
import model.domain.UserDebt;

/**
 *
 * @author fsmag
 */
public class PayDebtController extends GridPane {

    private ShareShopFacade facade;

    @FXML
    private TextField amount;

    @FXML
    private Label name;

    @FXML
    private Label rest;
    
    private UserDebt select;

    public PayDebtController() throws IOException {
	FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/PayDebtView.fxml"));
	leLoader.setController(this);
	leLoader.setRoot(this);
	leLoader.load();
	this.facade = ShareShopFacade.getInstance();
	select = facade.getSelectedDebt();
	User u = facade.getUserById(select.getIdTo());
	name.setText("Pay " + u.getFistname());
    }

    @FXML
    void back(ActionEvent event) {
	try {
	    super.getChildren().clear();
	    super.getChildren().add(new DebtController());
	} catch (IOException ex) {
	    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

	}
    }

    public void pay(UserDebt debt) {
	facade.setSelectedDebt(debt);
	try {
	    super.getChildren().clear();
	    super.getChildren().add(new AfficherListController());
	} catch (IOException ex) {
	    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

	}
    }

    @FXML
    private void check(KeyEvent event) {
	if (!"-0123456789".contains(event.getCharacter())) {
	    event.consume();
	    Double val = Double.parseDouble(amount.getText());
	    if(val > select.getAmount()){
		amount.setText(Double.toString(select.getAmount()));
	    }
	}
    }

}
