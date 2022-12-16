package com.electricity.system.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.electricity.system.entity.Bill;




public interface BillRepo extends JpaRepository<Bill, Integer> {
	@Query(value = "select u from Bill u where status='not paid' and u.meter = :meter")
	public List<Bill> getBillByMeter(@Param("meter") int meter);
	
	@Query("SELECT a from  Bill a WHERE  a.board LIKE %?1%"+" OR a.bconntype LIKE %?1%"+" OR a.meter LIKE %?1%"+" OR a.date LIKE %?1%"+" OR a.status LIKE %?1%" )
	public List<Bill> getbillByKeyword(String keyword);
	
	
	@Modifying
	@Query(value = "delete from Bill u where u.meter = :meter")
	public void deleteBillsBYMeter(@Param("meter") int meter);
	
	@Query(value = "select u from Bill u where u.meter = :meter")
	public Bill getBill(@Param("meter") int meter);
	
	@Query(value = "select u from Bill u where u.id = :id")
	public List<Bill>  getBillsById(@Param("id") int id);
	
	
	@Modifying
	@Query(value = "delete from Bill u where u.board = :board and u.bconntype=:bconntype  and u.metertype=:metertype")
	public void deleteBills( String board,String bconntype,String metertype);
}
