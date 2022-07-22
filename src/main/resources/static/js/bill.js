$(document).ready(
	function() {

		// SUBMIT FORM
		$("#getBills").submit(function(event) {
			// Prevent the form from submitting via the browser.
			event.preventDefault();
			ajaxGet();
		});

	});
var globleTableData=[]

function decPageNo()
{
	let page=Number($('#billPageNo').text())
	//console.log(page,'prev')
	if(page!=1)
	page-=1
	pagedata(page);
	$('#billPageNo').text(page)
}

function incPageNo()
{
	let page=Number($('#billPageNo').text())
	//console.log(page,'prev')
	pagedata(page+1);
	$('#billPageNo').text(page+1)
}

function pagedata(pageno){
	let tableData="";
	let startno=(pageno-1)*5
	let endno=(pageno*5)
	data=globleTableData.slice(startno,endno)
	data.forEach(function(item) {
		tableData += '<tr>' +
					'<td id = "Id' + item.billid + '">' + item.billid + '</td>' +
					'<td id = "name' + item.billid + '">' + item.name+ '</td>' +
					'<td id = "meter' + item.billid + '">' + item.meter+ '</td>' +
                    '<td id = "metertype' + item.billid + '">' + item.metertype+ '</td>' +
					'<td id = "board' + item.billid + '">' + item.board+ '</td>' +
					'<td id = "bconntype' + item.billid + '">' + item.bconntype + '</td>' +
					'<td id = "energy' + item.billid + '">' + item.energy + '</td>' +
					'<td id = "date' + item.billid + '">' + item.date + '</td>' +
					'<td id = "price' + item.billid + '">' + item.price + '</td>' +
					'<td id = "status' + item.billid + '">' + item.status + '</td>' +
					
					
					
					
					'<td>' +
					'<button type = "button" id = "edit' + item.billid + '" class = "btn btn-warning btn-md edit">Edit</button>' +
					'</td>' +
					'<td>' +
					'<button type = "button" id = "delet' + item.billid + '" class = "btn btn-danger btn-md delet" onclick = "delet(' + item.billid + ')">Pay Now</button>' +
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
		url: "/viewbills",
		data:{keyword: keyword},
		success: function(data) {
		globleTableData=data
			let page=Number($('#billPageNo').text())
			console.log(globleTableData,'globleTableData')
			pagedata(page)
//			data.forEach(function(item) {
//				tableData += '<tr>' +
//					'<td id = "Id' + item.billid + '">' + item.billid + '</td>' +
//					'<td id = "name' + item.billid + '">' + item.name+ '</td>' +
//					'<td id = "meter' + item.billid + '">' + item.meter+ '</td>' +
//                    '<td id = "metertype' + item.billid + '">' + item.metertype+ '</td>' +
//					'<td id = "board' + item.billid + '">' + item.board+ '</td>' +
//					'<td id = "bconntype' + item.billid + '">' + item.bconntype + '</td>' +
//					'<td id = "energy' + item.billid + '">' + item.energy + '</td>' +
//					'<td id = "date' + item.billid + '">' + item.date + '</td>' +
//					'<td id = "price' + item.billid + '">' + item.price + '</td>' +
//					'<td id = "status' + item.billid + '">' + item.status + '</td>' +
//					
//					
//					
//					
//					'<td>' +
//					'<button type = "button" id = "edit' + item.billid + '" class = "btn btn-warning btn-md edit">Edit</button>' +
//					'</td>' +
//					'<td>' +
//					'<button type = "button" id = "delet' + item.billid + '" class = "btn btn-danger btn-md delet" onclick = "delet(' + item.billid + ')">Pay Now</button>' +
//					'</td>' +
//					
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
function delet(billid){
	if (confirm('Do you really want to pay the bill?')) {
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

/*edit*/
$(document).delegate('.edit', 'click', function() {

	var parent = $(this).parent().parent();

	var billid = parent.children("td:nth-child(1)");
	var name = parent.children("td:nth-child(2)");
	var meter= parent.children("td:nth-child(3)");
	var metertype= parent.children("td:nth-child(4)");
	var board = parent.children("td:nth-child(5)");
	var bconntype = parent.children("td:nth-child(6)");
	var energy = parent.children("td:nth-child(7)");
	var date= parent.children("td:nth-child(8)");
	var price = parent.children("td:nth-child(9)");
	var status = parent.children("td:nth-child(10)");
	
    var buttons = parent.children("td:nth-child(11)");
    



	energy.html("<input type='text' id='energy' value='" + energy.html() + "'/>");
	date.html("<input type='date' id='date' value='" + date.html() + "'/>");
	
	
	buttons.html("<button id='save' class= 'btn btn-success'>Save</button>");

});

$(document).delegate('#save', 'click', function() {
	var parent = $(this).parent().parent();

	
	var billid = parent.children("td:nth-child(1)");
	var name = parent.children("td:nth-child(2)");
	var meter= parent.children("td:nth-child(3)");
	var metertype= parent.children("td:nth-child(4)");
	var board = parent.children("td:nth-child(5)");
	var bconntype = parent.children("td:nth-child(6)");
	var energy = parent.children("td:nth-child(7)");
	var date= parent.children("td:nth-child(8)");
	var price = parent.children("td:nth-child(9)");
	var status = parent.children("td:nth-child(10)");
	
    var buttons = parent.children("td:nth-child(11)");
    
    
 
	$.ajax({
		type: "POST",
		contentType: "application/json; charset=utf-8",
		url: "/updatebill",
		data: JSON.stringify({
			'billid': billid.html(), 'name': name.html(),'meter': meter.html(),'metertype': metertype.html(),'board': board.html(), 'bconntype': bconntype.html(), 
			'energy': energy.children("input[type=text]").val(),'date': date.children("input[type=date]").val(),
			'price': price.html(),'status': status.html(),
			
		}),
		cache: false,
		success: function() {
	    	
	       energy.html(energy.children("input[type = text]").val());
	       date.html(date.children("input[type = date]").val());
	       
			buttons.html("<button class='btn btn-warning edit' id='" + billid.html() + "'>Edit</button>");
		},

	});

});
