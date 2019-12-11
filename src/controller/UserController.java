/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facade.ShareShopFacade;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author fsmag
 */
public class UserController extends GridPane {
    
    @FXML
    private GridPane loginview;
    
    @FXML
    private TextField login;
    
    @FXML
    private TextField pwd;
    
    private final ObjectProperty<ShareShopFacade> manager = new SimpleObjectProperty<>(new ShareShopFacade());
    public ShareShopFacade getManager() {return manager.get();}
    public void setManager(ShareShopFacade m){
        manager.set(m);} 
    public ObjectProperty<ShareShopFacade> managerProperty() {return manager;}
    
    public UserController(ShareShopFacade manager) throws IOException{
        System.out.println("A");
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("/view/LoginView.fxml"));
        leLoader.setController(this);
        leLoader.setRoot(this);
        leLoader.load();
        setManager(manager);                
    }
    
    @FXML
    private void login(ActionEvent event) {
        String id = login.getText();
        String pass = pwd.getText();
        // On récupère les contenus des champs texte de la vue et on va regarder s'ils sont pas nul avant d'envoyer au controleur
        
        manager.get().login();
    }
    
    @FXML
    private void register(ActionEvent event) {
        System.out.println(manager);
        Stage view = (Stage) loginview.getScene().getWindow();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/BudgetView.fxml"));
            Scene scene = new Scene(root);
            view.setScene(scene);
            view.show();
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
