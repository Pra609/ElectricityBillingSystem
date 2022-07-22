$(document).ready(
	function() {

		// SUBMIT FORM
		$("#getCustomers").submit(function(event) {
			// Prevent the form from submitting via the browser.
			event.preventDefault();
			ajaxGet();
		});

	});
	
// DO GET
var globleTableData=[]

function decPageNo()
{
	let page=Number($('#customerPageNo').text())
	//console.log(page,'prev')
	if(page!=1)
	page-=1
	pagedata(page);
	$('#customerPageNo').text(page)
}

function incPageNo()
{
	let page=Number($('#customerPageNo').text())
	//console.log(page,'prev')
	pagedata(page+1);
	$('#customerPageNo').text(page+1)
}

function pagedata(pageno){
	let tableData="";
	let startno=(pageno-1)*5
	let endno=(pageno*5)
	data=globleTableData.slice(startno,endno)
	data.forEach(function(item) {
				tableData += '<tr>' +
					'<td id = "Id' + item.id + '">' + item.id + '</td>' +
					'<td id = "Id' + item.id + '">' + item.name + '</td>' +
					'<td id = "Id' + item.id + '">' + item.meter + '</td>' +
					'<td id = "board' + item.id + '">' + item.board+ '</td>' +
					'<td id = "conntype' + item.id + '">' + item.conntype + '</td>' +
					'<td id = "metertype' + item.id + '">' + item.metertype + '</td>' +
					'<td id = "price' + item.id + '">' + item.email + '</td>' +
										'<td id = "price' + item.id + '">' + item.contact + '</td>' +
					
					
					
					'<td>' +
					'<button type = "button" id = "edit' + item.id + '" class = "btn btn-warning btn-md edit">Edit</button>' +
					'</td>' +
					'<td>' +
					'<button type = "button" id = "delet' + item.id + '" class = "btn btn-danger btn-md delet" onclick = "delet(' + item.id + ')">Delete</button>' +
					'</td>' +
					 
				
					
					'</tr>';
			});
			$("#myTable>tbody").html(tableData);
	
}

function ajaxGet() {
    var keyword = $("#keyword").val();
	var tableData = "";
	$.ajax({
		type: "GET",
		url: "/viewcustomers",
		data:{keyword: keyword},
		success: function(data) {
			globleTableData=data
			let page=Number($('#customerPageNo').text())
			console.log(globleTableData,'globleTableData')
			pagedata(page)
//			data.slice(0,5).forEach(function(item) {
//				tableData += '<tr>' +
//					'<td id = "Id' + item.id + '">' + item.id + '</td>' +
//					'<td id = "Id' + item.id + '">' + item.name + '</td>' +
//					'<td id = "Id' + item.id + '">' + item.meter + '</td>' +
//					'<td id = "board' + item.id + '">' + item.board+ '</td>' +
//					'<td id = "conntype' + item.id + '">' + item.conntype + '</td>' +
//					'<td id = "metertype' + item.id + '">' + item.metertype + '</td>' +
//					'<td id = "price' + item.id + '">' + item.email + '</td>' +
//										'<td id = "price' + item.id + '">' + item.contact + '</td>' +
//					
//					
//					
//					'<td>' +
//					'<button type = "button" id = "edit' + item.id + '" class = "btn btn-warning btn-md edit">Edit</button>' +
//					'</td>' +
//					'<td>' +
//					'<button type = "button" id = "delet' + item.id + '" class = "btn btn-danger btn-md delet" onclick = "delet(' + item.id + ')">Delete</button>' +
//					'</td>' +
//					 
//				
//					
//					'</tr>';
//			});
//			$("#myTable>tbody").html(tableData);
		},
		
	});
}
$(document).ready(function() {
	ajaxGet();
})

