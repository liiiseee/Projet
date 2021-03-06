package com.intiformation.gestion.model;

import java.io.Serializable;

public class Client implements Serializable{
	/*____________ Propri�t�s _____________*/
	
	private int idClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String ville;
	private String codePostal;
	private String telephone;
	private double conseillerId;

	
	/*__________ Constructeurs ____________*/


	
	public Client() {
		super();
	}
	

	public Client(int idClient, String nom, String prenom, String adresse, String ville, String codePostal,
			String telephone) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
		this.telephone = telephone;
	}

	
	public Client(String nom, String prenom, String adresse, String ville, String codePostal, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
		this.telephone = telephone;
	}
	
	public Client(int idClient, String nom, String prenom, String adresse, String ville, String codePostal,
			String telephone, double conseillerId) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
		this.telephone = telephone;
		this.conseillerId = conseillerId;
	}
	
	
	
	
	
	public Client(String nom, String prenom, String adresse, String ville, String codePostal, String telephone,
			double conseillerId) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
		this.telephone = telephone;
		this.conseillerId = conseillerId;
	}


	/*________ Getters et Setters _________*/


	


	public int getIdClient() {
		return idClient;
	}
	
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public double getConseillerId() {
		return conseillerId;
	}


	public void setConseillerId(double conseillerId) {
		this.conseillerId = conseillerId;
	}


	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	
	
	/*_____________ M�thodes ______________*/
	@Override
	public String toString() {
		return " \n_____________________________\n Identifiant Client : " + idClient + "\n Nom : " + nom + "\n Prenom : " + prenom + "\n Adresse : " + adresse
				+ "\n Code postal : " + codePostal + "\n Ville : " + ville + "\n Telephone : " + telephone + "\n_____________________________";
	} 

	
}//end class


