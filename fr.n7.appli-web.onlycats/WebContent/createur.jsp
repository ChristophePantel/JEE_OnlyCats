<%@ page language="java" import="java.util.Collection" import="fr.n7.onlycats.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="onlycats.css">
<title>Page de créateur</title>
</head>
<body>
	<% 
	Createur createur  = (Createur) request.getAttribute("createur"); 
	if (createur == null) {
		System.err.println("Le paramètre créateur n'a pas été transmis.");
		%>
		<a href ="index.html">Retour</a>
		<%
	} else {
	%>
	<div class="createur">
		Créateur : <%= createur.getPrenom() %> <%= createur.getNom() %> (<%= createur.getPseudo() %>) Cagnotte <%= createur.getCagnotte() %><br/>
	</div>	
	<div class="chats">
		<ol>
		<% 
		for (Chat chat : createur.getChats()) { 
		%>
		<li> <div class="chat"> <%= chat.getNom() %> <br/> <%= chat.getDescription() %> </div> </li>
		<%
		}
		%>
		</ol>
	</div>
	<div class="formulaireContenu">
		<form action="Controleur" method="post">
			<input type="hidden" name="operation" value="ajouterContenu">
			Titre : <input type="text" name="titre"/>
			<br/>
			Texte : <input type="text" name="texte"/>
			<br/>
			URL (pour image ou vidéo) : <input type="text" name="url"/>
			<br/>
			<input type ="radio" name="nature" value="image"> Image
			<br/>
			<input type ="radio" name="nature" value="texte"> Texte
			<br/>
			<input type ="radio" name="nature" value="video"> Vidéo
			<br/>
			<input type="submit" value="Poster">
		</form>
	</div>
	<div class="formulaireChat">
		<form action="Controleur" method="post">
			<input type="hidden" name="operation" value="ajouterChat">
			Nom : <input type="text" name="nom"/>
			<br/>
			Description : <input type="text" name="description"/>
			<br/>
			Prix : <input type="text" name="prix"/>
			<br/>
			<input type="submit" value="Créer chat">		
		</form>
		<a href ="Controleur?operation=deconnecter">Se déconnecter</a>
		<br/>
	</div>
	<%
	}
	%>
</body>
</html>