package com.intiformation.gestionclients.model;

import java.io.Serializable;

/**
 * modele de données pour le conseiller. <br/>
 * modele sous forme de javabean. <br/>
 * 
 * @author INTIFORMATION
 *
 */
public class Conseiller implements Serializable {

	/* ________________________ attributs _______________________ */
	private int idConseiller;
	private String nom;
	private String email;
	private String motDePasse;

	/* ________________________ ctors _______________________ */
	/**
	 * ctor vide sans params
	 */
	public Conseiller() {
	}

	public Conseiller(int idConseiller, String nom, String email, String motDePasse) {
		this.idConseiller = idConseiller;
		this.nom = nom;
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public Conseiller(String nom, String email, String motDePasse) {
		this.nom = nom;
		this.email = email;
		this.motDePasse = motDePasse;
	}

	/* ________________________ getters/setters _______________________ */

	/**
	 * @return the idConseiller
	 */
	public int getIdConseiller() {
		return idConseiller;
	}

	/**
	 * @param idConseiller
	 *            the idConseiller to set
	 */
	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse
	 *            the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

}// end class
