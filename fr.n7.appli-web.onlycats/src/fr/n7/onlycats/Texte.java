/**
 * 
 */
package fr.n7.onlycats;

import javax.persistence.Entity;

/**
 * @author cpantel
 *
 */
@Entity
public class Texte extends Contenu {
	
	String texte;

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

}
