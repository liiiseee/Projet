<%@page import="com.intiformation.gestion.model.Client"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>ajout client</title>
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
    <h2>Ajouter un client</h2>
   
  </div>

<c:set value="${client-modif}" var="clientUpdate"/>
	 
	 <% 
	 	Client client = (Client)request.getAttribute("client-modif");
	 %>
	 
    <div class="col-md-8 order-md-1">
      <h4 class="mb-3">Coordonnées du client</h4>
      <form class="needs-validation" novalidate method="post" action="gestion-client-servlet">
        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="firstName">Nom</label>
            <input type="text" class="form-control" id="firstName" placeholder="" name="pNom"  required>
            <div class="invalid-feedback">
              Valid first name is required.
            </div>
          </div>
          <div class="col-md-6 mb-3">
            <label for="lastName">Prénom</label>
            <input type="text" class="form-control" id="lastName" placeholder="" name="pPrenom"  required>
            <div class="invalid-feedback">
              Valid last name is required.
            </div>
          </div>
        </div>




        <div class="mb-3">
          <label for="address">Adresse</label>
          <input type="text" class="form-control" id="address" placeholder="6 rue Monge" name="pAdresse"  required>
          <div class="invalid-feedback">
            Veuillez renseigner l'adresse
          </div>
        </div>

      

        <div class="row">
     
          <div class="col-md-4 mb-3">
            <label for="state">Ville</label>
            <input type="text" name="pVille" />
            <select class="custom-select d-block w-100" id="state" required>
              <option value="">Choose...</option>
              <option>Paris</option>
              <option>Lyon</option>
              <option>Marseille</option>
            </select>
            <div class="invalid-feedback">
              Entrez une ville valide.
            </div>
          </div>
          <div class="col-md-3 mb-3">
            <label for="zip">Code Postal</label>
            <input type="text" class="form-control" id="zip" placeholder="75000" name="pCodePostal" required>
            <div class="invalid-feedback">
              Code postal requis.
            </div>
          </div>
          <div class="col-md-3 mb-3">
            <label for="zip">Téléphone</label>
            <input type="text" class="form-control" id="" placeholder="0102136548" name="pTelelphone"  required>
           
          </div>
      
        </div>
        

     
       
        
        <hr class="mb-4">
        <input type="hidden" name="action" value="ajouter"/>
        <button class="btn btn-primary btn-lg btn-block" type="submit">Ajouter</button>
      </form>
    </div>



</div>
</body>
</html>