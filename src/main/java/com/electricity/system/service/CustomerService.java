package com.electricity.system.service;


import java.util.List;

import org.springframework.data.domain.Page;

import com.electricity.system.entity.Customer;

public interface CustomerService {

public void saveCustomer(Customer customer);
public Customer getByMeter(int meter);
public List<Customer> customer();

public Customer getById(int id);

Page<Customer> getAllCustomers(Integer page);

//Page<Customer> getAllCustomersbypageno(String keyword,Integer page);

List<Customer> getByKeyword(String keyword);

void deleteCustomer(int id);

void updateCustomer(Customer customer);
public Customer findById(int id);

List<Customer> getAllcustomers();
}
