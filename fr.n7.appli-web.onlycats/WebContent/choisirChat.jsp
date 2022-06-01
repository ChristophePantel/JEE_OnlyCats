<%@ page language="java" import="java.util.Collection" import="fr.n7.onlycats.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="onlycats.css">
<title>Lister les chats</title>
</head>
<body>
	<%
	Collection<Chat> chats = (Collection<Chat>) request.getAttribute("chats"); 
	if (chats == null) {
		System.err.println("Le paramètres chats n'a pas été transmis.");
	%>
		<a href ="index.html">Retour</a>
	<%
	} else {
		if (chats.size() > 0) {
	%>
		Chats : </br>
		<form action="Controleur" method="post">
			<input type="hidden" name="operation" value="abonnerChat">
			<%
			for(Chat chat : chats) {
			%>
			<input type="radio" name="chat" value="<%= chat.getIdentificateur() %>"/> <%= chat.getNom() %> de <%= chat.getProprietaire().getPseudo() %>
			<br/>
			<%
			}
			%>
			<input type="submit" value="S'abonner">
		</form>
	<%
		}
	}
	%>
</body>
</html>