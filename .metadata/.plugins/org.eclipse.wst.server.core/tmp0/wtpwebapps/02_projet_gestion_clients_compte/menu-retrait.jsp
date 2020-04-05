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

<div class="container-fluid">
  <div class="row">
    <nav class="col-md-2 d-none d-md-block bg-light sidebar">
      <div class="sidebar-sticky">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" href="#">
              <span data-feather="home"></span>
              Liste des comptes <span class="sr-only"></span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ajout-compte.jsp">
              <span data-feather="file"></span>
              Ajouter un nouveau compte
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file"></span>
              Attribuer un compte � un client
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="gestion-compte-servlet?action=retrait">
              <span class="sr-only">(current)</span>
              Retirer de l'argent d'un compte
            </a>
          </li>
          <li class="nav-item">
          <input type="hidden" name="action" value="dep"/>
            <a class="nav-link" href="menu-depot.jsp">
              <span data-feather="users"></span>
             D�poser de l'argent sur un compte
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="bar-chart-2"></span>
              Effectuer un virement
            </a>
          </li>
          </ul>
          

       
      </div>
    </nav>
    </div>
    </div>



 
   
   <h2>Liste des comptes</h2>
   <div class="row">
     <div class="table-responsive">
       <table class="table table-striped table-sm">
       
     
          
         
          <thead >
            <tr>
              	<th style="width:10%;">ID</th>
              	<th style="width:10%;">Id du client</th>
	 			<th style="width:10%;">Solde</th>
	 			<th style="width:10%;">type de compte</th>
	 			<th style="width:10%;">Taux</th>
	 			<th style="width:10%;">D�couvert Autoris�</th>
	 			<th style="width:10%;">Retirer</th>
	 			
	 			
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
	 					<a href="gestion-compte-servlet?action=retirer&id-compte=${compte.idCompte}">retirer</a>
	 				</td>
	 				
	 				
	 			
	 				
	 				</tr>
         
            </c:forEach>
            
          
          </tbody>
          
        </table>
    
            </div>
        </div>
      
   
      
</body>
</html>