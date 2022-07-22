package com.electricity.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electricity.system.entity.Customer;

import com.electricity.system.service.CustomerService;




@Controller
@RequestMapping("/admin")
public class AdminViewController {
	
	
	
	
	@Autowired
	private CustomerService customerService;
	@RequestMapping("/home")
	public String adminHome() {
		return "Admin/adminhome";
	}
	
	@RequestMapping("/rates")
	public String addRates() {
		return "Admin/rate";
	}
	@RequestMapping("/reports")
	public String energyReports() {
		return "Admin/monthly";
	}

	@RequestMapping("/viewrates")
	public String viewAllRates() {
	return "Admin/viewrates";
	}
	
	@RequestMapping("/generatebill")
	public String generateBill() {
	return "Admin/bill";
	}
	
	@GetMapping("/viewcustomers/{page}")
	public String viewCustomersMeter(@PathVariable("page") Integer page,Model model) {
		model.addAttribute("title", "All Customers");
		
		
       Page<Customer> customer=customerService.getAllCustomers(page);
		model.addAttribute("customer", customer);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", customer.getTotalPages());
		return "Admin/customer";
	}
	
	
	@RequestMapping("/generate/{id}")
	public String generateForm(@PathVariable("id") Integer id,Model model) {
	
		
		Customer customer=customerService.getById(id);
		model.addAttribute("customer", customer);
		
		return "Admin/generate";
  }
	@RequestMapping("/customers")
	public String allCustomers() {
	return "Admin/viewcustomer";
	}
	
	@RequestMapping("/search")
	public String searchBook(@Param("keyword") String keyword,Model model) {
		
	   if(keyword==null) {
		   List<Customer> customer=customerService.getAllcustomers();
		   model.addAttribute("customer",customer);
	   }
	   else {
		   List<Customer> customer=customerService.getByKeyword(keyword);
		   model.addAttribute("customer",customer);
	   }
		
		
		
		
		
		return "Admin/customer";
	}
}
