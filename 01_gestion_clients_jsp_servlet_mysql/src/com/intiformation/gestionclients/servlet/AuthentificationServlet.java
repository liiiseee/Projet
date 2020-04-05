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
 * controleur (servlet) pour la gestion de l'authentification
 * cette servlet peut �tre invoqu�e via l'url '/authentification-servlet'
 * @author IN-DF-029
 *
 */
public class AuthentificationServlet extends HttpServlet{
	
	/**
	 * <pre>
	 * 				Gestion de la session dans les jsp/servlet
	 * 				------------------------------------------
	 * 
	 * 		> d�finition d'une session :
	 * 				- c'est pouvoir en tant que d�veloppeur associ� des donn�es � un utilisateur du site
	 * 
	 * 				- une session est un objet associ� � un utilisateur ou visiteur du site
	 * 
	 * 				- on peut mettre dans la session des donn�es et les r�cup�rer apr�s
	 * 
	 * 		> technique : - Une session est un objet de type de la classe HttpSession
	 * 
	 * 					  - L'objet HttpSession permet de cr�er une session pour un utilisateur
	 * 							-> cr�ation de la session = cr�ation de l'id de la session au niveau du serveur
	 * 
	 * 					  - on peut sauvegarder dans l'objet HttpSession les donn�es et les r�cup�rer apr�s
	 * 
	 * 		> process session :
	 * 				1. faire connecter l'utiliasteur => cr�ation d'un id de session via HttpSession
	 * 			
	 * 				2. faire d�connecter l'utiliasteur => destruction de la session et de l'id de session via HttpSession
	 * </pre>
	 */

	/**
	 * traitement de la requ�te envoy�e au click de 'Se D�connecter' de la page 'accueil.jsp' <br/>
	 * C'est une requ�te http GET avec l'url http://localhost:8080/gestion-clients/authentification-servlet?destroy=true
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*=======================================================================================*/
		/*==========================DECONNEXION DU CONSEILLER========r============================*/
		/*=======================================================================================*/
		/**
		 * d�connexion = destruction de l'objet HttpSession via la m�thode invalidate()
		 */
		
		/*1. r�cup de la session associ�e � la requ�te (conseiller)*/
		/**
		 * getSession() : r�cup de la session
		 */
		HttpSession session = request.getSession(false); // false = si la session n'existe pas, ne la cr�e pas
		
		/* 2. r�cup du param de la requ�te 'destroy'*/
		String destroySession = request.getParameter("destroy");
		
		/* 3. d�connexion du conseiller-----*/
		if ("true".equals(destroySession)) {
			//--> d�connexion
			session.invalidate();
			
		}// end if
		
