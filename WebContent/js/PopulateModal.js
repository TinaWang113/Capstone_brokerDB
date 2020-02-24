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

$(document).ready(function () {
    $('.deleteStaffBtn').click(function () {
		var id = $(this).attr('data-id');
		console.log(id)
		$("#deletebtnConfirm").val(id);
		
    });
});