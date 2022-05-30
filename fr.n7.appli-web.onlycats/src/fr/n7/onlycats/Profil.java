package fr.n7.onlycats;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Profil {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int identificateur;
	
	String prenom;
	
	String nom;
	
	String pseudo;
	
	String adresse;
	
	String motDePasse;
	
	int cagnotte;

	public synchronized int getCagnotte() {
		return cagnotte;
	}

	public synchronized void setCagnotte(int cagnotte) {
		this.cagnotte = cagnotte;
	}

	public int getIdentificateur() {
		return identificateur;
	}
	
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
	
	public synchronized boolean prelever(int prix) {
		boolean resultat = (0 <= prix) && (prix <= this.getCagnotte());
		if (resultat) {
			this.setCagnotte(this.getCagnotte() - prix);
		}
		return resultat;
	}
	
	public synchronized boolean verser(int somme) {
		boolean resultat = (somme >= 0);
		if (resultat) {
			this.setCagnotte(this.getCagnotte() + somme);
		}
		return resultat;
	}
	
}
