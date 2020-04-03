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




    <!-- Custom styles for this template -->
    <link href="assets/styles/styleMenu.css" rel="stylesheet">
    <link href="assets/css/dashboard.css" rel="stylesheet">
  </head>
  <body>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm" >
  <h5 class="my-0 mr-md-auto font-weight-normal">Gestion des clients</h5>
  
  <!-- on test la pr�sence de l'attribut de session 'isLogged' dans la session -->
		<c:if test="${not empty isLogged}">
  <a class="btn btn-outline-primary" href="authentification-servlet?destroy=true">Se d�connecter</a>
  </c:if>
</div>

<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
  <h1 class="display-4">Menu gestion des clients</h1>
  <p class="lead">Faites votre choix</p>
</div>



<div class="container">
  <div class="card-deck mb-3 text-center">
  
  	<div class="card mb-4 shadow-sm">
  	<form class="form-signin" method="post" action="gestion-client-servlet">
     <div class="card-body">
      	<h1 class="card-title pricing-card-title">Liste des clients</h1>
      	 <input type="hidden" name="action" value="liste"/>
        <button type="submit" class="btn btn-lg btn-block btn-outline-primary" >Afficher </button>
      </div><!-- end card-body -->
     </form>
    </div><!-- end card mb-4 shadow-sm -->
    <div class="card mb-4 shadow-sm">
    <form class="form-signin" method="post" action="gestion-client-servlet">
     <div class="card-body">
      	<h1 class="card-title pricing-card-title">Ajout d'un client</h1>
      	<input type="hidden" name="action" value="ajout"/>
        <button type="submit" class="btn btn-lg btn-block btn-outline-primary" >Ajouter</button>
      </div><!-- end card-body -->
       </form>
    </div><!-- end card mb-4 shadow-sm -->
    <div class="card mb-4 shadow-sm">
    <form class="form-signin" method="post" action="gestion-client-servlet">
     <div class="card-body">
      	<h1 class="card-title pricing-card-title">Modifification d'un client</h1>
      	<input type="hidden" name="action" value="modif"/>
        <button type="submit" class="btn btn-lg btn-block btn-outline-primary" >Modifier</button>
      </div><!-- end card-body -->
      </form>
      </div>
    <div class="card mb-4 shadow-sm">
    <form class="form-signin" method="post" action="gestion-client-servlet">
      <div class="card-body">
      	<h1 class="card-title pricing-card-title">Suppression d'un client</h1>
          <input type="hidden" name="action" value="supprimer"/>
        <button type="submit" class="btn btn-lg btn-block btn-primary">Supprimer</button>
      </div>
       </form>
    </div>
    <div class="card mb-4 shadow-sm">
    <li class="nav-item">
            <a class="nav-link active" href="gestion-pages-servlet?action=chercherClient">
              Chercher un client
            </a>
          </li>
    </div>
    
    
  </div>
  </div>

 </form> 

</body>
</html>