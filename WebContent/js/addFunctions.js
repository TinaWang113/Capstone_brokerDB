//this method is for sending the items to the servlet

//without reloading the webpage
//this will also return the amount of items ordered for the badge 

var count = 0;
$(document).ready(function () {
    $('.addToOrderBtn').click(function () {
			if (($(this).parent().find("input").val()) < 0) {
				$(this).parent().find("input").val("");
				return;
			}
			$.ajax({
					type: "POST",
					url: "order",
					datatype : 'text',
					data: {
						itemId : $(this).attr('data-itemId'),
						itemQuantity : $(this).parent().find("input").val(),
						action : $("#addToOrderBtn").val(),
						
						
				},
				success: function(responseData){
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
