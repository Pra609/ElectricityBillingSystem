package com.electricity.system.impl;



import java.util.Calendar;
import java.util.Date;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.electricity.system.entity.Bill;
import com.electricity.system.entity.Consumption;
import com.electricity.system.entity.Customer;
import com.electricity.system.entity.Rate;
import com.electricity.system.repo.BillRepo;
import com.electricity.system.repo.ConsumptionRepo;
import com.electricity.system.service.BillService;
import com.electricity.system.service.CustomerService;
import com.electricity.system.service.RateService;
import com.electricity.system.service.ConsumptionService;

@Service
@Transactional
public class BillServiceImpl implements BillService{

	
	@Autowired
	private BillRepo billRepo;
	
	
    @Autowired
     private RateService rateService;
 
    @Autowired
    private ConsumptionService conService;
    
    @Autowired
    private ConsumptionRepo crepo;
    
    @Autowired
    private CustomerService customerService;
	@Override
	public void saveBill(Bill bill) {
		int id=bill.getBillid();
		 int m=bill.getMeter();
		 Customer customer=customerService.getByMeter(m);
		 String name=customer.getName();
		 //bill.setName(name);
		 System.out.println(m);
		String board=bill.getBoard();
		String conntype=bill.getBconntype();
		String metertype=bill.getMetertype();
		System.out.println(board);
		System.out.println(conntype);
		bill.setStatus("not paid");
   	Rate rate=rateService.getRates(board, conntype,metertype);

	System.out.println(rate);
		double p=rate.getPrice();
	    int e=bill.getEnergy();
	   
		double amount=p*e;
	    bill.setPrice(amount);
		
		System.out.println(customer);
		//billRepo.save(bill);
		
		 
		List<Bill> bil1=billRepo.getBillByMeter(m);
	     bil1.add(bill);
	     customer.setBill(bil1);
	     
	     billRepo.save(bill);
	     conService.saveEnergy(bill);
	    
			
	   
	}

	@Override
	public List<Bill> generateBills() {
		// TODO Auto-generated method stub
	return billRepo.findAll();
		
	}

	@Override
	public List<Bill> billByKeyword(String keyword) {
		return billRepo.getbillByKeyword(keyword);
	}


	@Override
	public void deleteBill(int billid) {
		billRepo.deleteById(billid);
		
	}

	@Override
	public void updateBill(Bill bill) {
   billRepo.save(bill);
		
	}

	@Override
	public List<Bill> getBillsByMeter(int meter) {
		return billRepo.getBillByMeter(meter);
	}

	@Override
	public List<Bill> getBillsById(int id) {
		return billRepo.getBillsById(id);
	}

	@Override
	public void deleteBills(String board, String metertype, String bconntype) {
		billRepo.deleteBills(board, bconntype, metertype);
		
	}

	
	
	
	
	

}
