<%@page import="com.intiformation.gestion.model.Compte"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>recherche compte</title>
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
<div class="container">
<div class="py-5 text-center">
    <img class="d-block mx-auto mb-4" src="assets/images/banque.jpg" alt="" width="72" height="72">
    <h2>Chercher un compte par son id</h2>
   
  </div>
  
  <c:set value="${compte-chercher}" var="compteChercher"/>
  
  <% Compte compte = (Compte)request.getAttribute("compte-chercher"); %>

	
	 
    <div class="col-md-8 order-md-1">
      <h4 class="mb-3">Données du comptes</h4>
      <form class="needs-validation" novalidate method="post" action="gestion-compte-servlet">
        <div class="row">
     
          <div class="col-md-6 mb-3">
            <label for="lastName">Identifiant du client</label>
            <input type="text" class="form-control" id="lastName" placeholder="" name="pIdClient" required>
            <div class="invalid-feedback">
             Entrez l'identifiant du client
            </div>
         
       
          
          
          
        
       
        

</div>

         
       
        </div>
        

     
       
        
        <hr class="mb-4">
        <input type="hidden" name="action" value="chercher"/>
        <button class="btn btn-primary btn-lg btn-block" type="submit">Valider</button>
      </form>
    </div>



</div>
</body>
</html>