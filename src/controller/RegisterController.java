package controller;

import facade.ShareShopFacade;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class RegisterController extends GridPane {

	private final ShareShopFacade facade;

	
	public RegisterController(ShareShopFacade facade) throws IOException {
		FXMLLoader leLoader = new FXMLLoader(getClass().getResource("/view/RegisterView.fxml"));
		leLoader.setController(this);
		leLoader.setRoot(this);
		leLoader.load();
		this.facade = facade;
	}

	public boolean registerForm(String username, String password, String firstname, String lastname, String birthdate,
			String email) {
		// facade = new ShareShopFacade(username, password, firstname, lastname,
		// birthdate, email);
		return facade.register();
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
