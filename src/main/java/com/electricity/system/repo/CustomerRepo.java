package com.electricity.system.repo;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.electricity.system.entity.Customer;


public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	@Query(value = "select u from Customer u where u.email = :email")
	public Customer getUserByUserEmail(@Param("email") String email);
	
	@Query(value = "select u from Customer u where u.meter = :meter")
	public Customer getUserByMeter(@Param("meter") int meter);
	
	@Query("SELECT a from  Customer a WHERE  a.board LIKE %?1%"+" OR a.conntype LIKE %?1%"+" OR a.meter LIKE %?1%"+" OR a.contact LIKE %?1%"+" OR a.name LIKE %?1%"+" OR a.email LIKE %?1%" +" OR a.id LIKE %?1%"+" OR a.metertype LIKE %?1%")
	public List<Customer> getcustomerByKeyword(String keyword);
	
//	@Query("SELECT a from  Customer a WHERE  a.board LIKE %?1%"+" OR a.conntype LIKE %?1%"+" OR a.meter LIKE %?1%"+" OR a.contact LIKE %?1%"+" OR a.name LIKE %?1%"+" OR a.email LIKE %?1%" +" OR a.id LIKE %?1%"+" OR a.metertype LIKE %?1%")
//	public Page<Customer> getcustomerByKeyword(String keyword,Pageable pageable);
	
	@Query("from Customer r inner join fetch r.bill where r.id = :id")
	  Customer findBillById(@Param("id") int id);
}

