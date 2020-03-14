var quantityUpdate = 0;
$(document).ready(function () {
	console.log("IN THE METHOD");
    $('.addToOrderBtn').click(function () {
		console.log("IN THE METHOD2");
		$.ajax({
				type: "POST",
				url: "order",
				datatype : 'text',
				data: {
					itemId : $(this).attr('data-itemId'),
					itemQuantity : $("#intTextBox").val()
					// tableId = $(this).attr('data-tableId')
					
			},
			success: function(responseData){
				alert(responseData + " successfully added!");
				$("#quantityupdate").text(quantityUpdate = quantityUpdate+1);
			}
			


		});
    });
});
