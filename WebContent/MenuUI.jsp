<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">

    <title>Main menu</title>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/Navigation-Clean-1.css">
    <link rel="stylesheet" href="css/Navigation-Clean.css">
    <link rel="stylesheet" href="css/MenuStyle.css">
</head>

<body><img id="logo-1" src="img/migarock logo.png">
    <nav class="navbar navbar-light navbar-expand-md navigation-clean">
        <div class="container"><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">Menu&nbsp;</a>
                        <div class="dropdown-menu" role="menu">                     
	                       
	                       <c:forEach var="category" items="${parsedCategoryList}">
	                       <!-- ASK JOHN FOR MORE APPROPRIATE SOLUTION -->
	                       		<form action="submenu" method="GET">
	                        	<input type="submit" class="dropdown-item" role="presentation"  data-value="${category.getCategoryID()}" value ="${category.getCategoryName()}">
	                        	<input type="hidden" name="categorySelection" value="${category.getCategoryID()}">
	                        	</form>
	                        </c:forEach>
                        </div>
                    </li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="OrderUI.jsp">Order</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="BillUI.jsp">View Bill</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="HelpUI.jsp">Request Help</a></li>
                </ul>
            </div>
            	<a class="navbar-brand" href="#">Main Menu</a>
         </div>
    </nav>
    <!-- THIS IS CARD -->
    <br>
    <c:forEach items="${parsedItemList}" var="item">
    
    <div class="card mx-auto" style="width: 25rem;">
		  <div class="card-body">
		    <h5 class="card-title">${item.getItemName() }</h5>
			  <div id="itemBox">
				    	<img id="itemPic" src="img/migarock logo.png" class="rounded float-left, itemPic"> 
				  	<div class="float-right">
					  	<div id="qnty">
					  		<div class="col text-center">
							  	<button type="button" class="btn btn-light btn-sm Arrows" onclick="incrementValue()"><i class="fa fa-chevron-up"></i></button><br>
								  	<input id="intTextBox" size="4" maxlength="2"><br>
							  	<button type="button" class="btn btn-light btn-sm Arrows" onclick="decrementValue()"><i class="fa fa-chevron-down"></i></button><br>
							  	<button type="button" class="btn btn-primary btn-sm">Add </button>
						  	</div>
						</div>
				 	</div>
			  </div>
			  
		  
		  <div class="card-body">		  
		   <button type="button" class="btn btn-secondary float-left" data-toggle="modal" data-target="#infoModal">More Info</button>
		   <div class="float-right">
		   <p>${item.getItemPrice()}</p>
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
				    	<img id="itemPicInfo" src="img/migarock logo.png" class="rounded"> 
			  </div>
		  
		  <div class="card-body">
		  	
		  <p class="card-text">Some quick example text to build on the item description and make up the bulk of the card's content.</p>
		 	<button type="button" class="btn btn-secondary" data-container="body" data-toggle="popover" data-placement="bottom" 
		  		data-content="Product contains: Shell fish, peanuts, and deez nuts">
  				Allergy Info
			</button>
		  </div>
		  </div>
	</div> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-light btn-sm Arrows" onclick="incrementModalValue()"><i class="fa fa-chevron-up"></i></button>
		<input id="modalIntTextBox" size="4" maxlength="2">
		<button type="button" class="btn btn-light btn-sm Arrows" onclick="decrementModalValue()"><i class="fa fa-chevron-down"></i></button>
        <button type="button" class="btn btn-primary">Add</button>
      </div>
    </div>
  </div>
</div>
	
	<script>
		$(document).ready(function(){
		    $('[data-toggle="popover"]').popover();   
		});
	
	function incrementValue() {
	    var value = parseInt(document.getElementById('intTextBox').value, 10);
	    value = isNaN(value) ? 0 : value;
	    value++;
	    document.getElementById('intTextBox').value = value;
	}
	function decrementValue() {
	    var value = parseInt(document.getElementById('intTextBox').value, 10);
	    value = isNaN(value) ? 0 : value;
	    value--;
	    document.getElementById('intTextBox').value = value;
	}
	function incrementModalValue() {
		    var value = parseInt(document.getElementById('modalIntTextBox').value, 10);
		    value = isNaN(value) ? 0 : value;
		    value++;
		    document.getElementById('modalIntTextBox').value = value;
	}
	function decrementModalValue() {
		    var value = parseInt(document.getElementById('modalIntTextBox').value, 10);
		    value = isNaN(value) ? 0 : value;
		    value--;
		    document.getElementById('modalIntTextBox').value = value;
	}
	
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