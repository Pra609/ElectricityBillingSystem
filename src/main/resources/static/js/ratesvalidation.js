 var ratesvalidation=false
 function printError(elemId, hintMsg) {
    document.getElementById(elemId).innerHTML = hintMsg;
}

function submitForm(){
	document.getElementById("addRates").submit(); 
}

// Defining a function to validate form 
function validateForm() {
    // Retrieving the values of form elements 
   
    var board=document.addRates.board.value;
    
  	//var role = document.addCustomer.role.value;
  
    var conntype=document.addRates.conntype.value;
    var metertype=document.addRates.metertype.value;
     var price=document.addRates.price.value;
	// Defining error variables with a default value
    var  boardErr =true;
    var connErr=true;
    var metertypeErr=true;
    var priceErr=true;
  
     console.log(board)
      console.log(metertype)
      
    // Validate name
    
    //validate city
     if(board == "Select") {
        printError("boardErr", "Please select your board");
    }  else {
            printError("boardErr", "");
            boardErr = false;
        }
    
    
    if(conntype == "Select") {
        printError("connErr", "Please select your connection type");
    }  else {
            printError("connErr", "");
            connErr = false;
        }
        
        if(metertype == "Select") {
        printError("metertypeErr", "Please select your meter type");
    }  else {
            printError("metertypeErr", "");
            metertypeErr = false;
        }
    
    
    
    
  // validate password
  
    if(price == "") {
        printError("priceErr", "Please enter your price");
    } else {
            printError("priceErr", "");
            priceErr = false;
        }
    
  
  
    
    
    // Prevent the form from being submitted if there are any errors
    if((boardErr||connErr||metertypeErr||priceErr) == true) {
       return false;
    } else {
        // Creating a string from input data for preview
        var dataPreview = "You've entered the following details: \n" +
                          
                           "Board: " + board+ "\n" +
                        
                           "Connection Type: " + conntype + "\n" +
                           "Meter Type: " + metertype + "\n" +
                           "Price: " + price + "\n";
                         
                     
       console.log(dataPreview)
        // Display input data in a dialog box before submitting the form
        
        submitForm()
	   alert(dataPreview);
	  window.location = "/admin/viewrates";
	   ratesvalidation =true;
	   return true;
     
      
    }
    
};

