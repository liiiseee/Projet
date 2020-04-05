package com.intiformation.gestionclients.dao;

import java.sql.Connection;

import com.intiformation.gestionclients.tool.DbConnection;

/**
 * interface de la dao pour le conseiller 
 * @author INTIFORMATION
 *
 */
public interface IConseillerDAO {

	// récup de la connexion 
	public Connection connection = DbConnection.getInstance();
	
	//----- méthodes de la dao 
	
	/**
	 * permet de vérifier si un conseiller existe dans la bdd 
	 * avec mail et mdp. <br/>
	 * @param pMail
	 * @param pMdp
	 * @return
	 */
	public boolean isConseillerExists(String pMail, String pMdp);
}
