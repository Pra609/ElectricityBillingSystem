/**
 * 
 */
 var validated=false
 function printError(elemId, hintMsg) {
    document.getElementById(elemId).innerHTML = hintMsg;
}

function submitForm(){
	document.getElementById("addCustomer").submit(); 
	console.log("this frame");
}

// Defining a function to validate form 
function validateForm() {
    // Retrieving the values of form elements 
    var name = document.addCustomer.name.value;
    var board=document.addCustomer.board.value;
    var meter=document.addCustomer.meter.value;
    var email = document.addCustomer.email.value;
    var password = document.addCustomer.password.value;
  	//var role = document.addCustomer.role.value;
  	var contact = document.addCustomer.contact.value;
    var conntype=document.addCustomer.conntype.value;
    var metertype=document.addCustomer.metertype.value;
	// Defining error variables with a default value
    var nameErr =true;
    var meterErr=true;
    var emailErr = true;
    var contactErr = true;
    var passwordErr = true;
    var boardErr =true;
    var connErr=true;
    var metertypeErr=true;
    console.log(name)
     console.log(board)
      console.log(meter)
       console.log(email)
        console.log(password)
    // Validate name
    if(name == "") {
        printError("nameErr", "Please enter your name");
    } else {
        var regex = /^[a-zA-Z\s]+$/;                
        if(regex.test(name) === false) {
            printError("nameErr", "Please enter a valid name");
        } else {
            printError("nameErr", "");
            nameErr = false;
        }
    }
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
    
    //validate meter
     if (meter== "") {
        printError("meterErr", "Please enter your meter no.");
    } else {
        var regex =/^[0-9]*$/;                
        if(regex.test(meter) === false) {
            printError("meterErr", "Please enter a valid meter no.");
        } else {
            printError("meterErr", "");
            meterErr = false;
        }
    }
    
    // Validate email address
    if(email == "") {
        printError("emailErr", "Please enter your email address");
    } else {
        // Regular expression for basic email validation
        var regex = /^\S+@\S+\.\S+$/;
        if(regex.test(email) === false) {
            printError("emailErr", "Please enter a valid email address");
        } else{
            printError("emailErr", "");
            emailErr = false;
        }
    }
    
    // Validate contact number
    if(contact == "") {
        printError("contactErr", "Please enter your contact number");
    } else {
        var regex = /^[1-9]\d{9}$/;
        if(regex.test(contact) === false) {
            printError("contactErr", "Please enter a valid 10 digit contact number");
        } else{
            printError("contactErr", "");
            contactErr = false;
        }
    }
    
//    // Validate role
//    if(role == "Select") {
//        printError("roleErr", "Please select your role");
//    } else {
//        printError("roleErr", "");
//        roleErr = false;
//    }
  
  // validate password
  
    if(password == "") {
        printError("passwordErr", "Please enter your password");
    } else {
        var regex = /^[a-zA-Z1-9\s]+$/;                
        if(regex.test(password) === false) {
            printError("passwordErr", "Please enter a valid password");
        } else {
            printError("passwordErr", "");
            passwordErr = false;
        }
    }
  
  
    
    
    // Prevent the form from being submitted if there are any errors
    if((nameErr || emailErr|| meterErr || contactErr || passwordErr||boardErr||connErr||metertypeErr) == true) {
       console.log(nameErr)       
       return false;
    } else {
        // Creating a string from input data for preview
        var dataPreview = "You've entered the following details: \n" +
                          " Name: " + name + "\n" +
                           "Board: " + board+ "\n" +
                           "Meter: " + meter + "\n" +
                           "Connection Type: " + conntype + "\n" +
                           "Meter Type: " + metertype + "\n" +
                          "Email Address: " + email + "\n" +
                          "Contact Number: " + contact + "\n" ;
                         
             
       console.log(dataPreview)
        // Display input data in a dialog box before submitting the form
     
	   submitForm()
	   alert(dataPreview);
	   window.location = "/signin";
	   validated =true;
	   return true;
      
    }
    
};


