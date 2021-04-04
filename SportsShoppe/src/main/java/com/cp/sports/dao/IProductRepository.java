package com.cp.sports.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cp.sports.Entity.Product;
public interface IProductRepository extends JpaRepository<Product, String> {
	@Query("select p from Product p where p.productName="+"name")
	List<Product> findByProductName(String name);
	   
	
	@Query("select p from Product p where p.sizes="+"sizes")
	List<Product> findBySizes(String sizes);
	
	@Query("select p from Product p where p.priceAfterDiscount="+"priceAfterDiscount")
	List<Product> findByPriceAfterDiscount(double priceAfterDiscount);
	
	@Query("select p from Product p where p.color="+"color")
	List<Product> findByColor(String color);


	
}

