package fr.n7.onlycats;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur extends Profil {
	
	@OneToMany(mappedBy="abonne", fetch = FetchType.EAGER)
	Collection<Abonnement> abonnements;
	
	@ManyToMany(fetch = FetchType.EAGER)
	Collection<Contenu> liens;

	public Collection<Abonnement> getAbonnements() {
		return abonnements;
	}

	public void setAbonnements(Collection<Abonnement> abonnements) {
		this.abonnements = abonnements;
	}
	
	public Collection<Contenu> getLiens() {
		return liens;
	}

	public void setLiens(Collection<Contenu> liens) {
		this.liens = liens;
	}

}
