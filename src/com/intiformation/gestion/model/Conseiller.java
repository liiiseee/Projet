package com.intiformation.gestion.model;

import java.io.Serializable;

public class Conseiller implements Serializable{
	private double idConseiller;
	private int idClient;
	
	private String nom;
	private String email;
	private String motDePasse;
	private int idCompte;
	
	/*_________________________ctor vide pour javabean_________________________*/
	public Conseiller() {
	}

	public Conseiller(double idConseiller, String nom, String email, String motDePasse) {
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
	
	
	

	public Conseiller(double idConseiller, int idClient, String nom, String email, String motDePasse) {
		super();
		this.idConseiller = idConseiller;
		this.idClient = idClient;
		this.nom = nom;
		this.email = email;
		this.motDePasse = motDePasse;
	}
	
	

	

	public Conseiller(double idConseiller, String nom, String email, String motDePasse, int idCompte) {
		super();
		this.idConseiller = idConseiller;
		this.nom = nom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.idCompte = idCompte;
	}

	public Conseiller(double idConseiller, int idClient, int idCompte, String nom, String email, String motDePasse) {
		super();
		this.idConseiller = idConseiller;
		this.idClient = idClient;
		this.idCompte = idCompte;
		this.nom = nom;
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public double getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(double idConseiller) {
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
