package com.electricity.system.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.electricity.system.entity.Customer;

public class CustomUserDetails implements UserDetails{

	private static final long serialVersionUID = 3761809571831376999L;
	private Customer customer;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simple=new SimpleGrantedAuthority(customer.getRole());
		return Arrays.asList(simple);
	}
	
	
	public CustomUserDetails(Customer customer) {
		super();
		this.customer=customer;
		// TODO Auto-generated constructor stub
	}
	
	public int getMeter() {
		return customer.getMeter();
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return customer.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return customer.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
