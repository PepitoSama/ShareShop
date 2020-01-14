package ui.controller;


import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import bl.facade.ShareShopFacade;
import bl.manager.UserGroupManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.domain.User;
import model.domain.UserGroup;

/**
 *
 * @author emma_cbrt
 */
public class AfficherMembersController extends GridPane {
	private ShareShopFacade facade;
	private final ObservableList<HBox> buttons = FXCollections.observableArrayList();
	@FXML
	private VBox memberList;
	
	@FXML
	private ScrollPane member;
	
    private FilteredList<HBox> flButton;
    
    /**
     * AfficherMembersController controller that display the MemberList view in the main
     * view
     *
     * @throws IOException
     */
    public AfficherMembersController() throws IOException {
	FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/GroupMemberView.fxml"));
	leLoader.setController(this);
	leLoader.setRoot(this);
	leLoader.load();
	this.facade = ShareShopFacade.getInstance();
	memberList = new VBox();
	initList();
	flButton = new FilteredList(buttons, p -> true);
	memberList.getChildren().addAll(flButton);
	memberList.setAlignment(Pos.CENTER);
	member.setContent(memberList);
    }

    private void initList() {
    	List<User> MemberList = facade.getUserbyGroupId();
    	int groupId = facade.getSelectedGroupID();
    	memberList.getChildren().clear();
    	for (User liste : MemberList) {
    	    HBox h = new HBox();
    	    GridPane boutonGrid = new GridPane();
    	    boutonGrid.setHgap(20);
    	    boutonGrid.setPadding(new Insets(20));
    	    h.setId(liste.getFistname());
    	    Button b = new Button(liste.getFistname());
    	    b.setId("b" + Integer.toString(liste.getId()));
    	    b.setStyle("-fx-font-size: 24px; ");
    	    b.setAlignment(Pos.CENTER);
    	    b.setPrefWidth(250);
    	    Button r = new Button("❌");
    	    r.setId("r" + Integer.toString(liste.getId()));
    	    r.setStyle("-fx-font-size: 24px; ");
    	    r.setAlignment(Pos.CENTER);
    	    r.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent e) {
    			UserGroup userGroup = facade.getUserGroup(liste.getId(), groupId);
    		    remove(userGroup);
    		}
    	    });
    	    h.setSpacing(20);

    	    // Mettre les boutons dans la GridPane
    	    BorderPane leftBorder = new BorderPane();
    	    leftBorder.setCenter(b);
    	    boutonGrid.add(leftBorder, 0, 0);
    	    BorderPane rightBorder = new BorderPane();
    	    rightBorder.setCenter(r);
    	    boutonGrid.add(rightBorder, 2, 0);

    	    // Ajouter la GridPane a la VBox
    	    h.getChildren().add(boutonGrid);
    	    buttons.add(h);
    	}
    	memberList.setAlignment(Pos.CENTER);
    	memberList.setSpacing(10.0);
        }
    
    
    /**
     * FXML function to turn back to the previous view
     *
     * @param event
     */
    @FXML
    void back(ActionEvent event) {
	try {
	    super.getChildren().clear();
	    super.getChildren().add(new ShopListController());
	} catch (IOException ex) {
	    Logger.getLogger(ShopListController.class.getName()).log(Level.SEVERE, null, ex);

	}
    }
    
    /**
     * FXML function to add a user to the view
     *
     * @param event
     */
    @FXML
    void add(ActionEvent event) {
	try {
	    super.getChildren().clear();
	    super.getChildren().add(new AjoutMemberController());
	} catch (IOException ex) {
	    Logger.getLogger(AjoutMemberController.class.getName()).log(Level.SEVERE, null, ex);

	}
    }
    
    /**
     * function to remove a member of the group
     *
     * @param selectedUserGroup
     */
    public void remove(UserGroup selectedUserGroup) {
	facade.getUserGroupManager().setSelected(selectedUserGroup);
	showConfirmation(selectedUserGroup);
    }

    /**
     * function to update a member list
     *
     * @param selectedUserGroup
     */
    public void update(UserGroup selectedUserGroup) {
	facade.getUserGroupManager().setSelected(selectedUserGroup);
	try {
	    super.getChildren().clear();
	    super.getChildren().add(new UpdateMemberController());
	} catch (IOException ex) {
	    Logger.getLogger(UpdateMemberController.class.getName()).log(Level.SEVERE, null, ex);

	}
    }

    /**
     * function to confirm deleting of a group list
     *
     * @param liste
     */
    private void showConfirmation(UserGroup selectedUserGroup) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Delete List : " + selectedUserGroup.getIdUser());
		alert.setHeaderText("Are you're sure you want to remove this User?");
		alert.setContentText("This User will be definitly removed");
	
		// option != null.
		Optional<ButtonType> option = alert.showAndWait();
		if (option.get() == null) {
		} else if (option.get() == ButtonType.OK) {
		    facade.removeSelectedMember();
		    buttons.clear();
		    initList();
		    memberList.getChildren().clear();
		    flButton = new FilteredList(buttons, p -> true);
		    memberList.getChildren().addAll(flButton);
		    memberList.setAlignment(Pos.CENTER);
		    member.setContent(memberList);
		}
	    }
    


}
