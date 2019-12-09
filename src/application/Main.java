package application;

import java.io.IOException;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Personne;
import model.Personne.Sexe;
import view.PersonneMapping;

public class Main extends Application {

	// Nous cr�ons des variable de classes afin de pouvoir y acc�der partout
	// Ceci afin de pouvoir y positionner les �l�ments que nous avons fait
	// Il y a un BorderPane car le conteneur principal de notre IHM
	// est un BorderPane, nous reparlerons de l'objet Stage
	private Stage stagePrincipal;
	private BorderPane conteneurPrincipal;

	private ObservableList<Personne> listDePersonne = FXCollections.observableArrayList();

	public Main() {
		listDePersonne.add(new Personne("Proviste", "Alain", LocalDate.of(1970, 1, 1), Sexe.MASCULIN));
		listDePersonne.add(new Personne("D'Arc", "Jeanne", LocalDate.of(1431, 5, 30), Sexe.FEMININ));
		listDePersonne.add(new Personne("Caisse", "Jean", LocalDate.of(1950, 3, 3), Sexe.MASCULIN));
	}

	public ObservableList<Personne> getListDePersonne() {
		return listDePersonne;
	}

	@Override
	public void start(Stage primaryStage) {
		stagePrincipal = primaryStage;
		// Ca ne vous rappelle pas une JFrame ?
		stagePrincipal.setTitle("My Application");

		// Nous allons utiliser nos fichier FXML dans ces deux m�thodes
		initialisationConteneurPrincipal();
		initialisationContenu("../view/PersonView.fxml");
	}

	private void initialisationConteneurPrincipal() {
		// On cr�� un chargeur de FXML
		FXMLLoader loader = new FXMLLoader();
		// On lui sp�cifie le chemin relatif � notre classe
		// du fichier FXML a charger : dans le sous-dossier view
		loader.setLocation(Main.class.getResource("../view/ConteneurPrincipal.fxml"));
		try {
			// Le chargement nous donne notre conteneur
			conteneurPrincipal = (BorderPane) loader.load();
			// On d�finit une sc�ne principale avec notre conteneur
			Scene scene = new Scene(conteneurPrincipal);
			// Que nous affectons � notre Stage
			stagePrincipal.setScene(scene);
			// Pour l'afficher
			stagePrincipal.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initialisationContenu(String ressource) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(ressource));
		try {
			// Nous r�cup�rons notre conteneur qui contiendra les donn�es
			// Pour rappel, c'est un AnchorPane...
			AnchorPane conteneur = (AnchorPane) loader.load();
			// Qui nous ajoutons � notre conteneur principal
			// Au centre, puisque'il s'agit d'un BorderPane
			conteneurPrincipal.setCenter(conteneur);

			// Nous r�cup�rons notre mappeur via l'objet FXMLLoader
			PersonneMapping controleur = loader.getController();
			// Nous lui passons notre instance de classe
			// pour qu'il puisse r�cup�rer notre liste observable
			controleur.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
