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
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
public class CreateProductController extends GridPane {

	@FXML
	private TextField productName;
	
	@FXML
	private TextField description;
	
	@FXML
	private GridPane parentProductGP;
	
	private ShareShopFacade facade;
	
	private ChoiceBox<GeneralProduct> parentChoiceBox;


	public CreateProductController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/CreateProductView.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		loader.load();
		this.facade = ShareShopFacade.getInstance();
		
		
		List<GeneralProduct> subGenProd = facade.getAllSubGeneralProducts();
		
		parentChoiceBox = new ChoiceBox<>();
		parentChoiceBox.getItems().add(null);
		parentChoiceBox.getItems().addAll(subGenProd);
				
		parentProductGP.add(parentChoiceBox, 0, 1);
	}
	
	@FXML
	void back(ActionEvent event) {
		try {
			super.getChildren().clear();
			super.getChildren().add(new SearchProductsController());
		} catch (IOException ex) {
			Logger.getLogger(ModifyListController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	@FXML
	void create(ActionEvent event) {
		
		
		GeneralProduct parent = parentChoiceBox.getSelectionModel().selectedItemProperty().getValue();
		int idparent = 0;
		if (parent != null) {
			idparent = parent.getIdProduct();
		}
		boolean created = facade.addProduct(productName.getText().trim(), null, description.getText().trim(), idparent);
		
		if (created) {
			try {
				super.getChildren().clear();
				super.getChildren().add(new SearchProductsController());
			} catch (IOException ex) {
				Logger.getLogger(ModifyListController.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		
	}



}
