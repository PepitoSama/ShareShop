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
		messageVBox.setSpacing(8);
		List<Message> msg = facade.getMessages();
		Image avatar = new Image("https://i.kym-cdn.com/entries/icons/original/000/012/448/tumblr_mfpwn7pBuf1rzi1ugo1_500.png", 50, 50, false, true);
		for (Message message : facade.getMessages()) {
			HBox messageHBox = new HBox(5);
			messageHBox.setPadding(new Insets(5));
			GridPane messageGrid = new GridPane();
			messageGrid.setHgap(20);
			messageGrid.setPadding(new Insets(20));
			
			// Ajout de l'image avatar a gauche
			BorderPane borderAvatar = new BorderPane();
			
			ImageView avatarView = new ImageView(avatar);
			borderAvatar.setCenter(avatarView);
			
			
			// Ajout du message
			BorderPane borderText = new BorderPane();
			Label messageLabel = new Label(message.toString());
			messageLabel.setPrefWidth(500);
			messageLabel.setWrapText(true);
			borderText.setCenter(messageLabel);
			
			if(message.getSentBy().getId() == facade.getUserId()) {
				// User
				messageGrid.add(borderAvatar, 1, 0);
				messageGrid.add(borderText, 0, 0);
				String style = "-fx-background-color: rgba(66, 135, 245, 0.5); -fx-border-radius: 18 18 18 18; -fx-background-radius: 18 18 18 18;";
				messageGrid.setStyle(style);
			} else {
				// Others
				messageGrid.add(borderAvatar, 0, 0);
				messageGrid.add(borderText, 1, 0);
				String style = "-fx-background-color: rgba(130, 130, 130, 0.5); -fx-border-radius: 18 18 18 18; -fx-background-radius: 18 18 18 18;";
				messageGrid.setStyle(style);
			}
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
