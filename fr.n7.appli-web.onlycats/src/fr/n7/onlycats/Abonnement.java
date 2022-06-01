/**
 * 
 */
package fr.n7.onlycats;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author cpantel
 *
 */

@Entity
public class Abonnement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int identificateur;
	
	@OneToOne
	Utilisateur abonne;
	
	@OneToOne
	Chat chat;
	
	Date date;

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
}
