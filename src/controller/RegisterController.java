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
import javafx.scene.layout.GridPane;

public class RegisterController extends GridPane{
    
    private final ObjectProperty<ShareShopFacade> facade = new SimpleObjectProperty<>(new ShareShopFacade());
    public ShareShopFacade getManager() {return facade.get();}
    public void setManager(ShareShopFacade m){
        facade.set(m);} 
    public ObjectProperty<ShareShopFacade> facadeProperty() {return facade;}
    

    public RegisterController(ShareShopFacade facade) throws IOException{
        System.out.println("A");
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("/view/RegisterView.fxml"));
        leLoader.setController(this);
        leLoader.setRoot(this);
        leLoader.load();
        setManager(facade);                
    }

	public boolean registerForm(String username, String password, String firstname, String lastname, String birthdate,
			String email) {
		//facade = new ShareShopFacade(username, password, firstname, lastname, birthdate, email);
		return facade.get().register();
	}
        
        @FXML 
    void back(ActionEvent event){
        try{
        super.getChildren().clear();
        super.getChildren().add(new UserController(getManager()));
        }
        catch (IOException ex){
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
}
