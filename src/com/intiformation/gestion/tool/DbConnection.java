package com.intiformation.gestion.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnection {
	
	//infos pour la connexion à la bdd
		private static final String DB_URL= "jdbc:mysql://localhost:3306/db_jsp_servlet";
		private static final String DB_USER = "root";
		private static final String DB_PASSWORD ="root";
		private static final String JDBC_DRIVER_CLASS ="com.mysql.jdbc.Driver";
		
		//déclaration de la seule instance de la connexion
		private static Connection connection;
		
		private DbConnection() {}
		
		/**
		 * permet de renvoyer la seule instance de la connexion à la bdd
		 * @return
		 */
		public static Connection getInstance() {
			if (connection == null) {
				try {
					//chargement du pilote
					Class.forName(JDBC_DRIVER_CLASS);
					
					//récup de la connexion du driver
					connection = DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD);
					
				} catch (ClassNotFoundException  |SQLException e) {
					System.out.println("... ERREUR lors de la création de la connexion à la bdd...");
					e.printStackTrace();
				}
			}// end if
			return connection;
		}//end getInstance()

}
