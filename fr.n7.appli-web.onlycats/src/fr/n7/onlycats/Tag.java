package fr.n7.onlycats;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Tag {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int identificateur;
	
	String nom;
	
	@ManyToMany(mappedBy="tags", fetch = FetchType.EAGER)
	Collection<Chat> chats;
	
	@ManyToMany(mappedBy="tags", fetch = FetchType.EAGER)
	Collection<Contenu> contenus;

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
