/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import bl.facade.ShareShopFacade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author fsmag
 */
public class ShopListController extends GridPane {

    private ShareShopFacade facade;
    private final ObservableList<Button> buttons = FXCollections.observableArrayList();
    @FXML
    private VBox shopListe;

    @FXML
    private TextField search;

    private FilteredList<Button> flButton;

    public ShopListController() throws IOException {
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/GroupListsView.fxml"));
        leLoader.setController(this);
        leLoader.setRoot(this);
        leLoader.load();
        initList();
        search();
        flButton = new FilteredList(buttons, p -> true);
        shopListe.getChildren().addAll(flButton);
        this.facade = ShareShopFacade.getInstance();
    }

    private void initList() {
        List<String> shoopingList = new ArrayList<String>();
        shoopingList.add("Liste 1");
        shoopingList.add("ABDDD");
        shoopingList.add("ZADAZD");
        shoopingList.add("RRRRRRRRRR");
        shopListe.getChildren().clear();
        for (String liste : shoopingList) {
            Button b = new Button(liste);
            b.setId(liste);
            b.setStyle("-fx-font-size: 24px; ");
            b.setAlignment(Pos.CENTER);
            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    toList(b);
                }
            });
            buttons.add(b);
        }
        shopListe.setAlignment(Pos.CENTER);
        shopListe.setSpacing(10.0);
    }

    @FXML
    void favorites(ActionEvent event) {

    }

    @FXML
    void messages(ActionEvent event) {

    }

    @FXML
    void inventory(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) {

    }

    @FXML
    void add(ActionEvent event) {

    }

    public void toList(Button b) {

    }

    private void search() {
        search.setOnKeyReleased(keyEvent
                -> {
            flButton.setPredicate(p -> p.getText().toLowerCase().contains(search.getText().toLowerCase().trim()));//filter table by first name
            shopListe.getChildren().clear();
            if(flButton.isEmpty()){
                Label l = new Label("No result");
                shopListe.getChildren().add(l);
            }
            else{
                shopListe.getChildren().addAll(flButton);    
            }
        });
    }

}
