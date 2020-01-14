package ui.controller;


import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import bl.facade.ShareShopFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import model.domain.User;


/**
 *
 * @author emma_cbrt
 */
public class AjoutMemberController extends GridPane {

	@FXML
    private TextField memberNickname;
	
	@FXML
	private Text Erreur;

    private final ShareShopFacade facade;

    public AjoutMemberController() throws IOException {
        FXMLLoader leLoader = new FXMLLoader(getClass().getClassLoader().getResource("ui/view/AjoutMemberView.fxml"));
        leLoader.setController(this);
        leLoader.setRoot(this);
        leLoader.load();    
        this.facade = ShareShopFacade.getInstance();
    }
    
    @FXML
    private void back(ActionEvent event) {
        try {
            super.getChildren().clear();
            super.getChildren().add(new AfficherMembersController());
        } catch (IOException ex) {
            Logger.getLogger(AfficherMembersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void addMember(ActionEvent event) {
    	User user = facade.getUserByNickname(memberNickname.getText());
    	if (user != null) {
    		int userId = user.getId();
        	int groupId = facade.getSelectedGroupID();
        	if (facade.createUserGroup(userId, groupId)) {
        		try {
                    super.getChildren().clear();
                    super.getChildren().add(new AfficherMembersController());
                } catch (IOException ex) {
                    Logger.getLogger(AfficherMembersController.class.getName()).log(Level.SEVERE, null, ex);
                }
        	} else {
        		Erreur.setText("User doesn't exist!");
    			Erreur.setFill(Paint.valueOf("red"));
        	}
    	}
    	else {
    		Erreur.setText("User doesn't exist!");
			Erreur.setFill(Paint.valueOf("red")); 
    	}
    }
    


}
