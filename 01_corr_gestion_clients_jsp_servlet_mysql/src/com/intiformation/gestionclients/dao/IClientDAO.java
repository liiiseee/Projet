package com.intiformation.gestionclients.dao;

import java.sql.Connection;
import java.util.List;
import com.intiformation.gestionclients.model.Client;
import com.intiformation.gestionclients.tool.DbConnection;

/**
 * l'interface de la dao du client 
 * @author INTIFORMATION
 *
 */
public interface IClientDAO {

	// connexion à la bdd 
	public Connection connection = DbConnection.getInstance();
	
	//--------------- méthodes de la dao ---------------------------//
	
	public List<Client> getAllClients();

	public void ajouterClient(Client client);
	
	public void modifierClient(Client client);
	
	public void supprimerClientById(int pIdClient);
	
	public Client getClientById(int pIdClient);
	
}
