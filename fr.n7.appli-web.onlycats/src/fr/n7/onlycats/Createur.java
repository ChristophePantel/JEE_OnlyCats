package fr.n7.onlycats;

import java.util.Collection;

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
public class Createur extends Profil {
	
	// Liste des chats
	@OneToMany(fetch = FetchType.EAGER)
	Collection<Chat> chats;

	public Collection<Chat> getChats() {
		return chats;
	}

	public void setChats(Collection<Chat> chats) {
		this.chats = chats;
	}
	
}
