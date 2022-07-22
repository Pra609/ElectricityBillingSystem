 $(document).ready(
		function() {

			// SUBMIT FORM
			$("#addRates").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				
				//if noerror
				if(ratesvalidation)
				{
					console.log('post call happened')
					ajaxPost();					
				}
				
			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					
					board : $("#board").val(),
					
					conntype : $("#conntype").val(),
					metertype : $("#metertype").val(),
					price: $("#price").val(),
			
					
					
					
				}
				
				
				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/addrates",
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
