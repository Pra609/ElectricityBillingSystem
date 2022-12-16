package com.electricity.system.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity.system.entity.Bill;
import com.electricity.system.entity.Consumption;
import com.electricity.system.repo.ConsumptionRepo;
import com.electricity.system.service.ConsumptionService;

@Service
public class ConsumptionServiceImpl implements ConsumptionService{

	
	@Autowired
	private ConsumptionRepo crepo;
	
	@Override
	public void saveEnergy(Bill bill) {
		
		int e=bill.getEnergy();
	
		Date d=bill.getDate();
		//int en=bill.getEnergy();
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(d);
		 int  mo=cal.get(Calendar.MONTH);
		 int month=mo+1;
		 System.out.println(month);
		 //int year=cal.get(Calendar.YEAR);
		 int sum=0;
		 
		 Consumption c=new Consumption();
		 //String month=
		 System.out.println("month"+d);
		String cm= c.getMonth();
		System.out.println(cm);
		 if(month==1) {
			 String cmonth="january";
			 Consumption con=crepo.getByMonth(cmonth);
			 //int cid=con.getId();
			 System.out.println("coonsumption"+con);
			  
			 if(con!=null) {
				
				 int cen=con.getEnergy();
				 
				 int cnen=cen+e;
				 con.setEnergy(cnen);
				 con.setMonth(cmonth);
				 crepo.save(con);
			 }else {
				 sum=sum+e;
				 c.setMonth("january");
				 c.setEnergy(e);
				 crepo.save(c);
			 }
			 
		 }
		 else if(month==2) {
			 
			 String cmonth="febrauary";
			 Consumption con=crepo.getByMonth(cmonth);
			 //int cid=con.getId();
			 System.out.println("coonsumption"+con);
			  
			 if(con!=null) {
				
				 int cen=con.getEnergy();
				 
				 int cnen=cen+e;
				 con.setEnergy(cnen);
				 con.setMonth(cmonth);
				 crepo.save(con);
			 }else {
				 sum=sum+e;
				 c.setMonth("febrauary");
				 c.setEnergy(e);
				 crepo.save(c);
			 }
		 }
         else if(month==3) {
			 
			 String cmonth="march";
			 Consumption con=crepo.getByMonth(cmonth);
			 //int cid=con.getId();
			 System.out.println("coonsumption"+con);
			  
			 if(con!=null) {
				
				 int cen=con.getEnergy();
				 
				 int cnen=cen+e;
				 con.setEnergy(cnen);
				 con.setMonth(cmonth);
				 crepo.save(con);
			 }else {
				 sum=sum+e;
				 c.setMonth("march");
				 c.setEnergy(e);
				 crepo.save(c);
			 }
		 }
         else if(month==4) {
			 
			 String cmonth="april";
			 Consumption con=crepo.getByMonth(cmonth);
			 //int cid=con.getId();
			 System.out.println("coonsumption"+con);
			  
			 if(con!=null) {
				
				 int cen=con.getEnergy();
				 
				 int cnen=cen+e;
				 con.setEnergy(cnen);
				 con.setMonth(cmonth);
				 crepo.save(con);
			 }else {
				 sum=sum+e;
				 c.setMonth("april");
				 c.setEnergy(e);
				 crepo.save(c);
			 }
		 }else if(month==5) {
			 
			 String cmonth="may";
			 Consumption con=crepo.getByMonth(cmonth);
			 //int cid=con.getId();
			 System.out.println("coonsumption"+con);
			  
			 if(con!=null) {
				
				 int cen=con.getEnergy();
				 
				 int cnen=cen+e;
				 con.setEnergy(cnen);
				 con.setMonth(cmonth);
				 crepo.save(con);
			 }else {
				 sum=sum+e;
				 c.setMonth("may");
				 c.setEnergy(e);
				 crepo.save(c);
			 }
		 }else if(month==6) {
			 
			 String cmonth="june";
			 Consumption con=crepo.getByMonth(cmonth);
			 //int cid=con.getId();
			 System.out.println("coonsumption"+con);
			  
			 if(con!=null) {
				
				 int cen=con.getEnergy();
				 
				 int cnen=cen+e;
				 con.setEnergy(cnen);
				 con.setMonth(cmonth);
				 crepo.save(con);
			 }else {
				 sum=sum+e;
				 c.setMonth("june");
				 c.setEnergy(e);
				 crepo.save(c);
			 }
		 }else if(month==7) {
			 
			 String cmonth="july";
			 Consumption con=crepo.getByMonth(cmonth);
			 //int cid=con.getId();
			 System.out.println("coonsumption"+con);
			  
			 if(con!=null) {
				
				 int cen=con.getEnergy();
				 
				 int cnen=cen+e;
				 con.setEnergy(cnen);
				 con.setMonth(cmonth);
				 crepo.save(con);
			 }else {
				 sum=sum+e;
				 c.setMonth("july");
				 c.setEnergy(e);
				 crepo.save(c);
			 }
		 }else if(month==8) {
			 
			 String cmonth="august";
			 Consumption con=crepo.getByMonth(cmonth);
			 //int cid=con.getId();
			 System.out.println("coonsumption"+con);
			  
			 if(con!=null) {
				
				 int cen=con.getEnergy();
				 
				 int cnen=cen+e;
				 con.setEnergy(cnen);
				 con.setMonth(cmonth);
				 crepo.save(con);
			 }else {
				 sum=sum+e;
				 c.setMonth("august");
				 c.setEnergy(e);
				 crepo.save(c);
			 }
		 }else if(month==9) {
			 
			 String cmonth="september";
			 Consumption con=crepo.getByMonth(cmonth);
			 //int cid=con.getId();
			 System.out.println("coonsumption"+con);
			  
			 if(con!=null) {
				
				 int cen=con.getEnergy();
				 
				 int cnen=cen+e;
				 con.setEnergy(cnen);
				 con.setMonth(cmonth);
				 crepo.save(con);
			 }else {
				 sum=sum+e;
				 c.setMonth("september");
				 c.setEnergy(e);
				 crepo.save(c);
			 }
		 }else if(month==10) {
			 
			 String cmonth="october";
			 Consumption con=crepo.getByMonth(cmonth);
			 //int cid=con.getId();
			 System.out.println("coonsumption"+con);
			  
			 if(con!=null) {
				
				 int cen=con.getEnergy();
				 
				 int cnen=cen+e;
				 con.setEnergy(cnen);
				 con.setMonth(cmonth);
				 crepo.save(con);
			 }else {
				 sum=sum+e;
				 c.setMonth("october");
				 c.setEnergy(e);
				 crepo.save(c);
			 }
		 }else if(month==11) {
			 
			 String cmonth="november";
			 Consumption con=crepo.getByMonth(cmonth);
			 //int cid=con.getId();
			 System.out.println("coonsumption"+con);
			  
			 if(con!=null) {
				
				 int cen=con.getEnergy();
				 
				 int cnen=cen+e;
				 con.setEnergy(cnen);
				 con.setMonth(cmonth);
				 crepo.save(con);
			 }else {
				 sum=sum+e;
				 c.setMonth("november");
				 c.setEnergy(e);
				 crepo.save(c);
			 }
		 }else if(month==12) {
			 
			 String cmonth="december";
			 Consumption con=crepo.getByMonth(cmonth);
			 //int cid=con.getId();
			 System.out.println("coonsumption"+con);
			  
			 if(con!=null) {
				
				 int cen=con.getEnergy();
				 
				 int cnen=cen+e;
				 con.setEnergy(cnen);
				 con.setMonth(cmonth);
				 crepo.save(con);
			 }else {
				 sum=sum+e;
				 c.setMonth("december");
				 c.setEnergy(e);
				 crepo.save(c);
			 }
		 }
   
	
	}

	@Override
	public List<Consumption> showEnergyConsumption() {
		return crepo.findAll();
	}

	@Override
	public List<Consumption> showEnergyConsumptionByKeyword(String keyword) {
		
		return crepo.getconsumptionByKeyword(keyword);
	}

	
}
