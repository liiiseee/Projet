package com.intiformation.gestion.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.intiformation.gestion.model.Compte;
import com.intiformation.gestion.model.CompteCourant;
import com.intiformation.gestion.model.CompteEpargne;


public class CompteCourantDAOImpl extends CompteDaoImpl {


	public boolean add(CompteCourant compteCourant) {
		
		PreparedStatement ps = null;
		
		try {
			String requeteSqlAdd= "INSERT INTO  comptes ( client_id , solde, type_compte, taux, decouvert) VALUES (?, ?, ?, null, ?)";
			
			ps = this.connection.prepareStatement(requeteSqlAdd);
			
			ps.setInt(1, compteCourant.getClientID());
			ps.setDouble(2, compteCourant.getSolde());
			ps.setString(3, compteCourant.getTypeCompte());
			ps.setDouble(4, compteCourant.getDecouvert());

			int verifAjout = ps.executeUpdate();

			return (verifAjout==1);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				if(ps!= null) ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
	
	
	/*===========================================================================*/
	/*===========================================================================*/
	

	public boolean update(CompteCourant compteCourant) {
		
		PreparedStatement ps = null;
		
		try {
			String requeteSqlAdd= "UPDATE comptes SET client_id=? , solde=?, type_compte='courant' , decouvert=? WHERE id_compte= ? ";
			
			ps = this.connection.prepareStatement(requeteSqlAdd);
			
			ps.setInt(1, compteCourant.getClientID());
			ps.setDouble(2, compteCourant.getSolde());
			ps.setDouble(3, compteCourant.getDecouvert());
			
			ps.setInt(4, compteCourant.getIdCompte());

			int verifAjout = ps.executeUpdate();

			return (verifAjout==1);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				if(ps!= null) ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/*===========================================================================*/
	/*===========================================================================*/
	
	
	public boolean retrait(Compte compteCourant, double montant) {
				
		PreparedStatement ps = null;
		double solde = compteCourant.getSolde();
		int id_compte = compteCourant.getIdCompte();
		double decouvert = compteCourant.getDecouvert();

		if(montant<(solde+decouvert)) {
		
			try {
				String requeteSqlAdd= "UPDATE comptes SET solde=? WHERE id_compte= ? ";
				
				ps = this.connection.prepareStatement(requeteSqlAdd);
	
				
				ps.setDouble(1, solde-montant);
				ps.setInt(2, id_compte);
	
				int verifAjout = ps.executeUpdate();
	
				return (verifAjout==1);
				
			} catch (SQLException e) {
	
				e.printStackTrace();
			}finally {
				try {
					if(ps!= null) ps.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}//end try catch
		}//end if 
		else {
			System.out.println("Le montant demand� est trop �lev�");
		}
		return false;

	}

	public boolean transfert(Compte compteDonneurCourant, double montant, Compte compteReceveur) {
		PreparedStatement ps = null;
		
		double soldeReceveur = compteReceveur.getSolde();
		int id_compteReceveur = compteReceveur.getIdCompte();
		
		
		double soldeDonneur = compteDonneurCourant.getSolde();
		int id_compteDonneur = compteDonneurCourant.getIdCompte();
		double decouvertDonner = compteDonneurCourant.getDecouvert();
		
		if(montant<(soldeDonneur+decouvertDonner)) {
		
		try {
			String requeteSqlRemove= "UPDATE comptes SET solde=? WHERE id_compte= ? ";
			
			ps = this.connection.prepareStatement(requeteSqlRemove);

			ps.setDouble(1, soldeDonneur-montant);
			ps.setInt(2, id_compteDonneur);

			int verifTransfertDonneur = ps.executeUpdate();
			
			String requeteSqlAdd= "UPDATE comptes SET solde=? WHERE id_compte= ? ";
			
			ps = this.connection.prepareStatement(requeteSqlAdd);

			ps.setDouble(1, soldeReceveur+montant);
			ps.setInt(2, id_compteReceveur);

			int verifTransfertReceveur = ps.executeUpdate();

			return (verifTransfertDonneur+verifTransfertReceveur==2);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				if(ps!= null) ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//end try catch
		}//end if 
		else {
			System.out.println("Le montant demand� est trop �lev�");
		}
		return false;

	}
	
	public CompteCourant getByID(int id) {
		PreparedStatement ps = null;
		ResultSet resultatRequete =null;
		
		try {
			String requeteSqlGetById="SELECT * FROM comptes WHERE id_compte = ?";
			ps = this.connection.prepareStatement(requeteSqlGetById);
			ps.setInt(1, id);
			
			resultatRequete = ps.executeQuery();
			CompteCourant compte = null;
			
			resultatRequete.next();
			
			int idCompte = resultatRequete.getInt(1);
			int clientID = resultatRequete.getInt(2);
			double solde = resultatRequete.getDouble(3);
			String typeCompte = resultatRequete.getString(4);
			double taux = resultatRequete.getInt(5);
			double decouvert  = resultatRequete.getInt(6);

			
			if (typeCompte.equals("courant")) {
				compte = new CompteCourant(idCompte, solde, clientID, taux);
			}else {
				System.out.println("Le compte "+ idCompte + "n'est pas un compte courant.");;
			}
			
			return compte;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		
			try {
				if(resultatRequete!= null) resultatRequete.close();
				if(ps!= null) ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}






	
}
