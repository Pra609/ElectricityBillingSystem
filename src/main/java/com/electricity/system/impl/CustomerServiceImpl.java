package com.electricity.system.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.electricity.system.entity.Customer;
import com.electricity.system.repo.BillRepo;
import com.electricity.system.repo.CustomerRepo;
import com.electricity.system.service.CustomerService;



@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//	
	@Autowired
	private BillRepo billRepo;
	@Override
	public void saveCustomer(Customer customer) {
		//String encodedPassword = passwordEncoder.encode(customer.getPassword());
		  // customer.setPassword(encodedPassword);
	      customerRepo.save(customer);
	   
	     
	    
	}

	@Override
	public Customer getByMeter(int meter) {
		Customer customer=customerRepo.getUserByMeter(meter);
	    return customer;
	}

	@Override
	public List<Customer> customer() {
	return customerRepo.findAll();
	}

	@Override
	public Customer getById(int id) {
		return customerRepo.getById(id);
	}

	@Override
	public Page<Customer> getAllCustomers(Integer page) {
		 Pageable pageable = PageRequest.of(page, 5);
		return customerRepo.findAll(pageable);
	}

	
	
	@Override
	public List<Customer> getByKeyword(String keyword) {
	return customerRepo.getcustomerByKeyword(keyword);
	}

	@Override
	public void deleteCustomer(int id) {
		Customer customer=customerRepo.getById(id);
		int m=customer.getMeter();
		System.out.println(m);
		//List<Bill> b1=billRepo.getBillByMeter(m);
		//System.out.println(b1);
		
	   customerRepo.deleteById(id);
	   billRepo.deleteBillsBYMeter(m);
	   
	}

	@Override
	public void updateCustomer(Customer customer) {
		int id=customer.getId();
		int m=customer.getMeter();
		//List<Bill> b1=billRepo.getBillByMeter(m);
		Customer cus=customerRepo.getById(id);
		String role=cus.getRole();
		String pass=cus.getPassword();
		customer.setRole(role);
		customer.setPassword(pass);
		customerRepo.save(customer);
		
		/*int meter=customer.getMeter();
		String board=customer.getBoard();
		String conntype=customer.getConntype();
		
		
	    System.out.println(bill);
		bill.setMeter(meter);
		bill.setBoard(board);
		bill.setBconntype(conntype);
		billRepo.save(bill);*/
		
		
		
		
		
	}

	@Override
	public Customer findById(int id) {
		return customerRepo.findBillById(id);
	}

	@Override
	public List<Customer> getAllcustomers() {
		
		return customerRepo.findAll();
	}

//	@Override
//	public Page<Customer> getAllCustomersbypageno(String keyword, Integer page) {
//		return getAllCustomersbypageno(keyword, page);
//	}
	
	

}
