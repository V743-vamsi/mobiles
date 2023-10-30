package com.example.demo.repo;

import java.util.List;

import com.example.demo.Entity.Customer;

public interface OnlineServiceRepo {
	public List<Customer> getcustomer();
	 public String insertcustomer(Customer c);
	 public String updatecustomer(Customer c);
	 public String deletecustomer(Integer id);
}


