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
	<div>
		<h2 class="modal-title" id="modal">Table#${tableId} Status</h2>
	</div>
	<!--  	<div class="controlBar">-->
	<div class="row">
		<div class="col-8" style="text-align: left;">
			<button type="button" class="btn btn-outline-success btn-lg"
				data-dismiss="modal">Add item</button>
			<button type="button" class="btn btn-outline-secondary btn-lg"
				data-dismiss="modal">Change Status</button>

		</div>
		<div class="col-4" style="text-align: right; padding-right: 10%;">
			<button type="button" class="btn btn-outline-warning btn-lg"
				data-dismiss="modal">Help</button>
			<button type="button" class="btn btn-outline-info btn-lg"
				data-dismiss="modal">Bill</button>
		</div>
	</div>
	<br>
	<div>
		<div class="container">
			<div class="scrollbar scrollbar-primary">
				<table class="table">
					<thead>
						<tr style="text-align: center;">
							<th scope="col"><input type="checkbox"
								class="select-all checkbox" name="select-all" /></th>
							<th scope="col">Order Time</th>
							<th scope="col">Order Item</th>
							<th scope="col">QTY</th>
							<th scope="col">Price</th>
							<th scope="col">Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${orders}" var="order">
							<tr style="text-align: center;">
								<td style="text-align: center;">
									<div class="form-check">
										<input type="checkbox" class="select-item checkbox"
											name="select-item">
									</div>
								</td>
								<td>${order.getTimeStamp()}</td>
								<td>${order.getOrderItem()}</td>
								<td>${order.getOrderQty()}</td>
								<td>${order.getOrderPrice()}</td>
								<td><c:if test="${order.getOrderStatus()==0}">
										<a class="btn btn-light btn-sm mx-1 mt-2" data-toggle="modal"
											href="#changeStatus">Ordered</a>
									</c:if> <c:if test="${order.getOrderStatus()!=0}">
										<a class="btn btn-dark btn-sm mx-1 mt-2" data-toggle="modal"
											href="#changeStatus">Delivered</a>
									</c:if></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<table class="table">
				<tr style="text-align: center;">
					<td colspan="3">
						<h5>SubTotal</h5>
					</td>
					<td colspan="3">
						<h5>$ ${subTotal}</h5>
					</td>
				</tr>
				<tr style="text-align: center;">
					<td colspan="3">
						<h5>Tax</h5>
					</td>
					<td colspan="3">
						<h5>$ ${tax}</h5>
					</td>
				</tr>
				<tr style="text-align: center;">
					<td colspan="3">
						<h5>Total</h5>
					</td>
					<td colspan="3">
						<h5>$ ${totalAmount}</h5>
					</td>
				</tr>
			</table>
		</div>
		<div class="controlBar">
			<div class="row">
				<div class="col-6" style="text-align: left;">
					<button type="button" class="btn btn-danger btn-lg"
						data-dismiss="modal">Close Session</button>
				</div>
				<div class="col-6" style="text-align: right; padding-right: 10%;">

					<a class="btn btn-outline-danger btn-lg" href="tableMonitor"
						name="check">Close Window</a>

				</div>
			</div>
		</div>
		<!-- </div> -->
		<footer class="pt-4 my-md-5 pt-md-5 border-top"> </footer>
	</div>


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