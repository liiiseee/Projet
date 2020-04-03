<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>page d'ajout d'un nouveau client</title>
</head>
<body>

	<h3>Ajout d'un nouveau client</h3>
	
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
				<td> <input type="text" name="pNom"/> </td>
			</tr>
			<tr>
				<td>Prénom : </td>
				<td> <input type="text" name="pPrenom"/> </td>
			</tr>
			<tr>
				<td>Adresse : </td>
				<td> <input type="text" name="pAdresse"/> </td>
			</tr>
			<tr>
				<td>Code Postal : </td>
				<td> <input type="text" name="pCodePostal"/> </td>
			</tr>
			<tr>
				<td>Ville : </td>
				<td> <input type="text" name="pVille"/> </td>
			</tr>
			<tr>
				<td>Téléphone : </td>
				<td> <input type="text" name="pTelephone"/> </td>
			</tr>
			
			<!-- passage de paramètre à la requete dans un champ (input) caché  -->
			<!-- nom param 'action' / valeur param = ajout -->
			<tr>
				<td>
					<input type="hidden" name="action" value="ajout"/>
				</td>
			</tr>
		
			<tr>
				<td colspan="2"> <input type="submit" value="Ajouter"/> </td>
			</tr>
		</table>
		
	</form>

</body>
</html>