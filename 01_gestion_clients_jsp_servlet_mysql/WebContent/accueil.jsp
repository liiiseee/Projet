<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>page d'accueil</title>
</head>
<body>

		<%-- ================================================================================= --%>
		<%-- =====================affichage du bouton 'se d�connecter'======================== --%>
		<%-- ================================================================================= --%>
		<div style="float: right;">
		
			<!-- on v�rifie la pr�sence de l'attribut de session 'isLogged' dans la session -->
			<c:if test="${not empty isLogged}">
					<%-- le conseiller est d�j� connect� => affichage du bouton se d�connecter --%>
					
					<%--
						> au click sur le lien se d�connecter :
								-> envoi d'une requ�te http en GET
										-url de la requ�te : http://localhost:8080/gestion-clients/authentification-servlet?destroy=true
										
								-> cette requ�te part vers la servlet
										-> traitement de la requ�te dans la m�th doGet()
					 --%>
					<a href="authentification-servlet?destroy=true">Se D�connecter</a>
					
			</c:if>
		
		</div>
		

		<%-- ================================================================================= --%>
		<%-- =====================affichage de la liste des clients=========================== --%>
		<%-- ================================================================================= --%>
		<%--
				> r�cup de la liste des clients sauvegard�e dans la requ�te avant d�l�gation vers la page d'accueil
					(ref : dans la servlet �tape 3.1.2.2)
					-> request.setAttribute("liste_clients", listeClientsBdd);
		 --%>
		 
		 <table border="1" width="60%">
		 	<!-- en t�te de la table -->
		 	<thead style="background-color: lightgray;">
		 	<tr>
		 		<th> ID</th>
		 		<th> Nom</th>
		 		<th> Pr�nom</th>
		 		<th> Adresse</th>
		 		<th> Ville</th>
		 		<th> Code Postal</th>
		 		<th> t�l�phone</th>
		 		<th>Modifier</th>
		 		<th>Supprimer</th>
		 	
		 	
		 	</tr>
		 
		 	</thead>
		 	
		 	<!-- body de la table (donn�es des clients) -->
		 	<tbody>
		 			<c:forEach items="${liste_clients }" var="client">
		 				<tr>
		 				<td> <c:out value="${client.idClient}" /> </td>
		 				<td>${client.nom}</td>
		 				<td>${client.prenom}</td>
		 				<td>${client.adresse}</td>
		 				<td>${client.ville}</td>
		 				<td>${client.codePostal}</td>
		 				<td>${client.telephone}</td>
		 				<!-- lien pour modifier le client -->
		 				<%--
		 						> au click sur le lien, envoi d'une requ http GET avec url :
		 								http://localhost:8080/gestion-clients/gestion-client-servlet?action=modif&id-client=1
		 								vers la servlet GestionClientServlet
		 						> dans la servlet => doGet() pour le traitement
		 				 --%>
		 				<td> 
		 					<a href="gestion-client-servlet?action=modif&id-client=${client.idClient}">modifier</a>
		 				</td>
		 				
		 				
		 				<!-- lien pour supprimer le client -->
		 				<%--
		 						> au click sur le lien, envoi d'une requ http GET avec url :
		 								http://localhost:8080/gestion-clients/gestion-client-servlet?action=supp&id-client=1
		 								vers la servlet GestionClientServlet
		 						> dans la servlet => doGet() pour le traitement
		 				 --%>
		 				<td>
		 					<a href="gestion-client-servlet?action=supp&id-client=${client.idClient}">supprimer</a>
		 				</td>
		 				
		 				
		 				
		 				</tr>
		 			</c:forEach>
		 	
		 	</tbody>
		 
		 </table>
		 
		 <br/><br/>
		 <!-- lien pour ajouter un client -->
		 <a href="ajouter-client.jsp">Ajouter un nouveau client</a>
		
</body>
</html>