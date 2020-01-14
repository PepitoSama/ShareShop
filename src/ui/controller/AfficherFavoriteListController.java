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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
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
public class AfficherFavoriteListController extends GridPane {

	private ShareShopFacade facade;

	@FXML
	private ScrollPane scrollpane;
	
	@FXML
	private VBox productList;

	
	private List<GeneralProduct> products;

	public AfficherFavoriteListController() throws IOException {
		FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/FavoriteListView.fxml"));
		leLoader.setController(this);
		leLoader.setRoot(this);
		leLoader.load();
		this.facade = ShareShopFacade.getInstance();
		initList();
	}

	@FXML
	void back(ActionEvent event) {
		try {
			super.getChildren().clear();
			super.getChildren().add(new MyGroupsController());
		} catch (IOException ex) {
			Logger.getLogger(ShopListController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	private void initList() {
		products = facade.getFavorites();
		
		for (GeneralProduct p : products) {
			GridPane h = new GridPane();


			ColumnConstraints column1 = new ColumnConstraints();
			column1.setPercentWidth(30);
			h.getColumnConstraints().add(column1);

			ColumnConstraints column2 = new ColumnConstraints();
			column2.setPercentWidth(70);
			h.getColumnConstraints().add(column2);

			h.setId(p.getIdProduct() + "");

			Label name = new Label(p.getName());

			Label description = new Label(p.getDescription());
			
	
			h.add(name, 0, 0);
			h.add(description, 1, 0);
			h.setPrefWidth(productList.getPrefWidth());
			productList.getChildren().add(h);
			
		}
	}



}
