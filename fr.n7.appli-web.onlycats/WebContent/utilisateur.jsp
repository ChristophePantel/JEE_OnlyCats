<%@ page language="java"  import="java.util.Collection" import="fr.n7.onlycats.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--  <link rel="stylesheet" type="text/css" href="onlycats.css"> -->
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
		<%
		if (utilisateur.getAbonnements().size() > 0) {
		%>
			<ol>
			<% 
			for (Abonnement abonnement : utilisateur.getAbonnements()) { 
				Chat chat = abonnement.getChat();
			%>
				<li> 
					<%= chat.getNom() %> <br/> <%= chat.getDescription() %>
					<%
					if (chat.getFil().size() > 0) {
					%>
						<ol>
						<%
						for (Contenu contenu : chat.getFil()) {
						%>
							<li>
							<%= contenu.getTitre() %> (<%= contenu.getLikes() %>)
							<% 
							if (contenu.getMessages().size() > 0) {
							%>
								<ul>
								<%
								for (Message message : contenu.getMessages()) {
								%>
								<li>
								<%= message.getExpediteur().getPseudo() %> : <%= message.getTexte() %>
								</li>
								<%
								}
								%>
								</ul>
							<%
							}
							%>
							</li>
						<%
						}
						%>
						</ol>
					<%
					}
					%>
				</li>
			<%
			}
			%>
			</ol>
		<% 
		}
		%>
		
	<%
	}
	%>
	
	<br/>
	
	<a href ="Controleur?operation=choisirChat">S'abonner à un nouveau chat</a>
	
	<br/>
	
	<a href ="Controleur?operation=deconnecter">Se déconnecter</a>
</body>
</html>