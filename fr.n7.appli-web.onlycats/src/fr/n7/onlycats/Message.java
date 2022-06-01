package fr.n7.onlycats;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author cpantel
 *
 */
@Entity
public class Message {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int identificateur;
	
	@ManyToOne
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
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Message) {
			return (((Message)o).getIdentificateur() == this.getIdentificateur());
		} else {
			return false;
		}
	}

	public int getIdentificateur() {
		return identificateur;
	}
	
}
