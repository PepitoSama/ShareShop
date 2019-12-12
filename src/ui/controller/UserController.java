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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author fsmag
 */
public class UserController extends GridPane {

	@FXML
	private TextField login;

	@FXML
	private TextField pwd;
	
	@FXML 
	private Text txt;

	private final ShareShopFacade facade;



	public UserController(ShareShopFacade facade) throws IOException {
		FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/LoginView.fxml"));
		leLoader.setController(this);
		leLoader.setRoot(this);
		leLoader.load();	
		
		this.facade = facade;
	}

	@FXML
	private void login(ActionEvent event) {
		String id = login.getText();
		String pass = pwd.getText();
		// On récupère les contenus des champs texte de la vue et on va regarder s'ils
		// sont pas nul avant d'envoyer au controleur
		
		if(facade.login(id, pass)) {
			txt.setText("You are connected !");
		} else {
			txt.setText("Bad Login or Password !");

		}
	}

	@FXML
	private void register(ActionEvent event) {
		try {
			super.getChildren().clear();
			super.getChildren().add(new RegisterController(facade));
		} catch (IOException ex) {
			Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);

		}
	}

}
