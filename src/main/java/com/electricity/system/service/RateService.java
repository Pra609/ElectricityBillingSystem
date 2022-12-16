package com.electricity.system.service;

import java.util.List;



import com.electricity.system.entity.Rate;

public interface RateService {

public Rate getRates(String board,String conntype,String metertype);
void saveRates(Rate rate);
Rate updateRates(Rate rate);

public List<Rate> getRate(String keyword);

public List<Rate> getAllRates();

void deleteRate(int rid);
}
