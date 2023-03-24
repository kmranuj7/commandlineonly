package com.excel.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.api.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	

}
