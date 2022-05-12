package fr.n7.onlycats;

import java.util.Collection;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Session Bean implementation class Facade
 * Methods are called from servlet with parameters transmitted by HTTP GET/POST requests.
 * Parameters are thus base types (character strings, integers, etc).
 * Objects are refered by their identifiers (integer value).
 */
@Singleton
public class FacadeImpl implements RemoteFacade {

	// Map<Integer,Profil> utilisateurs;
	// Map<Integer, Chat> chats;
	
	@PersistenceContext(unitName = "OnlyCats")
	EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public FacadeImpl() {
        // TODO Auto-generated constructor stub
		/// this.utilisateurs = new HashMap<Integer,Personne>();
		// this.adresses = new HashMap<Integer, Adresse>();
    }

	@Override
	public void ajoutChat(String nom) {
		Chat chat = new Chat();
		chat.setNom(nom);
		entityManager.persist(chat);
		
	}

	@Override
	public void ajoutMessage(String texte, int idExpediteur, int idFilDiscussion) {
		// TODO Auto-generated method stub
		Message message = new Message();
		message.setContenuMessage(texte);
		Profil expediteur =  entityManager.find(Profil.class, idExpediteur);
		FilDiscussion fil = entityManager.find(FilDiscussion.class, idFilDiscussion);
		fil.getFil().add(message);
	}

	@Override
	public void ajoutProfil(String prenom, String nom, String nomUtilisateur, boolean nature) {
		Profil profil = null;
		if (nature) {
			profil = new ProfilCreateur();
		} else {
// TODO			profil = new ProfilUtilisateur();
		}
		profil.setPrenom(prenom);
		profil.setNom(nom);
		profil.setNomUtilisateur(nomUtilisateur);
		entityManager.persist(profil);
		
	}

	@Override
	public void ajoutTag(String hashtag, int idChat) {
		// TODO Auto-generated method stub
		Tag tag = new Tag();
		tag.setTag(hashtag);
		Chat chat = entityManager.find(Chat.class, idChat);
		chat.getTags().add(tag);
	}

	@Override
	public void ajoutContenuTexte(String texte, int idFilContenu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajoutContenuImage(int idImage, int idFilContenu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Chat> obtenirChatsPagePrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Chat> obtenirChatsProfil() {
		// TODO Auto-generated method stub
		return null;
	}

}
