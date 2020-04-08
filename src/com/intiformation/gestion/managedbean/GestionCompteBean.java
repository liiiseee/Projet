package com.intiformation.gestion.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
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
import com.mysql.fabric.xmlrpc.base.Params;

@ManagedBean (name = "gestionCompte")
@SessionScoped
public class GestionCompteBean implements Serializable{
	
	/*____________________propri�t�s____________________________*/
	List<Compte> listeCompteBdd;
	private double montant;
	private int idCompte;
	
	//-> prop compte pour ajout et modification
	private Compte compte;
	private Compte compte2;
	
	//-> dao du compte
	ICompteDAO compteDAO;
	
	
	/*____________________ctors_____________________________*/
	/**
	 * ctor vide pour instanciation du managedbean
	 */
	
	public GestionCompteBean() {
		compteDAO = new CompteDaoImpl();
	}
	
	
	
	public GestionCompteBean(double montant) {
		this.montant = montant;
	}



	/*__________________m�thodes___________________________*/
	
	
	public List<Integer> getAllID(ActionEvent event) {
		UIParameter cp =  (UIParameter) event.getComponent().findComponent("cherchCompte");
		int compteId = (int) cp.getValue();
		List<Integer> listeID = compteDAO.getAllID();
		return listeID;
		
	}
	
public Compte findCompteById(ActionEvent event) {
	UIParameter cp =  (UIParameter) event.getComponent().findComponent("cherchCompte");
	
	//2. r�cup de la valeur du param => l'id du livre � supprimer
	int compteId = (int) cp.getValue();
		Compte comptebdd = compteDAO.getCompteByID(compteId);
		return comptebdd;
		
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
		
		
		// 4. affectation du compte � modifier �  la prop 'compte' du managedbean
		setCompte(compteModif);
		
		/**
		 * dans la paeg modifier_compte.xhtml on r�cup�re le compte � modifier via la prop compte du MB
		 */
		
	}// end selectionnerCompte
	
/*public void selectionnerCompteRech(ActionEvent event) {
		
		//1. r�cup du param pass� dans le composant au click du lien 'editer'
		UIParameter cp =  (UIParameter) event.getComponent().findComponent("idCompteCh");
		
		
		//2. r�cup de la valeur du param => l'id du compte � modifier
		int compteId = (int) cp.getValue();
		
		// 3. r�cup du compte � modifier dans la bdd via l'id et la dao
		Compte compteById = compteDAO.getByID(compteId);
		
		
		// 4. affectation du compte � modifier �  la prop 'livre' du managedbean
		setCompte(compteById);
		
		
		  dans la paeg modifier_compte.xhtml on r�cup�re le compte � modifier via la prop compte du MB
		
		
	} end selectionnerCompte*/
	
	
public void selectionnerCompteVir(ActionEvent event) {
		
		//1. r�cup du param pass� dans le composant au click du lien 'editer'
		UIParameter cp =  (UIParameter) event.getComponent().findComponent("virementID");
		//UIParameter cpnt =  (UIParameter) event.getComponent().findComponent("virementID2");
		
		
		//2. r�cup de la valeur du param => l'id du compte � modifier
		int compteId = (int) cp.getValue();
		//int compteId2 = (int) cpnt.getValue();
		
		// 3. r�cup du compte � modifier dans la bdd via l'id et la dao
		Compte compteModif = compteDAO.getByID(compteId);
		//Compte compteM = compteDAO.getByID(compteId2);
		
		// 4. affectation du compte � modifier �  la prop 'livre' du managedbean
		setCompte(compteModif);
		//setCompte2(compteM);
		
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
	// instanciation d'un nouveau objet compte vide
	Compte compteAdd = new Compte();

	
	
	// affectation de l'objet � la propri�t� compte du MB
	setCompte(compteAdd);
	setCompte2(compteAdd);
	
	
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
	
		FacesContext contextJSF = FacesContext.getCurrentInstance();
		
		
				
				//Compte compteDepot = new Compte();
				//montant = compteDepot.getMontant();
		
		//ajout dans bdd
		if (compteDAO.deposit(compte, montant)) {
			System.out.println("dans d�pot if");
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

public void retraitCompte (ActionEvent event) {
	
	FacesContext contextJSF = FacesContext.getCurrentInstance();
	
				
			
			//Compte compteDepot = new Compte();
			//montant = compteDepot.getMontant();
	
	//ajout dans bdd
	if (compteDAO.retrait(compte, montant)) {
		System.out.println("dans d�pot if");
		// ajout OK
		/*message vers la vue*/
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Op�ration r�ussie", " - Le retrait a bien �t� effectu�");
		contextJSF.addMessage(null, message);
		
	} else {
		// ajout NOT  OK
		/*message vers la vue*/
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Echec du d�p�t ", " - Le retrait a �chou�");
		contextJSF.addMessage(null, message);

	}//end else
	
}//end attribuerCompte()

public void virementCompte (ActionEvent event) {
	
	FacesContext contextJSF = FacesContext.getCurrentInstance();
				
	
			
			//Compte compteDepot = new Compte();
			//montant = compteDepot.getMontant();
	
	//ajout dans bdd
	if (compteDAO.transfert(compte, compte2, montant)) {
		
		System.out.println("dans virement if");
		// ajout OK
		/*message vers la vue*/
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Op�ration r�ussie", " - Le virement a bien �t� effectu�");
		contextJSF.addMessage(null, message);
		
	} else {
		// ajout NOT  OK
		/*message vers la vue*/
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Echec du d�p�t ", " - Le virement a �chou�");
		contextJSF.addMessage(null, message);

	}//end else
	
}//end


public List<Compte> chercherCompte() {
	
	//1. r�cup du param pass� dans le composant au click du lien 'supprimer'
	
	List<Compte> listeCompte = new ArrayList();
	if (idCompte != 0) {
		listeCompte.add(compteDAO.getCompteByID(idCompte));
		
	}
	return listeCompte;
	
	
}
	
	


	
	
	
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



	public Compte getCompte2() {
		return compte2;
	}



	public void setCompte2(Compte compte2) {
		this.compte2 = compte2;
	}



	public int getIdCompte() {
		return idCompte;
	}



	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}
	
	
	
	

}//end class
