<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Menu Selection</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/Navigation-Clean-1.css">
    <link rel="stylesheet" href="css/Navigation-Clean.css">
    <link rel="stylesheet" href="css/ChoiceStyle.css">
</head>

<body><img id="logo-1" src="img/migarock logo.png">
	 <div class="jumbotron-fluid">
	  <h1 class="display-4">Welcome!</h1>
	  
	  <h6 class="display-6">Please select a menu from below!</h6>
	  <hr class="my-4">
	 
	</div>
	
	
	<div align="center">
		<form action="choice" method="POST">
	  		<input type="submit" class="btn btn-light hell" aria-haspopup="true" aria-expanded="false" style="width:50%" value="Regular">
	  		<input type="hidden" value="1" name="action">
  		</form>
	  		<form action="choice" method="POST">
	  		<input type="submit" class="btn btn-light" aria-haspopup="true" aria-expanded="false" style="width:50%" value="AYCE">
	  		<input type="hidden" value="2" name="action">
  		</form>
	</div>
	
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
</body>

</html>