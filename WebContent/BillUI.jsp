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
    
    <title>Bill</title>
  
  </head>
  
  <body>
  	<img id="logo-1" src="img/migarock logo.png">
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
	                        <a class="nav-link" href="menu">Main Menu</a>
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
    <h1>Request the bill</h1>
    
    <table class="table table-striped table-bordered" id="order">
	  <thead>
	    <tr>
	      <th scope="col">Qty</th>
	      <th scope="col">Item name</th>
	      <th scope="col">Price</th>
	    </tr>
	  </thead>
	  <tbody>
	  
	  <c:forEach var="order" items="${parsedOrderList}" >
	    <tr>
	     <td class="amt" >${order.value.getOrderItemQty()}</td>
	      <td class="item">${order.value.getOrderItem().getItemName()}</td>
	      <td class="price">$${order.value.getOrderAmount()}</td>
    	  </tr>
	    </c:forEach>
	    <tr>
		    <td colspan="2">Total (Excluding GST)</td>
		    <td ><div class="price" id="total">$${total}</div></td>
	    </tr>
	    
	  </tbody>
	</table>
	<form action="bill" method="POST">
 		<input type="submit" class="btn btn-success btn-lg  requestBillBtn btn-block" id="requestBillBtn"  value="Request The Bill">
 	</form>
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
   <script src="js/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>