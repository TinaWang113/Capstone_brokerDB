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

	<!-- 
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
        <h3 class="my-0 mr-md-auto font-weight-normal">Migarock Table Monitoring System</h3>
        <a class="btn btn-outline-primary" href="#">Lock</a>
    </div> -->
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
								<input type="hidden" name="tableId" value="1" />
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
								<input type="hidden" name="tableId" value="2" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
								<input type="hidden" name="tableId" value="3" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
								<input type="hidden" name="tableId" value="4" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
								<input type="hidden" name="tableId" value="5" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
								<input type="hidden" name="tableId" value="6" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
								<input type="hidden" name="tableId" value="7" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
						<c:if test="${table_8==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_08</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="8" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
						<c:if test="${table_9==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_09</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="9" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
						<c:if test="${table_10==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_10</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="10" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
						<c:if test="${table_11==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_11</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="11" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
						<c:if test="${table_12==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_12</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="12" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
						<c:if test="${table_13==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_13</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="13" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
						<c:if test="${table_14==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_14</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="14" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
						<c:if test="${table_15==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_15</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="15" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
						<c:if test="${table_16==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_16</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="16" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
						<c:if test="${table_17==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_17</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="17" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
						<c:if test="${table_18==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_18</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="18" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
						<c:if test="${table_19==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_19</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="19" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
						<c:if test="${table_20==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_20</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="20" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
						<c:if test="${table_21==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_21</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="21" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
						<c:if test="${table_22==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_22</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="22" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
						<c:if test="${table_23==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_23</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="23" />
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
							<div class="card-header status2" style="background-color: yellow;">
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
						<c:if test="${table_24==0}">
							<div class="card-header">
								<h3 class="my-0 font-weight-normal ">
									<strong>Table_24</strong>
								</h3>
							</div>
						</c:if>
						<div class="card-body">
							<form action="tableDetail" method="GET">
								<input type="hidden" name="tableId" value="24" />
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