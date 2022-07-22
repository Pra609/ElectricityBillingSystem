$(document).ready(
	function() {

		// SUBMIT FORM
		$("#getPays").submit(function(event) {
			// Prevent the form from submitting via the browser.
			event.preventDefault();
			ajaxGet();
		});

	});
	
// DO GET
function ajaxGet() {
    //var keyword= $("#keyword").val();
	var tableData = "";
	$.ajax({
		type: "GET",
		url: "/billsview",
		
		//data:{keyword: keyword},
		success: function(data) {
			
			data.forEach(function(item) {
				tableData += '<tr>' +
					'<td id = "Id' + item.billid + '">' + item.billid + '</td>' +
					'<td id = "meter' + item.billid + '">' + item.name+ '</td>' +
					'<td id = "meter' + item.billid + '">' + item.meter+ '</td>' +
					'<td id = "board' + item.billid + '">' + item.board+ '</td>' +
					'<td id = "bconntype' + item.billid + '">' + item.bconntype + '</td>' +
					'<td id = "energy' + item.billid + '">' + item.energy + '</td>' +
					'<td id = "date' + item.billid + '">' + item.date + '</td>' +
					'<td id = "price' + item.billid + '">' + item.price + '</td>' +
					'<td id = "status' + item.billid + '">' + item.status + '</td>' +
					
					
					
					
					 '<td>' +
					'<button type = "button" id = "delet' + item.billid + '" class = "btn btn-danger btn-md delet" onclick = "delet(' + item.billid + ')">Pay Now</button>' +
					'</td>' +
				
					
					'</tr>';
			});
			$("#myTable>tbody").html(tableData);
		},
		
	});
}
$(document).ready(function() {
	ajaxGet();
})

/* Delete */
function delet(billid){
	if (confirm('Do you really want to pay now?')) {
		var parent = $(this).parent().parent();
		
		$.ajax({
			type: "DELETE",
			url: "/deletebill/" +billid,
			cache: false,
			success: function() {
				parent.fadeOut('slow', function() {
					$(this).remove();
				});
				location.reload(true)
			},
			error: function() {
				$('#err').html('<span style=\'color:red; font-weight: bold; font-size: 30px;\'>Error deleting record').fadeIn().fadeOut(4000, function() {
					$(this).remove();
				});
			}
		});
	}
};