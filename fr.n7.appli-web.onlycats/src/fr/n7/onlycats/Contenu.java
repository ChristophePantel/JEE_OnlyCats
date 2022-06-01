package fr.n7.onlycats;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	int identificateur;
	
	String titre;
	
	@ManyToOne
	Chat sujet;
	
	@OneToMany(fetch = FetchType.EAGER)
	Collection<Message> messages;
	
	@ManyToMany(fetch = FetchType.EAGER)
	Collection<Tag> tags;
	
	Date date;

	int likes;
	
	public Chat getSujet() {
		return sujet;
	}

	public void setSujet(Chat sujet) {
		this.sujet = sujet;
	}

	public Collection<Message> getMessages() {
		return messages;
	}

	public void setMessages(Collection<Message> messages) {
		this.messages = messages;
	}
	
	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	public void setTags(Collection<Tag> tags) {
		this.tags = tags;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Contenu) {
			return (((Contenu)o).getIdentificateur() == this.getIdentificateur());
		} else {
			return false;
		}
	}

	public int getIdentificateur() {
		return identificateur;
	}
	
}