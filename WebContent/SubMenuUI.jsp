<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>  
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    
    <title>Sub-Menu</title>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/Navigation-Clean-1.css">
    <link rel="stylesheet" href="css/Navigation-Clean.css">
    <link rel="stylesheet" href="css/MenuStyle.css">
	<script src="js/addFunctions.js" type="text/javascript"></script>
    <script src="js/PopulateModal.js" type="text/javascript"></script>

    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>

<body><img id="logo-1" src="img/migarock logo.png">
    <nav class="navbar navbar-expand navbar-light">
    
    <div class="navbar">
        <ul class="navbar-nav">
            <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false">Menu&nbsp;</a>
                        <div class="dropdown-menu" role="menu">                     
	                       
	                       <c:forEach var="category" items="${sessionScope.parsedCategoryList}">
	                       
	                       		<form action="submenu" method="GET">
	                        	<input type="submit" class="dropdown-item" role="presentation"  data-value="${category.getCategoryID()}" value ="${category.getCategoryName()}">
	                        	<input type="hidden" name="categorySelection" value="${category.getCategoryID()}">
	                        	</form>
	                        </c:forEach>
                        </div>
            </li>
            <li class="nav-item" role="presentation">
            <a class="nav-link" href="order">Order<span class="badge badge-light" id="quantityupdate">${sessionScope.updateQuantity}</span></a>
            </li>

            <li class="nav-item" role="presentation"><a class="nav-link" href="bill" >Bill</a></li>
            <li class="nav-item" role="presentation"><a class="nav-link" href="help">Help</a></li>
            <li class="nav-item" role="presentation"><a class="nav-link" href="menu">Main Menu</a></li>
        </ul>
    </div>
    </nav>
    
    <c:forEach items="${subMenuItemList}" var="subMenuItem">
     <div class="card mx-auto" style="width: 25rem;">
		  <div class="card-body">
		    <h5 class="card-title">${subMenuItem.getItemName()}</h5>
			  <div id="itemBox">
				    	<img id="itemPic" src="${subMenuItem.getPhotoLocalDirectory()}" class="rounded float-left, itemPic"> 
				  	<div class="float-right">
					  	<div id="qnty">
					  		<div class="col text-center">
							  	<button type="button" class="btn btn-light btn-sm Arrows upArrow"><i class="fa fa-chevron-up"></i></button><br>
								  	<input id="${item.getItemID()}" size="4" maxlength="2" value="" placeholder="0"><br>
							  	<button type="button" class="btn btn-light btn-sm Arrows downArrow" ><i class="fa fa-chevron-down"></i></button><br>
							  	<button type="button" class="btn btn-primary btn-sm addToOrderBtn" id="addToOrderBtn" name="action"
							  	data-itemId="${subMenuItem.getItemID()}"
							  	value="addToOrder">Add</button>
						  	</div>
						</div>
				 	</div>
			  </div>
		  
		  <div class="card-body">
		   <button type="button" class="btn btn-secondary float-left moreInforBtn" 
		   		data-toggle="modal" 
		   		data-target="#infoModal"
		   		data-itemName="${subMenuItem.getItemName()}"
		   		data-itemDescription="${subMenuItem.getItemDesc()}"
		   		data-itemPrice="${subMenuItem.getItemPrice()}"
		   		data-allergyInfo="THESE ARE SOME SERIOUS ALLERGIES TO NUTS"
		   		data-photoLoc = "${subMenuItem.getPhotoLocalDirectory()}"
		   		id="${subMenuItem.getItemID()}"
		   >More Info</button>
		   <div class="float-right">
		   <p>${subMenuItem.getItemPrice()}</p>
		   </div>
		  </div>
		  </div>
	</div> 
	<br>
	</c:forEach>
	
<!-- More Info Modal -->
<div class="modal fade" id="infoModal" tabindex="-1" role="dialog" aria-labelledby="infoModalTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="infoModalLongTitle">Item Name</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="card mx-auto" style="width: 23rem;">
		  <div class="card-body">
			  <div id="itemBox">
				    	<img id="photoLoc" src="" class="rounded float-left, itemPic">  
			  </div>
		  
		  <div class="card-body">
		  	
		  <p class="card-text"  id="itemDescription"></p>
		 	<button type="button" class="btn btn-secondary" data-container="body" data-toggle="popover" data-placement="bottom" 
		  		data-content="Product contains: Shell fish, peanuts, and deez nuts">
  				Allergy Info
			</button>
		  </div>
		  </div>
	</div> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-light btn-sm Arrows upArrow"><i class="fa fa-chevron-up"></i></button>
		<input id="modalInputId" size="4" maxlength="2" value="" placeholder="0">
		<button type="button" class="btn btn-light btn-sm Arrows downArrow"><i class="fa fa-chevron-down"></i></button>
        <button type="button" class="btn btn-primary btn-sm addToOrderBtn" id="addToOrderBtnModal" name="action" data-itemId="0" value="addToOrder">Add </button>
      </div>
    </div>
  </div>
</div>
	
	<script>
		$(document).ready(function(){
		    $('[data-toggle="popover"]').popover();   
		});
	
	
	
	// Restricts input for the given textbox to the given inputFilter.
	function setInputFilter(textbox, inputFilter) {
	  ["input", "keydown", "keyup", "mousedown", "mouseup", "select", "contextmenu", "drop"].forEach(function(event) {
	    textbox.addEventListener(event, function() {
	      if (inputFilter(this.value)) {
	        this.oldValue = this.value;
	        this.oldSelectionStart = this.selectionStart;
	        this.oldSelectionEnd = this.selectionEnd;
	      } else if (this.hasOwnProperty("oldValue")) {
	        this.value = this.oldValue;
	        this.setSelectionRange(this.oldSelectionStart, this.oldSelectionEnd);
	      } else {
	        this.value = "";
	      }
	    });
	  });
	}
	// Install input filters.
	setInputFilter(document.getElementById("intTextBox"), function(value) {
	  return /^-?\d*$/.test(value); });
	</script>
	
	
	<script src="js/jquery.min.js"></script>
	
	<script src="js/popper.min.js"></script>
	
	<script src="js/bootstrap.min.js"></script>
	
	<script src="js/mdb.min.js"></script>
	
	
   
   
</body>
</html>