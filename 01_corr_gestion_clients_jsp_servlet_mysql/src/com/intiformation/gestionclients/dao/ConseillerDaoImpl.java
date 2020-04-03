package com.intiformation.gestionclients.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * impl�mentation concr�te de la couche dao du conseiller. <br/>
 * 
 * @author INTIFORMATION
 *
 */
public class ConseillerDaoImpl implements IConseillerDAO {

	/**
	 * permet de v�rifier si un conseiller existe dans la bdd avec mail et mdp.
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

			// 2. requete pr�par�e
			ps = this.connection.prepareStatement(isExistsReq);
			
			// 2.1. passage de params � la requ�te pr�par�e 
			ps.setString(1, pMail);
			ps.setString(2, pMdp);
			
			// 3. ex�cution + r�cup du r�sultat 
			rs = ps.executeQuery();
			
			// 4. lecture du r�sultat 
			rs.next();
			int verifIsExists = rs.getInt(1);
			
			//5. revoi du r�sultat 
			return (verifIsExists == 1)?true:false;
			
		} catch (SQLException e) {
			System.out.println("... erreur d'ex�cution de la requ�te isConseillerExists ...");
			e.printStackTrace();
		}

		return false;

	}// end isConseillerExists()

}// end class
