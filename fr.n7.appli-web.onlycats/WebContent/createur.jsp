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
	} else {
	%>
	Créateur : <%= createur.getPrenom() %> <%= createur.getNom() %> (<%= createur.getPseudo() %>) Cagnotte <%= createur.getCagnotte() %><br/>
		<ol>
		<% 
		for (Chat chat : createur.getChats()) { 
		%>
		<li> <%= chat.getNom() %> <br/> <%= chat.getDescription() %></li>
		<%
		}
		%>
		</ol>
		<a href ="Controleur?operation=ajouterChat">Ajouter Chat</a>
	<%
	}
	%>
</body>
</html>