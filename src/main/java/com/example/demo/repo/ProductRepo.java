package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{

	Product findByproductname(String productname);

	Product findByproductname(Product product);

}
