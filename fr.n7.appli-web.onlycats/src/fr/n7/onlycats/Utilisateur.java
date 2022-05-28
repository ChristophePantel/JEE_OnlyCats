package fr.n7.onlycats;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Utilisateur extends Profil {
	
	@ManyToMany
	Collection<Chat> abonnements;

	public Collection<Chat> getAbonnements() {
		return abonnements;
	}

	public void setAbonnements(Collection<Chat> abonnements) {
		this.abonnements = abonnements;
	}

}
