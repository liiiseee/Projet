package com.intiformation.gestion.managedbean;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import com.intiformation.gestion.dao.CompteDaoImpl;
import com.intiformation.gestion.dao.ICompteDAO;
import com.intiformation.gestion.model.Compte;
import com.intiformation.gestion.model.Conseiller;

@ManagedBean (name = "gestionCompte")
@SessionScoped
public class GestionCompteBean implements Serializable{
	
	/*____________________propri�t�s____________________________*/
	List<Compte> listeCompteBdd;
	double montant;
	
	//-> prop compte pour ajout et modification
	private Compte compte;
	
	//-> dao du compte
	ICompteDAO compteDAO;
	
	/*____________________ctors_____________________________*/
	/**
	 * ctor vide pour instanciation du managedbean
	 */
	
	public GestionCompteBean() {
		compteDAO = new CompteDaoImpl();
	}
	
	/*__________________m�thodes___________________________*/
	
public Compte findCompteById(ActionEvent event) {
	UIParameter cp =  (UIParameter) event.getComponent().findComponent("cherchCompte");
	
	//2. r�cup de la valeur du param => l'id du livre � supprimer
	int compteId = (int) cp.getValue();
		compte = compteDAO.getCompteByID(compteId);
		return compte;
		
	}
	
	public List<Compte> findCompteByIdConseiller() {
	
		FacesContext fCtx = FacesContext.getCurrentInstance();
		
		HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
		Conseiller conseiller = (Conseiller) session.getAttribute("conseillerLogged");
		double iDConseiller = conseiller.getIdConseiller();
		
		
		List<Compte> listeComptesBdd = compteDAO.getCompteByIdConseiller(iDConseiller);
	return listeComptesBdd;
	} // end findCompteByIdConseiller
	
	
	
