package com.intiformation.gestion.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import com.intiformation.gestion.dao.ClientDAOImpl;
import com.intiformation.gestion.dao.ConseillerDAOImpl;
import com.intiformation.gestion.dao.IClientDAO;
import com.intiformation.gestion.dao.IConseillerDAO;
import com.intiformation.gestion.model.Client;
import com.intiformation.gestion.model.Compte;
import com.intiformation.gestion.model.Conseiller;

@ManagedBean(name = "gestionclients")
@SessionScoped

public class ClientBean implements Serializable{

	
	List <Client> listeClient;
	IClientDAO clientdao;
	private double idconseiller;
	private Client client;
	IConseillerDAO conseillerdao;
	private int idClient;
	
	
	/*___________________________________méthode_________________________________________*/

	public ClientBean () {
		
		
		clientdao = new ClientDAOImpl();
		conseillerdao = new ConseillerDAOImpl();
	}
	
	
	
	/*___________________________________méthode_________________________________________*/

	
	public void supprimerClient(ActionEvent event) {
		
		
		UIParameter cp = (UIParameter) event.getComponent().findComponent("deleteID");
		int clientID = (int) cp.getValue();
		FacesContext contextJSF = FacesContext.getCurrentInstance();

		if (clientdao.deleteClient(clientID)) {
			
			//suppression ok
			
			
			/* envoi d 'un mesage vers la vue via le context*/
			contextJSF.addMessage(null, new FacesMessage("Le livre à été supprimé avec succès"));
			
		}else {
			
			
			//suppression not ok
			
			contextJSF.addMessage(null, new FacesMessage("La suppresion du livre à échouée"));

			
			
		}//end else
		
		
	}//end classe
	
	
	public List<Client> findallClientBdd() {
		
FacesContext fCtx = FacesContext.getCurrentInstance();
		
		HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
		Conseiller conseiller = (Conseiller) session.getAttribute("conseillerLogged");
		double iDConseiller = conseiller.getIdConseiller();
		
		
		List<Client> listeComptesBdd = clientdao.getClientByIdConseiller(iDConseiller);
	return listeComptesBdd;

		

	}//end find all
	
	public void initialiserClient(ActionEvent event) {
		
		Client ajoutclient = new Client();
		
		setClient(ajoutclient);
		
	}//end initialiser client

	
	
	public void selectionnerClient(ActionEvent event) {
		
		//1.recup du param passer dans le composant au click du lien
		UIParameter cp = (UIParameter) event.getComponent().findComponent("updateID");
				
		//2. récup de la valeur du param
		int ClientID = (int) cp.getValue();
		
		//3. récup du livre dans la bdd via l'id 
		Client clientUpdate = clientdao.getClientById(ClientID);
		
		//4.affectation du livre à modifier à la prop 'livre' du managedbean
		setClient(clientUpdate);
		
		
	}//end selectionnerClient()
	
	
	
	public void modifierClient(ActionEvent event) {
		FacesContext contextjsf = FacesContext.getCurrentInstance();
		if (clientdao.updateClient(client)) {
			//modif ok
		
			FacesMessage message = new FacesMessage (FacesMessage.SEVERITY_INFO,"Modification reussie","le client a été modifié avec succès");
		
			contextjsf.addMessage(null, message);
			
		}else {
		
			
			//modif not ok
		
		
			FacesMessage message = new FacesMessage (FacesMessage.SEVERITY_FATAL,"Modification non reussie","le client n'a pas été modifié");
			
			contextjsf.addMessage(null, message);
		}
		
	}//end modifier
	

	
	public void ajouterclient(ActionEvent event) {
		
		//récup le contexte de jsf pour l'envoi de messages vers la vue
		FacesContext contextjsf = FacesContext.getCurrentInstance();

		
		if (clientdao.addClient(client)) {
		//----------------ajout ok----------------------//
			FacesMessage message = new FacesMessage (FacesMessage.SEVERITY_INFO,"Ajout reussie","le Client a été ajouté avec succès");
			
			contextjsf.addMessage(null, message);
		
	} else {
		
		//----------------ajout not  ok----------------------//
		FacesMessage message = new FacesMessage (FacesMessage.SEVERITY_FATAL,"Ajout non reussie","le Client n'a pas été ajouté");
		
		contextjsf.addMessage(null, message);

	}//end else
		
		
	}//end ajouter livre
	
	public List <Client> recherclient() {
		System.out.println("Je suis dans recherclient");
		System.out.println("id client" +idClient);
		System.out.println(clientdao.getClientById(idClient));

		
		List<Client> listeclient = new ArrayList();
		if(idClient!=0) {
			listeclient.add(clientdao.getClientById(idClient));
		}
		return listeclient;

		
		
	}//end ajouter livre
	
	public String naviguerVersacceuil() {
		return "accueil";
	}

	

	
	
	/*___________________________________get/set_________________________________________*/
	

	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public List<Client> getListeClient() {
		return listeClient;
	}



	public void setListeClient(List<Client> listeClient) {
		this.listeClient = listeClient;
	}



	public IClientDAO getClientdao() {
		return clientdao;
	}



	public void setClientdao(IClientDAO clientdao) {
		this.clientdao = clientdao;
	}



	public double getIdconseiller() {
		return idconseiller;
	}



	public void setIdconseiller(double idconseiller) {
		this.idconseiller = idconseiller;
	}



	public IConseillerDAO getConseillerdao() {
		return conseillerdao;
	}



	public void setConseillerdao(IConseillerDAO conseillerdao) {
		this.conseillerdao = conseillerdao;
	}



	public int getIdClient() {
		return idClient;
	}



	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	
	
	
}//end classe
