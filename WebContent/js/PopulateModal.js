//populates the staff edit modal
$(document).ready(function () {
    $('.editStaffBtn').click(function () {
		var jobName = $(this).attr('data-jobName');
		var fName = $(this).attr('data-fName');
		var lName = $(this).attr('data-lName');
		var pin = $(this).attr('data-pin');
		var contactNum = $(this).attr('data-contactNum');
		var id = $(this).attr('id').toString();

		$("#jobName").val(jobName);
		$("#fName").val(fName);
		$("#lName").val(lName);
		$("#pin").val(pin);
		$("#contactNum").val(contactNum);
		$("#editbtnConfirm").val(id);
		
    });
});

//populates the delete modal confirm button with the id
//for the staff delete
$(document).ready(function () {
    $('.deleteStaffBtn').click(function () {
		var id = $(this).attr('data-id');
		console.log(id)
		$("#deletebtnConfirm").val(id);
		
    });
});

//populates item more info modal
$(document).ready(function () {
    $('.moreInforBtn').click(function () {
		var itemName = $(this).attr('data-itemName');
		var itemDescription = $(this).attr('data-itemDescription');
		var itemPrice = $(this).attr('data-itemPrice');

		$("#infoModalLongTitle").text(itemName);
		$("#itemDesc").text(itemDescription);
		$("#itemPrice").val(itemPrice);
		
    });
});
