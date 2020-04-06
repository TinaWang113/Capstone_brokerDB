//This will be for editing the order
$(document).ready(function () {
    $('.editItemBtn').click(function () {
    	
		var quantity = $(this).attr('data-qty');
		var itemName = $(this).attr('data-itemName');
		var itemIndex = $(this).attr('data-itemIndex');
		

		$("#quantity").val(quantity);
		$("#itemName").text(itemName);
		$("#editingOrderBtn").attr('data-itemIndex', itemIndex);
		$("#deleteOrderBtn").attr('data-itemIndex', itemIndex);
		
    });
});

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
					setTimeout(function() {
  						$("#editItemModal").modal('hide');
  						$("#order").load(location.href + " #order>*");
					}, 500);
				}
			});
		});
});

$(document).ready(function () {
    $('.deleteOrderBtn').click(function () {
			if (($(this).parent().find("input").val()) < 0) {
				$(this).parent().find("input").val("");
				return;
			}
			$.ajax({
					type: "POST",
					url: "order",
					datatype : 'text',
					data: {
						action : $("#deleteOrderBtn").val(),
						itemIndex : $(this).attr('data-itemIndex')
						
				},
				success: function(responseData){
					setTimeout(function() {
  						$("#editItemModal").modal('hide');
  						$("#order").load(location.href + " #order>*");
					}, 500);
					
				}
			});
		});
});



//Up arrow function
$(document).ready(function () {
	$('.editOrderupArrow').click( function () {
		
	    var value = $(this).parent().find("input").val()
			value = isNaN(value) ? 0 : value;
			value = value <= 0 ? 0 : value
	    value++;
	    $(this).parent().find("input").val(value);
	});
});
//Down arrow function
$(document).ready(function () {
	$('.editOrderdownArrow').click( function () {
		
	    var value = $(this).parent().find("input").val()
			value = isNaN(value) ? 0 : value;			
			value--;
			value = value < 1 ? 0 : value
	    $(this).parent().find("input").val(value)
	});
});