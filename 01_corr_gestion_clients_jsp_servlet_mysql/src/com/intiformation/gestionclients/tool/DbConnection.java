package com.intiformation.gestionclients.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * utilitaire pour récupérer une connxion vers la bdd <br/>
 * implémentation du design pattern du GOF singleton
 * 
 * @author INTIFORMATION
 *
 */
public class DbConnection {

	// infos pour la connexion à la bdd
	private static final String DB_URL = "jdbc:mysql://localhost:3306/db_jsp_servlet";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	private static final String JDBC_DRIVER_CLASS = "com.mysql.jdbc.Driver";

	// déclaration de la seule intstance de la connexion à retourner
	private static Connection connection;

	/**
	 * ctor en private
	 */
	private DbConnection() {
	}

	/**
	 * permet de renvoyer la seule instance de la connexion à la bdd. <br/>
	 * 
	 * @return
	 */
	public static Connection getInstance() {

		if (connection == null) {

			try {

				// chargement du pilote jdbc de mysql
				Class.forName(JDBC_DRIVER_CLASS);
				
				// récup de la connexion du DriverManager 
				connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				
				
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("... Erreur lors de la création de la connxion à la bdd ...");
				e.printStackTrace();
			}

		} // end if

		return connection;

	}// end getInstance()

}// end class
