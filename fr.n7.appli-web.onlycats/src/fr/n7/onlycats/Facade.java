package fr.n7.onlycats;

import java.util.Collection;

public interface Facade {

	public void ajoutChat(String nom);
	
	public void ajoutMessage(String texte, int idExpediteur, int idFilDiscussion);
	
	public void ajoutProfil(String prenom, String nom, String nomUtilisateur, boolean nature);
	
	public void ajoutTag(String tag, int idChat);
	
	public void ajoutContenuTexte(String texte, int idFilContenu);

	public void ajoutContenuImage(int idImage, int idFilContenu);
	
	public Collection<Chat> obtenirChatsPagePrincipal();

	public Collection<Chat> obtenirChatsProfil();
	
}
