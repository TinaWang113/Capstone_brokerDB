<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

<title>Migarock Table Monitoring System</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.0/examples/pricing/">

<!-- Bootstrap core CSS -->
<link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="pricing.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link href="./css/tableMonitor.css" rel="stylesheet">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<a class="nav-item nav-link active" href="tableMonitor">Monitor</a> <a
					class="nav-item nav-link " href="MenuUI.jsp">Menu</a> <a
					class="nav-item nav-link" href="staffmanagement">Staff</a> <a
					class="nav-item nav-link" href="reportCustomerServlet">Report</a>
				<a class="nav-item nav-link " href="DataBaseUI.jsp">Backup/
					Restore</a>
			</div>
		</div>
	</nav>
	<br/>
	<div class="row">
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center ">
					<div class="card mb-4 box-shadow ">
						<c:if test="${table_1==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_01</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_1==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_01</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_1==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_01</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_1==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_01</strong>
								</h3>
							</div>
						</c:if>

						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="1" /> <input
									type="hidden" name="tableStartTime"
									value="${table_1_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center">
					<div class="card mb-4 box-shadow">
						<c:if test="${table_2==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_02</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_2==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_02</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_2==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_02</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_2==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_02</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="2" /> <input
									type="hidden" name="tableStartTime"
									value="${table_2_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center">
					<div class="card mb-4 box-shadow">
						<c:if test="${table_3==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_03</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_3==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_03</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_3==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_03</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_3==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_03</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="3" /> <input
									type="hidden" name="tableStartTime"
									value="${table_3_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center">
					<div class="card mb-4 box-shadow">
						<c:if test="${table_4==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_04</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_4==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_04</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_4==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_04</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_4==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_04</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="4" /> <input
									type="hidden" name="tableStartTime"
									value="${table_4_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center">
					<div class="card mb-4 box-shadow">
						<c:if test="${table_5==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_05</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_5==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_05</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_5==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_05</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_5==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_05</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="5" /> <input
									type="hidden" name="tableStartTime"
									value="${table_5_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center">
					<div class="card mb-4 box-shadow ">
						<c:if test="${table_6==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_06</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_6==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_06</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_6==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_06</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_6==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_06</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="6" /> <input
									type="hidden" name="tableStartTime"
									value="${table_6_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center ">
					<div class="card mb-4 box-shadow ">
						<c:if test="${table_7==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_07</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_7==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_07</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_7==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_07</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_7==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_07</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="7" /> <input
									type="hidden" name="tableStartTime"
									value="${table_7_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center">
					<div class="card mb-4 box-shadow">
						<c:if test="${table_8==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_08</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_8==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_08</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_8==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_08</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_8==0 || table_8 ==null}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_08</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="8" /> <input
									type="hidden" name="tableStartTime"
									value="${table_8_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center">
					<div class="card mb-4 box-shadow">
						<c:if test="${table_9==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_09</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_9==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_09</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_9==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_09</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_9==0 || table_9 ==null}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_09</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="9" /> <input
									type="hidden" name="tableStartTime"
									value="${table_9_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center">
					<div class="card mb-4 box-shadow">
						<c:if test="${table_10==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_10</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_10==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_10</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_10==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_10</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_10==0 || table_10 ==null}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_10</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="10" /> <input
									type="hidden" name="tableStartTime"
									value="${table_10_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center">
					<div class="card mb-4 box-shadow">
						<c:if test="${table_11==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_11</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_11==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_11</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_11==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_11</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_11==0 || table_11 ==null}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_11</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="11" /> <input
									type="hidden" name="tableStartTime"
									value="${table_11_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center">
					<div class="card mb-4 box-shadow ">
						<c:if test="${table_12==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_12</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_12==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_12</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_12==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_12</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_12==0 || table_12 ==null}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_12</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="12" /> <input
									type="hidden" name="tableStartTime"
									value="${table_12_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center ">
					<div class="card mb-4 box-shadow ">
						<c:if test="${table_13==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_13</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_13==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_13</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_13==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_13</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_13==0 || table_13 ==null}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_13</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="13" /> <input
									type="hidden" name="tableStartTime"
									value="${table_13_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center">
					<div class="card mb-4 box-shadow">
						<c:if test="${table_14==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_14</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_14==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_14</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_14==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_14</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_14==0 || table_14 ==null}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_14</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="14" /> <input
									type="hidden" name="tableStartTime"
									value="${table_14_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center">
					<div class="card mb-4 box-shadow">
						<c:if test="${table_15==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_15</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_15==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_15</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_15==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_15/strong> 
								</h3>
							</div>
						</c:if>
						<c:if test="${table_15==0 || table_15 ==null}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_15</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="15" /> <input
									type="hidden" name="tableStartTime"
									value="${table_15_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center">
					<div class="card mb-4 box-shadow">
						<c:if test="${table_16==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_16</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_16==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_16</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_16==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_16</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_16==0 || table_16 ==null}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_16</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="16" /> <input
									type="hidden" name="tableStartTime"
									value="${table_16_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center">
					<div class="card mb-4 box-shadow">
						<c:if test="${table_17==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_17</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_17==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_17</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_17==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_17</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_17==0 || table_17 ==null}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_17</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="17" /> <input
									type="hidden" name="tableStartTime"
									value="${table_17_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center">
					<div class="card mb-4 box-shadow ">
						<c:if test="${table_18==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_18</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_18==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_18</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_18==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_18</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_18==0 || table_18 ==null}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_18</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="18" /> <input
									type="hidden" name="tableStartTime"
									value="${table_18_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center ">
					<div class="card mb-4 box-shadow ">
						<c:if test="${table_19==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_19</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_19==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_19</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_19==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_19</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_19==0 || table_19 ==null}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_19</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="19" /> <input
									type="hidden" name="tableStartTime"
									value="${table_19_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center">
					<div class="card mb-4 box-shadow">
						<c:if test="${table_20==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_20</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_20==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_20</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_20==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_20</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_20==0 || table_20 ==null}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_20</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="20" /> <input
									type="hidden" name="tableStartTime"
									value="${table_20_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center">
					<div class="card mb-4 box-shadow">
						<c:if test="${table_21==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>table_21</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_21==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_21</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_21==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_21</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_21==0 || table_21 ==null}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_21</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="21" /> <input
									type="hidden" name="tableStartTime"
									value="${table_21_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center">
					<div class="card mb-4 box-shadow">
						<c:if test="${table_22==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_22</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_22==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_22</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_22==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_22</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_22==0 || table_22 ==null}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_22</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="22" /> <input
									type="hidden" name="tableStartTime"
									value="${table_22_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center">
					<div class="card mb-4 box-shadow">
						<c:if test="${table_23==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_23</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_23==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_23</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_23==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_23</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_23==0 || table_23 ==null}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_23</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="23" /> <input
									type="hidden" name="tableStartTime"
									value="${table_23_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2">
			<div class="container">
				<div class="card-deck mb-3 text-center">
					<div class="card mb-4 box-shadow ">
						<c:if test="${table_24==1}">
							<div class="card-header status1" style="background-color: red;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_24</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_24==2}">
							<div class="card-header status2"
								style="background-color: yellow;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_24</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_24==3}">
							<div class="card-header status3" style="background-color: green;">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_24</strong>
								</h3>
							</div>
						</c:if>
						<c:if test="${table_24==0 || table_24 ==null}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_24</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="24" /> <input
									type="hidden" name="tableStartTime"
									value="${table_24_startTime}" />
								<button
									class="btn btn-outline-primary btn-lg btn-block mx-1 mt-1"
									name="check">
									Check</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer class="pt-4 my-md-5 pt-md-5 border-top"> </footer>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')
	</script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script>
		Holder.addTheme('thumb', {
			bg : '#55595c',
			fg : '#eceeef',
			text : 'Thumbnail'
		});
	</script>
	<script>
		$(function() {

			//button select all or cancel
			$("#select-all").click(function() {
				var all = $("input.select-all")[0];
				all.checked = !all.checked
				var checked = all.checked;
				$("input.select-item").each(function(index, item) {
					item.checked = checked;
				});
			});

			//button select invert
			$("#select-invert").click(function() {
				$("input.select-item").each(function(index, item) {
					item.checked = !item.checked;
				});
				checkSelected();
			});

			//button get selected info
			$("#selected").click(
					function() {
						var items = [];
						$("input.select-item:checked:checked").each(
								function(index, item) {
									items[index] = item.value;
								});
						if (items.length < 1) {
							alert("no selected items!!!");
						} else {
							var values = items.join(',');
							console.log(values);
							var html = $("<div></div>");
							html.html("selected:" + values);
							html.appendTo("body");
						}
					});

			//column checkbox select all or cancel
			$("input.select-all").click(function() {
				var checked = this.checked;
				$("input.select-item").each(function(index, item) {
					item.checked = checked;
				});
			});

			//check selected items
			$("input.select-item").click(function() {
				var checked = this.checked;
				console.log(checked);
				checkSelected();
			});

			//check is all selected
			function checkSelected() {
				var all = $("input.select-all")[0];
				var total = $("input.select-item").length;
				var len = $("input.select-item:checked:checked").length;
				console.log("total:" + total);
				console.log("len:" + len);
				all.checked = len === total;
			}
		});
	</script>
</body>

</html>