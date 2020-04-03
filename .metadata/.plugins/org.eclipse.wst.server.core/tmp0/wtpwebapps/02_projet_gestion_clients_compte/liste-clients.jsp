<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>liste clients</title>
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
  <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Gestion des clients</a>
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
</div>
</div>

 
   
   <h2>Liste des clients</h2>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th>ID</th>
	 			<th>Nom</th>
	 			<th>Prénom</th>
	 			<th>Adresse</th>
	 			<th>Code Postal</th>
	 			<th>Ville</th>
	 			<th>Téléphone</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${liste_clients}" var="client">
	 			<tr>
	 				<td> <c:out value="${client.idClient}"/> </td>
	 				<td> ${client.nom } </td>
	 				<td> ${client.prenom } </td>
	 				<td> ${client.adresse } </td>
	 				<td> ${client.codePostal } </td>
	 				<td> ${client.ville } </td>
	 				<td> ${client.telephone } </td>
	 				
	 				</tr>
         
            </c:forEach>
          
          </tbody>
        </table>
      </div>
   
      
</body>
</html>