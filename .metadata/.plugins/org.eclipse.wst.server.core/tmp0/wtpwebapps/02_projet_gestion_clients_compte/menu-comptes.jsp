<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>liste comptes</title>
<link href="assets/styles/bootstrap.min.css" rel="stylesheet" >
 
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
  <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Gestion des comptes</a>
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
            <a class="nav-link active" href="#">
              <span data-feather="home"></span>
              Liste des comptes <span class="sr-only">(current)</span>
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
              Attribuer un compte � un client
            </a>
          </li>
         <li class="nav-item">
            <a class="nav-link" href="recherche-compte.jsp">
              <span data-feather="shopping-cart"></span>
              Chercher un compte
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



 
   
   <h2>Liste des comptes</h2>
   
     <div class="table-responsive">
       <table  class="table table-striped table-sm" style="margin-left: 20%">
       
     
          
         
          <thead >
            <tr>
              	<th class="col-md-1">ID</th>
              	<th class="col-md-1">Id du client</th>
	 			<th class="col-md-1" >Solde</th>
	 			<th class="col-md-1" >type de compte</th>
	 			<th class="col-md-1" >Taux</th>
	 			<th class="col-md-1" >D�couvert Autoris�</th>
	 			<th class="col-md-1" >Modifier</th>
	 			<th class="col-md-1">Supprimer</th>
	 			<th class="col-md-1">Depot</th>
	 			<th class="col-md-1">Retrait</th>
	 			<th class="col-md-1">Virement</th>
	 			
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${liste_comptes}" var="compte">
	 			<tr>
	 			
	 				<td>${compte.idCompte }</td>
	 				<td> ${compte.clientID } </td>
	 				<td> ${compte.solde } </td>
	 				<td> ${compte.typeCompte } </td>
	 				<td> ${compte.taux } </td>
	 				<td> ${compte.decouvert } </td>
	 				<td>
	 					<a href="gestion-compte-servlet?action=modif&id-compte=${compte.idCompte}">modifier</a>
	 				</td>
	 				
	 				
	 				<td>
	 					<a href="gestion-compte-servlet?action=supp&id-compte=${compte.idCompte}">supprimer</a>
	 				</td>
	 				
	 				<td>
	 					<a href="gestion-compte-servlet?action=depot&id-compte=${compte.idCompte}">depot</a>
	 				</td>
	 				
	 				<td>
	 					<a href="gestion-compte-servlet?action=retrait&id-compte=${compte.idCompte}">retrait</a>
	 				</td>
	 				<td>
	 					<a href="gestion-compte-servlet?action=virement&id-compte=${compte.idCompte}">virement</a>
	 				</td>
	 			
	 				
	 			
	 				
	 				</tr>
         
            </c:forEach>
            
          
          </tbody>
          
        </table>
    
            </div>
      
      
   
      
</body>
</html>
