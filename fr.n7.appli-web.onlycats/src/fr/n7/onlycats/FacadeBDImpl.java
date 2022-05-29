/**
 * 
 */
package fr.n7.onlycats;

import java.util.Collection;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @author cpantel
 *
 */
@Singleton
public class FacadeBDImpl implements FacadeBD {

	@PersistenceContext(unitName = "OnlyCats")
	EntityManager entityManager;

	@Override
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
	public void ajouterTag(String nom) {
		Tag tag = new Tag();
		tag.setNom(nom);
		entityManager.persist(tag);
	}

	@Override
	public void ajouterChat(String nom, int idUtilisateur) {
		Createur createur = entityManager.find(Createur.class, idUtilisateur);
		Chat chat = new Chat();
		chat.setNom(nom);
		entityManager.persist(chat);
		createur.getChats().add(chat);
	}

	@Override
	public void taggerChat(int idChat, int idUtilisateur, int idTag) {
		Utilisateur utilisateur = entityManager.find(Utilisateur.class, idUtilisateur);
		Chat chat = entityManager.find(Chat.class, idChat);
		Tag tag = entityManager.find(Tag.class, idTag);
		if (chat.getAbonnes().contains(utilisateur)) {
			chat.getTags().add(tag);
		}
	}

	@Override
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
	public void abonnerChat(int idUtilisateur, int idChat) {
		Chat chat = entityManager.find(Chat.class, idChat);
		Utilisateur utilisateur = entityManager.find(Utilisateur.class, idUtilisateur);
		chat.getAbonnes().add(utilisateur);
	}

	@Override
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

	@Override
	public Profil utilisateurParPseudo(String pseudo, String motDePasse) {
		String query = "select p from Profil p where pseudo = \'" + pseudo + "\' and motDePasse = \'" + motDePasse + "\'";
		System.err.println(query);
		TypedQuery<Profil> requete = entityManager.createQuery(
				query,
				Profil.class);
		try {
			return requete.getSingleResult();
		}
		catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Collection<Chat> chatParUtilisateur(int idUtilisateur) {
		Utilisateur utilisateur = entityManager.find(Utilisateur.class, idUtilisateur);
		return utilisateur.getAbonnements();
	}

	@Override
	public Collection<Chat> chatParCreateur(int idCreateur) {
		Createur createur = entityManager.find(Createur.class, idCreateur);
		return createur.getChats();
	}

	@Override
	public Collection<Utilisateur> listerUtilisateurs() {
		return entityManager.createQuery("from Utilisateur", Utilisateur.class).getResultList();
	}

	@Override
	public Collection<Createur> listerCreateurs() {
		return entityManager.createQuery("from Createur", Createur.class).getResultList();
	}

	@Override
	public void ajouterLien(int idUtilisateur, int idContenu) {
		Utilisateur utilisateur = entityManager.find(Utilisateur.class, idUtilisateur);
		Contenu contenu = entityManager.find(Contenu.class, idContenu);
		if (utilisateur.getAbonnements().contains(contenu.getSujet())) {
			utilisateur.getLiens().add(contenu);
		}
	}

	@Override
	public void aimerChat(int idUtilisateur, int idChat) {
		Utilisateur utilisateur = entityManager.find(Utilisateur.class, idUtilisateur);
		Chat chat = entityManager.find(Chat.class, idChat);
		if (utilisateur.getAbonnements().contains(chat)) {
			chat.setLikes(chat.getLikes()+1);
		}
	}

	@Override
	public void aimerContenu(int idUtilisateur, int idContenu) {
		Utilisateur utilisateur = entityManager.find(Utilisateur.class, idUtilisateur);
		Contenu contenu = entityManager.find(Contenu.class, idContenu);
		if (utilisateur.getAbonnements().contains(contenu.getSujet())) {
			contenu.setLikes(contenu.getLikes()+1);
		}
	}
}