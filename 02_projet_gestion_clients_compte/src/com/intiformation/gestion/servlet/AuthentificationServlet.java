 package com.intiformation.gestion.servlet;

import java.io.IOException;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.intiformation.gestion.dao.ClientDAOImpl;
import com.intiformation.gestion.dao.ConseillerDAOImpl;
import com.intiformation.gestion.dao.IClientDAO;
import com.intiformation.gestion.dao.IConseillerDAO;
import com.intiformation.gestion.model.Client;
import com.intiformation.gestion.model.Conseiller;
import com.intiformation.gestion.dao.CompteDaoImpl;
import com.intiformation.gestion.dao.ICompteDAO;
import com.intiformation.gestion.model.Compte;

/**
 * controleur (servlet) pour la gestion de l'authentification <br/>
 * cette servlet peut �tre invoqu�e via l'url '/authentication-servlet'
 * @author INTIFORMATION
 *
 */

public class AuthentificationServlet extends HttpServlet{
	
	
	 
	@Override
	protected void doGet(HttpServletRequest request, 
			             HttpServletResponse response) throws ServletException, IOException {
		
		/*==========================================================================*/
		/*======= DECONNEXION DU CONSEILLER  =======================================*/
		/*==========================================================================*/
		/**
		 * d�connexion = destruction de la sesion (id de session) => destruction de l'objet HttpSession 
		 *               via la m�thode invalidate()
		 */
		
		/* 1. r�cup de la session associ�e � la requete (associ�e au conseiller)*/
		/**
		 * > getSession() : r�cup de la session.
		 * > false :  au serveur = si la session n'existe pas, ne la cr�e pas 
		 */
		HttpSession session =  request.getSession(false); 
		
		/* 2. r�cup du param de la requ�te 'destroy'*/
		String destroySession = request.getParameter("destroy");
		
		/* 3. d�connexion du conseiller */
		if ("true".equals(destroySession)) {
			//--> d�connexion 
			session.invalidate();
		}
		
		/* 4. redirection vers la page du formulaire 'autnentification.jsp'*/
		request.getRequestDispatcher("/authentification.jsp").forward(request, response);
		
		
	}//end doGet()

	
	
	
	
	
	/**
	 * traitement de la requ�te envoy�e apr�s la 
	 * soumission du formulaire de la page 'authentification.jsp'.<br/>
	 * -> cette requ�te � comme url : http://localhost:8080/gestion-clients/authentication-servlet
	 * -> cette requ�te poss�de 2 param�tres : - p-user = valeur sasie dans le champ email
	 *                                         - p-mdp = valeur sasie dans le champ mot de passe
	 *                                         
	 * @param request : la requ�te envoy�e du formulaire
	 * @param response : la r�ponse � renvoyer vers le client (navigateur) 
	 * 
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*==========================================================================*/
		/*======= GESTION DE LA SESSION UTILISATEUR ================================*/
		/*==========================================================================*/
		
		/* 1. r�cup de la session associ�e au conseiller ===========================*/
		/**
		 *  > getSession() : r�cup de la session associ�e � la requete 
		 *  		-> true : si la session n'existe pas, on demande au serveur de la cr�er 
		 */
		 HttpSession session = request.getSession(true);
		 
		 /* 2. v�rif si le conseiller est connect� ===================================*/
		 /**
		  * la v�rif se fait via l'attribut de session 'isLogged' d�finie 
		  * lors de l'authentificaton du conseiller 
		  */
		 if (session.getAttribute("isLogged") != null) {
			
			 // redirection vers la page du formulaire 'authentification.jsp'
			 request.getRequestDispatcher("/authentification.jsp").forward(request, response);
			 
		}//end if 
		
		
		/*==========================================================================*/
		
		
		
		/*-----------------------------------------------------------------*/
		/*---- 1. r�cup des param�tres de la requ�te ----------------------*/
		/*-----------------------------------------------------------------*/
		//--> params de la requete = la saisie du formulaire 
		
		/* 1.1. r�cup de la valeur du param�tre 'p-user' (l'email saisie dans le formulaire) */
		String emailUser = request.getParameter("p-user");
		
		/* 1.2. r�cup de la valeur du param�tre 'p-mdp' (le mot de passe sasie dans le formulaire) */
		String mdpUser = request.getParameter("p-mdp");
		
		
		/*-----------------------------------------------------------------*/
		/*---- 2. v�rif des valeurs  des param�tres de la requ�te ---------*/
		/*-----------------------------------------------------------------*/
		
		/* 2.1. v�rif si les valeurs sont null ----------------------------*/
		
