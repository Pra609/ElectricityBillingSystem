package com.electricity.system.controller;



import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.electricity.system.config.CustomUserDetails;
import com.electricity.system.entity.Bill;
import com.electricity.system.entity.Customer;
import com.electricity.system.service.BillService;
import com.electricity.system.service.CustomerService;




@RestController

public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BillService billService;

	@RequestMapping(method=RequestMethod.POST,value = "/customers")
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
	
		try {
			
		
			 customer.setRole("ROLE_USER");
				customerService.saveCustomer(customer);
				
		}catch (Exception e) {
			
		}
		return new ResponseEntity<>("Customer created successsfully", HttpStatus.CREATED);
		
	}
	@RequestMapping(method=RequestMethod.POST,value = "/customers/meter")
	public Customer byMeter (@RequestBody Customer customer,int meter) {
	
		return customerService.getByMeter(meter);
		
	}
	
	
	@GetMapping("/viewpayments")
	public List<Bill> viewCustomersMeter(int meter) {
	return billService.getBillsByMeter(meter);
	}
	
	@GetMapping("/billsview")
	public List<Bill> getbills(  Authentication principal){
		
		
		
		
		CustomUserDetails customerDetails=(CustomUserDetails)principal.getPrincipal();
		
	   int meter=customerDetails.getMeter();
	   System.out.println(meter);
	  
			List<Bill> allBills =billService.getBillsByMeter(meter);
				return allBills;
			
	  
		
		
		
	}
	
	
	
	
	
}
