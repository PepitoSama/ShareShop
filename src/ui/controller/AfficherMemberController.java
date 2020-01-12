package ui.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import bl.facade.ShareShopFacade;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.domain.Group;
import model.domain.GroupList;
import model.domain.User;
import model.domain.products.PricedProduct;

/**
 *
 * @author emma_cbrt
 */
public class AfficherMemberController extends GridPane {

	private Group group;

	private ShareShopFacade facade;
	
	@FXML
    private TextField name;
    
    @FXML
    private VBox MemberListe;
    
    @FXML
    private ScrollPane member;
    
    public AfficherMemberController() throws IOException {
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/GroupMemberView.fxml"));
        leLoader.setController(this);
        leLoader.setRoot(this);
        leLoader.load();
        this.facade = ShareShopFacade.getInstance();
    	MemberListe = new VBox();
    	List<User> UserList = facade.getMembers(group);
    	List<Label> membersList = new ArrayList();
    	for (User Liste : UserList) {
    		membersList.add(new Label(Liste.getFistname()));
    	}
    	MemberListe.getChildren().addAll(membersList);
    	MemberListe.setAlignment(Pos.CENTER);
    	member.setContent(MemberListe);
    }
    
    @FXML
    void back(ActionEvent event) {
        try {
            super.getChildren().clear();
            super.getChildren().add(new ShopListController());
        } catch (IOException ex) {
            Logger.getLogger(AfficherMemberController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    @FXML
    void add(ActionEvent event) {
        //TO DO
    }

}
