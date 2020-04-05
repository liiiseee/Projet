<%@page import="com.intiformation.gestion.model.Compte"%>
<%@page import="java.util.List"%>
<%@page import="com.intiformation.gestion.model.Conseiller"%>
<%@page import="com.intiformation.gestion.model.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>chercher client</title>
<link rel="canonical" href="https://getbootstrap.com/docs/4.4/examples/dashboard/">

    <!-- Bootstrap core CSS -->
<link href="assets/styles/bootstrap.min.css" rel="stylesheet">

    <!-- Favicons -->
<meta name="theme-color" content="#563d7c">


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
    <link href="assets/styles/dashboard.css" rel="stylesheet">
</head>
<body>


<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Gestion des clients</a>
  <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
  <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <a class="nav-link" href="authentification-servlet?destroy=true">Se d�connecter</a>
    </li>
  </ul>
</nav>

<div class="container-fluid" >
  <div class="row">
    <nav class="col-md-2 d-none d-md-block bg-light sidebar" >
      <div class="sidebar-sticky">
        <ul class="nav flex-column">
         

          <li class="nav-item">
            <a class="nav-link" href="gestion-pages-servlet?action=menuClient">
              <span data-feather="users"></span>
            Retour au menu gestion des clients
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
<!-- ====================================================================================== -->
<!-- ====================== Section principale (Main)  ==================================== -->
<!-- ====================================================================================== -->	


    <main role="main" class="col-md-9 ml-sm-auto col-lg-9 px-4">		<!-- == Ouverture du main ======== -->
    
    	<!-- --------------Titre de la page ------------------------------------ -->
    	
	    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	      <h1 class="h2">Gestion des clients</h1>
	    </div>
	
	
		<!-- -------Formulaire pour chercher un Client ----------------------- -->
		
	    <h5>Chercher un client par son identifiant</h5>
		
		
			<form method="post" action="gestion-client-servlet">
			  <div class="form-row">
			    <div class="col-md-4 mb-3">
			      <label for="validationDefault01"></label>
			      <input name="pIdClient" type="text" class="form-control" id="validationDefault02" placeholder="Identifiant"  required>
			    </div>
			    <div class="col-md-3 mb-3">
	      				<input type="hidden" name="action" value="chercher"/>
	    		</div>
	    		
			  </div>
			  <button class="btn btn-primary btn-sm" type="submit">Chercher</button>
			</form>
		
		<br/>
		<br/>
		
	<!-- -------Affichage du client recherch� ----------------------- -->	
	
	<% 
	 	Client client = (Client)request.getAttribute("clientRecherche"); 
	 %>
	 
	<c:catch var="exception"><% int id=client.getIdClient(); %></c:catch>
	<c:if test="${ empty exception}">
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
						<th>T�l�phone</th>
						<th>Id conseiller</th>
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
	            </tr>
	          </tbody>
	        </table>
      	</div>
      	
      	
      	
      	<!-- Affichage des boutons modifier et supprimer uniquement si le client appartient au conseiller enregistr� -->
     <% 
	 	Conseiller conseillerLogged = (Conseiller)session.getAttribute("conseillerLogged"); 
     	double idconseillerLogged = conseillerLogged.getIdConseiller();
     	double idconseiller = client.getConseillerId();
     	boolean test= (idconseiller==idconseillerLogged);

	 %>

	 
      	<c:if test="<%= idconseiller==idconseillerLogged %>">

      		    <a href="gestion-client-servlet?action=modifier&id-client=<%= client.getIdClient() %>" class="btn btn-primary btn-sm" role="button">Modifier</a>
      			<a href="gestion-client-servlet?action=supp&id-client=<%= client.getIdClient() %>" class="btn btn-danger btn-sm" role="button">Supprimer</a>
      	</c:if>

      	<a href="gestion-compte-servlet?action=getcomptes&id-client=<%= client.getIdClient() %>" class="btn btn-success btn-sm" role="button">Voir les comptes associ�s</a>
      </c:if>
      
      
      
     <br/> <br/>
     
     
     <!-- -------Affichage des comptes du client recherch� ----------------------- -->	
     
     <% 
	 	List<Compte> listecomptes = (List<Compte>)request.getAttribute("plisteComptesClient"); 
	 %>
	 
	<c:catch var="exception"><% Compte compte=listecomptes.get(0); %></c:catch>
	<c:if test="${ empty exception}">
		     <h5>Liste des comptes</h5>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
				<th>ID</th>
				<th>Client</th>
				<th>Solde</th>
				<th>Type de compte</th>
				<th>Taux</th>
				<th>D�couvert autoris�</th>
				<th> </th>

			</tr>
          </thead>
          <tbody>
            <c:forEach items="${plisteComptesClient }" var="comptes">
				<tr>
					<td> ${comptes.idCompte}</td>
					<td> ${comptes.clientID}</td>									
					<td> ${comptes.typeCompte}</td>
					<td> ${comptes.solde}</td>
					<td> ${comptes.taux}</td>
					<td> ${comptes.decouvert}</td>
					
			
					
				</tr>
			</c:forEach>
          </tbody>
        </table>
      </div>
      </c:if>

	
	<!-- -------Affichage des message d'erreur/ r�ussite ----------------------- -->
	
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