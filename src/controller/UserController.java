/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facade.ShareShopFacade;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author fsmag
 */
public class UserController  {
    
    @FXML
    private TextField login;
    
    @FXML
    private TextField pwd;
    
    private final ObjectProperty<ShareShopFacade> manager = new SimpleObjectProperty<>(new ShareShopFacade());
    public ShareShopFacade getManager() {return manager.get();}
    public void setManager(ShareShopFacade m){
        manager.set(m);} 
    public ObjectProperty<ShareShopFacade> managerProperty() {return manager;}
    
    @FXML
    private void login(ActionEvent event) {
        String id = login.getText();
        String pass = pwd.getText();
        // On récupère les contenus des champs texte de la vue et on va regarder s'ils sont pas nul avant d'envoyer au controleur
        
        manager.get().login();
    }
    
    
}
