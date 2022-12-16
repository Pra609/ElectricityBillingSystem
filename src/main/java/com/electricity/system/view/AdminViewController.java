package com.electricity.system.view;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electricity.system.entity.Customer;
import com.electricity.system.repo.CustomerRepo;
import com.electricity.system.service.CustomerService;




@Controller
@RequestMapping("/admin")
public class AdminViewController {
	
	
	
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerRepo customerRepo;
	
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
		
		Pageable pageable = PageRequest.of(page, 5);
       Page<Customer> customer=customerService.getAllCustomers(pageable);
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
	
	@RequestMapping("/search/{page}")
	public String search(@PathVariable("page") Integer page,String keyword,Model model) {
		
	 if(keyword==null) {
		  Pageable pageable = PageRequest.of(page, 5);
		   Page<Customer> customer=customerService.getAllCustomers(pageable);
		  // Page<Customer> customer=customerService
		  // List<Customer> customer=customerService.getAllcustomers();
		   model.addAttribute("customer", customer);
		  // model.addAttribute("customer",customer);
		 // model.addAttribute("totalPages", customer.getTotalPages());
	   }
	   else {
		   //List<Customer> customer=customerService.getByKeyword(keyword);
		    Pageable pageable = PageRequest.of(page, 5);
		    Page<Customer> customer=customerRepo.getcustomerByKeywordandPage(keyword, pageable);
		   //Page<Customer> customer=customerService.getAllCustomersbykeyword(keyword, page);
			model.addAttribute("currentPage", page);
		   model.addAttribute("customer", customer);
		   //model.addAttribute("customer",customer);
		   model.addAttribute("totalPages", customer.getTotalPages());
		   model.addAttribute("keyword", keyword);
	   }
		
		
		
		
		
		return "Admin/customer";
	}
}
