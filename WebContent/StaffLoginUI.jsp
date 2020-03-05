<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/Footer-Dark.css">
    <link rel="stylesheet" href="css/styles.css">
</head>

<body>
    <div><img id="logo" src="img/migarock%20logo.png"></div>
    <h1>Login</h1>
    <form action="loginservlet" method="POST">
<div id="loginPad"><div class="btn-group-vertical ml-4 mt-4" role="group" aria-label="Basic example">
    
    <div class="btn-group">
        <input class="text-center form-control-lg mb-2" type="text" id="pin" name="pin" maxlength="4">
    </div>
    <div class="btn-group">
        <button type="button" class="btn btn-outline-secondary py-3" onclick="document.getElementById('pin').value=document.getElementById('pin').value + '1';">1</button>
        <button type="button" class="btn btn-outline-secondary py-3" onclick="document.getElementById('pin').value=document.getElementById('pin').value + '2';">2</button>
        <button type="button" class="btn btn-outline-secondary py-3" onclick="document.getElementById('pin').value=document.getElementById('pin').value + '3';">3</button>
    </div>
    <div class="btn-group">
        <button type="button" class="btn btn-outline-secondary py-3" onclick="document.getElementById('pin').value=document.getElementById('pin').value + '4';">4</button>
        <button type="button" class="btn btn-outline-secondary py-3" onclick="document.getElementById('pin').value=document.getElementById('pin').value + '5';">5</button>
        <button type="button" class="btn btn-outline-secondary py-3" onclick="document.getElementById('pin').value=document.getElementById('pin').value + '6';">6</button>
    </div>
    <div class="btn-group">
        <button type="button" class="btn btn-outline-secondary py-3" onclick="document.getElementById('pin').value=document.getElementById('pin').value + '7';">7</button>
        <button type="button" class="btn btn-outline-secondary py-3" onclick="document.getElementById('pin').value=document.getElementById('pin').value + '8';">8</button>
        <button type="button" class="btn btn-outline-secondary py-3" onclick="document.getElementById('pin').value=document.getElementById('pin').value + '9';">9</button>
    </div>
    <div class="btn-group">
        <input type="reset" class="btn btn-outline-secondary py-3" value ="Clear">
        <button type="button" class="btn btn-outline-secondary py-3" onclick="document.getElementById('pin').value=document.getElementById('pin').value + '0';">0  </button>
        <input type="submit" class="btn btn-primary py-3" value="Enter" onclick="">
    </div>
</div>
</div>
</form>
    <div id="footer"><footer class="bg-dark mt-4 p-5 text-center" style="color: #ffffff;">
    Copyright &copy; 2020 Best Capstone Group</footer></div>
    <div></div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
</body>

</html>