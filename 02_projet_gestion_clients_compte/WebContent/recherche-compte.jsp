<%@page import="com.intiformation.gestion.model.Client"%>
<%@page import="com.intiformation.gestion.model.Conseiller"%>
<%@page import="java.util.List"%>
<%@page import="com.intiformation.gestion.model.Compte"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>recherche compte</title>
<!-- Bootstrap core CSS -->
<link href="assets/styles/bootstrap.min.css" rel="stylesheet">

  


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="assets/styles/styleModif.css" rel="stylesheet">
</head>
<body class="bg-light">
 <nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Gestion des comptes</a>
  <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
  <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <a class="nav-link" href="authentification-servlet?destroy=true">Se déconnecter</a>
    </li>
  </ul>
</nav>

<div class="container-fluid" >
  <div class="row">
    <nav class="col-md-2 d-none d-md-block bg-light sidebar" >
      <div class="sidebar-sticky">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" href="#">
              <span data-feather="home"></span>
              Liste des comptes
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ajout-compte.jsp">
              <span data-feather="file"></span>
              Ajouter un nouveau compte
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="attribuer-compte.jsp">
              <span data-feather="file"></span>
              Attribuer un compte à un client
            </a>
          </li>
         <li class="nav-item">
            <a class="nav-link" href="gestion-pages-servlet?action=chercherCompte">
              <span data-feather="shopping-cart"></span>
              Chercher un compte<span class="sr-only">(current)</span>
            </a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="gestion-pages-servlet?action=menuCompte">
              <span data-feather="users"></span>
            Retour au menu des comptes
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="menu.jsp">
              <span data-feather="bar-chart-2"></span>
              Retour au menu principal
            </a>
          </li>
          </ul>
          

       
      </div>
    </nav>
    </div>
    </div>
<!-- ====================================================================================== -->
<!-- ====================== Section principale (Main)  ==================================== -->
<!-- ====================================================================================== -->	

