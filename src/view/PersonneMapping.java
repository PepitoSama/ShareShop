package view;

import application.Main;

import model.Personne;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonneMapping {
	@FXML
    private TableView<Personne> personneTable;
    @FXML
    private TableColumn<Personne, String> nomColonne;
    @FXML
    private TableColumn<Personne, String> prenomColonne;
    @FXML
    private Label nomValeur;
    @FXML
    private Label prenomValeur;
    @FXML
    private Label dateValeur;
    @FXML
    private Label sexeValeur;

    //Objet servant de référence à notre classe principale
    //afin de pouvoir récupérer la liste de nos objets.
    private Main main;

    //Un constructeur par défaut
    public PersonneMapping() { }

    //Méthode qui initialise notre interface graphique
    //avec nos données métier
    @FXML
    private void initialize() {
        // Initialize the Personne table with the two columns.
        nomColonne.setCellValueFactory(cellData -> cellData.getValue().getNom());
        prenomColonne.setCellValueFactory(cellData -> cellData.getValue().getPrenom());
    }

    //Méthode qui sera utilisée dans l'initialisation de l'IHM
    //dans notre classe principale
    public void setMainApp(Main mainApp) {
        this.main = mainApp;
        // On lie notre liste observable au composant TableView
        personneTable.setItems(main.getListDePersonne());
    }
}
