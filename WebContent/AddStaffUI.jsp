<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<title>Migarock Management</title>
</head>
<body onLoad="setPin()">
	<nav class="navbar navbar-expand-lg navbar-dark bg-success">
    <a class="navbar-brand" href="DashboardUI.jsp">Migarock Management System</a>
    <!--Allows NAV bar to adapt to any size screen-->
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbar" aria-controls="navbar" aria-expanded="false">
        <!--Icon in case of small screen-->
        <span class="navbar-toggler-icon"></span>
    </button>
    <!--Top Navigation Bar-->
    <div class="collapse navbar-collapse justify-content-between" id="navbar">
        <div class="navbar-nav">
            <a class="nav-item nav-link " href="DashboardUI.jsp">Dashboard</a>
            <a class="nav-item nav-link " href="MenuMgmtUI.jsp">Menu</a>
            <a class="nav-item nav-link active" href="staffmanagement">Staff</a>
            <a class="nav-item nav-link " href="DataBaseUI.jsp">Backup/ Restore</a>
        </div>
        
    </div>
</nav>
<!--Dark grey Large Header-->
<header id="header">
    <div class="container p-3 bg-dark text-white">
        <div class="row">
            <div class="col-sm-9 info">
                <h4><img src="img/user_small.svg"> Staff Management
                    
                </h4>
            </div>
        </div>

    </div>

</header>
<!--Light grey header for bread crumbs-->
<div class="container">
<nav aria-label="breadcrumb">
    <ol class="breadcrumb blue-grey lighten-4">
      <li class="breadcrumb-item"><a class="black-text" href="staffmanagement">Staff Summary</a><i
          class="fas fa-angle-double-right mx-2" aria-hidden="true"></i></li>
      <li class="breadcrumb-item active"><a class="black-text">Add New Staff</a>
    </ol>
  </nav>
</div>
<!--The form to be filled out for adding a new staff to the DB-->
<!--All fields are required to be filled in, PIN is like the password to access the staff side of the application-->
<!--PINs must be unique, add JS to check with DB is PIN is used or not-->
<section id="main">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="list-group">
                    <a href="staffmanagement" class="list-group-item ">Staff Summary</a>
                    <a href="addStaff" class="list-group-item active">Add New Staff</a>
                </div>   
            </div>
            <div class="col-md-9">
                <div class="list-group">
                    <a class="list-group-item active">Input Staff Information</a>
                    
                    <div class="list-group-item">
                        <form class="form-group" action="addstaff" method="POST">
                        <label>Job Title</label>
                            <select class="form-control" name="jobSelect" id="jobSelect" onChange="return setPin()">
                                <option data-pin="0" value="manager">Manager</option>
                                <option data-pin="1" value="PT">PT Server</option>
                                <option data-pin="1" value="FT">FT Server</option>
                            </select><br>
                            <label>First Name</label>
                            <input class="form-control" type="text" name="fName"><br>
							<label>Last Name</label>
                            <input class="form-control" type="text" name="lName"><br>
                            <label>PIN</label>
                            <input class="form-control" type="text" name="pin" id="pin" readonly><br>
                            <label>Phone</label>
                            <input class="form-control" type="tel" id="example-tel-input" name="contactNum"><br>
                            
                        <button type="reset" class="btn btn-secondary">Clear</button>
        			    <input type="submit" value="Add" class="btn btn-primary" data-toggle="modal" data-target="#addModal"> 
                    	<input type="hidden" value="addConfirm" name="addbtnConfirm">
                        </form>
                    </div>

                </div>
            </div>

        </div>

    </div>
</section>
<!--Popup for successful addition to staff table, maybe display name and job title in this popup to make it clear-->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        
        <h4 class="modal-title" id="myModalLabel">Success!</h4>
      </div>
      <div class="modal-body">
        {Added Staff info} has been added!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<!--Popup for failure message, could pass through a few error messages to make this reactive and more clear on issue-->
<div class="modal fade" id="failModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        
        <h4 class="modal-title" id="myModalLabel">Whoops!</h4>
      </div>
      <div class="modal-body">
        {Error} something has gone wrong!<br>
        Please try again!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<footer class="bg-dark mt-4 p-5 text-center" style="color: #ffffff;">
    Copyright &copy; 2020 Best Capstone Group
</footer>


<!-- Scripts -->

<script>
function setPin(){
    // find the dropdown
    var ddl = document.getElementById("jobSelect");
    // find the selected option
    var selectedOption = ddl.options[ddl.selectedIndex];
    // find the attribute value
    var pinValue = selectedOption.getAttribute("data-pin");
    // find the textbox
    var textBox = document.getElementById("pin");

    // set the textbox value
    if(pinValue=="0"){
        textBox.value = "4321";
    }
    else if(pinValue=="1"){
        textBox.value = "1234";
    }   
}</script>
<script src="js/jquery.min.js"></script>

<script src="js/popper.min.js"></script>

<script src="js/bootstrap.min.js"></script>

<script src="js/mdb.min.js"></script>

</body>
</html>