	public void selectionnerCompte(ActionEvent event) {
		
		//1. r�cup du param pass� dans le composant au click du lien 'editer'
		UIParameter cp =  (UIParameter) event.getComponent().findComponent("updateID");
		
		//2. r�cup de la valeur du param => l'id du compte � modifier
		int compteId = (int) cp.getValue();
		
		// 3. r�cup du compte � modifier dans la bdd via l'id et la dao
		Compte compteModif = compteDAO.getByID(compteId);
		
		
		// 4. affectation du compte � modifier �  la prop 'livre' du managedbean
		setCompte(compteModif);
		
		/**
		 * dans la paeg modifier_compte.xhtml on r�cup�re le compte � modifier via la prop compte du MB
		 */
		
	}// end selectionnerCompte
	
public void selectionnerCompteDep(ActionEvent event) {
		
		//1. r�cup du param pass� dans le composant au click du lien 'editer'
		UIParameter cp =  (UIParameter) event.getComponent().findComponent("depotID");
		
		//2. r�cup de la valeur du param => l'id du compte � modifier
		int compteId = (int) cp.getValue();
		
		// 3. r�cup du compte � modifier dans la bdd via l'id et la dao
		Compte compteModif = compteDAO.getByID(compteId);
		
		
		// 4. affectation du compte � modifier �  la prop 'livre' du managedbean
		setCompte(compteModif);
		
		/**
		 * dans la paeg modifier_compte.xhtml on r�cup�re le compte � modifier via la prop compte du MB
		 */
		
	}// end selectionnerCompte
	
public void supprimerCompte(ActionEvent event) {
		
		//1. r�cup du param pass� dans le composant au click du lien 'supprimer'
		UIParameter cp =  (UIParameter) event.getComponent().findComponent("deleteID");
		
		//2. r�cup de la valeur du param => l'id du livre � supprimer
		int compteId = (int) cp.getValue();
		
		// 3. suppression du livre dans la bdd via dao
		//3.1. r�cup du context de JSF
		FacesContext contextJSF = FacesContext.getCurrentInstance();
		
		//3.2. suppression + message
		if (compteDAO.delete(compteId)) {
			//--suppresion ok
			
			/* envoi d'un msg vers la vue via le context*/
			contextJSF.addMessage(null, new FacesMessage("Le compte a �t� supprim� avec succ�s"));
			
			
		}else {
			//--suppresion not ok
			
			/* envoi d'un msg vers la vue via le context*/
			contextJSF.addMessage(null, new FacesMessage("La suppression du compte a �chou�e"));
			
		}//end else
		
		
	}// end supprimerCompte()

public void initialiserCompte(ActionEvent event) {
	// instanciation d'un nouveau objet livre vide
	Compte compteAdd = new Compte();
	
	// affectation de l'objet � la propri�t� livre du MB
	setCompte(compteAdd);
	
	
}// end initialiserLivre()

public void ajouterCompte(ActionEvent event) {
	
	// r�cup du contexte JSF pour l'envoi du msg vers la vue
	FacesContext contextJSF = FacesContext.getCurrentInstance();
	
	//ajout dans bdd
	if (compteDAO.add(compte)) {
		// ajout OK
		/*message vers la vue*/
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajout r�ussi", " - Le compte a �t� ajout� avec succ�s");
		contextJSF.addMessage(null, message);
		
	} else {
		// ajout NOT  OK
		/*message vers la vue*/
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Echec de l'ajout ", " - L'ajout du compte a �chou�");
		contextJSF.addMessage(null, message);

	}//end else
	
}//end ajouterLivre()

public void modifierCompte(ActionEvent event) {
	/**
	 * la prop livre du managedbean(mb) encapsule les infos du livre � modifier dans la bdd
	 */
	
	FacesContext contextJSF = FacesContext.getCurrentInstance();
	if (compteDAO.update(compte)) {
		//-------------modif OK--------------------//
		
		/*message vers la vue*/
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification r�ussie", "Le compte a �t� modif avec succ�s");
		contextJSF.addMessage(null, message);
		
		
	}else {
		//-------------modif NOT OK--------------------//
		/*message vers la vue*/
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Echec de la Modification ", " - La modification du compte a �chou�e");
		contextJSF.addMessage(null, message);
		
	}//end else
	
}//end modif

public void attribuerCompte (ActionEvent event) {
//r�cup du contexte JSF pour l'envoi du msg vers la vue
	FacesContext contextJSF = FacesContext.getCurrentInstance();
	//1. r�cup du param pass� dans le composant au click du lien 'supprimer'
			UIParameter cp =  (UIParameter) event.getComponent().findComponent("attribIdCompte");
			UIParameter comp =  (UIParameter) event.getComponent().findComponent("attribIdClient");
			//2. r�cup de la valeur du param => l'id du livre � supprimer
			int compteId = (int) cp.getValue();
			int clientID = (int) comp.getValue();
	
	//ajout dans bdd
	if (compteDAO.setClient(compteId, clientID)) {
		// ajout OK
		/*message vers la vue*/
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Op�ration r�ussie", " - Le compte a bien �t� attribu� au client");
		contextJSF.addMessage(null, message);
		
	} else {
		// ajout NOT  OK
		/*message vers la vue*/
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Echec de l'attribution du compte ", " - L'attribution du compte a �chou�e");
		contextJSF.addMessage(null, message);

	}//end else
	
}//end attribuerCompte()




public void depotCompte (ActionEvent event) {
	//r�cup du contexte JSF pour l'envoi du msg vers la vue
		
		montant = (double) event.getComponent().getAttributes().get("montantDepot");
		FacesContext contextJSF = FacesContext.getCurrentInstance();
		UIParameter cpnt =  (UIParameter) event.getComponent().findComponent("depotID");
	
		//1. r�cup du param pass� dans le composant au click du lien 'depot'
				
		
		
				//UIParameter comp =  (UIParameter) event.getComponent().findComponent("montDep");
				//2. r�cup de la valeur du param => l'id du livre � supprimer
				//double montantC = (double) comp.getValue();
		
		//ajout dans bdd
		if (compteDAO.deposit(compte, montant)) {
			// ajout OK
			/*message vers la vue*/
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Op�ration r�ussie", " - Le d�p�t a bien �t� effectu�");
			contextJSF.addMessage(null, message);
			
		} else {
			// ajout NOT  OK
			/*message vers la vue*/
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Echec du d�p�t ", " - Le d�p�t a �chou�");
			contextJSF.addMessage(null, message);

		}//end else
		
	}//end attribuerCompte()

public void chercherCompte(ActionEvent event) {
	
	//1. r�cup du param pass� dans le composant au click du lien 'supprimer'
	UIParameter cp =  (UIParameter) event.getComponent().findComponent("cherchCompte");
	
	//2. r�cup de la valeur du param => l'id du livre � supprimer
	int compteId = (int) cp.getValue();
	
	
	// 3. suppression du livre dans la bdd via dao
	//3.1. r�cup du context de JSF
	FacesContext contextJSF = FacesContext.getCurrentInstance();
	
	compteDAO.getCompteByID(compteId);
	
	
	
	//3.2. suppression + message
	if (compteDAO.getCompteByID(compteId) != null) {
		//--suppresion ok
		
		/* envoi d'un msg vers la vue via le context*/
		contextJSF.addMessage(null, new FacesMessage("Le compte a �t� retrouv�"));
		
		
	}else {
		//--suppresion not ok
		
		/* envoi d'un msg vers la vue via le context*/
		contextJSF.addMessage(null, new FacesMessage("La suppression du compte a �chou�e"));
		
	}//end else
	
	
}// end supprimerCompte()

	
	
	
	/*________________getters/setters____________________________*/
	
	public List<Compte> getListeCompteBdd() {
		return listeCompteBdd;
	}

	public void setListeCompteBdd(List<Compte> listeCompteBdd) {
		this.listeCompteBdd = listeCompteBdd;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public ICompteDAO getCompteDAO() {
		return compteDAO;
	}

	public void setCompteDAO(ICompteDAO compteDAO) {
		this.compteDAO = compteDAO;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	

}//end class
