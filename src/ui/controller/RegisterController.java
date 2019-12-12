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
import javafx.scene.layout.GridPane;

public class RegisterController extends GridPane {

	private final ShareShopFacade facade;

	public RegisterController(ShareShopFacade facade) throws IOException {
		FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/RegisterView.fxml"));
		leLoader.setController(this);
		leLoader.setRoot(this);
		leLoader.load();
		this.facade = facade;
	}

	public void registerForm(String username, String password, String firstname, String lastname, String birthdate,
			String email) {
		// facade = new ShareShopFacade(username, password, firstname, lastname,
		// birthdate, email);
		facade.register(username, password, firstname, lastname, birthdate, email);
	}

	@FXML
	void back(ActionEvent event) {
		try {
			super.getChildren().clear();
			super.getChildren().add(new UserController(facade));
		} catch (IOException ex) {
			Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);

		}
	}
}
