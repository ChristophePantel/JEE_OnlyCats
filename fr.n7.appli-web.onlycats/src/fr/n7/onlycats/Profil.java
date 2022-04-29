package fr.n7.onlycats;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Profil {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int idProfil;
	
	String prenom;
	
	String nom;
	
	String nomUtilistaeur;
	
	String adresseMail;
	
	String motDePasse;
	
	String description;
	
	// Liste d'abonnements
	Collection<Chat> abonnements;
	
	// Fil de discussion
	FilDiscussion filDiscussionProfil;
	
}
