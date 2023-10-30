package com.example.demo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Customer;
@Service
public class OnlineServiceImpl implements OnlineServiceRepo {
	@Autowired
	CustomerRepo customerrepo;

	@Override
	public List<Customer> getcustomer() {
		List<Customer> list=customerrepo.findAll();
		return list;
	}

	@Override
	public String insertcustomer(Customer c) {
		customerrepo.save(c);
		return "Record inserted";
	}

	@Override
	public String updatecustomer(Customer c) {
		customerrepo.save(c);
		return "Record updated";
		
	}

	@Override
	public String deletecustomer(Integer id) {
		customerrepo.deleteById(id);
		return "Record deleted";
		
	}

}