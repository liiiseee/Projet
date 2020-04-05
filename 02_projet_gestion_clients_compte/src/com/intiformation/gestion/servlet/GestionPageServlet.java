package com.intiformation.gestion.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.intiformation.gestion.model.Client;
import com.intiformation.gestion.model.Compte;
import com.intiformation.gestion.model.Conseiller;
import com.intiformation.gestion.dao.ClientDAOImpl;
import com.intiformation.gestion.dao.CompteDaoImpl;
import com.intiformation.gestion.dao.ConseillerDAOImpl;
import com.intiformation.gestion.dao.IClientDAO;
import com.intiformation.gestion.dao.ICompteDAO;
import com.intiformation.gestion.dao.IConseillerDAO;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="GestionPagesServlet", urlPatterns= {"/gestion-pages-servlet"})
public class GestionPageServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. Init des objets dao et listes
		IClientDAO clientDAO =new ClientDAOImpl();
		ICompteDAO compteDAO = new CompteDaoImpl();
		IConseillerDAO conseillerDAO = new ConseillerDAOImpl();
		List<Client> listeClients=null;
		
		//1. r�cup de la valeur du parametre 'action' 
		String userAction =request.getParameter("action");
		
		//2. test de la valeur 
		switch(userAction) {
		
		case "dashboard":
			//Recup de la session associ� � la requete + false=ne cr�e pas de nouvelle session
				
				
				HttpSession session = request.getSession(false);
				
				// Recup du conseiller connect�
				Conseiller conseillerlogged=(Conseiller)session.getAttribute("conseillerLogged");
				
				//R�cup de la liste des clients appartenant au conseiller 
				
				List<Client> listeClientsConseiller = conseillerDAO.getClientByIdConseiller(conseillerlogged.getIdConseiller());
				
				
				//R�cup de la liste des comptes appartenant � ses clients
				
				List<Compte> listeComptesConseiller=new ArrayList<>();
				List<Compte> listeCompteClient=new ArrayList<>();
				
				//Concat�nation des listes de comptes de chaque client
				for(Client client : listeClientsConseiller) {
					listeCompteClient= compteDAO.getCompteByIDClient(client.getIdClient());
					listeComptesConseiller.addAll(listeCompteClient);
				}
				
				//Sauvegarde de la liste des clients dans un attribut de la requete
				request.setAttribute("liste_clients", listeClientsConseiller);
				request.setAttribute("liste_comptes", listeComptesConseiller);

				// d�l�gation vers la page d'accueil
				request.getRequestDispatcher("/menu.jsp").forward(request,  response);
				
				break;
				
		case "chercherClient":
			//Redirection vers la page 'chercher-client.jsp'

			request.getRequestDispatcher("/chercher-client.jsp").forward(request, response);
			
			break;
			
		case "menuCompte":
			List<Compte> listeComptesBdd = compteDAO.getAll();
			
			request.setAttribute("liste_comptes", listeComptesBdd);
			request.getRequestDispatcher("/menu-comptes.jsp").forward(request, response);
			
			break;
			
		case "menuClient":
			request.getRequestDispatcher("/menu-client.jsp").forward(request, response);
				
				
			default:
				break;
				}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	



}