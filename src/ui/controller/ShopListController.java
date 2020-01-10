/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import bl.facade.ShareShopFacade;

import java.io.IOException;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.domain.GroupList;

/**
 *
 * @author fsmag
 */
public class ShopListController extends GridPane {

	private ShareShopFacade facade;
	private final ObservableList<HBox> buttons = FXCollections.observableArrayList();
	@FXML
	private VBox shopListe;

	@FXML
	private ScrollPane scrollpane;

	@FXML
	private TextField search;

	private FilteredList<HBox> flButton;

	public ShopListController() throws IOException {
		FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/GroupListsView.fxml"));
		leLoader.setController(this);
		leLoader.setRoot(this);
		leLoader.load();
		this.facade = ShareShopFacade.getInstance();
		shopListe = new VBox();
		initList();
		search();
		flButton = new FilteredList(buttons, p -> true);
		shopListe.getChildren().addAll(flButton);
		shopListe.setAlignment(Pos.CENTER);
		scrollpane.setContent(shopListe);
	}

	private void initList() {
		List<GroupList> shoopingList = facade.getShoppingList();
		shopListe.getChildren().clear();
		for (GroupList liste : shoopingList) {
			HBox h = new HBox();
			h.setId(liste.getName());
			Button b = new Button(liste.getName());
			b.setId("b" + Integer.toString(liste.getIdGroupList()));
			b.setStyle("-fx-font-size: 24px; ");
			b.setAlignment(Pos.CENTER);
			b.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					toList(liste);
				}
			});
			Button u = new Button("✏");
			u.setId("u" + Integer.toString(liste.getIdGroupList()));
			u.setStyle("-fx-font-size: 24px; ");
			u.setAlignment(Pos.CENTER);
			u.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					update(liste);
				}
			});
			Button r = new Button("❌");
			r.setId("r" + Integer.toString(liste.getIdGroupList()));
			r.setStyle("-fx-font-size: 24px; ");
			r.setAlignment(Pos.CENTER);
			r.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					remove(liste);
				}
			});
			h.setSpacing(20);
			h.getChildren().add(b);
			h.getChildren().add(u);
			h.getChildren().add(r);
			buttons.add(h);
		}
		shopListe.setAlignment(Pos.CENTER);
		shopListe.setSpacing(10.0);
	}

	@FXML
	void favorites(MouseEvent event) {
		System.out.println("TODO");
	}

	@FXML
	void messages(MouseEvent event) {
		this.facade.setMessageSelected();
		try {
			super.getChildren().clear();
			super.getChildren().add(new MessageController());
		} catch (IOException ex) {
			Logger.getLogger(MessageController.class.getName()).log(Level.SEVERE, null, ex);

		}
	}

	@FXML
	void inventory(MouseEvent event) {
		System.out.println("TODO");
	}

	@FXML
	void back(ActionEvent event) {
		try {
			super.getChildren().clear();
			super.getChildren().add(new MyGroupsController());
		} catch (IOException ex) {
			Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

		}
	}

	@FXML
	void add(ActionEvent event) {
		try {
			super.getChildren().clear();
			super.getChildren().add(new AjoutListController());
		} catch (IOException ex) {
			Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

		}
	}

	public void toList(GroupList selectedList) {
		facade.getListManager().setSelected(selectedList);
		try {
			super.getChildren().clear();
			super.getChildren().add(new AfficherListController());
		} catch (IOException ex) {
			Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

		}
	}

	public void remove(GroupList selectedList) {
		facade.getListManager().setSelected(selectedList);
		try {
			super.getChildren().clear();
			super.getChildren().add(new AfficherListController());
		} catch (IOException ex) {
			Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

		}
	}

	public void update(GroupList selectedList) {
		facade.getListManager().setSelected(selectedList);
		try {
			super.getChildren().clear();
			super.getChildren().add(new AfficherListController());
		} catch (IOException ex) {
			Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

		}
	}

	private void search() {
		search.setOnKeyReleased(keyEvent -> {
			flButton.setPredicate(p -> p.getId().toLowerCase().contains(search.getText().toLowerCase().trim()));// filter
																												// table
																												// by
																												// first
																												// name
			shopListe.getChildren().clear();
			if (flButton.isEmpty()) {
				Label l = new Label("No result");
				shopListe.getChildren().add(l);
			} else {
				shopListe.getChildren().addAll(flButton);
			}
		});
	}

}
