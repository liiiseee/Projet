package com.intiformation.gestion.dao;

import java.sql.Connection;
import java.util.List;



import com.intiformation.gestion.model.Compte;

import com.intiformation.gestion.tool.DbConnection;

public interface ICompteDAO {
	
	
	public Connection connection=DbConnection.getInstance();
	
	public List<Compte> getCompteByIDClient(int idClient);
	
	public boolean setClient(int id_compte, int idClient);
	
	public boolean deposit(Compte compte, double montant);
	
	public List<Compte> getCompteByIdConseiller(double idConseiller);
	
public List<Compte> getAll();

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
	
	
	public boolean update (Compte compte);
	
	public boolean delete(int id);
	
	public boolean retrait(Compte compte, double montant);
	

	
	
	public Compte getCompteByID(int pIDCompte);
	
	
	
	public boolean transfert(Compte compteDonneur, Compte compteReceveur, double montant);


}
