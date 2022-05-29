/**
 * 
 */
package fr.n7.onlycats;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author cpantel
 *
 */

@Entity
public class Abonnement {
	
	@OneToOne
	Utilisateur abonne;
	
	@OneToOne
	Chat chat;
	
	Date date;
	
	int cagnotte;

	public Utilisateur getAbonne() {
		return abonne;
	}

	public void setAbonne(Utilisateur abonne) {
		this.abonne = abonne;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCagnotte() {
		return cagnotte;
	}

	public void setCagnotte(int cagnotte) {
		this.cagnotte = cagnotte;
	}

}
