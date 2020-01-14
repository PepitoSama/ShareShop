/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controller;

import bl.facade.ShareShopFacade;
import java.util.Optional;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.domain.GroupList;

/**
 *
 * @author fsmag
 */
public class ShopListController extends GridPane {

    private ShareShopFacade facade;
    private final ObservableList<HBox> buttons = FXCollections.observableArrayList();
    @FXML
    private VBox shopListe;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private TextField search;

    private FilteredList<HBox> flButton;

    /**
     * ShopListController controller that display the GroupList view in the main
     * view
     *
     * @throws IOException
     */
    public ShopListController() throws IOException {
	FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/GroupListsView.fxml"));
	leLoader.setController(this);
	leLoader.setRoot(this);
	leLoader.load();
	this.facade = ShareShopFacade.getInstance();
	shopListe = new VBox();
	initList();
	search();
	flButton = new FilteredList(buttons, p -> true);
	shopListe.getChildren().addAll(flButton);
	shopListe.setAlignment(Pos.CENTER);
	scrollpane.setContent(shopListe);
    }

    /**
     * function that initialize the list of GroupList
     */
    private void initList() {
	List<GroupList> shoopingList = facade.getShoppingList();
	shopListe.getChildren().clear();
	for (GroupList liste : shoopingList) {
	    HBox h = new HBox();
	    GridPane boutonGrid = new GridPane();
	    boutonGrid.setHgap(20);
	    boutonGrid.setPadding(new Insets(20));
	    h.setId(liste.getName());
	    Button b = new Button(liste.getName());
	    b.setId("b" + Integer.toString(liste.getIdGroupList()));
	    b.setStyle("-fx-font-size: 24px; ");
	    b.setAlignment(Pos.CENTER);
	    b.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
		    toList(liste);
		}
	    });
	    b.setPrefWidth(250);
	    Button u = new Button("✏");
	    u.setId("u" + Integer.toString(liste.getIdGroupList()));
	    u.setStyle("-fx-font-size: 24px; ");
	    u.setAlignment(Pos.CENTER);
	    u.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
		    update(liste);
		}
	    });
	    Button r = new Button("❌");
	    r.setId("r" + Integer.toString(liste.getIdGroupList()));
	    r.setStyle("-fx-font-size: 24px; ");
	    r.setAlignment(Pos.CENTER);
	    r.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
		    remove(liste);
		}
	    });
	    h.setSpacing(20);

	    // Mettre les boutons dans la GridPane
	    BorderPane leftBorder = new BorderPane();
	    leftBorder.setCenter(b);
	    boutonGrid.add(leftBorder, 0, 0);
	    BorderPane centerBorder = new BorderPane();
	    centerBorder.setCenter(u);
	    boutonGrid.add(centerBorder, 1, 0);
	    BorderPane rightBorder = new BorderPane();
	    rightBorder.setCenter(r);
	    boutonGrid.add(rightBorder, 2, 0);

	    // Ajouter la GridPane a la VBox
	    h.getChildren().add(boutonGrid);
	    buttons.add(h);
	}
	shopListe.setAlignment(Pos.CENTER);
	shopListe.setSpacing(10.0);
    }

    /**
     * FXML function that display favorites products list
     *
     * @param event
     */
    @FXML
    void favorites(MouseEvent event) {
    	
    	try {
			super.getChildren().clear();
			super.getChildren().add(new AfficherFavoriteListController());
		} catch (IOException ex) {
			Logger.getLogger(ShopListController.class.getName()).log(Level.SEVERE, null, ex);
		}
    }
    
    /**
     * FXML function that display the member view
     *
     * @param event
     */
    @FXML
    void members(MouseEvent event) {
    	try {
    	    super.getChildren().clear();
    	    super.getChildren().add(new AfficherMembersController());
    	} catch (IOException ex) {
    	    Logger.getLogger(ShopListController.class.getName()).log(Level.SEVERE, null, ex);

    	}
    }
    

    /**
     * FXML function that permit to acces to messages
     *
     * @param event
     */
    @FXML
    void messages(MouseEvent event) {
	facade.setMessageSelected();
	try {
	    super.getChildren().clear();
	    super.getChildren().add(new MessageController());
	} catch (IOException ex) {
	    Logger.getLogger(MessageController.class.getName()).log(Level.SEVERE, null, ex);

	}
    }

    /**
     * FXML function that display the invetory of the group
     *
     * @param event
     */
    @FXML
    void inventory(MouseEvent event) {
	System.out.println("TODO");
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
	    super.getChildren().add(new MyGroupsController());
	} catch (IOException ex) {
	    Logger.getLogger(MyGroupsController.class.getName()).log(Level.SEVERE, null, ex);

	}
    }

    /**
     * FXML function to add a shopping list to the view
     *
     * @param event
     */
    @FXML
    void add(ActionEvent event) {
	try {
	    super.getChildren().clear();
	    super.getChildren().add(new AjoutListController());
	} catch (IOException ex) {
	    Logger.getLogger(AjoutListController.class.getName()).log(Level.SEVERE, null, ex);

	}
    }

    /**
     * function to access to a group list
     *
     * @param selectedList
     */
    public void toList(GroupList selectedList) {
	facade.getListManager().setSelected(selectedList);
	try {
	    super.getChildren().clear();
	    super.getChildren().add(new AfficherListController());
	} catch (IOException ex) {
	    Logger.getLogger(AfficherListController.class.getName()).log(Level.SEVERE, null, ex);

	}
    }

    /**
     * function to remove a group list
     *
     * @param selectedList
     */
    public void remove(GroupList selectedList) {
	facade.getListManager().setSelected(selectedList);
	showConfirmation(selectedList);
    }

    /**
     * function to update a group list
     *
     * @param selectedList
     */
    public void update(GroupList selectedList) {
	facade.getListManager().setSelected(selectedList);
	try {
	    super.getChildren().clear();
	    super.getChildren().add(new UpdateListController());
	} catch (IOException ex) {
	    Logger.getLogger(UpdateListController.class.getName()).log(Level.SEVERE, null, ex);

	}
    }

    /**
     * function to confirm deleting of a group list
     *
     * @param liste
     */
    private void showConfirmation(GroupList liste) {

	Alert alert = new Alert(AlertType.CONFIRMATION);
	alert.setTitle("Delete List : " + liste.getName());
	alert.setHeaderText("Are you're sure you want to remove this List?");
	alert.setContentText("This shopping list will be definitly removed");

	// option != null.
	Optional<ButtonType> option = alert.showAndWait();
	if (option.get() == null) {
	} else if (option.get() == ButtonType.OK) {
	    facade.removeSelectedList();
	    buttons.clear();
	    initList();
	    shopListe.getChildren().clear();
	    flButton = new FilteredList(buttons, p -> true);
	    shopListe.getChildren().addAll(flButton);
	    shopListe.setAlignment(Pos.CENTER);
	    scrollpane.setContent(shopListe);
	}
    }

    /**
     * function to display only group list search
     */
    private void search() {
	search.setOnKeyReleased(keyEvent -> {
	    flButton.setPredicate(p -> p.getId().toLowerCase().contains(search.getText().toLowerCase().trim()));// filter
	    // table
	    // by
	    // first
	    // name
	    shopListe.getChildren().clear();
	    if (flButton.isEmpty()) {
		Label l = new Label("No result");
		shopListe.getChildren().add(l);
	    } else {
		shopListe.getChildren().addAll(flButton);
	    }
	});
    }

}
