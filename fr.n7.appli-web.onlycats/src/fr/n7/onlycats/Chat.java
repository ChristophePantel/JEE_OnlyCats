/**
 * 
 */
package fr.n7.onlycats;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	int likes;

	@ManyToOne(fetch = FetchType.EAGER)
	Createur proprietaire;
	
	@ManyToMany(fetch = FetchType.EAGER)
	Collection<Tag> tags;
	
	@OneToMany(mappedBy="sujet", fetch = FetchType.EAGER)
	Collection<Contenu> fil;
	
	@ManyToMany(fetch = FetchType.EAGER)
	Collection<Utilisateur> abonnes;
	
	public Collection<Contenu> getFil() {
		return fil;
	}

	public void setFil(Collection<Contenu> fil) {
		this.fil = fil;
	}
	
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
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public Createur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Createur proprietaire) {
		this.proprietaire = proprietaire;
	}
	
}
