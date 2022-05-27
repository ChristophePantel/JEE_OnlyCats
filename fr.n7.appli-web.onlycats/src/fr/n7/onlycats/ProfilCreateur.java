package fr.n7.onlycats;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ProfilCreateur extends Profil {
	
	// List des chats
	Collection<Chat> chats;

	// Distinction d'un profil payant ou non
	boolean deluxe;
	
}
