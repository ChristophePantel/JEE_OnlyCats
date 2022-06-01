<%@ page language="java" import="java.util.Collection" import="fr.n7.onlycats.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lister les créateurs</title>
</head>
<body>
		<%
		Collection<Createur> createurs = (Collection<Createur>) request.getAttribute("createurs"); 
			if (createurs == null) {
				System.err.println("Le paramètres créateurs n'a pas été transmis.");
			} else {
		%>
				Créateurs : </br>
				<ul>
				<%
				for(Createur createur : createurs) {
					out.println("<li>" + createur.getNom() + ", " + createur.getPrenom() + "</li>");
					Collection<Chat> chats = createur.getChats();
					%>
					<ol>
					<%
					for(Chat chat : chats) {
						out.println("<li>" + chat.getNom() + "</li>");
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