package com.intiformation.gestionclients.dao;

import java.sql.Connection;

import com.intiformation.gestionclients.tool.DbConnection;

/**
 * interface de la dao pour le conseiller
 * @author IN-DF-029
 *
 */
public interface IConseillerDAO {

	// récup de la connexion
	public Connection connection = DbConnection.getInstance();
	
	//--------méthode de a dao-----------
	
	/**
	 * permet de vérifier si un conseiller existe dans la bdd
	 * @param pMail
	 * @param pMdp
	 * @return
	 */
	public boolean isConseillerExists(String pMail, String pMdp);
}
