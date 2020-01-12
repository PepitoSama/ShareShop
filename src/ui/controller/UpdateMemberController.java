package ui.controller;


import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import bl.facade.ShareShopFacade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


/**
 *
 * @author emma_cbrt
 */
public class UpdateMemberController extends GridPane {

	private ShareShopFacade facade;

	@FXML
	private TextField name;

	@FXML
	private Text res;
	
	
	/**
	 * AjoutListController constructor Display view Ajout ShopList in the Main View
	 *
	 * @throws IOException
	 */
	public UpdateMemberController() throws IOException {
		//TO DO
	}


}
