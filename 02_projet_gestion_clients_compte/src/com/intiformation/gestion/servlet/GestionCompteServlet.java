package com.intiformation.gestion.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.intiformation.gestion.model.Client;
import com.intiformation.gestion.model.Compte;
import com.intiformation.gestion.model.Conseiller;
import com.intiformation.gestion.dao.ClientDAOImpl;
import com.intiformation.gestion.dao.CompteDaoImpl;
import com.intiformation.gestion.dao.ConseillerDAOImpl;
import com.intiformation.gestion.dao.IClientDAO;
import com.intiformation.gestion.dao.ICompteDAO;
import com.intiformation.gestion.dao.IConseillerDAO;

@WebServlet(name = "GestionCompteServlet", urlPatterns = {"/gestion-compte-servlet"} )
public class GestionCompteServlet extends HttpServlet{
	private IConseillerDAO conseillerDAO = new ConseillerDAOImpl();
	private ICompteDAO compteDAO = new CompteDaoImpl();
	IClientDAO clientDAO = new ClientDAOImpl();
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userAction = request.getParameter("action");

		// 2. test de la valeur du param action
		switch (userAction) {
		case "modif":
			// r�cup l'id du compte � modifier � partir de la requete
						int idCompte = Integer.parseInt(request.getParameter("id-compte"));

						// r�cup du compte par son id
						Compte compte = compteDAO.getByID(idCompte);
						
						
						System.out.println("compte get by id servlet ----------- : " + compte);

						// redirection vers la page 'modifier-compte.jsp' pour afficher
						// le compte � modifier dans un formulaire

						request.setAttribute("compte-modif", compte);

						request.getRequestDispatcher("/modifier-compte.jsp").forward(request, response);
						
						break;
						
			
		case "supp":
			System.out.println("dans do get supp");
			
			// r�cup l'id du compte � supprimer � partir de la requete
			int idCompteSupp = Integer.parseInt(request.getParameter("id-compte"));
			
			// appel de la dao pour la suppression du client
			compteDAO.delete(idCompteSupp);
			
			
			// redirection vers la page 'accueil.jsp'
			// r�cup de la nouvelle liste des clients + ajout de la liste dans la requete 
			HttpSession session = request.getSession(false);
			Conseiller conseiller = (Conseiller) session.getAttribute("conseillerLogged");
		
			double iDConseiller = conseiller.getIdConseiller();
			request.setAttribute("liste_comptes", compteDAO.getCompteByIdConseiller(iDConseiller));
			
			request.getRequestDispatcher("/menu-comptes.jsp").forward(request, response);
			
			break;
			
		case "depot":
			int idCompteDep = Integer.parseInt(request.getParameter("id-compte"));

			// r�cup du client par son id
			Compte compteDep = compteDAO.getByID(idCompteDep); 
			
			
			System.out.println("compte get by id servlet ----------- : " + compteDep);
			
			request.setAttribute("compte-depot", compteDep);

			request.getRequestDispatcher("/depot-compte.jsp").forward(request, response);
			
			break;
			
		case "retrait":
			int idCompteRetr = Integer.parseInt(request.getParameter("id-compte"));

			// r�cup du client par son id
			Compte compteRetr = compteDAO.getByID(idCompteRetr); 
			
			
			System.out.println("compte get by id servlet ----------- : " + compteRetr);
			
			request.setAttribute("compte-retrait", compteRetr);

			request.getRequestDispatcher("/retrait-compte.jsp").forward(request, response);
			
			break;
			
		case "virement" :
			int idCompteVir = Integer.parseInt(request.getParameter("id-compte"));

			// r�cup du client par son id
			Compte compteVir = compteDAO.getByID(idCompteVir); 
			
			
			System.out.println("compte get by id servlet ----------- : " + compteVir);
			
			request.setAttribute("compte-virement", compteVir);

			request.getRequestDispatcher("/virement-compte.jsp").forward(request, response);
			
			break;
			
		case "chercherCompte":
			//Redirection vers la page 'chercher-compte.jsp' 

			request.getRequestDispatcher("/recherche-compte.jsp").forward(request, response);
			
			break;
			
		case "getcomptes":
			
			// R�cup�ration du client � afficher par son identifiant (parametre)
			int idClient =Integer.parseInt(request.getParameter("id-client"));
			Client client = clientDAO.getClientById(idClient);
		
			// Sauvegarde du client comme attribut de la requete pour pouvoir le r�-afficher
			request.setAttribute("clientRecherche", client);
			request.setAttribute("pIdClient", idClient);
			
			// R�cup�ration de la liste des comptes du client par la m�thode getCompteByIDClient() 
			List<Compte> listeComptesClient = compteDAO.getCompteByIDClient(idClient);
			
			//Verif si le client a des comptes
			if(listeComptesClient.size()==0) {
				request.setAttribute("reussiteOperation", "false");
				request.setAttribute("message", "Ce client n'a aucun compte.");	
			}
			
			// Sauvegarde de la liste des comptes du client comme attribut de la requete
			request.setAttribute("plisteComptesClient", listeComptesClient);
			
			//Redirection vers la page 'chercher-client.jsp'
			request.getRequestDispatcher("/chercher-client.jsp").forward(request, response);
			
			break;
			
		case "afficher":
			
			// R�cup�ration du compte � afficher par son identifiant (parametre)
			int idCompteAfficher =Integer.parseInt(request.getParameter("id-compte"));
			Compte compterecherche = compteDAO.getCompteByID(idCompteAfficher);
			
			//Verif si le compte existe
			if(compterecherche==null) {
				request.setAttribute("reussiteOperation", "false");
				request.setAttribute("message", "Ce compte n'existe pas.");	
			}else {
				// sauvegarde du compte et de son identifiant comme attribut de la requete
				request.setAttribute("compteRecherche", compterecherche);
				request.setAttribute("pIdCompte", idCompteAfficher);
				
				// sauvegarde du client propri�taire en attribut
				Client client2 = clientDAO.getClientById(compterecherche.getClientID());
				request.setAttribute("pClientProprio", client2);
			}
			
			//Envoie de la requete vers la page chercher-compte.jsp
			request.getRequestDispatcher("/chercher-compte.jsp").forward(request, response);

			break;
			
	
	
		
			
		
			
			

		default:
			break;
		}
	}
		



	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userAction = request.getParameter("action");
		
		
		switch (userAction) {
		
		case "gererComptes":
			System.out.println("dans do POST");
			HttpSession session = request.getSession(false);
			Conseiller conseiller = (Conseiller) session.getAttribute("conseillerLogged");
		
			double iDConseiller = conseiller.getIdConseiller();
		
		List<Compte> listeComptesBdd = compteDAO.getCompteByIdConseiller(iDConseiller);
		
		request.setAttribute("liste_comptes", listeComptesBdd);
		request.getRequestDispatcher("/menu-comptes.jsp").forward(request, response);
			
			break;
			
		case "modification":
			System.out.println("je suis dans le do post case modification");
			int idCompte = Integer.parseInt(request.getParameter("pIdCompte")) ;
			int ClientID = Integer.parseInt(request.getParameter("pClientID")) ;
			double solde = Double.parseDouble(request.getParameter("pSolde"));
			String typeCompte = request.getParameter("pTypeCompte");
			double decouvert = Double.parseDouble(request.getParameter("pDecouvert"));
			double taux= Double.parseDouble(request.getParameter("pTaux"));
			double idConseiller = Double.parseDouble(request.getParameter("pConseillerID"));
			
			
			

			// chargmenet des donn�es dans un objet compte
			Compte compteUpd = new Compte(idCompte, solde, typeCompte, ClientID, decouvert, taux, idConseiller);
			/*Compte compteUp = new Compte(idCompte, solde, typeCompte, decouvert, taux);*/
			
			compteDAO.update(compteUpd);

			

			// redirection vers la page 'menu-comptes.jsp' + sauvegarde de la nouvelle liste de
			// compte dans la requete
			session = request.getSession(false);
			conseiller = (Conseiller) session.getAttribute("conseillerLogged");
		
			iDConseiller = conseiller.getIdConseiller();
		
		

			
			request.setAttribute("liste_comptes", compteDAO.getCompteByIdConseiller(iDConseiller));

			request.getRequestDispatcher("/menu-comptes.jsp").forward(request, response);

			break;
			
		case "ajout":
			
			
			solde = Double.parseDouble(request.getParameter("pSolde"));
			typeCompte = request.getParameter("pTypeCompte");
			taux= Double.parseDouble(request.getParameter("pTaux"));
			decouvert = Double.parseDouble(request.getParameter("pDecouvert"));
			idConseiller = Double.parseDouble(request.getParameter("pConseillerID"));
			

			// chargmenet des donn�es dans un objet Client
			Compte compte = new Compte(solde, typeCompte, decouvert, taux, idConseiller);
			
			
			compteDAO.add(compte);
			session = request.getSession(false);
			conseiller = (Conseiller) session.getAttribute("conseillerLogged");
		
			iDConseiller = conseiller.getIdConseiller();
		
			List<Compte> listeComptes = compteDAO.getCompteByIdConseiller(iDConseiller);

			

			// redirection vers la page 'accueil.jsp' + sauvegarde de la nouvelle liste de
			// client dans la requete

			request.setAttribute("liste_comptes", listeComptes);

			request.getRequestDispatcher("/menu-comptes.jsp").forward(request, response);

			break;
			
			
		case "deposer":
			idCompte = Integer.parseInt(request.getParameter("pIdCompte")) ;
			solde = Double.parseDouble(request.getParameter("pSolde"));
			typeCompte = request.getParameter("pTypeCompte");
			decouvert = Double.parseDouble(request.getParameter("pDecouvert"));
			taux= Double.parseDouble(request.getParameter("pTaux"));
			double montant = Double.parseDouble(request.getParameter("pMontant"));
			
			Compte compteDep =  new Compte(idCompte, solde, typeCompte, decouvert, taux);
			compteDAO.deposit(compteDep, montant);
			
			session = request.getSession(false);
			conseiller = (Conseiller) session.getAttribute("conseillerLogged");
		
			iDConseiller = conseiller.getIdConseiller();
		
		

			
			request.setAttribute("liste_comptes", compteDAO.getCompteByIdConseiller(iDConseiller));

			request.getRequestDispatcher("/menu-comptes.jsp").forward(request, response);
			
			
			
			break;
		
			
		case "ret":
			idCompte = Integer.parseInt(request.getParameter("pIdCompte")) ;
			solde = Double.parseDouble(request.getParameter("pSolde"));
			typeCompte = request.getParameter("pTypeCompte");
			decouvert = Double.parseDouble(request.getParameter("pDecouvert"));
			taux= Double.parseDouble(request.getParameter("pTaux"));
			montant = Double.parseDouble(request.getParameter("pMontant"));
			
			Compte compteRet =  new Compte(idCompte, solde, typeCompte, decouvert, taux);
			compteDAO.retrait(compteRet, montant);
			
			session = request.getSession(false);
			conseiller = (Conseiller) session.getAttribute("conseillerLogged");
		
			iDConseiller = conseiller.getIdConseiller();
		
		

			
			request.setAttribute("liste_comptes", compteDAO.getCompteByIdConseiller(iDConseiller));

			request.getRequestDispatcher("/menu-comptes.jsp").forward(request, response);
			
			break;
			
		case "transfert":
			idCompte = Integer.parseInt(request.getParameter("pIdCompte")) ;
			int idCompteRec = Integer.parseInt(request.getParameter("pIdCompteRecv")) ;
			solde = Double.parseDouble(request.getParameter("pSolde"));
			typeCompte = request.getParameter("pTypeCompte");
			decouvert = Double.parseDouble(request.getParameter("pDecouvert"));
			taux= Double.parseDouble(request.getParameter("pTaux"));
			montant = Double.parseDouble(request.getParameter("pMontant"));
			
			Compte compteVir =  new Compte(idCompte, solde, typeCompte, decouvert, taux);
			Compte compteRecv = new Compte(idCompteRec, solde, typeCompte, decouvert, taux);
			compteDAO.transfert(compteVir, compteRecv, montant);
			
			session = request.getSession(false);
			conseiller = (Conseiller) session.getAttribute("conseillerLogged");
		
			iDConseiller = conseiller.getIdConseiller();
		
		

			
			request.setAttribute("liste_comptes", compteDAO.getCompteByIdConseiller(iDConseiller));

			request.getRequestDispatcher("/menu-comptes.jsp").forward(request, response);
			
			break;
			
		case "attrib":
			
			idCompte = Integer.parseInt(request.getParameter("pIdCompte")) ;
			int idClient = Integer.parseInt(request.getParameter("pIdClient")) ;
			
			
			
			compteDAO.setClient(idCompte, idClient);
			
			request.setAttribute("liste_comptes", compteDAO.getAll());

			request.getRequestDispatcher("/menu-comptes.jsp").forward(request, response);
			
			break;
			
		case "recherche":
			idCompte = Integer.parseInt(request.getParameter("pIdCompte")) ;
			
			
			
			
			System.out.println("le compte correspondant � "+idCompte +" est : "+compteDAO.getByID(idCompte));
			session = request.getSession(false);
			conseiller = (Conseiller) session.getAttribute("conseillerLogged");
		
			iDConseiller = conseiller.getIdConseiller();
		
		
			
			
			request.setAttribute("liste_comptes", compteDAO.getCompteByIdConseiller(iDConseiller));

			request.getRequestDispatcher("/menu-comptes.jsp").forward(request, response);
			
			

			break;
			
		case "chercher":
			idClient =  Integer.parseInt(request.getParameter("pIdClient")) ;
			System.out.println("le compte correspondant au client "+idClient +" est : "+compteDAO.getCompteByIDClient(idClient));
			session = request.getSession(false);
			conseiller = (Conseiller) session.getAttribute("conseillerLogged");
		
			iDConseiller = conseiller.getIdConseiller();
		
		

			
			request.setAttribute("liste_comptes", compteDAO.getCompteByIdConseiller(iDConseiller));

			request.getRequestDispatcher("/menu-comptes.jsp").forward(request, response);
			
			break;
			
		case "cherche":
			
			//R�cuperation du compte par son identifiant (parametre)
			 idCompte = Integer.parseInt(request.getParameter("pIdCompte"));
			Compte compterecherche = compteDAO.getCompteByID(idCompte);
			
			//Test si le compte existe
			if(compterecherche==null) {
				request.setAttribute("reussiteOperation", "false");
				request.setAttribute("message", "Ce compte n'existe pas.");	
			}else {
				//Sauvegarde du compte comme attribut de la requete
				request.setAttribute("compteRecherche", compterecherche);
				request.setAttribute("pIdCompte", idCompte);
			}
			
			
			//Redirection vers la page 'chercher-compte.jsp'
			request.getRequestDispatcher("/recherche-compte.jsp").forward(request, response);
			
			break;
		default:
			break;
		};
		}
	}




