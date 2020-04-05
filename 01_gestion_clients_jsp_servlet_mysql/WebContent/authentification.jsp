<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%-- ajout de la taglib 'core des jsp --%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.6">
    <title>Signin Template � Bootstrap</title>



    <!-- Bootstrap core CSS -->
    <!-- lien vers la feuille de style de Bootstrap -->
<link href="assets/styles/bootstrap.min.css" rel="stylesheet" />



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
    <link href="assets/styles/style.css" rel="stylesheet">
  </head>
  <body class="text-center">
  
  <%-- ============================================================================= --%>
  <%-- ============ Affichage des mess d'erreurs =================================== --%>
  <%-- ============================================================================= --%>
  <%--
  		> affichage de la liste des messeges sauvegard�s dans la requ�te avant d�l�gation
  			---> request.setAttribute("messages_erreurs", listeMessageErreurs);
   --%>
   
   <div>
   		<ul>
   		
   			<c:forEach items="${messages_erreurs }" var="messageErreur">
   				<li style="color: red; font-style: italic;">
   					<c:out value="${messageErreur }"/>
   				</li>
   			
   			</c:forEach>
   		
   		</ul>
   
   </div>
  
  <!-- formulaire d'auth� -->
  <!-- 
  		> � la soumisssion du formulaire (click sur le bouton Se connecter) :
  				-> appel de la servlet ayant l'url /authentification-servlet = envoi d'une rqu�te http en post (r�f method="post")
  						-> url de la requ�te : http://localhost:8080/gestion-clients/authentification-servlet
  						-> param�tres de la requ�te (ref attribut name des input):
  								- p-user : sa valeur est la saisie du champ email
  								- p-mdp : sa valeur est la saisie du champ mot de passe
   -->
    <form class="form-signin" method="post" action="authentification-servlet">
    
    <!-- image du fomrulaire -->
  <img class="mb-4" src="assets/images/image.jpg" alt="" width="300" height="150">
  <h1 class="h3 mb-3 font-weight-normal">Authentifiez-vous</h1>
  
  <!--  champ texte pour le mail -->
  <label for="inputEmail" class="sr-only">Email address</label>
  <input type="email" name="p-user" id="inputEmail" class="form-control" placeholder="Email address" >
  
  <!--  champ texte pour le mdp -->
  <label for="inputPassword" class="sr-only">Password</label>
  <input type="password" name="p-mdp" id="inputPassword" class="form-control" placeholder="Password" >
  
  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me"> Se souvenir de moi
    </label>
  </div>
  
  <!-- bouton de soumission du form -->
  <button class="btn btn-lg btn-primary btn-block" type="submit">Se connecter</button>
  <p class="mt-5 mb-3 text-muted">&copy; 2019-2020</p>
</form>
</body>
</html>
