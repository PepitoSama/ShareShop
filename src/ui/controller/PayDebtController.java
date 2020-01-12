/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import bl.facade.ShareShopFacade;
import java.util.Optional;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

	private Pattern p;

	private Double re;

	/**
	 * PayDebtController constructor Display view to pay a Debt in the Main View
	 *
	 * @throws IOException
	 */
	public PayDebtController() throws IOException {
		FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/PayDebtView.fxml"));
		leLoader.setController(this);
		leLoader.setRoot(this);
		leLoader.load();
		this.facade = ShareShopFacade.getInstance();
		select = facade.getSelectedDebt();
		User u = facade.getUserById(select.getIdTo());
		name.setText("Pay " + u.getFistname());
		rest.setText("Amount due: " + select.getAmount() + " €");
		p = Pattern.compile("([0-9]*)+\\.?([0-9]?[0-9]?)?");
	}

	/**
	 * FXML function back, return previous view
	 *
	 * @param event
	 */
	@FXML
	void back(ActionEvent event) {
		try {
			super.getChildren().clear();
			super.getChildren().add(new DebtController());
		} catch (IOException ex) {
			Logger.getLogger(DebtController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * FXML function pay that pay the Debt with the amount entered by user and turn
	 * back to Debt View
	 *
	 * @param event
	 */
	@FXML
	public void pay(ActionEvent event) {
		Double val = select.getAmount() - Double.parseDouble(amount.getText());
		facade.getSelectedDebt().setAmount(val);
		if (facade.updateDebt()) {
			try {
				super.getChildren().clear();
				super.getChildren().add(new DebtController());
			} catch (IOException ex) {
				Logger.getLogger(DebtController.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		rest.setText(rest.getText() + "\n" + "Fail to pay debt");
	}

	/**
	 * FXML function that checkinkg amount entered by the user
	 *
	 * @param event
	 */
	@FXML
	private void check(KeyEvent event) {
		String am = amount.getText();
		Matcher m = p.matcher(am);
		if (am == "" | am == null) {
			rest.setText("Amount due: " + select.getAmount() + " €");
		} else {
			if (m.matches()) {
				try {
					Double val = Double.parseDouble(am);
					if (val > select.getAmount()) {
						amount.setText(Double.toString(select.getAmount()));
						rest.setText("Amount due : 0€");
					} else {
						re = select.getAmount() - val;
						DecimalFormat df = new DecimalFormat("#.##");
						String aff = (df.format(re)).replace(",", ".");
						rest.setText("Amount due : " + aff + " €");
					}
				} catch (Exception e) {
					amount.setText("");
					rest.setText("Amount due : " + select.getAmount() + " €");
				}
			} else {
				DecimalFormat df = new DecimalFormat("#.##");
				String aff = (df.format(select.getAmount() - re)).replace(",", ".");
				amount.setText(aff);
			}
		}

	}

}
