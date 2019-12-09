package view;

import application.Main;
import model.Personne;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class LoginMapping {
	// Objet servant de r�f�rence � notre classe principale
	// afin de pouvoir r�cup�rer la liste de nos objets.
	private Main main;

	// Un constructeur par d�faut
	public LoginMapping() {
	}

	// M�thode qui initialise notre interface graphique
	// avec nos donn�es m�tier
	@FXML
	private void initialize() {
	}

	// M�thode qui sera utilis�e dans l'initialisation de l'IHM
	// dans notre classe principale
	public void setMainApp(Main mainApp) {
		this.main = mainApp;
	}
}
