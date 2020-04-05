package com.intiformation.gestion.model;

import java.io.Serializable;

public class CompteCourant extends Compte implements Serializable{
	
/*____________ Propri�t�s _____________*/
	
	private double decouvert = 100;

	/*__________ Constructeurs ____________*/
	
	public CompteCourant(int idCompte, double solde, int clientID,  double decouvert,
			double conseillerId) {
		super(idCompte, solde, "courant", clientID, conseillerId );
		this.decouvert=decouvert;
		// TODO Auto-generated constructor stub
	}
	

	public CompteCourant(int idCompte, double solde, int clientID, double decouvert) {
		super(idCompte, solde, "courant", clientID);
		this.decouvert = decouvert;
	}



	public CompteCourant(int idCompte, double solde, double decouvert) {
		super(idCompte, solde, "courant");
	}

	/*________ Getters et Setters _________*/
	
	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	@Override
	public String toString() {
		return " \n_____________________________\n Identifiant du Compte : " + getIdCompte() + "\n Solde : " + getSolde() + "� \n "
				+ "type du compte : " + getTypeCompte() + "\n Identifiant client : " + getClientID() 
				+ "\n Decouvert : " + decouvert +"� \n_____________________________";
	}

	
	/*_____________ M�thodes ______________*/

}
