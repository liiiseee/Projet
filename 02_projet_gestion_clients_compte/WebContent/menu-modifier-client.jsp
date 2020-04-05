<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>modification client</title>
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
<h2>Liste des clients</h2>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th>ID</th>
	 			<th>Nom</th>
	 			<th>Pr�nom</th>
	 			<th>Adresse</th>
	 			<th>Code Postal</th>
	 			<th>Ville</th>
	 			<th>T�l�phone</th>
	 			<th>Modifier</th>
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
	 				
	 				<!-- lien pour modifier le client -->
	 				<%--
	 					> au click sur le lien => envoi d'une requete http GET ayant comme url : 
	 						http://localhost:8080/gestion-clients/gestion-client-servlet?action=modif&id-client=1
	 					
	 					  vers la servlet GestionClientServlet
	 					  
	 					 > dans la servlet => doGet() pour le traitement  
	 						
	 				 --%>
	 				<td>
	 					<a href="gestion-client-servlet?action=modifier&id-client=${client.idClient}">modifier</a>
	 				</td>
	 				
	 				</tr>
         
            </c:forEach>
          
          </tbody>
        </table>
      </div>

</body>
</html>