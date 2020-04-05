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
 * servlet pour gestion du client
 * @author IN-DF-029
 *
 */
@WebServlet(name="GestionClientServlet", urlPatterns = {"/gestion-client-servlet"})
public class GestionClientServlet extends HttpServlet{
	
	// dao du client
		private	IClientDAO clientDAO = new ClientDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * Traitement des requ�tes :
		 *  1. modification => url : http://localhost:8080/gestion-clients/gestion-client-servlet?action=modif&id-client=1
		 */
		
		
		// 1. r�cup de la valeur du param action
		String userAction = request.getParameter("action");
		
		// 2. tes de la valeur
		switch (userAction) {
		
		// tratiement de la requ venant de accueil. jsp (lien modifier)
		case "modif":
			// r�cup de l'id du client ) modifier � patir de la requ�te
			int idClient = Integer.parseInt(request.getParameter("id-client"));
			
			// r�cup client par id
			Client client = clientDAO.getClientById(idClient);
			
			// redirection vers 'modifier-client.jsp' pour afficher le client � modif
			request.setAttribute("client-modif", client);
			
			request.getRequestDispatcher("/modifier-client.jsp").forward(request, response);
			
			
			
			
			break;
			
			// cas : suppression d'un client (ref accueil.jsp - lien supprimer)
			//-> url : http://localhost:8080/gestion-clients/gestion-client-servlet?action=supp&id-client=1
		case "supp":
			
			// r�cup id client � supprimer
			int idClientSupp = Integer.parseInt(request.getParameter("id-client"));
			
			// appel de la dao pour la supp� du client
			clientDAO.supprimerClient(idClientSupp);
			
			// redirection vers la page 'accueil.jsp'
			// r�cup de la nouvelle liste des client + ajout de la liste dans la req
			request.setAttribute("liste_clients", clientDAO.getAllClients());
			
			request.getRequestDispatcher("/accueil.jsp").forward(request, response);
			
			break;
			
		
		

		default:
			break;
		}
		
		
	}// end doGet()
	
	
	/*==============================================*/

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. r�cup de la valeur du param 'action'
		String userAction = request.getParameter("action");
		
		
		
		// 2. v�rif de la valeur du param action
		switch (userAction) {
		case "ajout": // si action = ajout
			// r�cup des param�tres de la requ�te (saisie du formulaire)
			String nom = request.getParameter("pNom");
			String prenom = request.getParameter("pPrenom");
			String adresse = request.getParameter("pAdresse");
			String ville = request.getParameter("pVille");
			String codePostal = request.getParameter("pCodePostal");
			String telephone = request.getParameter("pTelephone");
			
			// chargement des donn�es dans un objet client
			Client client = new Client(nom, prenom, adresse, codePostal, ville, telephone);
			
			// appel de la dao pour ajouter le client dans la bdd
			clientDAO.ajouterClient(client);
			
			// redirection vers la page 'accueil.jsp' + sauvegarde de la nouvelle liste de clients dans la requ�te
			List<Client> listeClients = clientDAO.getAllClients();
			
			request.setAttribute("liste_clients", listeClients);
			
			request.getRequestDispatcher("/accueil.jsp").forward(request, response);
			
			
			break;
			
case "modification" :
	
	// r�cup des param�tres de la requ�te (saisie du formulaire)
				int idClient = Integer.parseInt(request.getParameter("pIdClient"));
				nom = request.getParameter("pNom");
				 prenom = request.getParameter("pPrenom");
				 adresse = request.getParameter("pAdresse");
				 ville = request.getParameter("pVille");
				 codePostal = request.getParameter("pCodePostal");
				 telephone = request.getParameter("pTelephone");
				
				// chargement des donn�es dans un objet client
				Client clientUp = new Client(idClient, nom, prenom, adresse, codePostal, ville, telephone);
				
				// appel de la dao pour ajouter le client dans la bdd
				clientDAO.modifierClient(clientUp);
				
				// redirection vers la page 'accueil.jsp' + sauvegarde de la nouvelle liste de clients dans la requ�te
				
				
				request.setAttribute("liste_clients", clientDAO.getAllClients());
				
				request.getRequestDispatcher("/accueil.jsp").forward(request, response);
			
			break;

		default:
			break;
		}// end switch
		
	}// end doPost()
	
	

}
