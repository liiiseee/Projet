package com.intiformation.gestionclients.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * impl�mentation concr�te de la couche dao du conseiller
 * @author IN-DF-029
 *
 */
public class ConseillerDaoImpl implements IConseillerDAO{

	/**
	 * permet de v�rifier si un conseiller existe dans la bdd
	 */
	@Override
	public boolean isConseillerExists(String pMail, String pMdp) {
		
		PreparedStatement ps = null;
		ResultSet rs =null;
		try {
		// 1. requ�te SQL
		String isExistsReq = "SELECT COUNT(id_conseiller) FROM conseiller WHERE email=? AND mot_de_passe=?";
		
		// 2. requ�te pr�par�e
		
			ps = this.connection.prepareStatement(isExistsReq);
			
		// 2. 1 passage de param
			ps.setString(1, pMail);
			ps.setString(2, pMdp);
			
			// ex�cution  + r�cup r�s
			rs = ps.executeQuery();
			
			// 4. lecture du r�sultat
			rs.next();
			int verifIsExists =rs.getInt(1);
			
			//5. renvoi du r�sultat
			return (verifIsExists == 1)?true:false;
			
		} catch (SQLException e) {
			System.out.println("... erreur ex�cution requ�te isConseillerExists...");
			e.printStackTrace();
		}
		
		
		return false;
	}//end isConseillerExists()

}//end class