package com.intiformation.gestionclients.dao;

import java.sql.Connection;
import java.util.List;

import com.intiformation.gestionclients.model.Client;
import com.intiformation.gestionclients.tool.DbConnection;

/**
 * interface de la dao du client
 * @author IN-DF-029
 *
 */
public interface IClientDAO{
	
	//connexion à la bdd
	public Connection connection = DbConnection.getInstance();
	
	//--------méthode qui retourne liste des clients
	public List<Client> getAllClients();

	public void ajouterClient(Client client);
	
	public void modifierClient(Client client);
	public void supprimerClient(int pIdClient);
	public  Client getClientById(int pIdClient);
		

}
