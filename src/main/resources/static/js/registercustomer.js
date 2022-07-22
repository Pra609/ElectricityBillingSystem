
$(document).ready(
		function() {

			// SUBMIT FORM
			$("#addCustomer").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				//if noerror
				if(validated)
				{
					console.log('post call happened')
					ajaxPost();					
				}			
			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					name : $("#name").val(),
					meter : $("#meter").val(),
					board : $("#board").val(),
					contact : $("#contact").val(),
					conntype : $("#conntype").val(),
					metertype : $("#metertype").val(),
					email : $("#email").val(),
					password : $("#password").val(),
					
					
					
				}
				
				
				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "customers",
					data : JSON.stringify(formData),
					dataType : 'json',
					encode: true,
					})
					.done(function(data){
		        			console.log(data);
		        			alert("you are successfully submitted");
					 });
				   
			
			     
				}
		
					
				});
