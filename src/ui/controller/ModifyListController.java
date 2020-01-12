package ui.controller;

import bl.facade.ShareShopFacade;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

/**
 *
 * @author pepito
 */
public class ModifyListController extends GridPane {

	private ShareShopFacade facade;

	/**
	 * ModifyListController constructor Display view ModifyShopListView in the Main View
	 *
	 * @throws IOException
	 */
	public ModifyListController() throws IOException {
		FXMLLoader leLoader = new FXMLLoader(getClass().getResource("../view/ModifyShopListView.fxml"));
		leLoader.setController(this);
		leLoader.setRoot(this);
		leLoader.load();
		this.facade = ShareShopFacade.getInstance();
	}

	/**
	 * FXML function back, return previous view
	 *
	 * @param event
	 */
	@FXML
	void back(ActionEvent event) {
		try {
			super.getChildren().clear();
			super.getChildren().add(new AfficherListController());
		} catch (IOException ex) {
			Logger.getLogger(AfficherListController.class.getName()).log(Level.SEVERE, null, ex);

		}
	}
	
	@FXML
    void addProduct(ActionEvent event) {
    	 try {
             super.getChildren().clear();
             super.getChildren().add(new SearchProductsController());

         } catch (Exception ex) {
             Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

         }
    }

}
