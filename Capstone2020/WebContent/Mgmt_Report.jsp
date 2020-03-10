<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width-device-width, initial-scale-1, shrink-to-fit-no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script src="js/PopulateModal.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/custom.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Migarock Management</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-success">
		<a class="navbar-brand" href="DashboardUI.jsp">Migarock Management
			System</a>
		<!--Allows NAv bar to adapt to any size screen-->
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbar" aria-controls="navbar" aria-expanded="false">
			<!--Icon for screens too small for full NAV bar-->
			<span class="navbar-toggler-icon"></span>
		</button>
		<!--Default NAV Bar-->
		<div class="collapse navbar-collapse justify-content-between"
			id="navbar">
			<div class="navbar-nav">
				<a class="nav-item nav-link active" href="Mgmt_Report.jsp">Report</a>
				<a class="nav-item nav-link " href="MenuUI.jsp">Menu</a> <a
					class="nav-item nav-link " href="staffmanagement">Staff</a> <a
					class="nav-item nav-link " href="DataBaseUI.jsp">Backup/
					Restore</a>
			</div>
		</div>
	</nav>
	<header id="header">
		<div class="container p-3 bg-dark text-white">
			<div class="row">
				<div class="col-sm-12 info">
					<h4>
						<img src="img/settings.svg"> Report
					</h4>
				</div>
			</div>

		</div>

	</header>

	<div class="container">
		<ol class="breadcrumb">
			<li class="active">Diplay the report based on the criteria</li>

		</ol>
	</div>

	<section id="main">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<div class="list-group">
						<a href="Mgmt_Report.jsp" class="list-group-item active">User
							Report</a> <a href="userReport.jsp" class="list-group-item ">Sales
							Report</a> <a href="staffReport.jsp" class="list-group-item ">Staff
							Report</a>
					</div>
				</div>
				<div class="col-md-9">
					<div class="list-group">
						<a href="index.html" class="list-group-item active">Today's
							User Report</a>
						<div class="list-group-item">
							<div class="row m-1">
								<div class="col-md-3 text-center bg-light p-5">
									<img src="img/user.svg">
									<h3>100</h3>
									<h5>Visitor</h5>
								</div>
								<div class="col-md-3 text-center bg-light p-5">
									<img src="img/chart.svg">
									<h3>1213</h3>
									<h5>Order</h5>
								</div>
								<div class="col-md-3 text-center bg-light p-5">
									<img src="img/bell.svg">
									<h3>205</h3>
									<h5>Help</h5>
								</div>
								<div class="col-md-3 text-center bg-light p-5">
									<img src="img/edit.svg">
									<h3>78</h3>
									<h5>Review</h5>
								</div>

							</div>
						</div>
					</div>
					<div class="list-group mt-3">
						<a href="#" class="list-group-item active">Visitor Trends</a>
						<div class="list-group-item">
							<canvas id="lineChart"></canvas>
						</div>
					</div>
				</div>

			</div>

		</div>
	</section>

	<!--제이쿼리 자바스크립트 추가하기-->
	<script src="js/jquery.min.js"></script>
	<!--popper 자바스크립트 추가하기-->
	<script src="js/popper.min.js"></script>
	<!--부트스트랩 자바스크립트 추가하기-->
	<script src="js/bootstrap.min.js"></script>
	<!--MDB 자바스크립트 추가하기 (맨 밑에 있어야 함)-->
	<script src="js/mdb.min.js"></script>
	<script>
		var ctxL = document.getElementById("lineChart").getContext('2d');
		var myLineChart = new Chart(ctxL, {
			type : 'line',
			data : {
				labels : [ "January", "February", "March", "April", "May",
						"June", "July" ],
				datasets : [ {
					label : "This Year",
					data : [ 12, 22, 35, 41, 56, 67, 90 ],
					backgroundColor : [ 'rgba(105, 0, 132, .2)', ],
					borderColor : [ 'rgba(200, 99, 132, .7)', ],
					borderWidth : 2
				}, {
					label : "Last Year",
					data : [ 8, 13, 22, 29, 35, 44, 70 ],
					backgroundColor : [ 'rgba(0, 137, 132, .2)', ],
					borderColor : [ 'rgba(0, 10, 130, .7)', ],
					borderWidth : 2
				} ]
			},
			options : {
				responsive : true
			}
		});
	</script>

	<!-- Footer -->
	<footer class="bg-dark mt-4 p-5 text-center" style="color: #ffffff;">
		Copyright &copy; 2020 Best Capstone Group </footer>


</body>
</html>