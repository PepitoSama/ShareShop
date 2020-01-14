/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import bl.facade.ShareShopFacade;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.domain.Group;
import model.domain.UserGroup;
import model.domain.products.GeneralProduct;

/**
 *
 * @author fsmag
 */
public class SearchProductsController extends GridPane {

	private final ObservableList<Button> buttons = FXCollections.observableArrayList();

	@FXML
	private VBox productList;

	@FXML
	private ScrollPane scrollpane;

	@FXML
	private TextField searchbar;

	private ShareShopFacade facade;

	private ArrayList<HBox> productsList;

	private List<GeneralProduct> selectedProducts;

	List<GeneralProduct> products;

	public SearchProductsController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("ui/view/SearchProductsView.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		loader.load();
		this.facade = ShareShopFacade.getInstance();
		productList = new VBox();
		scrollpane.setContent(productList);
		products = new ArrayList<>();
		selectedProducts = new ArrayList<GeneralProduct>();
		productList.setAlignment(Pos.CENTER);
		productList.setPrefWidth(scrollpane.getPrefWidth());
	}

	@FXML
	void back(ActionEvent event) {
		try {
			super.getChildren().clear();
			super.getChildren().add(new ModifyListController());
		} catch (IOException ex) {
			Logger.getLogger(ModifyListController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@FXML
	void search() {
		productList.getChildren().clear();
		String txt = searchbar.getText().toLowerCase().trim();
		products = facade.searchProducts(txt);
		printProducts();
	}

	@FXML
	void select(ActionEvent event) {
		facade.addProductsToShopList(selectedProducts);
		try {
			super.getChildren().clear();
			super.getChildren().add(new AfficherListController());

		} catch (IOException ex) {
			Logger.getLogger(SearchProductsController.class.getName()).log(Level.SEVERE, null, ex);

		}
	}

	private void printProducts() {
		for (GeneralProduct p : products) {
			GridPane h = new GridPane();

			ColumnConstraints column1 = new ColumnConstraints();
			column1.setPercentWidth(10);
			h.getColumnConstraints().add(column1);
			
			ColumnConstraints column1b = new ColumnConstraints();
			column1b.setPercentWidth(10);
			h.getColumnConstraints().add(column1b);

			ColumnConstraints column2 = new ColumnConstraints();
			column2.setPercentWidth(20);
			h.getColumnConstraints().add(column2);

			ColumnConstraints column3 = new ColumnConstraints();
			column3.setPercentWidth(50);
			h.getColumnConstraints().add(column3);

			h.setId(p.getIdProduct() + "");

			CheckBox c = new CheckBox();
			c.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					check(p, c);
				}
			});
			Label name = new Label(p.getName());

			Label description = new Label(p.getDescription());
			
			Button addFav = new Button("⭐");
			addFav.setOnAction( e-> {
				facade.addFavorite(p);
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Added to favorite");
				alert.setContentText("The product \"" + p + "\" has been added to your favorite list");
				
				alert.showAndWait();
			});

			h.add(c, 0, 0);
			h.add(addFav,1,0);
			h.add(name, 2, 0);
			h.add(description, 3, 0);
			h.setPrefWidth(productList.getPrefWidth());
			productList.getChildren().add(h);
		}
	}

	public void check(GeneralProduct p, CheckBox c) {
		if (c.isSelected()) {
			if (!selectedProducts.contains(p)) {
				selectedProducts.add(p);
			}
		} else {
			if (selectedProducts.contains(p)) {
				selectedProducts.remove(p);
			}
		}
	}
	
	@FXML
	void createProduct(ActionEvent event) {
		try {
			super.getChildren().clear();
			super.getChildren().add(new CreateProductController());
		} catch (IOException ex) {
			Logger.getLogger(ModifyListController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
