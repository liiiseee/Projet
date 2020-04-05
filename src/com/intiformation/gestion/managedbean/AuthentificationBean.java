package com.intiformation.gestion.managedbean;

import java.io.Serializable;



import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import com.intiformation.gestion.dao.ConseillerDAOImpl;
import com.intiformation.gestion.dao.IConseillerDAO;
import com.intiformation.gestion.model.Conseiller;


@ManagedBean(name = "authenticationBean")
@SessionScoped
public class AuthentificationBean implements Serializable{
	
	
	/*__________________________props__________________________*/
	
	private String email;
	private String password;
	
	//dao
	private IConseillerDAO conseillerDAO;
	
	// context de JSF
	FacesContext contextJSF;
	
	/*__________________________ctors__________________________*/
	/**
	 * ctor vide pour instanciation du managed bean
	 */
	public AuthentificationBean() {
		conseillerDAO = new ConseillerDAOImpl();
		
	}

	
	
	/*__________________________méthodes__________________________*/
	/**
	 * permet de connecter l'user et de lui créer une session
	 * @return
	 */
	public String connecterUtilisateur() {
		
		//récup du context de JSF
		FacesContext contextJSF = FacesContext.getCurrentInstance();
		
		// 1. vérif si l'utlisateur existe dans bdd
		if (conseillerDAO.isConseillerExists(email, password)) {
			
			//-------------utilisateur existe-------------------//
			/* création de la session pour l'utilisateur => création d'un id de session*/
			HttpSession session = (HttpSession) contextJSF.getExternalContext().getSession(true);
			
			/* sauveagarde du login dans la session */
			session.setAttribute("user_email", email);
			Conseiller conseiller = conseillerDAO.getConseillerByEmail(email, password);
			session.setAttribute("conseillerLogged", conseiller);
			
			/*redirection (navigation) vers la page accueil.xhtml*/
			return "accueil.xhtml";
			
		}else {
			//-------------utilisateur n'existe pas-------------------//
			/**
			 * envoi d'un message vers la vue via la classe facesMessage
			 */
			
			
			//déf du message via Facesmessage
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Echec de connexion", "Identifiant et/ou mot de passe invalide(s)");
			
			//envoi messgae via le contexte
			/**
			 * addMessage(String, FacesMessage) :
			 * 	- String : soit l'id du composant ou null pour l'ensemble de la page
			 */
			contextJSF.addMessage(null, message);
			
			/*redirection (navigation) vers la page authentification.xhtml*/
			return "authentification.xhtml";
			
		}//end else
		
		
	}//end connecterUtilisateur()
	/**
	 * detruit la session
	 * @return
	 */
	public String deconnecterUtilisateur() {
		
		//récup du context de JSF
		FacesContext contextJSF = FacesContext.getCurrentInstance();
		
		// 1. récup de la session de l'utilisateur
		HttpSession session = (HttpSession) contextJSF.getExternalContext().getSession(false);
		
		// 2. déconnexion
		session.invalidate();
		
		// 3. redirection vers  authentification.xhtml
		return "authentification.xhtml";
		
	}//end deconnecterUtilisateur()
	
	/*________________________getters/setters________________________*/
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
