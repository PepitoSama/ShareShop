/*
 * To change this license header, choose License Headers in Project Properties.
 */
package ui.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import bl.facade.ShareShopFacade;
import java.util.ArrayList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.domain.GroupList;
import model.domain.User;
import model.domain.UserDebt;
import model.domain.products.GeneralProduct;
import model.domain.products.PricedProduct;
import model.domain.products.QuantifiedProduct;

/**
 *
 * @author emma_cbrt
 */
public class AfficherListController extends GridPane {

    private ShareShopFacade facade;

    @FXML
    private Label nameList;

    private final List<HBox> cellbp = new ArrayList();
    private final List<HBox> cellsl = new ArrayList();

    @FXML
    private VBox shopListe;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private VBox boughtProductListe;

    @FXML
    private ScrollPane scrollpane1;

    public AfficherListController() throws IOException {
	FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/ShopListView.fxml"));
	leLoader.setController(this);
	leLoader.setRoot(this);
	leLoader.load();
	this.facade = ShareShopFacade.getInstance();
	shopListe = new VBox();
	boughtProductListe = new VBox();
	nameList.setText(facade.getListName());
	initShopList();
	shopListe.getChildren().addAll(cellsl);
	shopListe.setAlignment(Pos.CENTER);
	scrollpane.setContent(shopListe);
	initBoughtProduct();
	boughtProductListe.getChildren().addAll(cellbp);
	boughtProductListe.setAlignment(Pos.CENTER);
	scrollpane1.setContent(boughtProductListe);
    }

    @FXML
    void back(ActionEvent event) {
	try {
	    super.getChildren().clear();
	    super.getChildren().add(new ShopListController());
	} catch (IOException ex) {
	    Logger.getLogger(ShopListController.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    @FXML
    void ok(ActionEvent event) {
	try {
	    super.getChildren().clear();
	    super.getChildren().add(new AfficherListController());
	} catch (IOException ex) {
	    Logger.getLogger(AfficherListController.class.getName()).log(Level.SEVERE, null, ex);

	}
    }

    /**
     * FXML function to add a shopping list to the view
     *
     * @param event
     */
    @FXML
    void modify(ActionEvent event) {
	try {
	    super.getChildren().clear();
	    super.getChildren().add(new ModifyListController());
	} catch (IOException ex) {
	    Logger.getLogger(ModifyListController.class.getName()).log(Level.SEVERE, null, ex);

	}
    }

    @FXML
    void validate(ActionEvent event) {
	try {
	    super.getChildren().clear();
	    super.getChildren().add(new AfficherListController());
	} catch (IOException ex) {
	    Logger.getLogger(AfficherListController.class.getName()).log(Level.SEVERE, null, ex);

	}
    }

    private void initBoughtProduct() {
	List<PricedProduct> boughtProducts = facade.getBoughtProducts();
	boughtProductListe.getChildren().clear();
	for (PricedProduct p : boughtProducts) {
	    HBox h = new HBox();
	    GeneralProduct prod = facade.getProductById(p.getIdProduct());
	    Label name = new Label(prod.getName());
	    name.setStyle("-fx-font-size: 24px; ");
	    name.setAlignment(Pos.CENTER);
	    Label quantity = new Label(Integer.toString(p.getQuantity()));
	    quantity.setStyle("-fx-font-size: 24px; ");
	    quantity.setAlignment(Pos.CENTER);
	    Label amount = new Label(Double.toString(p.getPrice()) + " €");
	    amount.setStyle("-fx-font-size: 24px; ");
	    amount.setAlignment(Pos.CENTER);
	    h.setSpacing(20);
	    h.getChildren().add(name);
	    h.getChildren().add(quantity);
	    h.getChildren().add(amount);
	    cellbp.add(h);
	}
	boughtProductListe.setAlignment(Pos.CENTER);
	boughtProductListe.setSpacing(10.0);
    }

    private void initShopList() {
	List<QuantifiedProduct> shoplist = facade.getShopList();
	shopListe.getChildren().clear();
	for (QuantifiedProduct p : shoplist) {
	    HBox h = new HBox();
	    GeneralProduct prod = facade.getProductById(p.getIdProduct());
	    Label name = new Label(prod.getName());
	    name.setStyle("-fx-font-size: 24px; ");
	    name.setAlignment(Pos.CENTER);
	    Label quantity = new Label(Integer.toString(p.getQuantity()));
	    quantity.setStyle("-fx-font-size: 24px; ");
	    quantity.setAlignment(Pos.CENTER);
	    h.setSpacing(20);
	    h.getChildren().add(name);
	    h.getChildren().add(quantity);
	    cellsl.add(h);
	}
	shopListe.setAlignment(Pos.CENTER);
	boughtProductListe.setSpacing(10.0);
    }

}
