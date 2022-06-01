/**
 * 
 */
package fr.n7.onlycats;

import java.util.Collection;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author cpantel
 *
 */

@Singleton
@Path("/")
public class RESTFacadeImpl implements RemoteFacade {
	
	@EJB
	FacadeBD facade;

	@Override
	@POST
	@Consumes("text/json")
	@Path("ajouterProfil")
	public void ajouterProfil(String prenom, String nom, String pseudo, String adresse, String motPasse, int cagnotte,
			boolean nature) {
		facade.ajouterProfil(prenom, nom, pseudo, adresse, motPasse, cagnotte, nature);
	}

	@Override
	@POST
	@Consumes("text/json")
	@Path("ajouterTag")
	public void ajouterTag(String nom) {
		facade.ajouterTag(nom);
	}

	@Override
	@POST
	@Consumes("text/json")
	@Path("ajouterChat")
	public void ajouterChat(String nom, String description, int prix, int idCreateur) {
		facade.ajouterChat(nom, description, prix, idCreateur);
	}

	@Override
	@POST
	@Consumes("text/json")
	@Path("taggerChat")
	public void taggerChat(int idChat, int idUtilisateur, int idTag) {
		facade.taggerChat(idChat, idUtilisateur, idTag);
	}

	@Override
	@POST
	@Consumes("text/json")
	@Path("posterTexte")
	public void posterTexte(int idChat, int idCreateur, String titre, String texte, Date date) {
		facade.posterTexte(idChat, idCreateur, titre, texte, date);
	}

	@Override
	@POST
	@Consumes("text/json")
	@Path("posterImage")
	public void posterImage(int idChat, int idCreateur, String titre, String url, Date date) {
		facade.posterImage(idChat, idCreateur, titre, url, date);
	}

	@Override
	@POST
	@Consumes("text/json")
	@Path("posterVideo")
	public void posterVideo(int idChat, int idCreateur, String titre, String url, Date date) {
		facade.posterVideo(idChat, idCreateur, titre, url, date);
	}

	@Override
	@POST
	@Consumes("text/json")
	@Path("abonnerChat")
	public void abonnerChat(int idUtilisateur, int idChat) {
		facade.abonnerChat(idUtilisateur, idChat);
	}

	@Override
	@POST
	@Consumes("text/json")
	@Path("posterMessage")
	public void posterMessage(int idUtilisateur, int idPost, String texte) {
		facade.posterMessage(idUtilisateur, idPost, texte);
	}

	@Override
	@POST
	@Consumes("text/json")
	@Produces("text/json")
	public Profil authentifierUtilisateurParPseudo(String pseudo, String motDePasse) {
		return facade.authentifierUtilisateurParPseudo(pseudo, motDePasse);
	}

	@Override
	@GET
	@Consumes("text/json")
	@Produces("text/json")
	public Collection<Chat> chatParUtilisateur(int idUtilisateur) {
		return facade.chatParUtilisateur(idUtilisateur);
	}

	@Override
	@GET
	@Consumes("text/json")
	@Produces("text/json")
	public Collection<Chat> chatParCreateur(int idCreateur) {
		return facade.chatParCreateur(idCreateur);
	}

	@Override
	@GET
	@Produces("text/json")
	public Collection<Utilisateur> listerUtilisateurs() {
		return facade.listerUtilisateurs();
	}

	@Override
	@GET
	@Produces("text/json")
	public Collection<Createur> listerCreateurs() {
		return facade.listerCreateurs();
	}

	@Override
	@POST
	@Consumes("text/json")
	public void ajouterLien(int idUtilisateur, int idContenu) {
		facade.ajouterLien(idUtilisateur, idContenu);
	}

	@Override
	@POST
	@Consumes("text/json")
	public void aimerChat(int idUtilisateur, int idChat) {
		facade.aimerChat(idUtilisateur, idChat);
	}

	@Override
	@POST
	@Consumes("text/json")
	public void aimerContenu(int idUtilisateur, int idContenu) {
		facade.aimerContenu(idUtilisateur, idContenu);
	}

	@Override
	public void tester() {
		facade.tester();
	}

	@Override
	@GET
	@Produces("text/json")
	public Collection<Chat> listerChats() {
		return facade.listerChats();
	}

	@Override
	@GET
	@Produces("text/json")
	public Collection<Abonnement> listerAbonnements() {
		return facade.listerAbonnements();
	}

	@Override
	@GET
	@Produces("text/json")
	public Profil profilParPseudo(String pseudo) {
		return facade.profilParPseudo(pseudo);
	}

}
