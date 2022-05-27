/**
 * 
 */
package fr.n7.onlycats;

import java.util.Collection;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @author cpantel
 *
 */

@Singleton
@Path("/")
public class RESTFacadeImpl implements RemoteFacade {
	
	@PersistenceContext(unitName = "OnlyCats")
	EntityManager entityManager;

	@Override
	@POST
	@Path("ajouterProfil")
	public void ajouterProfil(String prenom, String nom, String pseudo, String adresse, String motPasse,
			boolean nature) {
		Profil profil = null;
		if (nature) {
			profil = new Createur();
		} else {
			profil = new Utilisateur();
		}
		profil.setPrenom(prenom);
		profil.setNom(nom);
		profil.setPseudo(pseudo);
		profil.setAdresse(adresse);
		profil.setMotDePasse(motPasse);
		entityManager.persist(profil);
	}

	@Override
	@POST
	@Path("ajouterTag")
	public void ajouterTag(String nom) {
		Tag tag = new Tag();
		tag.setNom(nom);
		entityManager.persist(tag);
	}

	@Override
	@POST
	@Path("ajouterChat")
	public void ajouterChat(String nom, int idUtilisateur) {
		Createur createur = entityManager.find(Createur.class, idUtilisateur);
		Chat chat = new Chat();
		chat.setNom(nom);
		entityManager.persist(chat);
		createur.getChats().add(chat);
	}

	@Override
	@POST
	@Path("taggerChat")
	public void taggerChat(int idChat, int idUtilisateur, int idTag) {
		Utilisateur utilisateur = entityManager.find(Utilisateur.class, idUtilisateur);
		Chat chat = entityManager.find(Chat.class, idChat);
		Tag tag = entityManager.find(Tag.class, idTag);
		if (chat.getAbonnes().contains(utilisateur)) {
			chat.getTags().add(tag);
		}
	}

	@Override
	@POST
	@Path("posterTexte")
	public void posterTexte(int idChat, int idCreateur, String texte) {
		Createur createur = entityManager.find(Createur.class, idCreateur);
		Chat chat = entityManager.find(Chat.class, idChat);
		if (createur.getChats().contains(chat)) {
			Texte contenu = new Texte();
			contenu.setTexte(texte);
			entityManager.persist(contenu);
			chat.getFil().add(contenu);
		}
	}

	@Override
	@POST
	@Path("posterImage")
	public void posterImage(int idChat, int idCreateur, String url) {
		Createur createur = entityManager.find(Createur.class, idCreateur);
		Chat chat = entityManager.find(Chat.class, idChat);
		if (createur.getChats().contains(chat)) {
			Image contenu = new Image();
			contenu.setUrl(url);
			entityManager.persist(contenu);
			chat.getFil().add(contenu);
		}
	}

	@Override
	@POST
	@Path("posterVideo")
	public void posterVideo(int idChat, int idCreateur, String url) {
		Createur createur = entityManager.find(Createur.class, idCreateur);
		Chat chat = entityManager.find(Chat.class, idChat);
		if (createur.getChats().contains(chat)) {
			Video contenu = new Video();
			contenu.setUrl(url);
			entityManager.persist(contenu);
			chat.getFil().add(contenu);
		}
	}

	@Override
	@POST
	@Path("abonnerChat")
	public void abonnerChat(int idUtilisateur, int idChat) {
		Chat chat = entityManager.find(Chat.class, idChat);
		Utilisateur utilisateur = entityManager.find(Utilisateur.class, idUtilisateur);
		chat.getAbonnes().add(utilisateur);
	}

	@Override
	@POST
	@Path("posterMessage")
	public void posterMessage(int idUtilisateur, int idPost, String texte) {
		Utilisateur utilisateur = entityManager.find(Utilisateur.class, idUtilisateur);
		Contenu contenu = entityManager.find(Contenu.class, idPost);
		Chat chat = contenu.getSujet();
		if (chat.getAbonnes().contains(utilisateur)) {
			Message message = new Message();
			message.setTexte(texte);
			message.setExpediteur(utilisateur);
			entityManager.persist(message);
			contenu.getMessages().add(message);
		}
	}



}
