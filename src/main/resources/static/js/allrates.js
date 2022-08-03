$(document).ready(
	function() {

		// SUBMIT FORM
		$("#getRates").submit(function(event) {
			// Prevent the form from submitting via the browser.
			event.preventDefault();
			ajaxGet();
		});

	});
var globleTableData=[]

function decPageNo()
{
	let page=Number($('#ratePageNo').text())
	//console.log(page,'prev')
	if(page!=1)
	page-=1
	pagedata(page);
	$('#ratePageNo').text(page)
}

function incPageNo()
{
	let page=Number($('#ratePageNo').text())
	//console.log(page,'prev')
	let datalength=globleTableData.length;
	let pagelimit=Math.ceil((datalength/5.0));
	if(page+1>pagelimit)
	{
		console.log('Page limit reached');	
		return;	
	}
	pagedata(page+1);
	$('#ratePageNo').text(page+1)
}
function pagedata(pageno){
	let tableData="";
	let startno=(pageno-1)*5
	let endno=(pageno*5)
	data=globleTableData.slice(startno,endno)
	data.forEach(function(item) {
		tableData += '<tr>' +
					'<td id = "Id' + item.rid + '">' + item.rid + '</td>' +
					'<td id = "board' + item.rid + '">' + item.board+ '</td>' +
					'<td id = "conntype' + item.rid + '">' + item.conntype + '</td>' +
					'<td id = "conntype' + item.rid + '">' + item.metertype + '</td>' +
					'<td id = "price' + item.rid + '">' + item.price + '</td>' +
					
					
					
					'<td>' +
					'<button type = "button" id = "edit' + item.rid + '" class = "btn btn-warning btn-md edit">Edit</button>' +
					'</td>' +
					'<td>' +
					'<button type = "button" id = "delet' + item.rid + '" class = "btn btn-danger btn-md delet" onclick = "delet(' + item.rid + ')">Delete</button>' +
					'</td>' +
					 
				
					
					'</tr>';
			});
			$("#myTable>tbody").html(tableData);		
	
}
	
// DO GET
function ajaxGet() {
    var keyword = $("#keyword").val();
	var tableData = "";
	$.ajax({
		type: "GET",
		url: "/ratelist",
		data:{keyword: keyword},
		success: function(data) {
			globleTableData=data
			let page=Number($('#ratePageNo').text())
			console.log(globleTableData,'globleTableData')
			pagedata(page)
			
			//data.forEach(function(item) {
//				tableData += '<tr>' +
//					'<td id = "Id' + item.rid + '">' + item.rid + '</td>' +
//					'<td id = "board' + item.rid + '">' + item.board+ '</td>' +
//					'<td id = "conntype' + item.rid + '">' + item.conntype + '</td>' +
//					'<td id = "conntype' + item.rid + '">' + item.metertype + '</td>' +
//					'<td id = "price' + item.rid + '">' + item.price + '</td>' +
//					
//					
//					
//					'<td>' +
//					'<button type = "button" id = "edit' + item.rid + '" class = "btn btn-warning btn-md edit">Edit</button>' +
//					'</td>' +
//					'<td>' +
//					'<button type = "button" id = "delet' + item.rid + '" class = "btn btn-danger btn-md delet" onclick = "delet(' + item.rid + ')">Delete</button>' +
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
function delet(rid){
	if (confirm('Do you really want to delete record?')) {
		var parent = $(this).parent().parent();
		
		$.ajax({
			type: "DELETE",
			url: "/deleterate/" +rid,
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

	var rid = parent.children("td:nth-child(1)");
	var board = parent.children("td:nth-child(2)");
	var conntype = parent.children("td:nth-child(3)");
	var metertype = parent.children("td:nth-child(4)");
	var price = parent.children("td:nth-child(5)");
	
	
    var buttons = parent.children("td:nth-child(6)");
    

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
	price.html("<input type='text' id='price' value='"+ price.html() +"'/>");
	
	buttons.html("<button id='save' class= 'btn btn-success'>Save</button>");

});

$(document).delegate('#save', 'click', function() {
	var parent = $(this).parent().parent();

	var rid = parent.children("td:nth-child(1)");
	var board = parent.children("td:nth-child(2)");
	var conntype = parent.children("td:nth-child(3)");
	var metertype = parent.children("td:nth-child(4)");
	var price = parent.children("td:nth-child(5)");
	
	
    var buttons = parent.children("td:nth-child(6)");
 
	$.ajax({
		type: "POST",
		contentType: "application/json; charset=utf-8",
		url: "/updaterate",
		data: JSON.stringify({
			'rid': rid.html(),  'board': board.find(":selected").text(),'conntype': conntype.find(":selected").text(),
			'metertype': metertype.find(":selected").text(),'price': price.children("input[type=text]").val(),
		}),
		cache: false,
		success: function() {
	    board.html(board.find(":selected").text());
	        conntype.html(conntype.find(":selected").text());
	         metertype.html(metertype.find(":selected").text());
	        price.html(price.children("input[type = text]").val());
	        
			buttons.html("<button class='btn btn-warning edit' id='" + rid.html() + "'>Edit</button>");
		},

	});

});
