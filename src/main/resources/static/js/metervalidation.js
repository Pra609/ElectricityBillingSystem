$(document).ready(function() {
			$("#addCustomer").on("input", function(e) {
				$('#msg').hide();
				if ($('#meter').val() == null || $('#meter').val() == "") {
					$('#msg').show();
					$("#msg").html("Meter is a required field.").css("color", "red");
				} else {
					$.ajax({
						type: 'post',
						url: "/customers/meter",
						data: JSON.stringify({meter: $('#meter').val()}),
						contentType: 'application/json; charset=utf-8',
						//dataType: 'html',
						cache: false,
						beforeSend: function (f) {
							$('#msg').show();
							$('#msg').html('Checking...');
						},
						statusCode: {
						    500: function(xhr) {
						    	$('#msg').show();
						    	$("#msg").html("meter available").css("color", "green");
						    }
						},
						success: function(msg) {
							$('#msg').show();
							if(msg !== null || msg !== "") {
								$("#msg").html("Meter already taken").css("color", "red");
							} else {
								$("#msg").html("Meter available").css("color", "green");
							}
						},
						error: function(jqXHR, textStatus, errorThrown) {
							$('#msg').show();
							$("#msg").html(textStatus + " " + errorThrown).css("color", "red");
						}
					});
					}
			});
		});