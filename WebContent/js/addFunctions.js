//this method is for sending the items to the servlet
//without reloading the webpage
//this will also return the amount of items ordered for the badge 
$(document).ready(function () {
    $('.addToOrderBtn').click(function () {
		$.ajax({
				type: "POST",
				url: "order",
				datatype : 'text',
				data: {
					itemId : $(this).attr('data-itemId'),
					itemQuantity : $(this).parent().find("input").val(),
					action : $("#addToOrderBtn").val()
					
			},
			success: function(responseData){
				$("#quantityupdate").text(responseData);
				
			}
			


		});
		$(this).parent().find("input").val("")
		});
});

$(document).ready(function () {
	$('.upArrow').click( function () {
		
	    var value = $(this).parent().find("input").val()
			value = isNaN(value) ? 0 : value;
			value = value <= 0 ? 0 : value
	    value++;
	    $(this).parent().find("input").val(value);
	});
});

$(document).ready(function () {
	$('.downArrow').click( function () {
		
	    var value = $(this).parent().find("input").val()
			value = isNaN(value) ? 0 : value;
			value = value < 1 ? 0 : value
	    value--;
	    $(this).parent().find("input").val(value)
	});
});

