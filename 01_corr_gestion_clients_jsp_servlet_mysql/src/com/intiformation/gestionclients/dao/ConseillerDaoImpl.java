package com.intiformation.gestionclients.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * implémentation concrète de la couche dao du conseiller. <br/>
 * 
 * @author INTIFORMATION
 *
 */
public class ConseillerDaoImpl implements IConseillerDAO {

	/**
	 * permet de vérifier si un conseiller existe dans la bdd avec mail et mdp.
	 * <br/>
	 * 
	 * @param pMail
	 * @param pMdp
	 * @return
	 */
	@Override
	public boolean isConseillerExists(String pMail, String pMdp) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			// 1. requete SQL
			String isExistsReq = "SELECT COUNT(id_conseiller) FROM conseiller WHERE mail=? AND mot_de_passe=?";

			// 2. requete préparée
			ps = this.connection.prepareStatement(isExistsReq);
			
			// 2.1. passage de params à la requête préparée 
			ps.setString(1, pMail);
			ps.setString(2, pMdp);
			
			// 3. exécution + récup du résultat 
			rs = ps.executeQuery();
			
			// 4. lecture du résultat 
			rs.next();
			int verifIsExists = rs.getInt(1);
			
			//5. revoi du résultat 
			return (verifIsExists == 1)?true:false;
			
		} catch (SQLException e) {
			System.out.println("... erreur d'exécution de la requête isConseillerExists ...");
			e.printStackTrace();
		}

		return false;

	}// end isConseillerExists()

}// end class
