package fr.n7.onlycats;

import java.util.Collection;


//@Path("/")
public interface Facade {
	/*@POST
	 * @Path(/addCat)*/
	public void ajoutChat(String nom);
	
	/*@POST
	 * @Path(/addMessage)*/
	public void ajoutMessage(String texte, int idExpediteur, int idFilDiscussion);
	
	/*@POST
	 * @Path(/addProfil)*/
	public void ajoutProfil(String prenom, String nom, String nomUtilisateur, boolean nature);
	
	/*@POST
	 * @Path(/addTag)*/
	public void ajoutTag(String tag, int idChat);
	
	/*@POST
	 * @Path(/addText)*/
	public void ajoutContenuTexte(String texte, int idFilContenu);
	
	/*@POST
	 * @Path(/addImage)*/
	public void ajoutContenuImage(int idImage, int idFilContenu);
	
	/* Services qui fournissent les données nécessaires pour une vue particulière */
	
	/* Vue page principale */
	/*@Get
	 * @Path(/listCatPagePrincipal)*/
	public Collection<Chat> obtenirPostsPagePrincipal();
	// Lister les posts de tous les abonnements du profil
	
	
	/* Vue page abonné */
	public Collection<Chat> obtenirChatsProfil();
	
}
