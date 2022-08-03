$(document).ready(
	function() {

		// SUBMIT FORM
		$("#getEnergy").submit(function(event) {
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
	let datalength=globleTableData.length;
	let pagelimit=Math.ceil((datalength/5.0));
	if(page+1>pagelimit)
	{
		console.log('Page limit reached');	
		return;	
	}
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
					
					'<td id = "month' + item.id + '">' + item.month + '</td>' +
					'<td id = "energy' + item.id + '">' + item.energy+ '</td>' +
					
				
				
				
					
					'</tr>';
			});
			$("#myTable>tbody").html(tableData);
	
}

function ajaxGet() {
    var keyword = $("#keyword").val();
	var tableData = "";
	$.ajax({
		type: "GET",
		url: "/viewenergy",
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