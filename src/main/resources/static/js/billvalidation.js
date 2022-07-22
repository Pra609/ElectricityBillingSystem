
 function printError(elemId, hintMsg) {
    document.getElementById(elemId).innerHTML = hintMsg;
}

function submitForm(){
	document.getElementById("addBills").submit(); 
}

// Defining a function to validate form 
function validateForm() {
    // Retrieving the values of form elements 
   
    var energy=document.addBills.energy.value;
    
  	//var role = document.addCustomer.role.value;
  
    var date=document.addBills.date.value;
    
    var  energyErr =dateErr=true;
  
     console.log(energy)
      console.log(date)
      
    // Validate name
    
    //validate city
     if(energy == "") {
        printError("energyErr", "Please  enter a energy");
    }  else {
            printError("energyErr", "");
            energyErr = false;
        }
    
    
    
    
    
    
  // validate password
  
    if(date == "") {
        printError("dateErr", "Please enter date");
    } else {
            printError("dateErr", "");
            dateErr = false;
        }
    
  
  
    
    
    // Prevent the form from being submitted if there are any errors
    if((energyErr||dateErr) == true) {
       return false;
    } else {
        // Creating a string from input data for preview
        var dataPreview = "You've entered the following details: \n" +
                          
                           "Energy: " + energy+ "\n" +
                        
                           "Date: " + date + "\n" ;
                       
                         
                     
       console.log(dataPreview)
        // Display input data in a dialog box before submitting the form
       if(dataPreview!=null){
	   alert(dataPreview);
	    window.location = "/admin/generatebill";
       }else{
	     alert("something went wrong");
	     window.location = "/admin/generatebill";
       }
       
      
    }
    
};

