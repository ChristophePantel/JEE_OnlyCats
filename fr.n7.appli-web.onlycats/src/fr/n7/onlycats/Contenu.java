package fr.n7.onlycats;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public abstract class Contenu {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int idPost;
	
	String contenuPost;
	
	int nombreLikes;
	
	// Contenu multimédia
	
	
}