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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
	<link rel="stylesheet" href="css/MenuStyle.css">
	<script src="js/EditOrder.js" type="text/javascript"></script>
    
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
            <a class="nav-link" href="order">Order<span class="badge badge-light" id="quantityupdate">${sessionScope.updateQuantity}</span></a>
            </li>

            <li class="nav-item" role="presentation"><a class="nav-link" href="bill" >Bill</a></li>
            <li class="nav-item" role="presentation"><a class="nav-link" href="help">Help</a></li>
            <li class="nav-item" role="presentation"><a class="nav-link" href="menu">Main Menu</a></li>
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
	      <td class="price">$${order.value.getOrderAmount()}</td>	      
	      	<c:set var = "orderStatus" scope = "session" value = "${order.value.getOrderStatus()}"/>
	      	<c:choose>
    			<c:when test="${orderStatus == 1}">
       		 		<td class="status">Ordered</td>
       		 		<td class="edit"><button type="button" class="btn btn-secondary" disabled>Edit</button>
			  		</td>
    			</c:when>
    			<c:when test="${orderStatus == 2}">
    				<td class="status">Delivered</td>
    			</c:when>    
    			<c:otherwise>
       		 		<td class="status">Pending</td>
       		 		<td class="edit"><button type="button" class="btn btn-primary editItemBtn" 
						data-toggle="modal" 
						data-target="#editItemModal" 
						data-qty="${order.value.getOrderItemQty()}"
						data-itemName="${order.value.getOrderItem().getItemName()}"
						data-itemIndex="${order.key}"
						>Edit</button>
			  		</td>
    			</c:otherwise>
			</c:choose>
				
    	  </tr>
	    </c:forEach>
	  </tbody>
	</table>
	<div class="text-center">
	<form action="order" method="POST">
		<input type="submit" class="btn btn-lg btn-success btn-block" value="Submit"/>
		<input type="hidden" value="submitForOrder" name="action"/>
	</form>
	</div>
	
	<!-- Edit Item Modal -->
<div class="modal fade" id="editItemModal" tabindex="-1" role="dialog" aria-labelledby="editModalTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="itemName">Item Name</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body mx-auto">
        <div class="row">
  		<div class="col-sm-4">
        <div class="card text-center" style="width: 19rem;">
		  <div class="card-body">
		  <div>
		   <button type="button" class="btn btn-primary btn-sm Arrows editOrderupArrow"><i class="fa fa-chevron-up"></i></button>
		   
				<input id="quantity" size="4" maxlength="2" value="" placeholder="0">
			
				<button type="button" class="btn btn-primary btn-sm Arrows editOrderdownArrow"><i class="fa fa-chevron-down"></i></button>
		  </div>
		  <br>
		      <button type="button"  class="btn btn-success btn-sm editingOrderBtn btn-block" id="editingOrderBtn" 
		      data-itemIndex="0" 
		      value="editItem">Update Item</button>
		  </div>
		</div>
		<div class="row">
	      <div class="col-sm-4">
           <div class="card text-center">
		   <div class="card-body">
		   <div>
			 <button type="button" class="btn btn-danger btn-sm  deleteOrderBtn btn-block" id="deleteOrderBtn" data-itemIndex="0" value="deleteItem">Delete Item </button>
			 </div>
		 </div>
		</div>
	   </div>
      </div> 
     </div>
    </div>
   </div>
  </div>
 </div>
</div>
  
  
	
	<!-- Script for adding up total bill -->
	<script>
	 //var cls = document.getElementById("order").getElementsByTagName("td");
	 	//var temp = 0;
	   // var sum = 0;
	    //var total = 0;
	   // var amount = 0;
	    //for (var i = 0; i < cls.length; i++){
	    	
	    	//if(cls[i].className == "amt"){
	    		
	    	//amount = isNaN(cls[i].innerHTML) ? 0 : parseFloat(cls[i].innerHTML);
	    	//}
	    	
	        //if(cls[i].className == "price"){
	        	
	            //sum = isNaN(cls[i].innerHTML) ? 0 : parseFloat(cls[i].innerHTML);
	            //temp = amount * sum;
	            //total += temp
	            //document.getElementById('total').innerHTML = "$"+total;
	        //}
	    //}
	</script>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="js/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>
    <script src="js/mdb.min.js"></script>
  </body>
</html>