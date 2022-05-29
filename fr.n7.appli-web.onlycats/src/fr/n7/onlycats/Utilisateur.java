package fr.n7.onlycats;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
public class Utilisateur extends Profil {
	
	@ManyToMany(fetch = FetchType.EAGER)
	Collection<Chat> abonnements;
	
	@ManyToMany(fetch = FetchType.EAGER)
	Collection<Contenu> liens;

	public Collection<Chat> getAbonnements() {
		return abonnements;
	}

	public void setAbonnements(Collection<Chat> abonnements) {
		this.abonnements = abonnements;
	}
	
	public Collection<Contenu> getLiens() {
		return liens;
	}

	public void setLiens(Collection<Contenu> liens) {
		this.liens = liens;
	}

}
