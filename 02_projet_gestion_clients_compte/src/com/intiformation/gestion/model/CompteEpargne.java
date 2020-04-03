package com.intiformation.gestion.model;

public class CompteEpargne extends Compte{
	
/*____________ Propriétés _____________*/
	
	private double taux=3;

	/*__________ Constructeurs ____________*/

	public CompteEpargne(int idCompte, double solde,  int clientID, double taux) {
		super(idCompte, solde, "epargne", clientID);
		this.taux = taux;
		
	}

	public CompteEpargne(int idCompte, double solde,  double taux) {
		super(idCompte, solde, "epargne");
		
		
	}
	
	public CompteEpargne(int idCompte, double solde, int clientID,  double taux,
			double conseillerId) {
		super(idCompte, solde, "epargne", clientID, conseillerId );
		this.taux=taux;
		// TODO Auto-generated constructor stub
	}
	
	

	/*________ Getters et Setters _________*/

	

	

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	
	/*_____________ Méthodes ______________*/

	@Override
	public String toString() {
		return " \n_____________________________\n Identifiant du Compte : " + getIdCompte() + "\n Solde : " + getSolde() + "€ \n "
				+ "type du compte : " + getTypeCompte() + "\n Identifiant client : " + getClientID() 
				+ "\n Taux : " + taux +"% \n_____________________________";
	}

}
