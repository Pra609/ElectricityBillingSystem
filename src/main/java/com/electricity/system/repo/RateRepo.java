package com.electricity.system.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.electricity.system.entity.Rate;

public interface RateRepo extends JpaRepository<Rate, Integer> {
	@Query(value = "select u from Rate u where u.board = :board and u.conntype=:conntype  and u.metertype=:metertype")
	public Rate getFromRate( String board,String conntype,String metertype);
	
	@Query("SELECT a from Rate a WHERE  a.board LIKE %?1%"+" OR a.conntype LIKE %?1%" +" OR a.price LIKE %?1%")
	public List<Rate> getrateByKeyword(String keyword);
}
