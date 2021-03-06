<%@ page language="java" import="java.util.Collection" import="onlycat.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="onlycats.css">
<title>Lister les créateurs</title>
</head>
<body>
		<%
		Collection<Utilisateur> utilisateurs = (Collection<Utilisateur>) request.getAttribute("utilisateurs"); 
			if (utilisateurs == null) {
				System.err.println("Le paramètres utilisateurs n'a pas été transmis.");
			%>
				<a href ="index.html">Retour</a>
			<%
			} else {
		%>
				Utilisateurs : </br>
				<ul>
				<%
					for(Utilisateur utilisateur : utilisateurs) {
							out.println("<li>" + utilisateur.getNom() + ", " + 	utilisateur.getPrenom() + "</li>");
							Collection<onlycat.Abonnement> abonnements = utilisateur.getAbonnements();
				%>
					<ol>
					<%
						for(onlycat.Abonnement abonnement : abonnements) {
									out.println("<li>" + abonnement.getChat().getNom() + "</li>");
								}
					%>
					</ol>
					<%
				}
				%>
				</ul>
				<br/>
				<a href ="index.html">Retour</a>
		<%
			}
		%>
</body>
</html>