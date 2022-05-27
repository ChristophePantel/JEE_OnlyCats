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
import javax.persistence.OneToMany;

/**
 * @author cpantel
 *
 */
@Entity
public class Chat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int identificateur;
	
	String nom;
	
	String description;
	
	// Tags : Liste de tags
	@ManyToMany
	Collection<Tag> tags;
	
	@OneToMany
	Collection<Contenu> fil;
	
	public Collection<Contenu> getFil() {
		return fil;
	}

	public void setFil(Collection<Contenu> fil) {
		this.fil = fil;
	}

	@ManyToMany
	Collection<Utilisateur> abonnes;
	
	public Collection<Utilisateur> getAbonnes() {
		return abonnes;
	}

	public void setAbonnes(Collection<Utilisateur> abonnes) {
		this.abonnes = abonnes;
	}

	public void setTags(Collection<Tag> tags) {
		this.tags = tags;
	}
	
	public Chat() {
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
