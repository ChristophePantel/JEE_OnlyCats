package fr.n7.onlycats;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public abstract class Contenu {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idContenu;
	
	@ManyToOne
	Chat sujet;
	
	public Chat getSujet() {
		return sujet;
	}

	public void setSujet(Chat sujet) {
		this.sujet = sujet;
	}

	int likes;
	
	@OneToMany
	Collection<Message> messages;

	public Collection<Message> getMessages() {
		return messages;
	}

	public void setMessages(Collection<Message> messages) {
		this.messages = messages;
	}
	
}