/* Delete */
function delet(id){
	if (confirm('Do you really want to delete record?')) {
		var parent = $(this).parent().parent();
	
		$.ajax({
			type: "DELETE",
			url: "/deletecustomer/" +id,
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

/* Edit */

$(document).delegate('.edit', 'click', function() {

	var parent = $(this).parent().parent();

	var id = parent.children("td:nth-child(1)");
	var name = parent.children("td:nth-child(2)");
	var meter = parent.children("td:nth-child(3)");
	var board = parent.children("td:nth-child(4)");
	var conntype = parent.children("td:nth-child(5)");
	var metertype = parent.children("td:nth-child(6)");
	var email = parent.children("td:nth-child(7)");
	var contact = parent.children("td:nth-child(8)");
	
	
    var buttons = parent.children("td:nth-child(9)");    

    name.html("<input type='text' id='board' value='" + name.html() + "'/>");
    meter.html("<input type='text' id='board' value='" + meter.html() + "'/>");
    let boarddropdown=`<select id="board" name="board" style="padding: 4px;">

									<option value="Andhra Pradesh">Andhra Pradesh</option>
                                <option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</opt>
                                <option value="Arunachal Pradesh">Arunachal Pradesh</option>
                                <option value="Assam">Assam</option>
                                <option value="Bihar">Bihar</option>
                                <option value="Chandigarh">Chandigarh</option>
                                <option value="Chhattisgarh">Chhattisgarh</option>
                                <option value="Dadar and Nagar Haveli">Dadar and Nagar Haveli</option>
                                <option value="Daman and Diu">Daman and Diu</option>
                                <option value="Delhi">Delhi</option>
                                <option value="Lakshadweep">Lakshadweep</option>
                                <option value="Puducherry">Puducherry</option>
                                <option value="Goa">Goa</option>
                                <option value="Gujarat">Gujarat</option>
                                <option value="Haryana">Haryana</option>
                                <option value="Himachal Pradesh">Himachal Pradesh</option>
                                <option value="Jammu and Kashmir">Jammu and Kashmir</option>
                               <option value="Jharkhand">Jharkhand</option>
                               <option value="Karnataka">Karnataka</option>
                               <option value="Kerala">Kerala</option>
                               <option value="Madhya Pradesh">Madhya Pradesh</option>
                               <option value="Maharashtra">Maharashtra</option>
                               <option value="Manipur">Manipur</option>
                              <option value="Meghalaya">Meghalaya</option>
                               <option value="Mizoram">Mizoram</option>
                              <option value="Nagaland">Nagaland</option>
                               <option value="Odisha">Odisha</option>
                                <option value="Punjab">Punjab</option>
                               <option value="Rajasthan">Rajasthan</option>
                              <option value="Sikkim">Sikkim</option>
                               <option value="Tamil Nadu">Tamil Nadu</option>
                               <option value="Telangana">Telangana</option>
                               <option value="Tripura">Tripura</option>
                               <option value="Uttar Pradesh">Uttar Pradesh</option>
                               <option value="Uttarakhand">Uttarakhand</option>
                               <option value="West Bengal">West Bengal</option>	
	</select>`;
	board.html(boarddropdown);
	let dropdown=`<select id="conntype" name="conntype" style="padding: 4px;">
	
  	<option value="domestic">domestic</option>
  	<option value="commercial">commercial</option>  
	</select>`;
	conntype.html(dropdown);
	let meterdropdown=`<select id="metertype" name="metertype" style="padding: 4px;">
	
                                 <option value = "2Kw">2Kw</option>
                                     <option  value = "3Kw">3Kw</option>
                                      <option  value = "4Kw">4Kw</option>
                                       <option  value = "5Kw">5Kw</option>
	</select>`;
	metertype.html(meterdropdown);
	email.html("<input type='text' id='price' value='"+ email.html() +"'/>");
	contact.html("<input type='text' id='board' value='" + contact.html() + "'/>");
	
	buttons.html("<button id='save' class= 'btn btn-success'>Save</button>");

});

$(document).delegate('#save', 'click', function() {
	var parent = $(this).parent().parent();

	var id = parent.children("td:nth-child(1)");
	var name = parent.children("td:nth-child(2)");
	var meter = parent.children("td:nth-child(3)");
	var board = parent.children("td:nth-child(4)");
	var conntype = parent.children("td:nth-child(5)");
	var metertype = parent.children("td:nth-child(6)");
	var email = parent.children("td:nth-child(7)");
	var contact = parent.children("td:nth-child(8)");
	
	console.log('hello ',conntype.find(":selected").text());
    var buttons = parent.children("td:nth-child(9)");
 
	$.ajax({
		type: "POST",
		contentType: "application/json; charset=utf-8",
		url: "/updatecustomer",
		data: JSON.stringify({
			'id': id.html(), 'name': name.children("input[type=text]").val(),'meter': meter.children("input[type=text]").val(), 'board': board.find(":selected").text(),'conntype': conntype.find(":selected").text(), 
			'metertype': metertype.find(":selected").text(),'email': email.children("input[type=text]").val(),'contact': contact.children("input[type=text]").val(),
		}),
		cache: false,
		success: function() {
			name.html(name.children("input[type = text]").val());
			meter.html(meter.children("input[type = text]").val());
	    	board.html(board.find(":selected").text());
	        conntype.html(conntype.find(":selected").text());
	         metertype.html(metertype.find(":selected").text());
	        email.html(email.children("input[type = text]").val());
	        contact.html(contact.children("input[type = text]").val());
	        
			buttons.html("<button class='btn btn-warning edit' id='" + id.html() + "'>Edit</button>");
		},

	});

});


