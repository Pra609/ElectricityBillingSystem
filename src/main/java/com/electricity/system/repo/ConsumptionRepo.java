package com.electricity.system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.electricity.system.entity.Consumption;


public interface ConsumptionRepo extends JpaRepository<Consumption, Integer> {
	
@Query("Select u from Consumption u where u.month=:month")
public Consumption getByMonth(String month);

@Query("SELECT a from  Consumption a WHERE  a.month LIKE %?1%"+" OR a.energy LIKE %?1%")
public List<Consumption> getconsumptionByKeyword( String keyword);
}
