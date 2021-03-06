package com.intiformation.gestion.model;

import java.io.Serializable;

public class Compte implements Serializable{
	
	private int idCompte;
	private double solde;
	private String typeCompte;
	private int clientID;
	private double decouvert;
	private double taux;
	private double conseillerId;
	private double montant;
	private int idCompteRec;
	private double soldeRec;

	
	/*__________ Constructeurs ____________*/
	
	
	
	
	
	
	public Compte(int idCompte, double solde, String typeCompte, int clientID) {
		super();
		this.idCompte = idCompte;
		this.solde = solde;
		this.typeCompte = typeCompte;
		this.clientID = clientID;
	}
	public Compte(double solde, String typeCompte, double decouvert, double taux, double conseillerId) {
		super();
		this.solde = solde;
		this.typeCompte = typeCompte;
		this.decouvert = decouvert;
		this.taux = taux;
		this.conseillerId = conseillerId;
	}
	public Compte(int idCompte, double solde, String typeCompte, double decouvert, double taux, double conseillerId) {
		super();
		this.idCompte = idCompte;
		this.solde = solde;
		this.typeCompte = typeCompte;
		this.decouvert = decouvert;
		this.taux = taux;
		this.conseillerId = conseillerId;
	}
	public Compte(int idCompte, double solde, double conseillerId, String typeCompte, double taux) {
		super();
		this.idCompte = idCompte;
		this.solde = solde;
		this.typeCompte = typeCompte;
		this.taux = taux;
		this.conseillerId = conseillerId;
		
	}
	
	
	
	
	public Compte(double solde, String typeCompte, int clientID, double decouvert, double taux, double conseillerId) {
		super();
		this.solde = solde;
		this.typeCompte = typeCompte;
		this.clientID = clientID;
		this.decouvert = decouvert;
		this.taux = taux;
		this.conseillerId = conseillerId;
	}
	public Compte(int idCompte, double solde, String typeCompte, int clientID, double decouvert, double taux,
			double conseillerId) {
		super();
		this.idCompte = idCompte;
		this.solde = solde;
		this.typeCompte = typeCompte;
		this.clientID = clientID;
		this.decouvert = decouvert;
		this.taux = taux;
		this.conseillerId = conseillerId;
	}
	public Compte(int idCompte, double solde, String typeCompte, double decouvert, double taux) {
		super();
		this.idCompte = idCompte;
		this.solde = solde;
		this.typeCompte = typeCompte;
		this.decouvert = decouvert;
		this.taux = taux;
	}
	public Compte(double solde, String typeCompte, double decouvert, double taux) {
		super();
		this.solde = solde;
		this.typeCompte = typeCompte;
		this.decouvert = decouvert;
		this.taux = taux;
	}
	public Compte(double solde, String typeCompte, int clientID, double decouvert, double taux) {
		super();
		this.solde = solde;
		this.typeCompte = typeCompte;
		this.clientID = clientID;
		this.decouvert = decouvert;
		this.taux = taux;
	}
	public Compte(int idCompte, double solde, String typeCompte, int clientID, double decouvert, double taux) {
		super();
		this.idCompte = idCompte;
		this.solde = solde;
		this.typeCompte = typeCompte;
		this.clientID = clientID;
		this.decouvert = decouvert;
		this.taux = taux;
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
	
	
	
	public double getConseillerId() {
		return conseillerId;
	}
	public void setConseillerId(double conseillerId) {
		this.conseillerId = conseillerId;
		
	}
	
	
	
	
	
	
	
	
	public double getSoldeRec() {
		return soldeRec;
	}
	public void setSoldeRec(double soldeRec) {
		this.soldeRec = soldeRec;
	}
	public int getIdCompteRec() {
		return idCompteRec;
	}
	public void setIdCompteRec(int idCompteRec) {
		this.idCompteRec = idCompteRec;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	/*_____________ M�thodes ______________*/
	@Override
	public String toString() {
		return " \n_____________________________\n Identifiant du Compte : " + idCompte + "\n Solde : " + solde + "� \n "
				+ "type du compte : " + typeCompte + "\n Identifiant compte : " + clientID + "\n_____________________________";
	}

}
