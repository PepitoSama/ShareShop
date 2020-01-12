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
public class DebtController extends GridPane {

    private ShareShopFacade facade;
    private final List<HBox> cellsMB = new ArrayList();
    private final List<HBox> cellsAD = new ArrayList();

    @FXML
    private VBox myDebt;

    @FXML
    private VBox amountDue;

    @FXML
    private ScrollPane scrollpaneMD;

    @FXML
    private ScrollPane scrollpaneAD;

    /**
     * DebtController constructor Display view Debt in the Main View
     *
     * @throws IOException
     */
    public DebtController() throws IOException {
	FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/DebtView.fxml"));
	leLoader.setController(this);
	leLoader.setRoot(this);
	leLoader.load();
	this.facade = ShareShopFacade.getInstance();
	myDebt = new VBox();
	amountDue = new VBox();
	initDebt();
	initDue();
	myDebt.getChildren().addAll(cellsMB);
	myDebt.setAlignment(Pos.CENTER);
	scrollpaneMD.setContent(myDebt);
	amountDue.getChildren().addAll(cellsAD);
	amountDue.setAlignment(Pos.CENTER);
	scrollpaneAD.setContent(amountDue);
    }

    /**
     * private function to init My Debt
     */
    private void initDebt() {
	List<UserDebt> debt = facade.getMyDebt();
	myDebt.getChildren().clear();
	for (UserDebt ud : debt) {
	    if (ud.getAmount() > 0) {
		HBox h = new HBox();
		h.setId(Integer.toString(ud.getIdDebt()) + "b");
		Label i = new Label("👤");
		User u = facade.getUserById(ud.getIdFrom());
		Label l = new Label(u.getFistname());
		l.setStyle("-fx-font-size: 24px; ");
		l.setAlignment(Pos.CENTER);
		Label amount = new Label(Double.toString(ud.getAmount()) + " €");
		amount.setStyle("-fx-font-size: 24px; ");
		amount.setAlignment(Pos.CENTER);
		h.setSpacing(20);
		h.getChildren().add(i);
		h.getChildren().add(l);
		h.getChildren().add(amount);
		cellsMB.add(h);
	    }
	}
	myDebt.setAlignment(Pos.CENTER);
	myDebt.setSpacing(10.0);
    }

    /**
     * private function to init Amount Due
     */
    private void initDue() {
	List<UserDebt> debt = facade.getMyDue();
	amountDue.getChildren().clear();
	for (UserDebt ud : debt) {
	    if (ud.getAmount() > 0) {
		HBox h = new HBox();
		h.setId(Integer.toString(ud.getIdDebt()) + "b");
		Label i = new Label("👤");
		User u = facade.getUserById(ud.getIdTo());
		Label l = new Label(u.getFistname());
		l.setStyle("-fx-font-size: 24px; ");
		l.setAlignment(Pos.CENTER);
		Label amount = new Label(Double.toString(ud.getAmount()) + " €");
		amount.setStyle("-fx-font-size: 24px; ");
		amount.setAlignment(Pos.CENTER);
		Button pay = new Button("Pay");
		pay.setId(Integer.toString(ud.getIdDebt()));
		pay.setStyle("-fx-font-size: 24px; ");
		pay.setAlignment(Pos.CENTER);
		pay.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
			pay(ud);
		    }
		});
		h.setSpacing(20);
		h.getChildren().add(i);
		h.getChildren().add(l);
		h.getChildren().add(amount);
		h.getChildren().add(pay);
		cellsAD.add(h);
	    }
	}
	amountDue.setAlignment(Pos.CENTER);
	amountDue.setSpacing(10.0);
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
	    super.getChildren().add(new MyGroupsController());

	} catch (IOException ex) {
	    Logger.getLogger(DebtController.class
		    .getName()).log(Level.SEVERE, null, ex);
	}
    }

    /**
     * public function to pay a Debt
     *
     * @param debt
     */
    public void pay(UserDebt debt) {
	facade.setSelectedDebt(debt);
	try {
	    super.getChildren().clear();
	    super.getChildren().add(new PayDebtController());

	} catch (IOException ex) {
	    Logger.getLogger(DebtController.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

}
