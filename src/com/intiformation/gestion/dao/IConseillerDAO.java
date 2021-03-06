package com.intiformation.gestion.dao;

import java.sql.Connection;
import java.util.List;

import com.intiformation.gestion.model.Client;
import com.intiformation.gestion.model.Compte;
import com.intiformation.gestion.model.Conseiller;
import com.intiformation.gestion.tool.DbConnection;


public interface IConseillerDAO {
	
	public Connection connection = DbConnection.getInstance();
	public List<Compte> getCompteByIdConseiller(double idConseiller);
	public List<Client> getClientByIdConseiller(double idConseiller);
	

	public boolean isConseillerExists(String pMail, String pMdp);
	
	public Conseiller getConseillerByEmail(String email, String mdp);
	
	public List<Conseiller> getAllConseillers();

	public boolean ajouterConseiller(Conseiller conseiller);
	
	public boolean modifierConseiller(Conseiller conseiller);
	
	public boolean supprimerConseillerByID(int pIDConseiller);
	
	public Conseiller getConseillerByID(int pIDConseiller);
	
	public List<Integer> getAllIDConseillers();
	
	
}
