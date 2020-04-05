package com.intiformation.gestionclients.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.intiformation.gestionclients.model.Compte;
import com.intiformation.gestionclients.model.CompteCourant;
import com.intiformation.gestionclients.model.CompteEpargne;


public class CompteDaoImpl implements ICompteDAO<Compte> {

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
				double decouvert  = resultatRequete.getInt(6);

				
				if (typeCompte.equals("epargne")) {
					compte = new CompteEpargne(idCompte, solde, clientID, taux);
				}else {
					compte = new CompteCourant(idCompte, solde, clientID, decouvert);
				}
				
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Compte compte) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Compte compte) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Compte> getCompteByIDClient(int idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setClient(int id_compte, int idClient) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deposit(Compte compte, double montant) {
		// TODO Auto-generated method stub
		return false;
	}

}
