/**
 * 
 */
package fr.n7.onlycats;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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
	public void ajouterProfil(String prenom, String nom, String pseudo, String adresse, String motPasse, int cagnotte, 
			boolean nature) {
		Profil profil = profilParPseudo(pseudo);
		if (profil == null) {
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
			profil.setCagnotte(cagnotte);
			entityManager.persist(profil);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void ajouterTag(String nom) {
		Tag tag = new Tag();
		tag.setNom(nom);
		entityManager.persist(tag);
	}

	@Override
	public void ajouterChat(String nom, String description, int prix, int idCreateur) {
		Createur createur = entityManager.find(Createur.class, idCreateur);
		Chat chat = new Chat();
		chat.setNom(nom);
		chat.setDescription(description);
		chat.setPrix(prix);
		chat.setProprietaire(createur);
		entityManager.persist(chat);
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
	public void posterTexte(int idChat, int idCreateur, String titre, String texte, Date date) {
		Createur createur = entityManager.find(Createur.class, idCreateur);
		Chat chat = entityManager.find(Chat.class, idChat);
		log("Poster texte pour " + idChat + " par " + idCreateur);
		if (chatConnu(createur.getChats(),chat)) {
			Texte contenu = new Texte();
			contenu.setTitre(titre);
			contenu.setTexte(texte);
			contenu.setDate(date);
			contenu.setSujet(chat);
			entityManager.persist(contenu);
		}
	}

	@Override
	public void posterImage(int idChat, int idCreateur, String titre, String url, Date date) {
		Createur createur = entityManager.find(Createur.class, idCreateur);
		Chat chat = entityManager.find(Chat.class, idChat);
		log("Poster image pour " + idChat + " par " + idCreateur);
		if (chatConnu(createur.getChats(),chat)) {
			Image contenu = new Image();
			contenu.setTitre(titre);
			contenu.setUrl(url);
			contenu.setDate(date);
			contenu.setSujet(chat);
			entityManager.persist(contenu);
		}
	}

	@Override
	public void posterVideo(int idChat, int idCreateur, String titre, String url, Date date) {
		Createur createur = entityManager.find(Createur.class, idCreateur);
		Chat chat = entityManager.find(Chat.class, idChat);
		log("Poster video pour " + idChat + " par " + idCreateur);
		if (chatConnu(createur.getChats(),chat)) {
			Video contenu = new Video();
			contenu.setTitre(titre);
			contenu.setUrl(url);
			contenu.setDate(date);
			contenu.setSujet(chat);
			entityManager.persist(contenu);
		}
	}

	@Override
	public void abonnerChat(int idUtilisateur, int idChat) {
		Chat chat = entityManager.find(Chat.class, idChat);
		Utilisateur utilisateur = entityManager.find(Utilisateur.class, idUtilisateur);
		if (chat.accepter(utilisateur)) {
			Abonnement abonnement = new Abonnement();
			abonnement.setChat(chat);
			abonnement.setAbonne(utilisateur);
			entityManager.persist(abonnement);
		}
	}
	
	public boolean profilConnu(Collection<Profil> profils, Profil candidat) {
		for (Profil profil : profils) {
			if (candidat.getIdentificateur() == profil.getIdentificateur()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean chatConnu(Collection<Chat> chats, Chat candidat) {
		for (Chat chat : chats) {
			if (candidat.getIdentificateur() == chat.getIdentificateur()) {
				return true;
			}
		}
		return false;
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
	public Profil authentifierUtilisateurParPseudo(String pseudo, String motDePasse) {
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
		Collection<Chat> resultat = new ArrayList<Chat>();
		for (Abonnement abonnement : utilisateur.getAbonnements()) {
			resultat.add(abonnement.getChat());
		}
		return resultat;
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
	public Collection<Chat> listerChats() {
		return entityManager.createQuery("from Chat", Chat.class).getResultList();
	}

	@Override
	public Collection<Abonnement> listerAbonnements() {
		return entityManager.createQuery("from Abonnement", Abonnement.class).getResultList();
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

	@Override
	public void tester() {
		final int NBR_CREATEURS = 2;
		final int NBR_UTILISATEURS = 4;
		final int NBR_CONTENU = 2;
		Createur createurs[] = new Createur[NBR_CREATEURS];
		Utilisateur utilisateurs[] = new Utilisateur[NBR_UTILISATEURS];
		Chat chats[][] = new Chat[NBR_CREATEURS][];
		for (int i = 0; i < NBR_CREATEURS; i++) {
			String prenom = "PN" + i;
			String nom = "N" + i;
			String pseudo = "P" + i;
			String motDePasse = "mp" + i;
			String adresse = "PN" + i + ".N" + i + "@n7.fr";
			Createur profil = new Createur();
			profil.setPrenom(prenom);
			profil.setNom(nom);
			profil.setPseudo(pseudo);
			profil.setAdresse(adresse);
			profil.setMotDePasse(motDePasse);
			createurs[i] = profil;
			entityManager.persist(profil);
			chats[i] = new Chat[NBR_UTILISATEURS];
			for (int j = 0; j < NBR_UTILISATEURS; j++) {
				String nomChat = "C" + j + "_" + i;
				String description = "Description de " + nomChat + "\n";
				Chat chat = new Chat();
				chat.setNom(nomChat);
				chat.setDescription(description);
				chat.setPrix(i+j);
				chat.setProprietaire(profil);
				entityManager.persist(chat);
				chats[i][j] = chat;
				for (int k = 0; k < NBR_CONTENU; k++) {
					Image image = new Image();
					image.setTitre("image_" + i + "_" + j + "_" + k);
					image.setSujet(chat);
					entityManager.persist(image);
					Texte texte = new Texte();
					texte.setTitre("texte_" + i + "_" + j + "_" + k);
					texte.setSujet(chat);
					entityManager.persist(texte);
					Video video = new Video();
					video.setTitre("video_" + i + "_" + j + "_" + k);
					video.setSujet(chat);
					entityManager.persist(video);
				}
			}
		}
		for (int k = 0; k < NBR_UTILISATEURS; k++) {
			int i = NBR_CREATEURS + k;
			String prenom = "PN" + i;
			String nom = "N" + i;
			String pseudo = "P" + i;
			String motDePasse = "mp" + i;
			String adresse = "PN" + i + ".N" + i + "@n7.fr";
			int cagnotte = i;
			Utilisateur profil = new Utilisateur();
			profil.setPrenom(prenom);
			profil.setNom(nom);
			profil.setPseudo(pseudo);
			profil.setAdresse(adresse);
			profil.setMotDePasse(motDePasse);
			profil.setCagnotte(cagnotte);
			utilisateurs[k] = profil;
			entityManager.persist(profil);
			for (int j = 0; j < NBR_CREATEURS; j++) {
				Abonnement abonnement = new Abonnement();
				abonnement.setChat(chats[j][k]);
				abonnement.setAbonne(profil);
				entityManager.persist(abonnement);
			}
		}
	}

	@Override
	public Profil profilParPseudo(String pseudo) {
		Profil profil = null;
		String query = "select p from Profil p where pseudo = \'" + pseudo + "\'";
		log(query);
		TypedQuery<Profil> requete = entityManager.createQuery(
				query,
				Profil.class);
		if (requete.getResultList().size() == 1) {
			return requete.getSingleResult();
		} else {
			return null;
		}
	}

	@Override
	public void log(String message) {
		System.err.println(message);
	}

}
