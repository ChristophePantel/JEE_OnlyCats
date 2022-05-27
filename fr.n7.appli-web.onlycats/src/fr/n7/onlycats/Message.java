package fr.n7.onlycats;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int idFilDiscussion;
	
	Profil expediteur;
	
	String texte;
	
	public Profil getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(Profil expediteur) {
		this.expediteur = expediteur;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	Collection<Chat> chats;
	
	Collection<Profil> abonnes;
	
}
