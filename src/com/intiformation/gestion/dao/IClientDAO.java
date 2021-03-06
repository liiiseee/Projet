package com.intiformation.gestion.dao;

import java.sql.Connection;

import java.util.List;

import com.intiformation.gestion.model.Client;

import com.intiformation.gestion.tool.DbConnection;


public interface IClientDAO {
	public Connection connection = DbConnection.getInstance();
	
	public List<Client> getAllClients();

	public boolean addClient(Client client);
	
	public boolean updateClient(Client client);
	
	public boolean deleteClient(int pIdClient);
	
	public Client getClientById(int idClient);
	
	public List<Client> getClientByIdConseiller(double idConseiller);
	
	public List<Integer> getAllIDClients();
	
	

}
