package com.intiformation.gestion.dao;

import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.intiformation.gestion.model.Client;
import com.intiformation.gestion.model.Compte;


public class ClientDAOImpl implements IClientDAO{

	/*===========================================================================*/
	/*===========================================================================*/
	

	
	@Override
	public List<Integer> getAllIDClients(){
		PreparedStatement ps = null;
		ResultSet resultatRequete =null;
		
		try {
			String requeteSqlGetAll="SELECT id_client FROM clients";
			ps = this.connection.prepareStatement(requeteSqlGetAll);
			
			resultatRequete = ps.executeQuery();

			Client client = null;
			
			List<Integer> listeIDClient = new ArrayList <>();

			while (resultatRequete.next()) {
				int idClient = resultatRequete.getInt(1);
				
				listeIDClient.add(idClient);
				
			}//end while
			return listeIDClient;
		
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
	}// end getAllID()
		
	/*===========================================================================*/
	/*===========================================================================*/
	
	
	@Override
	public Client getClientById(int idClient) {
		PreparedStatement ps = null;
		ResultSet resultatRequete =null;
		
		try {
			String requeteSqlGetById="SELECT * FROM clients WHERE id_client = ?";
			ps = this.connection.prepareStatement(requeteSqlGetById);
			ps.setInt(1, idClient);
			
			resultatRequete = ps.executeQuery();
			Client client = null;
			
			resultatRequete.next();
			int iDClient = resultatRequete.getInt(1);
			String prenom = resultatRequete.getString(2);
			String nom = resultatRequete.getString(3);
			String adresse = resultatRequete.getString(4);
			String ville = resultatRequete.getString(5);
			String codePostal = resultatRequete.getString(6);
			
			String telephone = resultatRequete.getString(7);
			double conseillerID = resultatRequete.getDouble(8);

			client = new Client(iDClient, nom, prenom, adresse, ville, codePostal, telephone, conseillerID);
			
			return client;
		
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
	public boolean addClient(Client client) {
		
		PreparedStatement ps = null;
		
		try {
			String requeteSqlAdd= "INSERT INTO  clients (nom,prenom,adresse,code_postal,ville,telephone,conseiller_id) VALUES (?, ?, ?, ?, ?, ?,? )";
			
			ps = this.connection.prepareStatement(requeteSqlAdd);
			
			
			ps.setString(1, client.getNom());
			ps.setString(2, client.getPrenom());
			ps.setString(3, client.getAdresse());
			
			ps.setString(4, client.getVille());
			ps.setString (5, client.getCodePostal());
			ps.setString(6, client.getTelephone());
			ps.setDouble(7, client.getConseillerId());

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
	
	@Override
	public boolean updateClient(Client client) {
		
		PreparedStatement ps = null;
		
		try {
	
			String requeteSqlAdd= "UPDATE clients SET  nom =?, prenom = ?, adresse=?, ville=?, code_postal=?, telephone=?, conseiller_id=? WHERE id_client= ? ";
			
			ps = this.connection.prepareStatement(requeteSqlAdd);
			ps.setString(1, client.getNom());
			ps.setString(2, client.getPrenom());
		    ps.setString(3, client.getAdresse());
			
			ps.setString(4, client.getVille());
			ps.setString (5, client.getCodePostal());
			ps.setString(6, client.getTelephone());
			ps.setDouble(7, client.getConseillerId());
			ps.setInt(8, client.getIdClient());
			

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

	@Override
	public boolean deleteClient(int id) {
		PreparedStatement ps = null;
		
		
		try {
			
			String requeteSqlDelete= "DELETE FROM clients WHERE id_client=?";
			
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
	public List<Client> getAllClients() {
		PreparedStatement ps = null;
		ResultSet resultatRequete =null;
		
		try {
			String requeteSqlGetAll="SELECT * FROM clients";
			ps = this.connection.prepareStatement(requeteSqlGetAll);
			
			resultatRequete = ps.executeQuery();

			Client client = null;
			
			List<Client> listeClient = new ArrayList <>();

			while (resultatRequete.next()) {
				int idClient = resultatRequete.getInt(1);
				String nom = resultatRequete.getString(2);
				String prenom = resultatRequete.getString(3);
				String adresse = resultatRequete.getString(4);
				String ville = resultatRequete.getString(5);
				String codePostal = resultatRequete.getString(6);
				
				String telephone = resultatRequete.getString(7);
				Double idConseiller = resultatRequete.getDouble(8);

				client = new Client(idClient, nom, prenom, adresse, ville, codePostal, telephone, idConseiller);
				
				listeClient.add(client);
				
			}//end while
			return listeClient;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}




	


	@Override
	public List<Client> getClientByIdConseiller(double idConseiller) {
		PreparedStatement ps = null;
		ResultSet resultatRequete =null;
		
		try {
			String requeteSqlGetById="SELECT * FROM clients WHERE conseiller_id = ?";
			ps = this.connection.prepareStatement(requeteSqlGetById);
			ps.setDouble(1, idConseiller);
			
			resultatRequete = ps.executeQuery();
			Client client = null;
			List<Client> listeClient = new ArrayList <>();

			while (resultatRequete.next()) {
				int idClient = resultatRequete.getInt(1);
				String nom = resultatRequete.getString(2);
				String prenom = resultatRequete.getString(3);
				String adresse = resultatRequete.getString(4);
				String ville = resultatRequete.getString(5);
				String codePostal = resultatRequete.getString(6);
				
				String telephone = resultatRequete.getString(7);
				Double iDConseiller = resultatRequete.getDouble(8);

				client = new Client(idClient, nom, prenom, adresse, ville, codePostal, telephone, iDConseiller);
				
				listeClient.add(client);
				
			}//end while
			return listeClient;
			
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


	
}// end class
