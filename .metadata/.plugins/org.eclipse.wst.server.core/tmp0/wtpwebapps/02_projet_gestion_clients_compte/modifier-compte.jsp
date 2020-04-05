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
<title>modification compte</title>
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
    <h2>Formulaire de modification</h2>
   
  </div>

<c:set value="${compte-modif}" var="compteUpdate"/>
	 
	 <% 
	 	Compte compte = (Compte)request.getAttribute("compte-modif");
	 
	 %>
	 
    <div class="col-md-8 order-md-1">
      <h4 class="mb-3">Données du comptes</h4>
      <form class="needs-validation" novalidate method="post" action="gestion-compte-servlet">
      
        <div class="row">
        
          <div class="col-md-6 mb-3">
            <label for="lastName">Solde</label>
            <input type="text" class="form-control" id="lastName" placeholder="" name="pSolde" value="<%= compte.getSolde() %>" required>
            <div class="invalid-feedback">
              Veuillez renseigner le solde
            </div>
          </div>
        </div>




     

      

        <div class="row">
     
          <div class="col-md-4 mb-3">
            <label for="state">Type de compte</label>
            <input type="text" name="pTypeCompte" value="<%= compte.getTypeCompte() %>"/>
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
            <input type="text" class="form-control" id="zip" placeholder="" name="pTaux" value="<%= compte.getTaux() %>" >
       
          </div>
          
          <div class="col-md-3 mb-3">
            <label for="zip">Découvert</label>
            <input type="text" class="form-control" id="" placeholder="" name="pDecouvert" value="<%= compte.getDecouvert() %>" >
           
          </div>
          <div>
            
            <input type="hidden"  name="pClientID" value="<%= compte.getClientID() %>" >
           
          </div>
          
          <div>
            <input type="hidden" name="pIdCompte" value="<%= compte.getIdCompte() %>" />
           
          </div>
        </div>
        
        <div id="selectIdCompte" class="col-md-4 mb-3">
				    <label for="exampleFormControlSelect1">Identifiant du conseiller</label>
				    <select name="pConseillerID" class="form-control" id="exampleFormControlSelect1">
				    	<option value="<%= compte.getConseillerId() %>"><%= compte.getConseillerId() %> (actuel)</option>
				    	
				    	<% List<Integer> listeConseillers = (List<Integer>)request.getAttribute("liste-id-conseillers");%>
	
					   	<c:forEach items="<%= listeConseillers%>" var="conseillerid">
						    	<option value="${conseillerid }">${conseillerid }</option>
						</c:forEach>
				    </select>
			    </div>
		  	
        

     
       
        
        <hr class="mb-4"/>
        <input type="hidden" name="action" value="modification"/>
        <button class="btn btn-primary btn-lg btn-block" type="submit">Modifier</button>
      </form>
    </div>



</div>
</body>
</html>