package com.intiformation.gestion.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.intiformation.gestion.dao.ClientDAOImpl;
import com.intiformation.gestion.dao.ConseillerDAOImpl;
import com.intiformation.gestion.dao.IClientDAO;
import com.intiformation.gestion.dao.IConseillerDAO;
import com.intiformation.gestion.model.Client;
import com.intiformation.gestion.model.Compte;
import com.intiformation.gestion.model.Conseiller;
import com.intiformation.gestion.dao.CompteDaoImpl;
import com.intiformation.gestion.dao.ICompteDAO;

@WebServlet(name = "GestionClientServlet", urlPatterns = {"/gestion-client-servlet"} )
public class GestionClientServlet extends HttpServlet{
	
	// dao du client
		IClientDAO clientDAO = new ClientDAOImpl();
		IConseillerDAO conseillerDAO = new ConseillerDAOImpl();
		ICompteDAO compteDAO =new CompteDaoImpl();

/*=======================================m�thodes ==============================================*/
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String userAction = request.getParameter("action");
			switch (userAction) {
		case "modifier":

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
			
		case "supp":
			// r�cup l'id du client � supprimer � partir de la requete
						int idClientSupp = Integer.parseInt(request.getParameter("id-client"));
						
						// appel de la dao pour la suppression du client 
						clientDAO.deleteClient(idClientSupp);
						
						// redirection vers la page 'accueil.jsp'
						// r�cup de la nouvelle liste des clients + ajout de la liste dans la requete 
						HttpSession session = request.getSession(false);
						Conseiller conseiller = (Conseiller) session.getAttribute("conseillerLogged");
					
						double iDConseiller = conseiller.getIdConseiller();
						request.setAttribute("liste_clients", clientDAO.getClientByIdConseiller(iDConseiller));
						
						request.getRequestDispatcher("/supprimer-client.jsp").forward(request, response);
						
						break;
						
		case "afficher":
			
			// R�cup�ration du client � afficher par son identifiant (parametre)
			int idClientAfficher =Integer.parseInt(request.getParameter("id-client"));
			Client clientrecherche = clientDAO.getClientById(idClientAfficher);
			
			//Verif si le client existe
			if(clientrecherche==null) {
				request.setAttribute("reussiteOperation", "false");
				request.setAttribute("message", "Ce client n'existe pas.");	
			}else {
				// sauvegarde du client et de son identifiant comme attribut de la requete
				request.setAttribute("clientRecherche", clientrecherche);
				request.setAttribute("pIdClient", idClientAfficher);
				//Envoie du l'identifiant du conseiller en argument
				request.setAttribute("pIdConseiller", clientrecherche.getConseillerId());
			}
			
			
			
			
			//Envoie de la requete vers la page chercher-client.jsp
			request.getRequestDispatcher("/chercher-client.jsp").forward(request, response);

			break;
						
		case "afficheProprietaire":
			
			// R�cup�ration du client propri�taire par son ID 
			int idProprietaire =Integer.parseInt(request.getParameter("id-client"));
			
			//Verif si le compte a un propri�taire
			if(idProprietaire==0) {
				request.setAttribute("reussiteOperation", "false");
				request.setAttribute("message", "Ce compte n'est attribu� � aucun client.");

			}else {
				//V�rif si le client existe
				Client proprietaire = clientDAO.getClientById(idProprietaire);
				
				if(proprietaire==null) {
					request.setAttribute("reussiteOperation", "false");
					request.setAttribute("message", "L'identifiant client de ce compte ne correspond � aucun client.");	
				}else {
					// sauvegarde du client et de son identifiant comme attribut de la requete
					request.setAttribute("pPropretaire", proprietaire);
				}//end else	
			}//end else
			
			
			//R�cup�ration du compte pour le r�afficher et sauvegarde en attribut
			int idCompteAfficher =Integer.parseInt(request.getParameter("id-compte"));
			Compte compterecherche = compteDAO.getCompteByID(idCompteAfficher);
		
			request.setAttribute("compteRecherche", compterecherche);
			request.setAttribute("pIdCompte", idCompteAfficher);
			
			//Envoie de la requete vers la page chercher-compte.jsp
			request.getRequestDispatcher("/recherche-compte.jsp").forward(request, response);

			
			break;
			
	
			
		default:
			break;
		}
		
		}// end doGet

		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String userAction = request.getParameter("action");
			
			switch (userAction) {
			case "gererClient":
				
				
				request.getRequestDispatcher("/menu-client.jsp").forward(request, response);
				
				break;
				
			case "liste" :
				
				HttpSession session = request.getSession(false);
				Conseiller conseiller = (Conseiller) session.getAttribute("conseillerLogged");
			
				double iDConseiller = conseiller.getIdConseiller();
				
				List<Client> listeClientsBdd = clientDAO.getClientByIdConseiller(iDConseiller);
				
				/* 3.1.2.2 sauvegarde de la liste des client dans la requet ---*/
				request.setAttribute("liste_clients", listeClientsBdd);

				request.getRequestDispatcher("/liste-clients.jsp").forward(request, response);
				
				break;//end afficher
				
			case "modif":
				session = request.getSession(false);
				conseiller = (Conseiller) session.getAttribute("conseillerLogged");
			
				iDConseiller = conseiller.getIdConseiller();
				List<Client> listeClientsBd = clientDAO.getClientByIdConseiller(iDConseiller);
				
				/* 3.1.2.2 sauvegarde de la liste des client dans la requet ---*/
				request.setAttribute("liste_clients", listeClientsBd);
				request.getRequestDispatcher("/menu-modifier-client.jsp").forward(request, response);
				

				break;
			
			
		case "modification":
			// r�cup des param�tres de la requete (saisie du formulaire)
						int idClient = Integer.parseInt(request.getParameter("pIdClient"));
						String nom = request.getParameter("pNom");
						String prenom = request.getParameter("pPrenom");
						String adresse = request.getParameter("pAdresse");
						String ville = request.getParameter("pVille");
						String codePostal = request.getParameter("pCodePostal");
						String telephone = request.getParameter("pTelephone");
						double idConseiller = Double.parseDouble(request.getParameter("pConseillerID"));

						// chargmenet des donn�es dans un objet Client
						Client clientUp = new Client(idClient, nom, prenom, adresse, ville, codePostal, telephone, idConseiller);

						// appel de la dao pour modifier le client dans la bdd
						clientDAO.updateClient(clientUp);

						// redirection vers la page 'menu-modifier-client.jsp' + sauvegarde de la nouvelle liste de
						// client dans la requete
						session = request.getSession(false);
						conseiller = (Conseiller) session.getAttribute("conseillerLogged");
					
						iDConseiller = conseiller.getIdConseiller();

						request.setAttribute("liste_clients", clientDAO.getClientByIdConseiller(iDConseiller));

						request.getRequestDispatcher("/menu-modifier-client.jsp").forward(request, response);
			
			break;
			
		case "ajout":
			request.getRequestDispatcher("/ajout-client.jsp").forward(request, response);
			
			break;
			
			
		case "ajouter":
			nom = request.getParameter("pNom");
			prenom = request.getParameter("pPrenom");
			adresse = request.getParameter("pAdresse");
			ville = request.getParameter("pVille");
			codePostal = request.getParameter("pCodePostal");
			telephone = request.getParameter("pTelephone");
			idConseiller = Double.parseDouble(request.getParameter("pConseillerID"));

			// chargmenet des donn�es dans un objet Client
			Client client = new Client(nom, prenom, adresse, ville, codePostal, telephone, idConseiller);

			// appel de la dao pour ajouter le client dans la bdd
			clientDAO.addClient(client);

			// redirection vers la page 'accueil.jsp' + sauvegarde de la nouvelle liste de
			// client dans la requete
			
			session = request.getSession(false);
			conseiller = (Conseiller) session.getAttribute("conseillerLogged");
		
			iDConseiller = conseiller.getIdConseiller();
			List<Client> listeClients = clientDAO.getClientByIdConseiller(iDConseiller);
		

			request.setAttribute("liste_clients", listeClients);

			request.getRequestDispatcher("/liste-clients.jsp").forward(request, response);
			
			break;
			
		case "supprimer" :
			session = request.getSession(false);
			conseiller = (Conseiller) session.getAttribute("conseillerLogged");
		
			iDConseiller = conseiller.getIdConseiller();
			List<Client> listeClientsB = clientDAO.getClientByIdConseiller(iDConseiller);
			
			/* 3.1.2.2 sauvegarde de la liste des client dans la requet ---*/
			request.setAttribute("liste_clients", listeClientsB);
			request.getRequestDispatcher("/supprimer-client.jsp").forward(request, response);
			
			break;
			
		case "chercher":
			//R�cuperation du client par son identifiant (parametre)
			idClient = Integer.parseInt(request.getParameter("pIdClient"));
			Client clientrecherche = clientDAO.getClientById(idClient);
			
			
			//Test si le client existe
			if(clientrecherche==null) {
				request.setAttribute("reussiteOperation", "false");
				request.setAttribute("message", "Ce client n'existe pas.");	
			}else {
				//Sauvegarde du client comme attribut de la requete
				request.setAttribute("clientRecherche", clientrecherche);
				request.setAttribute("pIdClient", idClient);
			}
			
			//Redirection vers la page 'chercher-compte.jsp'
			request.getRequestDispatcher("/chercher-client.jsp").forward(request, response);
			
			break;
			
		default:
			break;
		}// end switch
			
			
		}// end doPost()
		
		

}