<%@ page language="java"  import="java.util.Collection" import="onlycat.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="onlycats.css">
<title>Page d'utilisateur</title>
</head>
<body>
	<% 
	Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur"); 
	if (utilisateur == null) {
		System.err.println("Le paramètre \"utilisateur\" n'a pas été transmis.");
	} else {
	%>
	Utilisateur : <%= utilisateur.getPrenom() %> <%= utilisateur.getNom() %> (<%= utilisateur.getPseudo() %>) Cagnotte <%= utilisateur.getCagnotte() %><br/>
		<ol>
		<% 
		for (Abonnement abonnement : utilisateur.getAbonnements()) { 
			Chat chat = abonnement.getChat();
		%>
		<li> <%= chat.getNom() %> <br/> <%= chat.getDescription() %></li>
			<ol>
			<%
			for (Contenu contenu : chat.getFil()) {
			%>
			<li>
			<%= contenu.getTitre() %>
				<ul>
				<%
					for (onlycat.Message message : contenu.getMessages()) {
				%>
				<li>
				<%= message.getExpediteur().getPseudo() %> : <%= message.getTexte() %>
				</li>
				<%
				}
				%>
				</ul>
			</li>
			<%
			}
			%>
			</ol>
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