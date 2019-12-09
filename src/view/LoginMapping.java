package view;

import application.Main;
import model.Personne;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class LoginMapping {
	// Objet servant de référence à notre classe principale
	// afin de pouvoir récupérer la liste de nos objets.
	private Main main;

	// Un constructeur par défaut
	public LoginMapping() {
	}

	// Méthode qui initialise notre interface graphique
	// avec nos données métier
	@FXML
	private void initialize() {
	}

	// Méthode qui sera utilisée dans l'initialisation de l'IHM
	// dans notre classe principale
	public void setMainApp(Main mainApp) {
		this.main = mainApp;
	}
}
