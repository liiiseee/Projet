package com.intiformation.gestionclients.model;

import java.io.Serializable;

public class Conseiller implements Serializable{
	private int idConseiller;
	private String nom;
	private String email;
	private String motDePasse;
	
	/*_________________________ctor vide pour javabean_________________________*/
	public Conseiller() {
	}

	public Conseiller(int idConseiller, String nom, String email, String motDePasse) {
		super();
		this.idConseiller = idConseiller;
		this.nom = nom;
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public Conseiller(String nom, String email, String motDePasse) {
		super();
		this.nom = nom;
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	
	
	

}
