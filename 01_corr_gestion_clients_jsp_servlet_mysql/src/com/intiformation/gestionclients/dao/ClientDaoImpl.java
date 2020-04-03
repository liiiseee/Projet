package com.intiformation.gestionclients.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.intiformation.gestionclients.model.Client;

/**
 * l'implémentation concrète de la dao du client.<br/>
 * @author INTIFORMATION
 *
 */
public class ClientDaoImpl implements IClientDAO{

	/**
	 * récup de la liste des clients dans la bdd. <br/>
	 */
	@Override
	public List<Client> getAllClients() {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
		// requête préparée 
		ps = this.connection.prepareStatement("SELECT * FROM clients");
		
		// exécution + résultat 
		rs = ps.executeQuery();
		
		List<Client> listeClients = new ArrayList<>();
		Client client = null;
		
		while (rs.next()) {
			
			client = new Client(rs.getInt(1), 
					            rs.getString(2), 
					            rs.getString(3), 
					            rs.getString(4), 
					            rs.getString(5), 
					            rs.getString(6), 
					            rs.getString(7));
			
			listeClients.add(client);
			
		}//end while
			
			return listeClients;
			
			
		} catch (SQLException e) {
			System.out.println("... erreur lors de l'exécution de la requête getAllClients de la dao ...");
			e.printStackTrace();
		}
		
		return null;
		
	}//end getAllClients()

	/**
	 * ajout d'un client 
	 */
	@Override
	public void ajouterClient(Client client) {
		

		PreparedStatement ps = null;
		
		try {
			
		// requête préparée 
		ps = this.connection.prepareStatement("INSERT INTO clients (nom,prenom,adresse,code_postal,ville,telephone) "
				                            + "VALUES (?,?,?,?,?,?)");
		
		ps.setString(1, client.getNom());
		ps.setString(2, client.getPrenom());
		ps.setString(3, client.getAdresse());
		ps.setString(4, client.getCodePostal());
		ps.setString(5, client.getVille());
		ps.setString(6, client.getTelephone());
		
		// exécution + résultat 
		ps.executeUpdate();
							
		} catch (SQLException e) {
			System.out.println("... erreur lors de l'exécution de la requête ajouterClient() de la dao ...");
			e.printStackTrace();
		}
		
		
	}//end ajouterClient

	/**
	 * modif d'un client 
	 */
	@Override
	public void modifierClient(Client client) {
		
		PreparedStatement ps = null;
		
		try {
			
		// requête préparée 
		ps = this.connection.prepareStatement("UPDATE clients "
				                            + "SET nom=?, prenom=?, adresse=?, code_postal=?, ville=?, telephone=?"
				                            + "WHERE id_client=?");
		
		ps.setString(1, client.getNom());
		ps.setString(2, client.getPrenom());
		ps.setString(3, client.getAdresse());
		ps.setString(4, client.getCodePostal());
		ps.setString(5, client.getVille());
		ps.setString(6, client.getTelephone());
		ps.setInt(7, client.getIdClient());
		
		// exécution + résultat 
		ps.executeUpdate();
							
		} catch (SQLException e) {
			System.out.println("... erreur lors de l'exécution de la requête modifierClien() de la dao ...");
			e.printStackTrace();
		}
		
	}//end modifierClient()

	/**
	 * suppression d'un client 
	 */
	@Override
	public void supprimerClientById(int pIdClient) {
		
		PreparedStatement ps = null;
		
		try {
			
		// requête préparée 
		ps = this.connection.prepareStatement("DELETE FROM clients WHERE id_client=?");
		
		ps.setInt(1, pIdClient);
		
		// exécution + résultat 
		ps.executeUpdate();
							
		} catch (SQLException e) {
			System.out.println("... erreur lors de l'exécution de la requête supprimerClientById() de la dao ...");
			e.printStackTrace();
		}
		
	}//end supprimerClientById

	/**
	 * récup d'un client par son id 
	 */
	@Override
	public Client getClientById(int pIdClient) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
		// requête préparée 
		ps = this.connection.prepareStatement("SELECT * FROM clients WHERE id_client=?");
		
		ps.setInt(1, pIdClient);
		
		// exécution + résultat 
		rs = ps.executeQuery();
		
		Client client = null;
		
		rs.next();
			
		client = new Client(rs.getInt(1), 
					        rs.getString(2), 
					        rs.getString(3), 
					        rs.getString(4), 
					        rs.getString(5), 
					        rs.getString(6), 
					        rs.getString(7));
			System.out.println("client get by id -------------------- " + client);
			
			
			return client;
			
		} catch (SQLException e) {
			System.out.println("... erreur lors de l'exécution de la requête getClientByID de la dao ...");
			e.printStackTrace();
		}
		
		return null;
		
		
	}//end getClientById

}//end class



