<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>depot</title>
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

 <h2>Liste des comptes</h2>
      <div class="table-responsive">
       <table class="table table-striped table-sm">
         
          <thead class="col-md-3 col-md-offset-3">
            <tr>
	 			<th>Solde</th>
	 			<th>type de compte</th>
	 			<th>ID</th>
               	<th>d�p�t</th>
           </tr>
          </thead>
          <tbody>
            <c:forEach items="${liste_comptes}" var="compte">
	 			<tr>
	 			
	 				
	 				<td> ${compte.solde } </td>
	 				<td> ${compte.typeCompte } </td>
	 				<td>${compte.idCompte }</td>
	 				<td>
	 					<a href="gestion-compte-servlet?action=depot&id-compte=${compte.idCompte}">depot</a>
	 				</td>
	 			</tr>
         
            </c:forEach>
            
          
          </tbody>
        </table>
    
      </div>

</body>
</html>