$(document).ready(function () {
    $('.helpBtn').click(function () {
		$.ajax({
				type: "POST",
				url: "help",
				datatype : 'text',
				data: {
					action : $(this).attr('data-choice')
			},
			success: function(responseData){
				if (responseData == 'help'){
					$("#helpModal").modal("show")
				}
				else if (responseData == 'cancel'){
					$("#helpText").text('Cancelled! Staff are not coming!')
					setTimeout(function() {
  						$("#helpModal").modal('hide');
					}, 1500);
					
				}	
			}
		});
		$("#helpText").text('We are on our way to assist you! Please be patient!')
	});
});