/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import java.io.IOException;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.domain.Group;
import model.domain.UserGroup;

/**
 *
 * @author fsmag
 */
public class MyGroupsController extends GridPane {

    private final ObservableList<Button> buttons = FXCollections.observableArrayList();
    @FXML
    private VBox shopListe;

    @FXML
    private ScrollPane scrollpane;

    private FilteredList<Button> flButton;

    private ShareShopFacade facade;

    public MyGroupsController() throws IOException {
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/MyGroupsView.fxml"));
        leLoader.setController(this);
        leLoader.setRoot(this);
        leLoader.load();
        this.facade = ShareShopFacade.getInstance();
        shopListe = new VBox();
        initList();
        flButton = new FilteredList(buttons, p -> true);
        shopListe.getChildren().addAll(flButton);
        shopListe.setAlignment(Pos.CENTER);
        scrollpane.setContent(shopListe);
    }

    private void initList() {
        int userId = facade.getUserId();
        List<UserGroup> userGroupList = facade.getUserGroupList(userId);
        List<Group> groupList = facade.getGroupList(userGroupList);
        shopListe.getChildren().clear();
        for (Group liste : groupList) {
            Button b = new Button(liste.getGroupName());
            b.setId(Integer.toString(liste.getId()));
            b.setStyle("-fx-font-size: 24px; ");
            b.setAlignment(Pos.CENTER);
            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    toGroup(liste);
                }
            });
            buttons.add(b);
        }
        shopListe.setAlignment(Pos.CENTER);
        shopListe.setSpacing(10.0);
    }

    /*
	 * TODO Il faut rajouter une fonction pour clear la face des infos du user + de
	 * la connection JDBC
     */
    @FXML
    private void disconnect(ActionEvent event) {

        try {
            super.getChildren().clear();
            super.getChildren().add(new LoginController());
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void profil(ActionEvent event) {
        try {
            super.getChildren().clear();
            super.getChildren().add(new ProfilController());
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void mystats(ActionEvent event) {
        try {
            super.getChildren().clear();
            super.getChildren().add(new StatsController());
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addGroup(ActionEvent event) {
        try {
            super.getChildren().clear();
            super.getChildren().add(new AddGroupController());
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void toGroup(Group group) {
        facade.getGroupManager().setSelected(group);
        try {
            super.getChildren().clear();
            super.getChildren().add(new ShopListController());
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
