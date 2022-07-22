package com.electricity.system.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.electricity.system.entity.Bill;
import com.electricity.system.entity.Consumption;
import com.electricity.system.entity.Customer;
import com.electricity.system.entity.Rate;
import com.electricity.system.service.BillService;
import com.electricity.system.service.ConsumptionService;
import com.electricity.system.service.CustomerService;
import com.electricity.system.service.RateService;




@RestController
public class AdminRestController {
	
	@Autowired
	private RateService rateService;
	
	@Autowired
	private BillService billService;
	
	@Autowired
	private CustomerService customerService;
	
	
	@Autowired
	private ConsumptionService cService;
	
	@RequestMapping(method=RequestMethod.POST,value = "/addrates")
	public void addRates(@RequestBody Rate rate) {
		rateService.saveRates(rate);
	}
	@RequestMapping(method=RequestMethod.POST, value="/updaterate")
	public Rate updateRate(@RequestBody Rate rate) {	
		
		return rateService.updateRates(rate);
	
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE,value="/deleterate/{rid}")
	public void deleteRates(@PathVariable int rid) {
		rateService.deleteRate(rid);
	}
	
	
	@GetMapping("/ratelist")
	private List<Rate> getRates(@RequestParam String keyword) {
		if(keyword == null) {		
		
     		List<Rate> allRates=rateService.getAllRates();
     		return allRates;
		}else {	
     	
			List<Rate> allRates=rateService.getRate(keyword);
			return allRates;
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value = "/addbill")
	public void addBills(@RequestBody Bill bill) {
		
		int m=bill.getMeter();
		System.out.println(m);
		billService.saveBill(bill);
	}

//	@GetMapping("/setbill/{keyword}")
//	public List<Bill> getBill(@PathVariable String keyword) {
//		if(keyword == null) {		
//		
//     		List<Bill> allBills=billService.generateBills();
//     		return allBills;
//		}else {	
//     	    	List<Bill> allBill=billService.billByKeyword(keyword);
//     	    	
//			return allBill;
//		}
//	}
//	@GetMapping("/billlist")
//	private List<Bill> getBills(@RequestParam String keyword) {
//		if(keyword == null) {		
//		
//     		
//     		List<Bill> allBills=billService.generateBills();
//     		return allBills;
//		}else {	
//     	
//			
//			
//			List<Bill> allBills=billService.billByKeyword(keyword);
//			return allBills;
//		}
//	}
	
	@GetMapping("/viewbills")
	public List<Bill> viewAllBills(@RequestParam String keyword) {
		
		if(keyword==null) {
		List<Bill> allBills =billService.generateBills();
			return allBills;
		}
		else{
			List<Bill> allBills=billService.billByKeyword(keyword);
			return  allBills;
		}
	
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/deletebill/{billid}")
	public void deleteBills(@PathVariable int billid) {
		billService.deleteBill(billid);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/updatebill")
	public void updateBill(@RequestBody Bill bill) {	
		
	billService.saveBill(bill);
		
	}
	
	@GetMapping("/viewcustomers")
	public List<Customer> viewAllustomers(@RequestParam String keyword) {
		
		if(keyword==null) {
	
		
		List<Customer> customers=customerService.getAllcustomers();
			return customers;
		}
		else{
			
			List<Customer> customers=customerService.getByKeyword(keyword);
			return  customers;
			
			
		}
		
	
		
	}
//	
//	@GetMapping("/viewcustomersbypage")
//	public List<Customer> viewAllustomersbypage(@RequestParam String keyword,int pageno) {
//		
//		int PageNo;
//		if(pageno==0 )
//			PageNo=0;
//		else
//			PageNo=pageno;
//		if(keyword==null) {
//	
//		
//		List<Customer> customers=customerService.getAllCustomers();
//			return customers;
//		}
//		else{
//			
//			List<Customer> customers=customerService.getByKeyword(keyword);
//			return  customers;
//			
//			
//		}
		
		
	
		
	//}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/deletecustomer/{id}")
	public void deleteCustomer(@PathVariable int id) {
		 
		  customerService.deleteCustomer(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/updatecustomer")
	public void updateCustomer(@RequestBody Customer customer) {	
		 customerService.updateCustomer(customer);
		
	
	}
	
	@GetMapping("/viewenergy")
	public List<Consumption> viewAllEnergy( String keyword) {
		
	if(keyword==null) {
		List<Consumption> c= cService.showEnergyConsumption();
		return c;
	}
	else {
		List<Consumption> c=cService.showEnergyConsumptionByKeyword(keyword);
		return c;
	}
	
	
	
		
	}
  
}
