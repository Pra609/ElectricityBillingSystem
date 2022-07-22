package com.electricity.system.service;

import java.util.List;

import com.electricity.system.entity.Bill;
import com.electricity.system.entity.Consumption;

public interface ConsumptionService {
	
	void saveEnergy(Bill bill);
	
	List<Consumption> showEnergyConsumption();

	 List<Consumption> showEnergyConsumptionByKeyword(String keyword);
}
