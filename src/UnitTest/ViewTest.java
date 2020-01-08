/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTest;

import bl.facade.ShareShopFacade;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import ui.controller.MainViewController;
import ui.controller.ShopListController;

/**
 *
 * @author fsmag
 */
public class ViewTest {
 
    @FXML
	private GridPane elements;

	@FXML
	private TextField pwd;

	private final ShareShopFacade manager = ShareShopFacade.getInstance();


	public void initialize() throws IOException {
		try {
			elements.getChildren().add(new ShopListController());
		} catch (IOException ex) {
			Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
