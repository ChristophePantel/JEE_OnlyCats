package fr.n7.onlycats;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controleur
 */
@WebServlet("/Controleur")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	FacadeBD facade;

    /**
     * Default constructor. 
     */
    public Controleur() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Servis par : ").append(request.getContextPath());
		String operation = request.getParameter("operation");
		if (operation == null) {
			System.err.println("Le servlet Controleur a reçu une requête sans paramètre operation.");
		} else {
			switch(operation) {
			case "ajouterProfil":
				String prenom = request.getParameter("prenom");
				String nom = request.getParameter("nom");
				String pseudo = request.getParameter("pseudo");
				String adresse = request.getParameter("adresse");
				String motDePasse = request.getParameter("motDePasse");
				String nature = request.getParameter("nature");
				boolean createur = false;
				switch (nature) {
				case "createur" :
					createur = true;
					break;
				case "utilisateur" :
					createur = false;
					break;
				}
				facade.ajouterProfil(prenom, nom, pseudo, adresse, motDePasse, createur);;
				request.getRequestDispatcher("index.html").forward(request, response);
				break;
			case "ajouterUtilisateur":
				break;
			case "listerCreateur":
				break;
			case "listerUtilisateur":
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
