package com.intiformation.gestionclients.dao;

import java.sql.Connection;
import java.util.List;

import com.intiformation.gestionclients.tool.DbConnection;

public interface ICompteDAO<Compte> {
	
/*____________ Propriétés _____________*/
	
	// récup de la connexion à la bdd via l'utilitaire ConnexionMySQL
	public Connection connection= DbConnection.getInstance();
	
	
	
	/*_____________ Méthodes ______________*/
	
	// Déclaration des méthodes à exposer dans la dao
	/**
	 * Recupere la liste des objets
	 * @return
	 */
	public List<Compte> getAll();
	
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
	public Compte getByID (int id);
	/**
	 * Ajoute un objet t
	 * @param t
	 * @return
	 */
	public boolean add (Compte compte);
	
	/**
	 * modifie l'objet t
	 * @param t
	 * @return
	 */
	
	public boolean update (Compte compte);
	
	/**
	 * Supprime l'objet par son id
	 * @param id
	 * @return
	 */
	public boolean delete(int id);
	
public List<Compte> getCompteByIDClient(int idClient);
	
	public boolean setClient(int id_compte, int idClient);
	
	public boolean deposit(Compte compte, double montant);

}
