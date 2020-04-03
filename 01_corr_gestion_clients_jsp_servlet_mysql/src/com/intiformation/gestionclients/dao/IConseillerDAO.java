package com.intiformation.gestionclients.dao;

import java.sql.Connection;

import com.intiformation.gestionclients.tool.DbConnection;

/**
 * interface de la dao pour le conseiller 
 * @author INTIFORMATION
 *
 */
public interface IConseillerDAO {

	// r�cup de la connexion 
	public Connection connection = DbConnection.getInstance();
	
	//----- m�thodes de la dao 
	
	/**
	 * permet de v�rifier si un conseiller existe dans la bdd 
	 * avec mail et mdp. <br/>
	 * @param pMail
	 * @param pMdp
	 * @return
	 */
	public boolean isConseillerExists(String pMail, String pMdp);
}
