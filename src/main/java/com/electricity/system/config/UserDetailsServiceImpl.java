package com.electricity.system.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.electricity.system.entity.Customer;
import com.electricity.system.repo.CustomerRepo;

public class UserDetailsServiceImpl implements UserDetailsService{
    
	
	@Autowired
	private CustomerRepo customerRepo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Customer customer=customerRepo.getUserByUserEmail(email);
		if(customer==null) {
			throw new UsernameNotFoundException("user 404");
		}
		else {
			return new CustomUserDetails(customer);
		}
	}

}
