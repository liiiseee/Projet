<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>page d'accueil du site</title>
</head>
<body>

	<%-- =============================================================== --%>
	<%-- === Affichage du bouton Se déconnecter  ======================= --%>
	<%-- =============================================================== --%>
	<div style="float: right;">
		
		<!-- on test la présence de l'attribut de session 'isLogged' dans la session -->
		<c:if test="${not empty isLogged}">
		
			<%-- le conseiller est déja connecté => affichage du bouton Se Déconnecter --%>
			<!-- 
				> au click su r le lien 'Se déconnecter' :
						-> envoi d'une requête http en GET
							- url de la requete : http://localhost:8080/gestion-clients
							                                          /authentication-servlet?destroy=true
					    -> cette requete part vers la servlet. 
					    		-> traitement de la requete dans la méthode doGet()
			 -->
			<a href="authentication-servlet?destroy=true">Se Déconnecter</a>
			
		</c:if>
		
	</div>

	<%-- =============================================================== --%>
	<%-- === Affichage de la liste des clients ========================= --%>
	<%-- =============================================================== --%>
	<%--
			> récup de liste des clients sauvegardée dans la requête 
			  avant délégation vers la page 'accueil.jsp' 
			  (ref : dans la servlet.  étape :/* 3.1.2.2  ---*/)
			  
			  -> request.setAttribute("liste_clients", listeClientsBdd);
	 --%>
	 
	 <table border="1" width="60%">
	 	
	 	<!-- en-tête de la table  -->
	 	<thead style="background-color: lightgray;">
	 		<tr>
	 			<th>ID</th>
	 			<th>Nom</th>
	 			<th>Prénom</th>
	 			<th>Adresse</th>
	 			<th>Code Postal</th>
	 			<th>Ville</th>
	 			<th>Téléphone</th>
	 			<th>Modifier</th>
	 			<th>Supprimer</th>
	 		</tr>
	 	</thead>
	 		
	 	<!-- body de la table (données des clients) -->
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
	 					<a href="gestion-client-servlet?action=modif&id-client=${client.idClient}">modifier</a>
	 				</td>
	 				
	 				<!-- lien pour supprimer le client -->
	 				<%--
	 					> au click sur le lien => envoi d'une requete http GET ayant comme url : 
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
	 <!-- lien pour ajouter un client  -->
	 <a href="ajouter-client.jsp">Ajouter un nouveau client</a>
	 

</body>
</html>





