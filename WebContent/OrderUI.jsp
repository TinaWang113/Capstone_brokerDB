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
    
    <title>Order Summary</title>
  
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
            <a class="nav-link" href="order">Order<span class="badge badge-light" id="quantityupdate"></span></a>
            </li>

            <li class="nav-item" role="presentation"><a class="nav-link" href="bill" >Bill</a></li>
            <li class="nav-item" role="presentation"><a class="nav-link" href="help">Help</a></li>
        </ul>
    </div>
    </nav>

    <h1>Order summary</h1>
    
	    <table class="table table-striped table-bordered" id="order">
	  <thead>
	    <tr>
	      <th scope="col">Qty</th>
	      <th scope="col">Item name</th>
	      <th scope="col">Price</th>
	      <th scope="col">Status</th>
	      <th scope="col">Edit</th>
	    </tr>
	  </thead>
	  <tbody>
	  
	  <c:forEach var="order" items="${parsedOrderList}" >
	    <tr>
	      <td class="amt" >${order.value.getOrderItemQty()}</td>
	      <td class="item">${order.value.getOrderItem().getItemName()}</td>
	      <td class="price">${order.value.getOrderAmount()}</td>
	      <td class="order" data-index="${order.key}">${order.value.getTable().getTableID()}</td>
	      
	      	<c:set var = "orderStatus" scope = "session" value = "${order.value.getOrderStatus()}"/>
	      	<c:choose>
    			<c:when test="${orderStatus == 1}">
       		 		<td class="status">Ordered</td>
    			</c:when>
    			<c:when test="${orderStatus == 2 }">
    				<td class="status">Delivered</td>
    			</c:when>    
    			<c:otherwise>
       		 		<td class="status">Pending</td>
    			</c:otherwise>
			</c:choose>
				<td class="edit"><button type="button" class="btn btn-primary editItemBtn"
											data-toggle="modal" data-target="#editItemModal"
											>Edit</button>
			  </td>
    	  </tr>
	    </c:forEach>
	    
	  </tbody>
	</table>
	<div class="text-center">
	<form action="order" method="POST">
		<input type="submit" class="btn btn-primary" value="Submit"/>
		<input type="hidden" value="submitForOrder" name="action"/>
	</form>
		<div class="float-right" id="total"></div>
	</div>
	
	<!-- Edit Item Modal -->
<div class="modal fade" id="editItemModal" tabindex="-1" role="dialog" aria-labelledby="editModalTitle" aria-hidden="true">
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
		  </div>
		  </div>
	</div> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-light btn-sm Arrows upArrow"><i class="fa fa-chevron-up"></i></button>
		<input id="modalInputId" size="4" maxlength="2" value="" placeholder="amt">
		<button type="button" class="btn btn-light btn-sm Arrows downArrow"><i class="fa fa-chevron-down"></i></button>
        <button type="button" class="btn btn-primary btn-sm addToOrderBtn" id="addToOrderBtnModal" name="action" data-itemId="0" value="addToOrder">Add </button>
      </div>
    </div>
  </div>
</div>
	
	<!-- Script for adding up total bill -->
	<script>
	 var cls = document.getElementById("order").getElementsByTagName("td");
	 	var temp = 0;
	    var sum = 0;
	    var total = 0;
	    var amount = 0;
	    for (var i = 0; i < cls.length; i++){
	    	
	    	if(cls[i].className == "amt"){
	    		
	    	amount = isNaN(cls[i].innerHTML) ? 0 : parseFloat(cls[i].innerHTML);
	    	}
	    	
	        if(cls[i].className == "price"){
	        	
	            sum = isNaN(cls[i].innerHTML) ? 0 : parseFloat(cls[i].innerHTML);
	            temp = amount * sum;
	            total += temp
	            document.getElementById('total').innerHTML = total;
	        }
	    }
	</script>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>
  </body>
</html>