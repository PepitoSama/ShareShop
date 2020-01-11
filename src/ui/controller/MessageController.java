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
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
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
	private VBox messageList;
	
	@FXML
	private ScrollPane scrollpane;

	@FXML
	private TextArea message;
    
    private ShareShopFacade facade;
    
    
    public MessageController() throws IOException {
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/MessageView.fxml"));
        leLoader.setController(this);
        leLoader.setRoot(this);
        leLoader.load();
        this.facade = ShareShopFacade.getInstance();
        this.messageList = new VBox();
        initMessages();
    }

	private void initMessages() {
		this.messageList.getChildren().clear();
		VBox messageVBox = new VBox();
		List<Message> msg = facade.getMessages();
		for (Message message : facade.getMessages()) {
			HBox messageHBox = new HBox();
			GridPane messageGrid = new GridPane();
			messageGrid.setPadding(new Insets(20));
			
			// Ajout de l'image avatar a gauche
			BorderPane borderAvatar = new BorderPane();
			Image avatar = new Image("https://freeiconshop.com/wp-content/uploads/edd/person-solid.png", 50, 50, false, true);
			ImageView avatarView = new ImageView(avatar);
			borderAvatar.setCenter(avatarView);
			messageGrid.add(borderAvatar, 0, 0);
			
			// Ajout du message
			BorderPane borderText = new BorderPane();
			Label messageLabel = new Label(message.toString());
			borderText.setCenter(messageLabel);
			messageGrid.add(borderText, 1, 0);
			
			// Ajout du Vbox au HBox
			messageVBox.getChildren().add(messageGrid);
		}
		messageList = messageVBox;
        messageList.setAlignment(Pos.CENTER);
        scrollpane.setContent(messageList);
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
	
	@FXML
    private void send() {
		// Save message in DataBase
		System.out.println(message.getText());
		if (facade.sendMessage(message.getText())) {
			// Clear message TextArea
			message.clear();
			// Refresh all messages
			initMessages();
		} else {
			// Show error
			System.out.println("Nupe");
		}
		
		
    }

}
