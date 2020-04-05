package com.intiformation.gestionclients.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.intiformation.gestionclients.dao.ClientDaoImpl;
import com.intiformation.gestionclients.dao.ConseillerDaoImpl;
import com.intiformation.gestionclients.dao.IClientDAO;
import com.intiformation.gestionclients.dao.IConseillerDAO;
import com.intiformation.gestionclients.model.Client;

/**
 * controleur (servlet) pour la gestion de l'authentification <br/>
 * cette servlet peut �tre invoqu�e via l'url '/authentication-servlet'
 * @author INTIFORMATION
 *
 */
public class AuthentificationServlet extends HttpServlet{
	
	/**
	 * <pre>
	 * 			Gestion de la session dans les jsp/servlet 
	 * 			------------------------------------------
	 * 
	 * 		> d�fintion d'une session : 
	 * 					- c'est pouvoir en tant que d�veloppeur associer 
	 *                    des donn�es � un utilisateur du site 
	 *                    
	 *                  - Une session est un objet associ� � un utilisateur ou visiteur du site 
	 *                  
	 *                  - On peut mettre dans la session des donn�es et les r�cup�rer apr�s. 
	 *                  
	 *      > technique : - Une session est un objet de type de la classe HttpSession 
	 *      
	 *      			  - l'objet HttpSession permet de cr�er une session pour un utilisateur 
	 *      
	 *       						-> cr�ation de la session = cr�ation de l'id de session au niveau du serveur
	 *       
	 *        			  - on peut sauveagrder dans l'objet HttpSession des donn�es 
	 *                      et les r�cup�rer apr�s 
	 *                      
	 *     > process session 
	 *     						1. faire connecter l'utilisateur => cr�ation d'un id de session via HttpSession
	 *     
	 *     						2. faire d�connecter l'utilisateur => destruction de la session 
	 *                                                              => destruction de l'id de session    
	 * </pre>
	 */
	
	
	/**
	 * traitement de la requ�te envoy�e au click du lien 'Se D�connecter' 
	 * de la page 'accueil.jsp'. <br/>
	 * c'est une requete http GET avec l'url : 
	 * 			http://localhost:8080/gestion-clients/authentication-servlet?destroy=true
	 * 
	 */
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
			IConseillerDAO conseillerDAO = new ConseillerDaoImpl();
			
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
				
				/*==========================================================================*/
				
				/* 3.1.2.1 r�cup de la liste des clients  ---------------------*/
				IClientDAO clientDAO = new ClientDaoImpl();
				List<Client> listeClientsBdd = clientDAO.getAllClients();
				
				/* 3.1.2.2 sauvegarde de la liste des client dans la requet ---*/
				request.setAttribute("liste_clients", listeClientsBdd);
				
				/* 3.1.2.3 d�l�gation (redirection) vers la page d'accueil ----*/
				request.getRequestDispatcher("/accueil.jsp").forward(request, response);
					
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





