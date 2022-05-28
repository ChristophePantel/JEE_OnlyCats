package fr.n7.onlycats;

import java.util.Collection;

public interface Facade {
	
	/**
	 * ajout d'un profil pour un utilisateur
	 * @param prenom : prénom de l'utilisateur
	 * @param nom : nom de l'utilisateur
	 * @param pseudo : pseudonyme de l'utilisateur
	 * @param adresse : adresse électronique de l'utilisateur
	 * @param motDePasse : mot de passe de l'utilisateur
	 * @param nature : nature de l'utilisateur (créateur ou client)
	 */
	public void ajouterProfil(String prenom, String nom, String pseudo, String adresse, String motDePasse, boolean nature);
	
	/**
	 * Ajout d'un tag par utilisateur
	 * @param tag : tag ajouté
	 */
	public void ajouterTag(String tag);
	
	/**
	 * ajout d'un chat par un créateur
	 * @param nom : le nom du chat
	 * @param idUtilisateur : l'identifiant du créateur
	 */
	public void ajouterChat(String nom, int idUtilisateur);
	
	/**
	 * Ajout d'un tag sur un chat par un utilisateur
	 * @param idChat : l'identifiant du chat
	 * @param idUtilisateur : l'identifiant de l'utilisateur qui ajoute le tag
	 * @param idTag : l'identifiant du tag ajouté
	 */
	public void taggerChat(int idChat, int idUtilisateur, int idTag);
	
	/**
	 * Ajout d'un texte dans la liste des posts concernant un chat par un utilisateur
	 * @param idChat : l'identifiant du chat
	 * @param idUtilisateur : l'identifiant de l'utilisateur
	 * @param texte : le texte posté
	 */
	public void posterTexte(int idChat, int idUtilisateur, String texte);
	
	/**
	 * Ajout d'une image dans la liste des posts concernant un chat par un utilisateur
	 * @param idChat : l'identifiant du chat
	 * @param idUtilisateur : l'identifiant de l'utilisateur
	 * @param url : l'url de l'image postée
	 */
	public void posterImage(int idChat, int idUtilisateur, String url);
	
	/**
	 * Ajout d'une vidéo dans la liste des posts concernant un chat par un utilisateur
	 * @param idChat : l'identifiant du chat
	 * @param idUtilisateur : l'identifiant de l'utilisateur
	 * @param url : l'url de la vidéo postée
	 */
	public void posterVideo(int idChat, int idUtilisateur, String url);
	
	/**
	 * Abonnement d'un utilisateur à un chat
	 * @param idUtilisateur : l'identifiant de l'utilisateur
	 * @param idChat : l'identifiant du chat
	 */
	public void abonnerChat( int idUtilisateur, int idChat);
	
	/**
	 * Ajout d'un texte dans la liste des posts concernant un chat par un utilisateur
	 * @param idUtilisateur : l'identifiant de l'utilisateur
	 * @param idPost : l'identifiant du post auquel le message est associé
	 * @param texte : le texte posté
	 */
	public void posterMessage(int idUtilisateur, int idPost, String texte);
	
	/* Services qui fournissent les données nécessaires pour une vue particulière */
	
	public Collection<Utilisateur> listerUtilisateurs();
	
	public Collection<Createur> listerCreateurs();
	
	public int utilisateurParPseudo(String pseudo, String motDePasse);
	
	public Collection<Chat> chatParUtilisateur(int idUtilisateur);
	
	public Collection<Chat> chatParCreateur(int idCreateur);
	
}
