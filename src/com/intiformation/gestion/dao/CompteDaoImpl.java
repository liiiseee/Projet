package com.intiformation.gestion.dao;

import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.intiformation.gestion.model.Compte;


public class CompteDaoImpl implements ICompteDAO {
	
	double montant;
	


	@Override
	public List<Compte> getCompteByIdConseiller(double idConseiller) {
		PreparedStatement ps = null;
		ResultSet resultatRequete =null;
		
		try {
			String requeteSqlGetById="SELECT * FROM comptes WHERE conseiller_id = ?";
			ps = this.connection.prepareStatement(requeteSqlGetById);
			ps.setDouble(1, idConseiller);
			
			resultatRequete = ps.executeQuery();
			Compte compte = null;
			List<Compte> listeCompte = new ArrayList <>();

			while (resultatRequete.next()) {
				int idCompte = resultatRequete.getInt(1);
				int clientID = resultatRequete.getInt(2);
				double solde = resultatRequete.getDouble(3);
				String typeCompte = resultatRequete.getString(4);
				double taux = resultatRequete.getInt(5);
				double decouvert  = resultatRequete.getInt(6);
				double conseillerId = resultatRequete.getDouble(7);

				compte = new Compte(idCompte, solde, typeCompte, clientID, decouvert, taux, conseillerId);
				
				listeCompte.add(compte);
				
			}//end while
			return listeCompte;
			
			
			
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

	@Override
	public List<Compte> getAll() {
		PreparedStatement ps = null;
		ResultSet resultatRequete =null;
		
		try {
			String requeteSqlGetAll="SELECT * FROM comptes";
			ps = this.connection.prepareStatement(requeteSqlGetAll);
			
			resultatRequete = ps.executeQuery();

			Compte compte = null;
			
			List<Compte> listeCompte = new ArrayList <>();

			while (resultatRequete.next()) {
				int idCompte = resultatRequete.getInt(1);
				int clientID = resultatRequete.getInt(2);
				double solde = resultatRequete.getDouble(3);
				String typeCompte = resultatRequete.getString(4);
				double taux = resultatRequete.getInt(5);
				double decouvert  = resultatRequete.getDouble(6);
				double idConseiller  = resultatRequete.getDouble(7);
			

				compte = new Compte(idCompte, solde, typeCompte, clientID, decouvert, taux, idConseiller);
				
				listeCompte.add(compte);
				
			}//end while
			return listeCompte;
		
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

	@Override
	public List<Integer> getAllID() {
		PreparedStatement ps = null;
		ResultSet resultatRequete =null;
		
		try {
			String requeteSqlGetAll="SELECT id_compte FROM comptes";
			ps = this.connection.prepareStatement(requeteSqlGetAll);
			
			resultatRequete = ps.executeQuery();
			
			List<Integer> listeIDCompte = new ArrayList <>();

			while (resultatRequete.next()) {
				int idCompte = resultatRequete.getInt(1);
				
				listeIDCompte.add(idCompte);
				
			}//end while
			return listeIDCompte;
		
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

	@Override
	public Compte getByID(int id) {
		PreparedStatement ps = null;
		ResultSet resultatRequete =null;
		
		try {
			String requeteSqlGetById="SELECT * FROM comptes WHERE id_compte = ?";
			ps = this.connection.prepareStatement(requeteSqlGetById);
			ps.setInt(1, id);
			
			resultatRequete = ps.executeQuery();
			Compte compte = null;
			
			resultatRequete.next();
			
			int idCompte = resultatRequete.getInt(1);
			int clientID = resultatRequete.getInt(2);
			double solde = resultatRequete.getDouble(3);
			String typeCompte = resultatRequete.getString(4);
			double taux = resultatRequete.getInt(5);
			double decouvert  = resultatRequete.getInt(6);
			double conseillerId = resultatRequete.getDouble(7);

			
			compte = new Compte(idCompte, solde, typeCompte, clientID, decouvert, taux, conseillerId);
			
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

	
	@Override
	public boolean delete(int id) {
PreparedStatement ps = null;
		
		
		try {
			
			String requeteSqlDelete= "DELETE FROM comptes WHERE id_compte=?";
			
			ps = this.connection.prepareStatement(requeteSqlDelete);
			
			ps.setInt(1, id);

			int verifdelete = ps.executeUpdate();

			return (verifdelete==1);
			
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

	@Override
	public List<Compte> getCompteByIDClient(int idClient) {
		PreparedStatement ps = null;
		ResultSet resultatRequete =null;
		
		try {
			String requeteSqlGetById="SELECT * FROM comptes WHERE client_id = ?";
			ps = this.connection.prepareStatement(requeteSqlGetById);
			ps.setInt(1, idClient);
			
			resultatRequete = ps.executeQuery();
			Compte compte = null;
			List<Compte> listeCompte = new ArrayList <>();

			while (resultatRequete.next()) {
				int idCompte = resultatRequete.getInt(1);
				int clientID = resultatRequete.getInt(2);
				double solde = resultatRequete.getDouble(3);
				String typeCompte = resultatRequete.getString(4);
				double taux = resultatRequete.getInt(5);
				double decouvert  = resultatRequete.getInt(6);
				double conseillerId = resultatRequete.getDouble(7);

				
				compte = new Compte(idCompte, solde, typeCompte, clientID, decouvert, taux, conseillerId);
				listeCompte.add(compte);
				
			}//end while
			return listeCompte;
			
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

	@Override
	public boolean setClient(int id_compte, int idClient) {
PreparedStatement ps = null;
		
		try {
			String requeteSqlAdd= "UPDATE comptes SET client_id=? WHERE id_compte= ? ";
			
			ps = this.connection.prepareStatement(requeteSqlAdd);
			

			ps.setDouble(1, idClient);
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
		}
		return false;
	}

	@Override
	public boolean deposit(Compte compte, double montant) {
		PreparedStatement ps = null;
		double solde = compte.getSolde();
		int id_compte = compte.getIdCompte();
		montant = compte.getMontant();
		
		try {
			String requeteSqlAdd= "UPDATE comptes SET solde=? WHERE id_compte= ? ";
			
			ps = this.connection.prepareStatement(requeteSqlAdd);
			
			ps.setDouble(1, solde+montant);
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
		}
		return false;
	}



	@Override
	public boolean add(Compte compte) {
PreparedStatement ps = null;
		
		try {
			String requeteSqlAdd= "INSERT INTO  comptes ( client_id , solde, type_compte, taux, autorisation_decouvert, conseiller_id) VALUES (?, ?, ?, ?, ?,?)";
			
			ps = this.connection.prepareStatement(requeteSqlAdd);
			
			if(compte.getClientID()==0) {
				ps.setString(1, null);
			}else {
				ps.setInt(1, compte.getClientID());
			}
			
			ps.setDouble(2, compte.getSolde());
			ps.setString(3, compte.getTypeCompte());
			ps.setDouble(4, compte.getTaux());
			ps.setDouble(5, compte.getDecouvert());
			ps.setDouble(6, compte.getConseillerId());

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

	@Override
	public boolean update(Compte compte) {
PreparedStatement ps = null;
		
		try {
			String requeteSqlAdd= "UPDATE comptes SET client_id=? , solde=?, type_compte=? , taux=?, autorisation_decouvert=?, conseiller_id=? WHERE id_compte= ?";
			
			ps = this.connection.prepareStatement(requeteSqlAdd);
			
			ps.setInt(1, compte.getClientID());
			ps.setDouble(2, compte.getSolde());
			ps.setString(3, compte.getTypeCompte());
			ps.setDouble(4, compte.getTaux());
			ps.setDouble(5, compte.getDecouvert());
			ps.setDouble(6, compte.getConseillerId());
			ps.setInt(7, compte.getIdCompte());
			

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

	@Override
	public Compte getCompteByID(int pIDCompte) {
		PreparedStatement ps = null;
		ResultSet resultatRequete =null;
		
		try {
			String requeteSqlGetById="SELECT * FROM comptes WHERE id_compte = ?";
			ps = this.connection.prepareStatement(requeteSqlGetById);
			ps.setInt(1, pIDCompte);
			
			resultatRequete = ps.executeQuery();
			Compte compte = null;
			
			resultatRequete.next();
			
			int idCompte = resultatRequete.getInt(1);
			int clientID = resultatRequete.getInt(2);
			double solde = resultatRequete.getDouble(3);
			String typeCompte = resultatRequete.getString(4);
			double taux = resultatRequete.getInt(5);
			double decouvert  = resultatRequete.getInt(6);
			double conseillerId = resultatRequete.getDouble(7);

			compte= new Compte(idCompte, solde, typeCompte, clientID, decouvert, taux, conseillerId);
			
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

	@Override
	public boolean retrait(Compte compte, double montant) {
		PreparedStatement ps = null;
		double solde = compte.getSolde();
		int id_compte = compte.getIdCompte();
		montant = compte.getMontant();

		if(montant<(solde)) {
		
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

	@Override
	public boolean transfert(Compte compteDonneur, Compte compteReceveur, double montant) {
		Compte compteDonn = getCompteByID(compteDonneur.getIdCompte());
		Compte compteRec = getCompteByID(compteDonneur.getIdCompteRec());
		
		
	
PreparedStatement ps = null;
		
		double soldeReceveur = compteRec.getSolde(); //getSolde
		int id_compteReceveur = compteRec.getIdCompte(); //getIdCompte
		//Compte compte = new Compte();
		
		
		double soldeDonneur = compteDonn.getSolde();
		int id_compteDonneur = compteDonn.getIdCompte();
		double decouvertDonner = compteDonn.getDecouvert();
		
		if(montant<(soldeDonneur+decouvertDonner)) {
		
		try {
			String requeteSqlRemove= "UPDATE comptes SET solde=? WHERE id_compte= ? ";
			
			ps = this.connection.prepareStatement(requeteSqlRemove);
			double resultat = soldeDonneur-montant;
			System.out.println(resultat);
			ps.setDouble(1, resultat);
			ps.setInt(2, id_compteDonneur);

			int verifTransfertDonneur = ps.executeUpdate();
			
			String requeteSqlAdd= "UPDATE comptes SET solde=? WHERE id_compte= ? ";
			
			ps = this.connection.prepareStatement(requeteSqlAdd);
			
			resultat = soldeReceveur+montant;
			System.out.println(resultat);
			ps.setDouble(1, resultat);
			
			ps.setInt(2, id_compteReceveur);
			

			int verifTransfertReceveur = ps.executeUpdate();
			System.out.println(soldeDonneur);
			System.out.println(soldeReceveur);

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

	
	
	
	/*==============================getters/setters=============================*/
	
	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	
}
