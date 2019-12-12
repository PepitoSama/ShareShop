package model.domain;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Personne {

	public enum Sexe {
		MASCULIN("Masculin"), FEMININ("Féminin"), INCONNU("Inconnu");

		private String name = "";

		Sexe(String n) {
			name = n;
		}

		public String toString() {
			return name;
		}
	}

	private ObjectProperty<LocalDate> dateDeNaissance = new SimpleObjectProperty<>();
	private ObjectProperty<Sexe> sexe = new SimpleObjectProperty<>();
	private StringProperty nom = new SimpleStringProperty();
	private StringProperty prenom = new SimpleStringProperty();

	public Personne() {
		sexe.set(Sexe.INCONNU);
		nom.set("");
		prenom.set("");
		dateDeNaissance.set(LocalDate.of(0, 1, 1));
	}

	public Personne(String n, String p, LocalDate ddn, Sexe s) {
		nom.set(n);
		prenom.set(p);
		dateDeNaissance.set(ddn);
		sexe.set(s);
		;
	}

	public ObjectProperty<LocalDate> getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(ObjectProperty<LocalDate> dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;

	}

	public ObjectProperty<Sexe> getSexe() {
		return sexe;
	}

	public void setSexe(ObjectProperty<Sexe> sexe) {
		this.sexe = sexe;
	}

	public StringProperty getNom() {
		return nom;
	}

	public void setNom(StringProperty nom) {
		this.nom = nom;
	}

	public StringProperty getPrenom() {
		return prenom;
	}

	public void setPrenom(StringProperty prenom) {
		this.prenom = prenom;
	}

	public String toString() {
		return "#Nom : " + nom.get() + " - prénom : " + prenom.get() + "#";
	}
}
