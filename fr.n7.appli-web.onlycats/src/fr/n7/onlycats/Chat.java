/**
 * 
 */
package fr.n7.onlycats;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author cpantel
 *
 */
@Entity
public class Chat {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int identificateur;
	
	String nom;
	
	String descriptionChat;
	
	// Tags : Liste de tags
	Collection<Tag> tags;
	
	// Contenu multimédia
	FilContenu filPostsChat;
	
	public Chat() {
		this.tags = new HashSet<Tag>();
	}
	
	public int getIdentificateur() {
		return identificateur;
	}

	public void setIdentificateur(int identificateur) {
		this.identificateur = identificateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Tag> getTags() {
		return this.tags;
	}
	
}
