package com.intiformation.gestionclients.model;

public class Compte {
	
	private int idCompte;
	private double solde;
	private String typeCompte;
	private int clientID;
	private double decouvert;
	private double taux;

	
	/*__________ Constructeurs ____________*/
	public Compte(int idCompte, double solde, String typeCompte, int clientID) {
		super();
		this.idCompte = idCompte;
		this.solde = solde;
		this.typeCompte = typeCompte;
		this.clientID = clientID;
	}
	public Compte() {
		super();
	}
	public Compte(int idCompte, double solde, String typeCompte) {
		super();
		this.idCompte = idCompte;
		this.solde = solde;
		this.typeCompte = typeCompte;
	}


	/*________ Getters et Setters _________*/
	
	public int getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public String getTypeCompte() {
		return typeCompte;
	}
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}
	public int getClientID() {
		return clientID;
	}
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	
	public double getDecouvert() {
		return decouvert;
	}
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	/*_____________ M�thodes ______________*/
	@Override
	public String toString() {
		return " \n_____________________________\n Identifiant du Compte : " + idCompte + "\n Solde : " + solde + "� \n "
				+ "type du compte : " + typeCompte + "\n Identifiant compte : " + clientID + "\n_____________________________";
	}

}