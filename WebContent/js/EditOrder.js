//This will be for editing the order

$(document).ready(function () {
    $('.editingOrderBtn').click(function () {
			if (($(this).parent().find("input").val()) < 0) {
				$(this).parent().find("input").val("");
				return;
			}
			$.ajax({
					type: "POST",
					url: "order",
					datatype : 'text',
					data: {
						itemQuantity : $(this).parent().find("input").val(),
						action : $("#editingOrderBtn").val(),
						itemIndex : $(this).attr('data-itemIndex')
						
				},
				success: function(responseData){
					$("#quantityupdate").text(responseData);
						
					setTimeout(function() {
  						$("#infoModal").modal('hide');
					}, 500);
				}
			});
		$(this).parent().find("input").val("");
		});
});




//Up arrow function
$(document).ready(function () {
	$('.upArrow').click( function () {
		
	    var value = $(this).parent().find("input").val()
			value = isNaN(value) ? 0 : value;
			value = value <= 0 ? 0 : value
	    value++;
	    $(this).parent().find("input").val(value);
	});
});
//Down arrow function
$(document).ready(function () {
	$('.downArrow').click( function () {
		
	    var value = $(this).parent().find("input").val()
			value = isNaN(value) ? 0 : value;			
			value--;
			value = value < 1 ? 0 : value
	    $(this).parent().find("input").val(value)
	});
});