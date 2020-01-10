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
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.domain.Group;
import model.domain.GroupList;
import model.domain.Message;
import model.domain.UserGroup;

/**
 *
 * @author pepito
 */
public class MessageController extends GridPane {

    @FXML
    private ScrollPane scrollpane;
    
    @FXML
	private VBox messageList;
    
    private ShareShopFacade facade;

    public MessageController() throws IOException {
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/MessageView.fxml"));
        leLoader.setController(this);
        leLoader.setRoot(this);
        leLoader.load();
        this.facade = ShareShopFacade.getInstance();
        messageList = new VBox();
        initMessageList();
        messageList.setAlignment(Pos.CENTER);
		scrollpane.setContent(messageList);
    }

    private void initMessageList() {
    	
    	List<Message> messageList = facade.getMessages();
    	this.messageList.getChildren().clear();
    	for(Message message : messageList) {
    		// Ajouter les messages ici
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
