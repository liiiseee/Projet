<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>page d'ajout d'un nouveau client</title>
</head>
<body>

<!-- formulaire pour ajouter client -->
<h3>Ajout d'un nouveau client</h3>


<%--
	> � la soumission du formulaire :
				-> envoi d'une requ�te http POST vers la servlet ayant l'url '/gestion-client-servlet'
				-> 6 param pour la req : pNom/pPrenom etc. (ref attribut name des input)
				
	> 
				
 --%>
<form method="post" action="gestion-client-servlet">
	<table>
		<tr> 
			<td>Nom : </td>
			<td> <input type="text" name="pNom"/> </td>
		
		
		</tr>
		<tr> 
			<td>Pr�nom : </td>
			<td> <input type="text" name="pPrenom"/> </td>
		
		
		</tr>
		<tr> 
			<td>Adresse : </td>
			<td> <input type="text" name="pAdresse"/> </td>
		
		
		</tr>
		<tr> 
			<td>Ville : </td>
			<td> <input type="text" name="pVille"/> </td>
		
		
		</tr>
		<tr> 
			<td>Code Postal : </td>
			<td> <input type="text" name="pCodePostal"/> </td>
		
		
		</tr>
		<tr> 
			<td>T�l�phone : </td>
			<td> <input type="text" name="pTelephone"/> </td>
		
		
		</tr>
		
		<!-- passage de param�tres � la requ�te dans un champ (input) cach� (non visibl � l'user) 
				> nom param = action; valeur param = ajout (action ajout seront cach�s)
		-->
		<tr>
			<td>
				<input type="hidden" name="action" value="ajout" />
			</td>
		</tr>
		
		
		<tr> 
			
			<td colspan="2"> <input type="submit" value="Ajouter"/> </td>
		
		
		</tr>
	
	
	</table>

</form>

</body>
</html>