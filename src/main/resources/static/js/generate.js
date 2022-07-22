$(document).ready(
		function() {

			// SUBMIT FORM
			$("#addBills").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					name:$("#name").val(),
					meter:$("#meter").val(),
					metertype : $("#metertype").val(),
					board : $("#board").val(),
					
					bconntype : $("#bconntype").val(),
					
					energy: $("#energy").val(),
			        date:$("#date").val(),
					
					
					
				}
				
				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/addbill",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(data)
				 {
				   console.log(data)
		        	if (data != null) 
					{
						
						 alert("You are successfully registered");
                   		 window.location = "/admin/generatebill";
					}
					else 
					{
						 alert("something went wrong");
                   		 window.location = "/admin/generatebill";
						
					}
					},
		
				
				});

			}

		})
