/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author fsmag
 */
public class ProfilController extends GridPane {

	@FXML
	private PasswordField passwordC;

	@FXML
	private PasswordField password;

	@FXML
	private TextField nickname;

	@FXML
	private TextField name;

	@FXML
	private TextField mail;

	@FXML
	private TextField lastname;

	@FXML
	private DatePicker age;

	@FXML
	private Text res;

	private final ShareShopFacade facade;

	public ProfilController() throws IOException {
		FXMLLoader leLoader = new FXMLLoader(getClass().getClassLoader().getResource("ui/view/ProfilView.fxml"));
		leLoader.setController(this);
		leLoader.setRoot(this);
		leLoader.load();
		this.facade = ShareShopFacade.getInstance();
		nickname.setText(this.facade.getNickname());
		name.setText(this.facade.getName());
		lastname.setText(this.facade.getLastname());
		mail.setText(this.facade.getMail());
		age.setValue(this.facade.getLocalBirthdate());
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
	private void modify(ActionEvent event) {

		if ((password.getText().equals(passwordC.getText())) && (!password.getText().equals(""))) {
			facade.setName(name.getText());
			facade.setMail(mail.getText());
			facade.setLastname(lastname.getText());
			facade.setNickname(nickname.getText());
			facade.setPassword(password.getText());
			Date ageV = null;

			try {
				LocalDate localDate = age.getValue();
				Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
				facade.setBirthdate(Date.from(instant));
			} catch (Exception e) {
				res.setText("Missing age");
				res.setFill(Paint.valueOf("red"));
			}

			try {
				facade.updateUser();
				super.getChildren().clear();
				super.getChildren().add(new MyGroupsController());
								
			} catch (IOException e) {
				res.setText(e.getMessage());
				res.setFill(Paint.valueOf("red"));
			}

		} else {
			res.setText("Entrez un mot de passe valide");
			res.setFill(Paint.valueOf("red"));
		}
	}

	@FXML
	private void mystats(ActionEvent event) {
		try {
			super.getChildren().clear();
			super.getChildren().add(new StatsController());
		} catch (IOException ex) {
			Logger.getLogger(StatsController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@FXML
	private void debt(ActionEvent event) {
		try {
			super.getChildren().clear();
			super.getChildren().add(new DebtController());
		} catch (IOException ex) {
			Logger.getLogger(DebtController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
