package com.electricity.system.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity.system.entity.Rate;
import com.electricity.system.repo.BillRepo;
import com.electricity.system.repo.RateRepo;
import com.electricity.system.service.RateService;

@Service
@Transactional
public class RateServiceImpl implements RateService{
	
	@Autowired
	private RateRepo rateRepo;
	
	@Autowired
	private BillRepo billRepo;
	
	

	@Override
	public Rate getRates(String board, String conntype,String metertype) {
		Rate rate=rateRepo.getFromRate(board, conntype,metertype);
		return rate;
	}



	@Override
	public void saveRates(Rate rate) {
		rateRepo.save(rate);
		
	}



	@Override
	public Rate updateRates(Rate rate) {
		Rate rates=rateRepo.save(rate);
		return rates;
		
	}



	@Override
	public List<Rate> getRate(String keyword) {
		
		return  rateRepo.getrateByKeyword(keyword);
	}



	@Override
	public List<Rate> getAllRates() {
	return rateRepo.findAll();
	}



	@Override
	public void deleteRate(int rid) {
		
		Rate rate=rateRepo.getById(rid);
		String board=rate.getBoard();
		String metertype=rate.getMetertype();
		String conntype=rate.getConntype();
		billRepo.deleteBills(board, conntype, metertype);
	    rateRepo.deleteById(rid);
	    
		
	}



	

}