<main role="main" class="col-md-9 ml-sm-auto col-lg-9 px-4">		<!-- == Ouverture du main ======== -->
    
    <!-- --------------Titre de la page ------------------------------------ -->
    
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Gestion des comptes</h1>
      </div>


	<!-- -------Formulaire pour chercher un compte ----------------------- -->
	
      <h5>Chercher un compte</h5>

			<form method="post" action="gestion-compte-servlet">
			  <div class="form-row">
			    <div class="col-md-4 mb-3">
			      <label for="validationDefault01"></label>
			      <input name="pIdCompte" type="text" class="form-control" id="validationDefault02" placeholder="Identifiant" required>
			    </div>
			    <div class="col-md-3 mb-3">
	      				<input type="hidden" name="action" value="cherche"/>
	    		</div>
	    		
			  </div>
			  <button class="btn btn-primary btn-sm" type="submit">Chercher</button>
			</form>
		
		<br/>
		<br/>
		
		
		
	<!-- -------Affichage du compte recherché ----------------------- -->	
     <% 
	 	Compte compte = (Compte)request.getAttribute("compteRecherche"); 
	 %>
	 
	<c:catch var="exception"><% int id=compte.getIdCompte(); %></c:catch>
	<c:if test="${ empty exception}">
		<div class="table-responsive">
	        <table class="table table-striped table-sm">
	          <thead>
	          		<tr>
						<th>ID</th>
						<th>Client</th>
						<th>Solde</th>
						<th>Type de compte</th>
						<th>Taux</th>
						<th>Découvert autorisé</th>
					</tr>
	          </thead>
	          <tbody>
	            <tr>
	            	<td><%= compte.getIdCompte() %></td>
	            	<td><%= compte.getClientID() %></td>
	            	<td><%= compte.getSolde() %></td>
	            	<td><%= compte.getTypeCompte() %></td>
	            	<td><%= compte.getTaux() %></td>
	            	<td><%= compte.getDecouvert()%></td>

	            </tr>
	          </tbody>
	        </table>
      	</div>
      	

		<a href="gestion-client-servlet?action=afficheProprietaire&id-client=<%= compte.getClientID() %>&id-compte=<%= compte.getIdCompte() %>" class="btn btn-success btn-sm" role="button">Retrouver le propriétaire</a>


		      	<!-- Affichage des boutons modifier, supprimer débit et credit uniquement si le client  appartient pas au conseiller enregistré -->
     <% 
	 	Conseiller conseillerLogged = (Conseiller)session.getAttribute("conseillerLogged"); 
     	double idconseillerLogged = conseillerLogged.getIdConseiller();
     	
		Client client = (Client)request.getAttribute("pClientProprio");
		double idconseiller = 0;
		if(client!=null){
			 idconseiller = client.getConseillerId();
		}
 
	 %>

	 
      	<c:if test="<%= idconseiller==idconseillerLogged || client==null %>">
      		<a href="gestion-compte-servlet?action=modif&id-compte=<%= compte.getIdCompte() %>" class="btn btn-danger btn-sm" role="button">Modifier</a>
      		<a href="gestion-compte-servlet?action=supp&id-compte=<%= compte.getIdCompte() %>" class="btn btn-danger btn-sm" role="button">Supprimer</a>
		
      	</c:if>
      
      
      </c:if>
      
      
      <br/><br/>
      
      
   <!-- -------Affichage du client propriétaire du compte recherché ----------------------- -->	
      
     <% 
	 	Client client = (Client)request.getAttribute("pPropretaire"); 
	 %>
	 
	 
	<c:catch var="exception"><% int id=client.getIdClient(); %></c:catch>
	<c:if test="${ empty exception}">
		<h5>Client propriétaire </h5>
		<div class="table-responsive">
	        <table class="table table-striped table-sm">
	          <thead>
	          		<tr>
						<th>ID</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Adresse</th>
						<th>Code Postal</th>
						<th>Ville</th>
						<th>Téléphone</th>
						<th>Id conseiller</th>
						<th>  </th>
						

					</tr>
	          </thead>
	          <tbody>
	            <tr>
	            	<td><%= client.getIdClient() %></td>
	            	<td><%= client.getNom() %></td>
	            	<td><%= client.getPrenom() %></td>
	            	<td><%= client.getAdresse() %></td>
	            	<td><%= client.getCodePostal() %></td>
	            	<td><%= client.getVille() %></td>
	            	<td><%= client.getTelephone() %></td>
	            	<td> <%= client.getConseillerId() %></td>
	            	<td>
						<a href="gestion-client-servlet?action=afficher&id-client=<%= client.getIdClient() %>">Afficher</a>
					</td>
	            </tr>
	          </tbody>
	        </table>
      	</div>  	
	</c:if>
	
	
	<!-- -------Affichage du formulaire de débit ----------------------- -->	
	
	<c:catch var="exception"><% String action = (String)request.getAttribute("pDebitCredit"); %></c:catch>
		
		<c:if test="${ empty exception}">
			<c:if test='${pDebitCredit.equals("debit")}'>
			
					<form method="post" action="gestion-compte-servlet">
					  <div class="form-row">
					    <div class="col-md-4 mb-3">
					      <label for="validationDefault01">Montant du débit</label>
					      <input name="pMontant" type="text" class="form-control" id="validationDefault02" required>
					    </div>
					    <div class="col-md-3 mb-3">
			      				<input type="hidden" name="action" value="debit"/>
			    		</div>
			    		<div class="col-md-3 mb-3">
			      				<input type="hidden" name="pIdCompte" value="<%= compte.getIdCompte() %>"/>
			    		</div>
			    		
					  </div>
					  <button class="btn btn-primary btn-sm" type="submit">Faire le retrait</button>
					</form>
			
			</c:if>
		
		
		<!-- -------Affichage du formulaire de débit ----------------------- -->
		
		
			<c:if test='${pDebitCredit.equals("credit")}'>
					<form method="post" action="gestion-compte-servlet">
					  <div class="form-row">
					    <div class="col-md-4 mb-3">
					      <label for="validationDefault01">Montant du crédit</label>
					      <input name="pMontant" type="text" class="form-control" id="validationDefault02" required>
					    </div>
					    <div class="col-md-3 mb-3">
			      				<input type="hidden" name="action" value="credit"/>
			    		</div>
			    		<div class="col-md-3 mb-3">
			      				<input type="hidden" name="pIdCompte" value="<%= compte.getIdCompte() %>"/>
			    		</div>
					  </div>
					  <button class="btn btn-primary btn-sm" type="submit">Faire le credit </button>
					</form>
			</c:if>
	</c:if>
	
	
	
    <!-- -------Affichage des message d'erreur/ réussite ----------------------- -->
    
    <c:catch var="exception"><% String reussiteOp = (String)request.getAttribute("reussiteOperation"); %></c:catch>
	<c:if test="${ empty exception}">
		<c:if test='${reussiteOperation.equals("true")}'>
		<div class="alert alert-success" role="alert">
  			${message}
		</div>
		
		</c:if>
		<c:if test='${reussiteOperation.equals("false")}'>
		<div class="alert alert-danger" role="alert">
  			${message}
		</div>
		
		</c:if>
	</c:if>
        
      
      
    </main>	<!-- == Fermeture du main ======== -->
  </div>	<!-- == Fermeture de la div row == -->
</div>		<!-- == Fermeture de la div principale ======== -->



<!-- ====================================================================================== -->
<!-- ====================== Scripts  ====================================================== -->
<!-- ====================================================================================== -->	


		<script src="assets/scripts/jquery-3.4.1.slim.min.js" ></script>

      	<script>window.jQuery || document.write('<script src="/docs/4.4/assets/js/vendor/jquery.slim.min.js"><\/script>')</script>
      
      	<script src="assets/scripts/bootstrap.bundle.min.js"></script>
        <script src="assets/scripts/feather.min.js"></script>
        <script src="assets/scripts/Chart.min.js"></script>
        <script src="assets/scripts/dashboard.js"></script>
</body>
</html>