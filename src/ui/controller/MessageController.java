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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.domain.Message;

/**
 *
 * @author pepito
 */
public class MessageController extends GridPane {
    
	@FXML
	private AnchorPane messageAnchor;
	
    private ShareShopFacade msg;
    
    private ShareShopFacade facade;
    
    public MessageController() throws IOException {
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/MessageView.fxml"));
        leLoader.setController(this);
        leLoader.setRoot(this);
        leLoader.load();
        this.facade = ShareShopFacade.getInstance();
        this.messageAnchor = new AnchorPane();
        initMessages();
    }

	private void initMessages() {
		this.messageAnchor.getChildren().clear();
		VBox messageVBox = new VBox();
		List<Message> msg = facade.getMessages();
		for (Message message : facade.getMessages()) {
			HBox messageHBox = new HBox();
			GridPane messageGrid = new GridPane();
			messageGrid.setPadding(new Insets(20));
			// Ajout de l'image avatar a gauche
			BorderPane borderAvatar = new BorderPane();
			ImageView avatarView = new ImageView();
			Image avatar = new Image("https://freeiconshop.com/wp-content/uploads/edd/person-solid.png");
			avatarView.setImage(avatar);
			messageGrid.add(avatarView, 0, 0);
//
//			messageGrid.add(avatarView, 0, 1);
//
//			messageGrid.add(avatarView, 0, 2);
			
			
			
			
			BorderPane borderText = new BorderPane();
			
		}
	}

	@FXML
    private void back() {
        try {
            super.getChildren().clear();
            super.getChildren().add(new ShopListController());
        } catch (IOException ex) {
            Logger.getLogger(ShopListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
