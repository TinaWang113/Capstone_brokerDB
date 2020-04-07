<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html>
  <head>
    <!-- Required meta tags -->
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/Navigation-Clean-1.css">
    <link rel="stylesheet" href="css/Navigation-Clean.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
	<link rel="stylesheet" href="css/MenuStyle.css">
	<link rel="stylesheet" href="css/ChoiceStyle.css">
	<script type="text/javascript" src="js/help.js"></script>
    
    <title>Help</title>
  
  </head>
  
  <body>
  	<img id="logo-1" src="img/migarock logo.png">
    <nav class="navbar navbar-expand navbar-light">
    
    <div class="navbar">
        <ul class="navbar-nav">
            <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false">Menu&nbsp;</a>
                        <div class="dropdown-menu" role="menu">                     
	                       
	                       <c:forEach var="category" items="${sessionScope.parsedCategoryList}">
	                       <!-- ASK JOHN FOR MORE APPROPRIATE SOLUTION -->
	                       		<form action="submenu" method="GET">
	                        	<input type="submit" class="dropdown-item" role="presentation"  data-value="${category.getCategoryID()}" value ="${category.getCategoryName()}">
	                        	<input type="hidden" name="categorySelection" value="${category.getCategoryID()}">
	                        	</form>
	                        </c:forEach>
                        </div>
            </li>
            <li class="nav-item" role="presentation">
            <a class="nav-link" href="order">Order<span class="badge badge-light" id="quantityupdate">${updateQuantity}</span></a>
            </li>

            <li class="nav-item" role="presentation"><a class="nav-link" href="bill" >Bill</a></li>
            <li class="nav-item" role="presentation"><a class="nav-link" href="help">Help</a></li>
            <li class="nav-item" role="presentation"><a class="nav-link" href="menu">Main Menu</a></li>
        </ul>
    </div>
    </nav>
    <h1>Request assistance</h1>
    
    
    
    <div align="center">
		<button type="button" class="btn btn-secondary helpBtn" data-toggle="modal" data-target="#helpModal" data-choice="help" id="helpButton">Request Help</button>
	</div>
	
	<!-- Help Modal -->
<div class="modal fade" id="helpModal" tabindex="-1" role="dialog" aria-labelledby="helpModalTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="infoModalLongTitle">Request Help</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="card mx-auto" style="width: 19rem;">
		  <div class="card-body">
			  
		  
		  <div class="card-body">
		  	
		  <p class="card-text" id="helpText">We are on our way to assist you! Please be patient!</p>

		  </div>
		  </div>
	</div> 
      </div>
      <div class="modal-footer">
       	<button type="button" class="btn btn-light helpBtn"  id="cancelHelp" data-choice="cancel" >Cancel request</button>
      </div>
    </div>
  </div>
</div>


<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="js/jquery.min.js"></script>
	
	<script src="js/popper.min.js"></script>
	
	<script src="js/bootstrap.min.js"></script>
	
	<script src="js/mdb.min.js"></script>
</body>
</html>