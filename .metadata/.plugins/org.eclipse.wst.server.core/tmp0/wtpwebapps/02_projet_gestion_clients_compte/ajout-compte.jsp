<%@page import="java.util.List"%>
<%@page import="com.intiformation.gestion.model.CompteCourant"%>
<%@page import="com.intiformation.gestion.model.CompteEpargne"%>
<%@page import="com.intiformation.gestion.model.Compte"%>
<%@page import="com.intiformation.gestion.model.Client"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>ajout compte</title>
<!-- Bootstrap core CSS -->
<link href="assets/styles/bootstrap.min.css" rel="stylesheet">

  


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
    <link href="assets/styles/styleModif.css" rel="stylesheet">
</head>
<body class="bg-light">
 <nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Gestion des comptes</a>
  <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
  <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <a class="nav-link" href="authentification-servlet?destroy=true">Se déconnecter</a>
    </li>
  </ul>
</nav>

<c:set value="${compte-ajout}" var="compteUpdate"/>
	 
	 <% 
	 	Compte compte = (Compte)request.getAttribute("compte-modif");
	 
	 %>

<div class="container-fluid" >
  <div class="row">
    <nav class="col-md-2 d-none d-md-block bg-light sidebar" >
      <div class="sidebar-sticky">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" href="#">
              <span data-feather="home"></span>
              Liste des comptes
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ajout-compte.jsp">
              <span data-feather="file"></span>
              Ajouter un nouveau compte<span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="attribuer-compte.jsp">
              <span data-feather="file"></span>
              Attribuer un compte à un client
            </a>
          </li>
         <li class="nav-item">
            <a class="nav-link" href="gestion-pages-servlet?action=chercherCompte">
              <span data-feather="shopping-cart"></span>
              Chercher un compte
            </a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="gestion-pages-servlet?action=menuCompte">
              <span data-feather="users"></span>
            Retour au menu des comptes
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="menu.jsp">
              <span data-feather="bar-chart-2"></span>
              Retour au menu principal
            </a>
          </li>
          </ul>
          

       
      </div>
    </nav>
    </div>
    </div>


<div class="container">
<div class="py-5 text-center">
    <img class="d-block mx-auto mb-4" src="assets/images/banque.jpg" alt="" width="72" height="72">
    <h2>Ajouter un compte</h2>
   
  </div>

	
	 
    <div class="col-md-8 order-md-1">
      <h4 class="mb-3">Données du comptes</h4>
      <form class="needs-validation" novalidate method="post" action="gestion-compte-servlet">
        <div class="row">
     
          <div class="col-md-6 mb-3">
            <label for="lastName">Solde</label>
            <input type="text" class="form-control" id="lastName" placeholder="" name="pSolde" required>
            <div class="invalid-feedback">
              Veuillez renseigner le solde
            </div>
          </div>
          
          <div class="col-md-6 mb-3">
            <label for="lastName">Identifiant du conseiller</label>
            <input type="text" class="form-control" id="lastName" placeholder="" name="pConseillerID" >
            
          </div>
        </div>




     

      

        <div class="row">
     
          <div class="col-md-4 mb-3">
            <label for="state">Type de compte</label>
            <input type="text" name="pTypeCompte"/>
            <select class="custom-select d-block w-100" id="state" required>
              <option value="">Choisissez...</option>
              <option>epargne</option>
              <option>courant</option>
            </select>
            <div class="invalid-feedback">
               Veuillez renseigner le type de compte
            </div>
          </div>
          <div class="col-md-3 mb-3">
            <label for="zip">Taux</label>
            <input type="text" class="form-control" id="zip" placeholder="" name="pTaux" >
       
          </div>
          <div class="col-md-3 mb-3">
            <label for="zip">Découvert</label>
            <input type="text" class="form-control" id="" placeholder="" name="pDecouvert"  >
           
          </div>
          
          
   
       
        </div>
        

     
       
        
        <hr class="mb-4">
        <input type="hidden" name="action" value="ajout"/>
        <button class="btn btn-primary btn-lg btn-block" type="submit">Ajouter</button>
      </form>
    </div>



</div>

</body>
</html>