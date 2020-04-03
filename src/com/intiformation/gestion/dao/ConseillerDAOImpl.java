package com.intiformation.gestion.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.intiformation.gestion.model.Client;
import com.intiformation.gestion.model.Compte;

import com.intiformation.gestion.model.Conseiller;

public class ConseillerDAOImpl implements IConseillerDAO{

	
	

	@Override
	public boolean isConseillerExists(String pMail, String pMdp) {
		PreparedStatement ps = null;
		ResultSet rs =null;
		try {
		// 1. requête SQL
		String isExistsReq = "SELECT COUNT(id_conseiller) FROM conseiller WHERE email=? AND mot_de_passe=?";
		
		// 2. requête préparée
		
			ps = this.connection.prepareStatement(isExistsReq);
			
		// 2. 1 passage de param
			ps.setString(1, pMail);
			ps.setString(2, pMdp);
			
			// exécution  + récup rés
			rs = ps.executeQuery();
			
			// 4. lecture du résultat
			rs.next();
			int verifIsExists =rs.getInt(1);
			
			//5. renvoi du résultat
			return (verifIsExists == 1)?true:false;
			
		} catch (SQLException e) {
			System.out.println("... erreur exécution requête isConseillerExists...");
			e.printStackTrace();
		}
		
		
		return false;
	}//end isConseillerExists()
	
