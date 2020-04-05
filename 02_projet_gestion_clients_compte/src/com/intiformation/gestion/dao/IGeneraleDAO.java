package com.intiformation.gestion.dao;

import java.sql.Connection;
import java.util.List;

import com.intiformation.gestion.model.Compte;
import com.intiformation.gestion.tool.DbConnection;



public interface IGeneraleDAO<T> {
	
	/*____________ Propri�t�s _____________*/
	
	// r�cup de la connexion � la bdd via l'utilitaire ConnexionMySQL
	public Connection connection= DbConnection.getInstance();
	
	
	
	/*_____________ M�thodes ______________*/
	
	// D�claration des m�thodes � exposer dans la dao
	/**
	 * Recupere la liste des objets
	 * @return
	 */
	public List<T> getAll();
	
	
	/**
	 * Recupere la liste des identifiants des objets
	 * @return
	 */
	public List<Integer> getAllID();
	
	/**
	 * recuperer 1 objet par son id de la bdd
	 * @param id
	 * @return
	 */
	public T getByID (int id);
	/**
	 * Ajoute un objet t
	 * @param t
	 * @return
	 */
	public boolean add (T t);
	
	/**
	 * modifie l'objet t
	 * @param t
	 * @return
	 */
	
	public boolean update (T t);
	
	/**
	 * Supprime l'objet par son id
	 * @param id
	 * @return
	 */
	public boolean delete(int id);

	

}//end interface

