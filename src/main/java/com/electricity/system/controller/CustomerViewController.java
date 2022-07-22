package com.electricity.system.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/user")
public class CustomerViewController {
	
	
	
	@RequestMapping("/home")
	public String customerHome() {
		return  "Customer/customerhome";
	}
	
	@RequestMapping("/pay")
	public String customerPay() {
		return  "Customer/pay";
	}
	@RequestMapping("/viewbill")
	public String customerBill() {
		return  "Customer/viewbill";
	}
	
}
