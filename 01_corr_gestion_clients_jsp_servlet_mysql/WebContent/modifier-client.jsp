<%@page import="com.intiformation.gestionclients.model.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>modifier un client</title>
</head>
<body>
	
	<%-- ============================================ --%>
	<%-- Récup des informations du client à modifier  --%>
	<%-- ============================================ --%>
	<%--
		> ref doGet() - case modif : request.setAttribute("client-modif", client);
	 --%>
	 <c:set value="${client-modif}" var="clientUpdate"/>
	 
	 <% 
	 	Client client = (Client)request.getAttribute("client-modif");
	 %>
	 
	 <%-- ============================================ --%>
	 <%-- formulaire pour modifier le client  --%>
	 <%-- ============================================ --%>
	 <h3>Modifier un client</h3>
	
	<%--
	    > à la soumission du formulaire : 
	    			-> envoi d'une requete http POST vers la servlet ayant l'url '/gestion-client-servlet'
	    			-> cette requete aura 7 paramètres : pNom/pPrenom/pAdresse/pCodePostal/pVille/pTelephone
	    			   (ref l'attribut name des inputs)
	    			   
	    > au niveau de la servlet : c'est la méthode doPost() qui va traiter la requête  
	 --%>
	
	<form method="post" action="gestion-client-servlet">
		
		<table>
			<tr>
				<td>Nom : </td>
				<td> <input type="text" name="pNom" value="<%= client.getNom() %>"/> </td>
			</tr>
			<tr>
				<td>Prénom : </td>
				<td> <input type="text" name="pPrenom" value="<%= client.getPrenom() %>"/> </td>
			</tr>
			<tr>
				<td>Adresse : </td>
				<td> <input type="text" name="pAdresse" value="<%= client.getAdresse() %>"/> </td>
			</tr>
			<tr>
				<td>Code Postal : </td>
				<td> <input type="text" name="pCodePostal" value="<%= client.getCodePostal() %>"/> </td>
			</tr>
			<tr>
				<td>Ville : </td>
				<td> <input type="text" name="pVille" value="<%= client.getVille() %>"/> </td>
			</tr>
			<tr>
				<td>Téléphone : </td>
				<td> <input type="text" name="pTelephone" value="<%= client.getTelephone() %>"/> </td>
			</tr>
			
			<!-- sauvegarde de l'id client dans un champ caché  -->
			<tr>
				<td>
					<input type="hidden" name="pIdClient" value="<%= client.getIdClient() %>"/>
				</td>
			</tr>
		
			<!-- passage de paramètre à la requete dans un champ (input) caché  -->
			<!-- nom param 'action' / valeur param = modification -->
			<tr>
				<td>
					<input type="hidden" name="action" value="modification"/>
				</td>
			</tr>
		
			<tr>
				<td colspan="2"> <input type="submit" value="Modifier"/> </td>
			</tr>
		</table>
		
	</form>

</body>
</html>