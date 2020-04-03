package com.intiformation.gestionclients.dao;

import java.sql.Connection;

import com.intiformation.gestionclients.tool.DbConnection;

/**
 * interface de la dao pour le conseiller
 * @author IN-DF-029
 *
 */
public interface IConseillerDAO {

	// r�cup de la connexion
	public Connection connection = DbConnection.getInstance();
	
	//--------m�thode de a dao-----------
	
	/**
	 * permet de v�rifier si un conseiller existe dans la bdd
	 * @param pMail
	 * @param pMdp
	 * @return
	 */
	public boolean isConseillerExists(String pMail, String pMdp);
}
