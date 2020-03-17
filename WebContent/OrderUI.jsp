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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
    		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
    		crossorigin="anonymous">
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
	<link rel="stylesheet" href="css/MenuStyle.css">
    
    <title>Order Summary</title>
  
  </head>
  
  <body>
  	<img id="logo-1" src="img/migarock logo.png">
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
                    <li class="nav-item" role="presentation"><a class="nav-link" href="order">Order</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="BillUI.jsp">View Bill</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="HelpUI.jsp">Request Help</a></li>
                </ul>
            </div>
         </div>
    </nav>
    <h1>Order summary</h1>
    
	    <table class="table table-striped table-bordered" id="order">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Item name</th>
	      <th scope="col">Price</th>
	      <th scope="col">Status</th>
	    </tr>
	  </thead>
	  <tbody>
	  
	  <c:forEach var="order" items="${parsedOrderList}" >
	    <tr>
	      <td class="amt">${order.getOrderItemQty()}</td>
	      <td class="item">${order.getOrderItem().getItemName()}</td>
	      <td class="price">${order.getOrderItem().getItemPrice()}</td>
	      
	      	<c:set var = "orderStatus" scope = "session" value = "${order.getOrderStatus()}"/>
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
			
    	  </tr>
	    </c:forEach>
	    
	  </tbody>
	</table>
	<div class="sumPanel">
	<form action="order" method="POST">
		<input type="submit" class="btn btn-primary" value="Submit"/>
		<input type="hidden" value="submitForOrder" name="action"/>
	</form>
		<div class="float-right" id="total"></div>
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
	    		
	    	amount = isNaN(cls[i].innerHTML) ? 0 : parseInt(cls[i].innerHTML);
	    	}
	    	
	        if(cls[i].className == "price"){
	        	
	            sum = isNaN(cls[i].innerHTML) ? 0 : parseInt(cls[i].innerHTML);
	            temp = amount * sum;
	            total += temp
	            document.getElementById('total').innerHTML = total;
	        }
	    }
	    
	</script>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>