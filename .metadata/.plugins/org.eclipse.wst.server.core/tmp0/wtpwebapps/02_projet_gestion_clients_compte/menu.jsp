<%@page import="java.util.List"%>
<%@page import="com.intiformation.gestion.model.Compte"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.6">
    <title>menu principal</title>



    <!-- Bootstrap core CSS -->
<link href="assets/styles/bootstrap.min.css" rel="stylesheet" >
<link href="assets/styles/dashboard.css" rel= "stylesheet">




    <!-- Custom styles for this template -->
    <link href="assets/styles/styleMenu.css" rel="stylesheet">
  </head>
  <body>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm" >
  <h5 class="my-0 mr-md-auto font-weight-normal">Banque de France</h5>
  
  <!-- on test la pr�sence de l'attribut de session 'isLogged' dans la session -->
		<c:if test="${not empty isLogged}">
  <a class="btn btn-outline-primary" href="authentification-servlet?destroy=true">Se d�connecter</a>
  </c:if>
</div>

<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
  <a class="display-4" href="gestion-pages-servlet?action=dashboard"><span data-feather="home"></span>Menu Principal</a>
  <p class="lead">Faites votre choix</p>
</div>

<div class="container">
  <div class="card-deck mb-3 text-center">
  
    <div class="card mb-4 shadow-sm">
    <form class="form-signin" method="post" action="gestion-client-servlet">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">Gestion des clients</h4>
        
      </div> <!-- end card-header -->
      <div class="card-body">
        <ul class="list-unstyled mt-3 mb-4">
          <li>Liste des clients</li>
          <li>Ajouter un client</li>
          <li>Supprimer un client</li>
          <li>etc.</li>
        </ul> 
       <input type="hidden" name="action" value="gererClient"/>
        <button type="submit" class="btn btn-lg btn-block btn-outline-primary" >G�rer les clients</button>
        
      </div><!-- end card-body -->
      </form>
    </div><!-- end card mb-4 shadow-sm -->
    
    <div class="card mb-4 shadow-sm">
    <form class="form-signin" method="post" action="gestion-compte-servlet">
   <!--   <c:set value="${compte-modif}" var="compteUpdate"/>  a v�rifier -->
	 
	 
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">Gestion des comptes</h4>
      </div>
      <div class="card-body">
        <ul class="list-unstyled mt-3 mb-4">
          <li>Afficher les comptes</li>
          <li>Ajouter un compte</li>
          <li>G�rer un virement</li>
          <li>etc.</li>
        </ul>
        
         <% 
	 	Compte compte = (Compte)request.getAttribute("comptesIdCons"); 
	 %>
        
          
        <div class="card mb-4 shadow-sm">
   			<input type="hidden" name="action" value="gererComptes"/>
            <button type="submit" class="btn btn-lg btn-block btn-outline-primary" >G�rer les comptes</button>
             
          
    </div>
        <!--  <button type="submit" class="btn btn-lg btn-block btn-primary">G�rer les comptes</button>-->
        
      </div>
       </form>
    </div>
    
    </div>
  </div>

  

</body>
</html>
