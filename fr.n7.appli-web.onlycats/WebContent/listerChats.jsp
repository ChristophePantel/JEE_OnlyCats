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
		%>
				Chats : </br>
				<ul>
				<%
				for(Chat chat : chats) {
					out.println("<li>" + chat.getNom() + "(" + chat.getDescription() + ") : " + chat.getProprietaire().getPseudo() + "</li>");
					Collection<Contenu> contenus = chat.getFil();
					%>
					<ol>
					<%
					for(Contenu contenu : contenus) {
						out.println("<li>" + contenu.getTitre() + "(" + contenu.getLikes() + ")" + "</li>");
					}
					%>
					</ol>
					<%
				}
				%>
				</ul>
		<%
			}
		%>
</body>
</html>