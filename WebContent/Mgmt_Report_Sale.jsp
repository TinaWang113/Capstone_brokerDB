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
						<a href="reportCustomerServlet" class="list-group-item ">Customer
							Report</a> <a href="reportSaleServlet" class="list-group-item active">Sales
							Report</a>
					</div>
				</div>
				<div class="col-md-9">
					<div class="list-group mt-9">
						<a href="#" class="list-group-item active">Sales Trend (Order
							Count)</a>
						<div class="list-group-item">
							<canvas id="lineChart"></canvas>
						</div>
					</div>
					<br>
					<div class="list-group">
						<a class="list-group-item active" data-toggle="collapse"
							href="#daily">Daily Best Menu</a>
						<div class="list-group-item">
							<div class="list-group">
								<div class="collapse" id="daily">
									<table class="table">
										<tbody>
											<tr>
												<th class="mobile" style="width: 130px; text-align: center">Item
													Name</th>
												<th class="mobile" style="width: 130px; text-align: center">Order
													Count</th>

											</tr>
											<c:forEach items="${bestToday}" var="today">
												<tr>

													<td class="mobile" style="text-align: left">${today.getBest_item()}</td>
													<td class="mobile" style="text-align: center">${today.getBest_qty()}</td>
												</tr>

											</c:forEach>

										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<br>
					<div class="list-group">
						<a class="list-group-item active" data-toggle="collapse"
							href="#monthly">Monthly Best Menu</a>
						<div class="list-group-item">
							<div class="list-group">
								<div class="collapse" id="monthly">
									<table class="table">
										<tbody>
											<tr>
												<th class="mobile" style="width: 130px; text-align: center">Item
													Name</th>
												<th class="mobile" style="width: 130px; text-align: center">Order
													Count</th>

											</tr>
											<c:forEach items="${bestMonth}" var="month">
												<tr>
													<td class="mobile" style="text-align: left">${month.getBest_item()}</td>
													<td class="mobile" style="text-align: center">${month.getBest_qty()}</td>
												</tr>

											</c:forEach>

										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="js/jquery.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/mdb.min.js"></script>
	<script>
		var ctxL = document.getElementById("lineChart").getContext('2d');
		var myLineChart = new Chart(ctxL, {
			type : 'line',
			data : {
				labels : [ "ThisMonth-12", "ThisMonth-11", "ThisMonth-10",
						"ThisMonth-9", "ThisMonth-8", "ThisMonth-7",
						"ThisMonth-6", "ThisMonth-5", "ThisMonth-4",
						"ThisMonth-3", "ThisMonth-2", "ThisMonth-1",
						"ThisMonth" ],
				datasets : [ {
					label : "Last 1 year	",
					data : [ ${report.getThisMonth_12()}, ${report.getThisMonth_11()}, ${report.getThisMonth_10()}, 
						${report.getThisMonth_9()}, ${report.getThisMonth_8()}, ${report.getThisMonth_7()}, 
						${report.getThisMonth_6()},${report.getThisMonth_5()},${report.getThisMonth_4()},
						${report.getThisMonth_3()},${report.getThisMonth_2()},${report.getThisMonth_1()},
						${report.getThisMonth_0()}],
					backgroundColor : [ 'rgba(105, 0, 132, .2)', ],
					borderColor : [ 'rgba(200, 99, 132, .7)', ],
					borderWidth : 2
				} ]
			},
			options : {
				responsive : true
			}
		});
		$('.input-group.date').datepicker({
			format : "dd.mm.yyyy"
		});
	</script>

	<!-- Footer -->
	<footer class="bg-dark mt-4 p-5 text-center" style="color: #ffffff;">
		Copyright &copy; 2020 Best Capstone Group </footer>


</body>
</html>