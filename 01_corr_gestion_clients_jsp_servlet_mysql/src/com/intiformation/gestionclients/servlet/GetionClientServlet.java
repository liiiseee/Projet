package com.intiformation.gestionclients.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.intiformation.gestionclients.dao.ClientDaoImpl;
import com.intiformation.gestionclients.dao.IClientDAO;
import com.intiformation.gestionclients.model.Client;

/**
 * la servlet pour la gestion du client <br/>
 * 
 * @author INTIFORMATION
 *
 */
@WebServlet(name = "GetionClientServlet", urlPatterns = { "/gestion-client-servlet" })
public class GetionClientServlet extends HttpServlet {

	// dao du client
	private IClientDAO clientDAO = new ClientDaoImpl();

	/**
	 * m�thode doGet()
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		/**
		 * Traitement des requetes : 1. modification => url :
		 * http://localhost:8080/gestion-clients
		 * /gestion-client-servlet?action=modif&id-client=1
		 */

		// 1. r�cup de la valeur du param�tre 'action'
		String userAction = request.getParameter("action");

		// 2. test de la valeur du param action
		switch (userAction) {

		// traitement de la requete venant de accueil.jsp (lien modifier)
		case "modif":

			// r�cup l'id du client � modifier � partir de la requete
			int idClient = Integer.parseInt(request.getParameter("id-client"));

			// r�cup du client par son id
			Client client = clientDAO.getClientById(idClient);
			
			System.out.println("client get by id servlet ----------- : " + client);

			// redirection vers la page 'modifier-client.jsp' pour afficher
			// le client � modifier dans un formulaire

			request.setAttribute("client-modif", client);

			request.getRequestDispatcher("/modifier-client.jsp").forward(request, response);

			break;
		
		// cas : suppression d'un client (ref accueil.jsp - lien supprimer )
		//-> url de la requete : http://localhost:8080/gestion-clients/gestion-client-servlet?action=supp&id-client=1
		case "supp":
			
			// r�cup l'id du client � supprimer � partir de la requete
			int idClientSupp = Integer.parseInt(request.getParameter("id-client"));
			
			// appel de la dao pour la suppression du client 
			clientDAO.supprimerClientById(idClientSupp);
			
			// redirection vers la page 'accueil.jsp'
			// r�cup de la nouvelle liste des clients + ajout de la liste dans la requete 
			request.setAttribute("liste_clients", clientDAO.getAllClients());
			
			request.getRequestDispatcher("/accueil.jsp").forward(request, response);
			
			break;

		default:
			break;
		}

	}// end doGet()

	/**
	 * m�thode doPost()
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. r�cup de la valeur du param�tre 'action'
		String userAction = request.getParameter("action");

		// 2. test de la valeur du param action
		switch (userAction) {

		// cas : ajout d'un client => ref ajouter-client.jsp
		case "ajout":

			// r�cup des param�tres de la requete (saisie du formulaire)
			String nom = request.getParameter("pNom");
			String prenom = request.getParameter("pPrenom");
			String adresse = request.getParameter("pAdresse");
			String codePostal = request.getParameter("pCodePostal");
			String ville = request.getParameter("pVille");
			String telephone = request.getParameter("pTelephone");

			// chargmenet des donn�es dans un objet Client
			Client client = new Client(nom, prenom, adresse, codePostal, ville, telephone);

			// appel de la dao pour ajouter le client dans la bdd
			clientDAO.ajouterClient(client);

			// redirection vers la page 'accueil.jsp' + sauvegarde de la nouvelle liste de
			// client dans la requete
			List<Client> listeClients = clientDAO.getAllClients();

			request.setAttribute("liste_clients", listeClients);

			request.getRequestDispatcher("/accueil.jsp").forward(request, response);

			break;

		// cas : modifier un client => ref modifier-client.jsp
		case "modification":

			// r�cup des param�tres de la requete (saisie du formulaire)
			int idClient = Integer.parseInt(request.getParameter("pIdClient")) ;
			nom = request.getParameter("pNom");
			prenom = request.getParameter("pPrenom");
			adresse = request.getParameter("pAdresse");
			codePostal = request.getParameter("pCodePostal");
			ville = request.getParameter("pVille");
			telephone = request.getParameter("pTelephone");

			// chargmenet des donn�es dans un objet Client
			Client clientUp = new Client(idClient,nom, prenom, adresse, codePostal, ville, telephone);

			// appel de la dao pour modifier le client dans la bdd
			clientDAO.modifierClient(clientUp);

			// redirection vers la page 'accueil.jsp' + sauvegarde de la nouvelle liste de
			// client dans la requete

			request.setAttribute("liste_clients", clientDAO.getAllClients());

			request.getRequestDispatcher("/accueil.jsp").forward(request, response);

			break;

		default:
			break;

		}// end switch

	}// end doPost()

}// end class