		/*4. redirection vers authentification.jsp*/
		request.getRequestDispatcher("/authentification.jsp").forward(request, response);
		
	}//end doGet()
	
	
	/**
	 * traitement de la requ�te envoy�e apr�s la soumission du formulaire de la page authentification.jsp
	 * Cette requ�te a pour url : http://localhost:8080/gestion-clients/authentification-servlet
	 * Cette requ�te poss�de 2 param�tres : - p-user = valeur saisie dans le champ email
	 * 										- p-mdp = valeur saisie dans le champ mot de passe
	 * 
	 * @param request : requ�te envoy�e par le formulaire
	 * @param response : r�ponse � renvoyer vers de le client
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*=======================================================================================*/
		/*==========================gestion de la session utilisateur============================*/
		/*=======================================================================================*/
		
		/*================== 1. r�cup de la session associ�e au conseiller=================*/
		/**
		 * 	> getSession() : r�cup de la session associ�e � la requ�te
		 * 			-> true : si la session n'existe pas, on demande au serveur de la cr�er
		 */
		HttpSession session = request.getSession(true);
		
		/* 2. v�rif que l'utilisateur est connect�==========================================*/
		/**
		 * la v�rif se fait via l'attribut de session 'isLogged' d�finie lors de l'authentification du conseiller
		 */
		if (session.getAttribute("isLogged") != null) {
			
			// redirection vers la page du formulaire 'authentification.jsp'
			request.getRequestDispatcher("/authentification.jsp").forward(request, response);
			
		}// end if
		
		/*=======================================================================================*/
	
		/*-----------------------------------------------------------------*/
		/*-------1. r�cup des params de la requ�te-------------------------*/
		/*-----------------------------------------------------------------*/
		//--> params de la requ = saisie du formulaire
		
		/* 1.1. r�cup de la valeur du param 'p-user'*/
		String emailUser = request.getParameter("p-user");
		
		/* 1.1. r�cup de la valeur du param 'p-mdp'*/
		String mdpUser = request.getParameter("p-mdp");
		
		/*-----------------------------------------------------------------*/
		/*-------2. v�rif des valeurs des params de la requ�te-------------*/
		/*-----------------------------------------------------------------*/
		
		//2.1. v�rif que les valeurs soient null
		
		if (emailUser==null || mdpUser == null) {
			
			/* 2.1.1 redirection vers la page du formulaire authentification.jsp*/
			//---> redirection = d�l�gation
			RequestDispatcher rd = request.getRequestDispatcher("/authentification.jsp");
			
			//- d�clenchement de la d�l�gation
			rd.forward(request, response);
			
		}//end if
		
		//2.2. v�rif que les valeurs soient vides
		
		/* 2.2.1. liste pour stocker les message d'erreurs*/
		List<String> listeMessageErreurs = new ArrayList<> ();
		
		/* 2.2.2. ------------------v�rif des valeurs-------------------*/
		if ("".equals(emailUser)) {
			
			//-> ajout d'un message d'erreur dans la liste
			listeMessageErreurs.add("L'adresse email est obligatoire");
		}// end if email
		
		if ("".equals(mdpUser)) {
			//-> ajout d'un message d'erreur dans la liste
			listeMessageErreurs.add("Le mot de passe est invalide");
		}// end if mdp
		
		
		/* 2.3. ------------------v�rif s'il y a des erreurs-------------------*/
		if (listeMessageErreurs.size() > 0) {
			
			/* 2.3.1. sauvegarde de la liste des messages dans la requ�te comme attribut*/
			request.setAttribute("messages_erreurs", listeMessageErreurs);
			
			/* 2.3.2. d�l�gation de la req/rep vers la page du formulaire authentification.jsp*/
			request.getRequestDispatcher("/authentification.jsp").forward(request, response);
			
		}
		
		/*-----------------------------------------------------------------*/
		/*-------3. authentification du conseiller-------------------------*/
		/*-----------------------------------------------------------------*/
		
		if (listeMessageErreurs.isEmpty()) {
			
			//-------------liste vide = pas d'erreurs -----------------------//
			
			/*---------------3.1. v�rif si le conseiller existe dans la bdd avec mail/mdp--------*/
			/*3.1.1. d�finition de la dao (appel de la dao)*/
			IConseillerDAO conseillerDAO = new ConseillerDaoImpl();
			
			/* 3.1.2. v�rif de l'existance du conseiller --------------------------*/
			if (conseillerDAO.isConseillerExists(emailUser, mdpUser)) {
				
				//-----------------le conseiller existe dans la bdd-----------------//
				/*=======================================================================================*/
				/*==========================CONNEXION DU CONSEILLER============================*/
				/*=======================================================================================*/
				
				session.setAttribute("isLogged", "true");
				
				
				
				/* 3.1.2.1. r�cup de la liste des clients --------------------------*/
				IClientDAO clientDAO = new ClientDaoImpl();
				
				List<Client> listeClientsBdd = clientDAO.getAllClients();
				
				/*3.1.2.2. sauvegarde de la liste des clients dans la requ�te*/
				request.setAttribute("liste_clients", listeClientsBdd);
				
				/* 3.1.2.3. redirection vers la page d'accueil--------------------------*/
				request.getRequestDispatcher("/accueil.jsp").forward(request, response);
				
				
			}else {
				
				//-----------------le conseiller n'existe pas dans la bdd-----------------//
				/* 3.1.2.1bis. redirection vers la page authentification.jsp --------------------------*/
				listeMessageErreurs.add("Identit� non valide");
				request.setAttribute("messages_erreurs", listeMessageErreurs);
				
				request.getRequestDispatcher("/authentification.jsp").forward(request, response);
				
			}//end else
			
		}// end if is empty
	}//end doPost()

	
	

}