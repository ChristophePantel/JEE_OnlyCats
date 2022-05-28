package fr.n7.onlycats;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Profil {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int identificateur;
	
	public int getIdentificateur() {
		return identificateur;
	}

	String prenom;
	
	String nom;
	
	String pseudo;
	
	String adresse;
	
	String motDePasse;
	
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	// Liste d'abonnements
	Collection<Chat> abonnements;
	
	// Fil de discussion
	FilDiscussion filDiscussionProfil;
	
	public Profil() {
		
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String nomUtilisateur) {
		this.pseudo = nomUtilisateur;
	}
	
}
