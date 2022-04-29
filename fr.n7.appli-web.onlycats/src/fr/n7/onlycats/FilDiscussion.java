package fr.n7.onlycats;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class FilDiscussion {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int idFilDiscussion;
	
	// Composé d'une liste de message ou d'une liste de fil de discussion avec une association
	// avec l'utilisateur qui a écrit le message.
	
}