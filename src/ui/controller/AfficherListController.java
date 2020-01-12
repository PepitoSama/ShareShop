/*
 * To change this license header, choose License Headers in Project Properties.
 */
package ui.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import bl.facade.ShareShopFacade;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyEvent;
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
	initBoughtProduct();
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
	cellbp.clear();
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
	if (boughtProducts.isEmpty()) {
	    Label mess = new Label("No product purchased");
	    mess.setStyle("-fx-font-size: 30px; ");
	    mess.setAlignment(Pos.CENTER);
	    HBox h = new HBox();
	    h.getChildren().add(mess);
	    cellbp.add(h);
	}
	boughtProductListe.setAlignment(Pos.CENTER);
	boughtProductListe.setSpacing(10.0);
	boughtProductListe.getChildren().addAll(cellbp);
	boughtProductListe.setAlignment(Pos.CENTER);
	scrollpane1.setContent(boughtProductListe);

    }

    private void initShopList() {
	List<QuantifiedProduct> shoplist = facade.getShopList();
	cellsl.clear();
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
	    Button purchase = new Button("Purchased");
	    purchase.setStyle("-fx-font-size: 24px; ");
	    purchase.setAlignment(Pos.CENTER);
	    purchase.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
		    purchase(p,prod);
		}
	    });
	    h.getChildren().add(name);
	    h.getChildren().add(quantity);
	    h.getChildren().add(purchase);
	    cellsl.add(h);
	}
	if (shoplist.isEmpty()) {
	    Label mess = new Label("No product to buy");
	    mess.setStyle("-fx-font-size: 30px; ");
	    mess.setAlignment(Pos.CENTER);
	    HBox h = new HBox();
	    h.getChildren().add(mess);
	    cellsl.add(h);

	}
	shopListe.setAlignment(Pos.CENTER);
	shopListe.setSpacing(10.0);
	shopListe.getChildren().addAll(cellsl);
	shopListe.setAlignment(Pos.CENTER);
	scrollpane.setContent(shopListe);
    }

    public void purchase(QuantifiedProduct p, GeneralProduct prod) {
	TextInputDialog dialog = new TextInputDialog("");
	dialog.setTitle("Purchase product");
	dialog.setHeaderText("Enter the product unit price" + prod.getName());
	dialog.setContentText("Please enter the unit amount:");

	Optional<String> result = dialog.showAndWait();
	if (result.isPresent()) {
	    String value = result.get();
	    Double price = check(value); 
	    if ( price != null) {
		facade.buyProduct(p,price);
	    }
	}

	initBoughtProduct();
	initShopList();
    }

    private Double check(String value) {
	Pattern p = Pattern.compile("([0-9]*)+\\.?([0-9]?[0-9]?)?");
	Matcher m = p.matcher(value);
	Double price = null;
	if (value != "" | value != null) {
	    if (m.matches()) {
		Double val = Double.parseDouble(value);
		DecimalFormat df = new DecimalFormat("#.##");
		price = Double.parseDouble(df.format(val).replace(",", "."));
	    }
	}
	return price;
    }

}
