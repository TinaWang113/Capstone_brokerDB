<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<a class="navbar-brand" href="tableMonitor">Migarock Management
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
				<a class="nav-item nav-link " href="tableMonitor">Monitor</a> <a
					class="nav-item nav-link " href="MenuUI.jsp">Menu</a> <a
					class="nav-item nav-link" href="staffmanagement">Staff</a> <a
					class="nav-item nav-link active" href="reportCustomerServlet">Report</a>
				<a class="nav-item nav-link " href="DataBaseUI.jsp">Backup/
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
			<li class="active">Display the report based on the criteria</li>

		</ol>
	</div>

	<section id="main">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<div class="list-group">
						<a href="reportCustomerServlet" class="list-group-item active">Customer
							Report</a> <a href="reportSaleServlet" class="list-group-item">Sales
							Report</a>
					</div>
				</div>
				<div class="col-md-9">
					<div class="list-group">
						<a href="index.html" class="list-group-item active">Today's
							Customer Report</a>
						<div class="list-group-item">
							<div class="row m-1">
								<div class="col-md-4 text-center bg-light p-5">
									<img src="img/user.svg">
									<h3>${report.getTodayCustomer()}</h3>
									<h5>Visitor</h5>
								</div>
								<div class="col-md-4 text-center bg-light p-5">
									<img src="img/chart.svg">
									<h3>${report.getTodayOrder()}</h3>
									<h5>Order</h5>
								</div>
								<div class="col-md-4 text-center bg-light p-5">
									<img src="img/edit.svg">
									<h3>${report.getTodayReview()}</h3>
									<h5>Review</h5>
								</div>

							</div>
						</div>
					</div>
					<div class="list-group mt-3">
						<a href="#" class="list-group-item active">Monthly Customer
							Satisfaction</a>
						<div class="list-group-item">
							<canvas id="barChart"></canvas>
						</div>
					</div>
					<div class="list-group mt-3">
						<a href="#" class="list-group-item active">Monthly Avg. Customer
							Satisfaction</a>
						<div class="list-group-item">
							<canvas id="pieChart"></canvas>
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
		//pie
		var ctxP = document.getElementById("pieChart").getContext('2d');
		var myPieChart = new Chart(ctxP,
				{
					type : 'pie',
					data : {
						labels : [ "Very Poor", "Poor", "Average", "Good",
								"Excellent" ],
						datasets : [ {
							data : [ ${report.getQ_avg_1()}, ${report.getQ_avg_2()}, ${report.getQ_avg_3()}, ${report.getQ_avg_4()}, ${report.getQ_avg_5()} ],
							backgroundColor : [ "#4D5360", , "#46BFBD",
									"#FDB45C", "#F7464A", "#4D5360" ],
							hoverBackgroundColor : [ "#FF5A5E", "#5AD3D1",
									"#FFC870", "#A8B3C5", "#616774" ]
						} ]
					},
					options : {
						responsive : true
					}
				});
	</script>
	<script>
		//bar
		var ctxB = document.getElementById("barChart").getContext('2d');
		var myBarChart = new Chart(ctxB, {
			type : 'bar',
			data : {
				labels : [ "Food", "Service", "Atmosphere", "Speed_svc",
						"Speed_food", "Recommendation", "rate_App" ],
				datasets : [ {
					label : '# of 5 Stars',
					data : [ ${report.getQ_food()}, ${report.getQ_service()}, ${report.getQ_atmosphere()}, ${report.getQ_speed_svc()}, ${report.getQ_speec_food()},${report.getQ_recommendation()} ,${report.getQ_rate_app()}],
					backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
							'rgba(54, 162, 235, 0.2)',
							'rgba(255, 206, 86, 0.2)',
							'rgba(75, 192, 192, 0.2)',
							'rgba(153, 102, 255, 0.2)',
							'rgba(255, 159, 64, 0.2)' ],
					borderColor : [ 'rgba(255,99,132,1)',
							'rgba(54, 162, 235, 1)', 'rgba(255, 206, 86, 1)',
							'rgba(75, 192, 192, 1)', 'rgba(153, 102, 255, 1)',
							'rgba(255, 159, 64, 1)' ],
					borderWidth : 1
				} ]
			},
			options : {
				scales : {
					yAxes : [ {
						ticks : {
							beginAtZero : true
						}
					} ]
				}
			}
		});
	</script>
</body>



</html>