		if (emailUser == null || mdpUser == null) {
			
			/* 2.1.1. redirection vers la page du formulaire 'authentification.jsp' */
			//--> redirection = d�l�gation 
			RequestDispatcher rd = request.getRequestDispatcher("/authentification.jsp");
			//- d�clenchement de la d�l�gation 
			rd.forward(request, response);
			
		}//end if 
		
		/* 2.2. v�rif si les valeurs sont vide -----------------------------*/
		
		/* 2.2.1. liste pour stocker les messages d'erreurs ----------------*/
		List<String> listeMessagesErreurs = new ArrayList<>();
		
		/* 2.2.2. v�rif des valeurs  ---------------------------------------*/
		
		if ("".equals(emailUser)) {
			
			//-> ajout d'un message d'erreur dans la liste 
			listeMessagesErreurs.add("Le mail est obligatoire");
			
		}//end if 
		
		if ("".equals(mdpUser)) {
			
			//-> ajout d'un message d'erreur dans la liste 
			listeMessagesErreurs.add("Le mot de passe est obligatoire");
			
		}//end if 
		
		/* 2.3. v�rif s'il y a des erreurs  -----------------------------*/
		if (listeMessagesErreurs.size() > 0) {
			
			/* 2.3.1. sauvegarde de la liste des messages dans la requ�te comme attribut*/
			request.setAttribute("messages_erreurs", listeMessagesErreurs);
			
			/* 2.3.2. d�l�gation de la requete/reponse � la page 'authentification.jsp' */
			//--> redirection vers la page 'authentification.jsp'
			request.getRequestDispatcher("/authentification.jsp").forward(request, response);
			
		}//end if 
		
		
		/*-----------------------------------------------------------------*/
		/*---- 3. authentification du conseiller --------------------------*/
		/*-----------------------------------------------------------------*/
		if (listeMessagesErreurs.isEmpty()) {
			
			//------------  liste vide = pas d'erreurs ---------------//
			
			/* 3.1. v�rif si le conseiller existe dans la bdd avec mail/mdp */
			
			/* 3.1.1. d�finition de la dao (appel de la dao ) ---------------*/
			IConseillerDAO conseillerDAO = new ConseillerDAOImpl();
			
			/* 3.1.2. v�rif de l'existance du conseiller ---------------------*/
			if (conseillerDAO.isConseillerExists(emailUser, mdpUser)) {
				
				//------- le conseiller existe dans la bdd ----------//
				
				/*==========================================================================*/
				/*===== CONNEXION DU CONSEILLER ============================================*/
				/*==========================================================================*/
				/**
				 * > on va faire connecter le conseiller � son espace personnel 
				 * 		-> cr�ation de la session => cr�ation d'un id de session
				 * 
				 * 				HttpSession session = request.getSession(true);
				 */
				 /* d�finition d'un attribut de session 'isLogged' */
				session.setAttribute("isLogged", "true");
				Conseiller conseiller = conseillerDAO.getConseillerByEmail(emailUser, mdpUser);
				session.setAttribute("conseillerLogged", conseiller);
				
				List<Client> listeClientsConseiller = conseillerDAO.getClientByIdConseiller(conseiller.getIdConseiller());
				//R�cup de la liste des comptes appartenant � ses clients
				
				ICompteDAO compteDAO = new CompteDaoImpl();
				
				/*List<Compte> listeComptesConseiller=new ArrayList<>();
				List<Compte> listeCompteClient=new ArrayList<>();
				
				for(Client client : listeClientsConseiller) {
					listeCompteClient= compteDAO.getCompteByIDClient(client.getIdClient());
					listeComptesConseiller.addAll(listeCompteClient);
				}
				
				//Sauvegarde de la liste des clients dans un attribut de la requete
				request.setAttribute("liste_clients", listeClientsConseiller);
				request.setAttribute("liste_comptes", listeComptesConseiller);*/
				
				request.getRequestDispatcher("/menu.jsp").forward(request, response);
				
				/*==========================================================================*/
				
				
					
			}else {
				
				//----- le conseiller n'existe pas dans la bdd -------//
				
				/* 3.1.2.1bis redirection vers 'authentification.jsp' ---------------------*/
				listeMessagesErreurs.add("Identit� non valide");
				request.setAttribute("messages_erreurs", listeMessagesErreurs);
				
				request.getRequestDispatcher("/authentification.jsp").forward(request, response);
				
				
			}//end else 
			
			
		}//end if liste isEmpty()
		
		
	}//end doPost()

	
	
}//end class 





