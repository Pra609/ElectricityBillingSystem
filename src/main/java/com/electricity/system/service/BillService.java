package com.electricity.system.service;

import java.util.List;


import com.electricity.system.entity.Bill;

public interface BillService {
 void saveBill(Bill bill);
 
 List<Bill> generateBills();
 
 public List<Bill> billByKeyword(String keyword);
 

 
 void deleteBill(int billid);
 
 void updateBill(Bill bill);
 
 List<Bill> getBillsByMeter(int meter);
 
 List<Bill> getBillsById(int id);
 
 void deleteBills(String board,String bconntype,String metertype);
 
 
}