	public Conseiller getConseillerByEmail(String email, String mdp) {
		PreparedStatement ps = null;
		ResultSet resultatRequete =null;
		
		try {
			String requeteSqlGetById="SELECT * FROM conseiller WHERE email =? AND mot_de_passe=?";
			ps = this.connection.prepareStatement(requeteSqlGetById);
			ps.setString(1, email);
			ps.setString(2, mdp);
			
			resultatRequete = ps.executeQuery();
			Conseiller conseiller = null;
			
			resultatRequete.next();
			double idConseiller = resultatRequete.getInt(1);
			String nom = resultatRequete.getString(2);
			String mail = resultatRequete.getString(3);
			String motDePasse = resultatRequete.getString(4);


			conseiller = new Conseiller(idConseiller, nom, mail, motDePasse);
			
			return conseiller;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		
			try {
				if(resultatRequete!= null) resultatRequete.close();
				if(ps!= null) ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	} 
	
	

	

	

	

	public List<Conseiller> getAllConseillers() {
		PreparedStatement ps = null;
		ResultSet resultatRequete =null;
		
		try {
			String requeteSqlGetAll="SELECT * FROM conseiller";
			ps = this.connection.prepareStatement(requeteSqlGetAll);
			
			resultatRequete = ps.executeQuery();

			Conseiller conseiller = null;
			
			List<Conseiller> listeConseiller = new ArrayList <>();

			while (resultatRequete.next()) {
				double idConseiller = resultatRequete.getDouble(1);
				String nom = resultatRequete.getString(2);
				String mail = resultatRequete.getString(3);
				String motDePasse = resultatRequete.getString(4);

				conseiller = new Conseiller(idConseiller, nom, mail, motDePasse);
				
				listeConseiller.add(conseiller);
				
			}//end while
			return listeConseiller;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultatRequete!= null) resultatRequete.close();
				if(ps!= null) ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean ajouterConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifierConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimerConseillerByID(int pIDConseiller) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Conseiller getConseillerByID(int pIDConseiller) {
		PreparedStatement ps = null;
		ResultSet resultatRequete =null;
		
		try {
			String requeteSqlGetById="SELECT * FROM conseiller WHERE id_conseiller = ?";
			ps = this.connection.prepareStatement(requeteSqlGetById);
			ps.setInt(1, pIDConseiller);
			
			resultatRequete = ps.executeQuery();
			Conseiller conseiller = null;
			
			resultatRequete.next();
			double idConseiller = resultatRequete.getDouble(1);
			String nom = resultatRequete.getString(2);
			String mail = resultatRequete.getString(3);
			String motDePasse = resultatRequete.getString(4);


			conseiller = new Conseiller(idConseiller, nom, mail, motDePasse);
			
			return conseiller;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		
			try {
				if(resultatRequete!= null) resultatRequete.close();
				if(ps!= null) ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public List<Integer> getAllIDConseillers() {
		PreparedStatement ps = null;
		ResultSet resultatRequete =null;
		
		try {
			String requeteSqlGetAll="SELECT id_conseiller FROM conseiller";
			ps = this.connection.prepareStatement(requeteSqlGetAll);
			
			resultatRequete = ps.executeQuery();

			Conseiller conseiller = null;
			
			List<Integer> listeIDConseiller = new ArrayList <>();

			while (resultatRequete.next()) {
				int idConseiller = resultatRequete.getInt(1);
				
				listeIDConseiller.add(idConseiller);
				
			}//end while
			return listeIDConseiller;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultatRequete!= null) resultatRequete.close();
				if(ps!= null) ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}


	

	@Override
	public List<Client> getClientByIdConseiller(double idConseiller) {
		PreparedStatement ps = null;
		ResultSet resultatRequete =null;
		
		try {
			String requeteSqlGetAll="SELECT * FROM clients WHERE conseiller_id=?";
			ps = this.connection.prepareStatement(requeteSqlGetAll);
			
			ps.setDouble(1, idConseiller);
			
			resultatRequete = ps.executeQuery();

			Client client = null;
			
			List<Client> listeClient = new ArrayList <>();

			while (resultatRequete.next()) {
				int idClient = resultatRequete.getInt(1);
				String nom = resultatRequete.getString(2);
				String prenom = resultatRequete.getString(3);
				String adresse = resultatRequete.getString(4);
				String codePostal = resultatRequete.getString(5);
				String ville = resultatRequete.getString(6);
				String telephone = resultatRequete.getString(7);
				int conseillerId = resultatRequete.getInt(8);

				client = new Client(idClient, nom, prenom, adresse, codePostal, ville, telephone, conseillerId);
				
				listeClient.add(client);
				
			}//end while
			return listeClient;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultatRequete!= null) resultatRequete.close();
				if(ps!= null) ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Compte> getCompteByIdConseiller(double idConseiller) {
		PreparedStatement ps = null;
		ResultSet resultatRequete =null;
		
		try {
			String requeteSqlGetById="SELECT * FROM comptes WHERE conseiller_id = ?";
			ps = this.connection.prepareStatement(requeteSqlGetById);
			ps.setDouble(1, idConseiller);
			
			resultatRequete = ps.executeQuery();
			Compte compte = null;
			List<Compte> listeCompte = new ArrayList <>();

			while (resultatRequete.next()) {
				int idCompte = resultatRequete.getInt(1);
				int clientID = resultatRequete.getInt(2);
				double solde = resultatRequete.getDouble(3);
				String typeCompte = resultatRequete.getString(4);
				double taux = resultatRequete.getInt(5);
				double decouvert  = resultatRequete.getInt(6);
				double conseillerId = resultatRequete.getDouble(7);

				compte = new Compte(idCompte, solde, typeCompte, clientID, decouvert, taux, conseillerId);
				
				listeCompte.add(compte);
				
			}//end while
			return listeCompte;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		
			try {
				if(resultatRequete!= null) resultatRequete.close();
				if(ps!= null) ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	/*===========================================================================*/

	public boolean retrait(Compte compte, double montant) {
		
		PreparedStatement ps = null;
		double solde = compte.getSolde();
		int id_compte = compte.getIdCompte();

		if(montant<(solde)) {
		
		try {
			String requeteSqlAdd= "UPDATE comptes SET solde=? WHERE id_compte= ? ";
			
			ps = this.connection.prepareStatement(requeteSqlAdd);

			
			ps.setDouble(1, solde-montant);
			ps.setInt(2, id_compte);

			int verifAjout = ps.executeUpdate();

			return (verifAjout==1);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				if(ps!= null) ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//end try catch
		}//end if 
		else {
			System.out.println("Le montant demandé est trop élevé");
		}
		return false;

	}
	
	
	public boolean transfertEp(Compte compteDonneurEpargne, double montant, Compte compteReceveur) {
		PreparedStatement ps = null;
		
		double soldeReceveur = compteReceveur.getSolde();
		int id_compteReceveur = compteReceveur.getIdCompte();
		
		
		double soldeDonneur = compteDonneurEpargne.getSolde();
		int id_compteDonneur = compteDonneurEpargne.getIdCompte();
		
		if(montant<(soldeDonneur)) {
		
		try {
			String requeteSqlRemove= "UPDATE comptes SET solde=? WHERE id_compte= ? ";
			
			ps = this.connection.prepareStatement(requeteSqlRemove);

			ps.setDouble(1, soldeDonneur-montant);
			ps.setInt(2, id_compteDonneur);

			int verifTransfertDonneur = ps.executeUpdate();
			
			String requeteSqlAdd= "UPDATE comptes SET solde=? WHERE id_compte= ? ";
			
			ps = this.connection.prepareStatement(requeteSqlAdd);

			ps.setDouble(1, soldeReceveur+montant);
			ps.setInt(2, id_compteReceveur);

			int verifTransfertReceveur = ps.executeUpdate();

			return (verifTransfertDonneur+verifTransfertReceveur==2);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				if(ps!= null) ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//end try catch
		}//end if 
		else {
			System.out.println("Le montant demandé est trop élevé");
		}
		return false;

	}

	
	
	

	public boolean transfert(Compte compteDonneur, double montant, Compte compteReceveur) {
		PreparedStatement ps = null;
		
		double soldeReceveur = compteReceveur.getSolde();
		int id_compteReceveur = compteReceveur.getIdCompte();
		
		
		double soldeDonneur = compteDonneur.getSolde();
		int id_compteDonneur = compteDonneur.getIdCompte();
		double decouvertDonner = compteDonneur.getDecouvert();
		
		if(montant<(soldeDonneur+decouvertDonner)) {
		
		try {
			String requeteSqlRemove= "UPDATE comptes SET solde=? WHERE id_compte= ? ";
			
			ps = this.connection.prepareStatement(requeteSqlRemove);

			ps.setDouble(1, soldeDonneur-montant);
			ps.setInt(2, id_compteDonneur);

			int verifTransfertDonneur = ps.executeUpdate();
			
			String requeteSqlAdd= "UPDATE comptes SET solde=? WHERE id_compte= ? ";
			
			ps = this.connection.prepareStatement(requeteSqlAdd);

			ps.setDouble(1, soldeReceveur+montant);
			ps.setInt(2, id_compteReceveur);

			int verifTransfertReceveur = ps.executeUpdate();

			return (verifTransfertDonneur+verifTransfertReceveur==2);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				if(ps!= null) ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//end try catch
		}//end if 
		else {
			System.out.println("Le montant demandé est trop élevé");
		}
		return false;

	}
	
	
	public List<Client> getAllClients() {
		PreparedStatement ps = null;
		ResultSet resultatRequete =null;
		
		try {
			String requeteSqlGetAll="SELECT * FROM clients";
			ps = this.connection.prepareStatement(requeteSqlGetAll);
			
			resultatRequete = ps.executeQuery();

			Client client = null;
			
			List<Client> listeClient = new ArrayList <>();

			while (resultatRequete.next()) {
				int idClient = resultatRequete.getInt(1);
				String nom = resultatRequete.getString(2);
				String prenom = resultatRequete.getString(3);
				String adresse = resultatRequete.getString(4);
				String ville = resultatRequete.getString(5);
				String codePostal = resultatRequete.getString(6);
				
				String telephone = resultatRequete.getString(7);

				client = new Client(idClient, nom, prenom, adresse, ville, codePostal, telephone);
				
				listeClient.add(client);
				
			}//end while
			return listeClient;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultatRequete!= null) resultatRequete.close();
				if(ps!= null) ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}// end getAll()
	
	/*=============================================================================================================*/
	/*=============================================================================================================*/
	
	public List<Integer> getAllIDClient(){
		PreparedStatement ps = null;
		ResultSet resultatRequete =null;
		
		try {
			String requeteSqlGetAll="SELECT id_client FROM clients";
			ps = this.connection.prepareStatement(requeteSqlGetAll);
			
			resultatRequete = ps.executeQuery();

			Client client = null;
			
			List<Integer> listeIDClient = new ArrayList <>();

			while (resultatRequete.next()) {
				int idClient = resultatRequete.getInt(1);
				
				listeIDClient.add(idClient);
				
			}//end while
			return listeIDClient;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultatRequete!= null) resultatRequete.close();
				if(ps!= null) ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}// end getAllIDClient()
	
	/*=============================================================================================================*/
	/*=============================================================================================================*/
	
	public Client getByIDClient(int id) {
		PreparedStatement ps = null;
		ResultSet resultatRequete =null;
		
		try {
			String requeteSqlGetById="SELECT * FROM clients WHERE id_client = ?";
			ps = this.connection.prepareStatement(requeteSqlGetById);
			ps.setInt(1, id);
			
			resultatRequete = ps.executeQuery();
			Client client = null;
			
			resultatRequete.next();
			int idClient = resultatRequete.getInt(1);
			String prenom = resultatRequete.getString(2);
			String nom = resultatRequete.getString(3);
			String adresse = resultatRequete.getString(4);
			String ville = resultatRequete.getString(5);
			String codePostal = resultatRequete.getString(6);
			
			String telephone = resultatRequete.getString(7);

			client = new Client(idClient, nom, prenom, adresse, ville, codePostal, telephone);
			
			return client;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		
			try {
				if(resultatRequete!= null) resultatRequete.close();
				if(ps!= null) ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	
	/*===========================================================================*/
	/*===========================================================================*/
	
	
	
	public boolean addClient(Client client) {
		
		PreparedStatement ps = null;
		
		try {
			String requeteSqlAdd= "INSERT INTO  clients ( nom, prenom, adresse, ville, code_postal,  telephone) VALUES (?, ?, ?, ?, ?, ? )";
			
			ps = this.connection.prepareStatement(requeteSqlAdd);
			
			ps.setString(1, client.getNom());
			ps.setString(2, client.getPrenom());
			ps.setString(3, client.getAdresse());
			ps.setString(4, client.getVille());
			ps.setString (5, client.getCodePostal());
			ps.setString(6, client.getTelephone());

			int verifAjout = ps.executeUpdate();

			return (verifAjout==1);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				if(ps!= null) ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/*===========================================================================*/
	/*===========================================================================*/
	

	public boolean updateClient(Client client) {
		
		PreparedStatement ps = null;
		
		try {
	
			String requeteSqlAdd= "UPDATE clients SET  nom =?, prenom = ?, adresse=?, ville=?, code_postal=?, telephone=? WHERE id_client= ? ";
			
			ps = this.connection.prepareStatement(requeteSqlAdd);
		
			ps.setString(1, client.getPrenom());
			ps.setString(2, client.getNom());
			ps.setString(3, client.getAdresse());
			ps.setString(4, client.getVille());
			ps.setString (5, client.getCodePostal());
			
			ps.setString(6, client.getTelephone());
			
			ps.setInt(7, client.getIdClient());
			

			int verifAjout = ps.executeUpdate();
			
			return (verifAjout==1);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				if(ps!= null) ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/*===========================================================================*/
	/*===========================================================================*/


	public boolean deleteClient(int id) {
		PreparedStatement ps = null;
		
		
		try {
			
			String requeteSqlDelete= "DELETE FROM clients WHERE id_client=?";
			
			ps = this.connection.prepareStatement(requeteSqlDelete);
			
			ps.setInt(1, id);

			int verifdelete = ps.executeUpdate();

			return (verifdelete==1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!= null) ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

		return false;
	}


}
