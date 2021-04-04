package com.cp.sports.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.sports.Entity.Product;
import com.cp.sports.Exception.ProductServiceException;
import com.cp.sports.Service.IProductService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/sports")
@Api
public class ProductController {
	@Autowired
	private IProductService productservice;

	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product resultProduct = productservice.addProduct(product);
		return new ResponseEntity<Product>(resultProduct,HttpStatus.OK) ;  
	}

	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable String id) throws ProductServiceException {
		productservice.removeProduct(id);
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Product resultProduct = productservice.updateProduct(product.getProductId(), product);
		return new ResponseEntity<Product>(resultProduct, HttpStatus.OK);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> findProduct(@PathVariable String id) throws ProductServiceException {
		Product resultProduct = productservice.getProduct(id);
		return new ResponseEntity<Product>(resultProduct, HttpStatus.OK);
	}

	@GetMapping("/product/all")
	public List<Product> getProducts() {
		return productservice.getAllProduct();
	}

	@GetMapping("/product1/{name}")
	public List<Product> getProductsByName(@PathVariable String name) {

		return productservice.getProductsByName(name);
	}

	@GetMapping("/product2/{sizes}")
	public List<Product> getProductsBySize(@PathVariable String sizes) {
		return productservice.getProductsBySize(sizes);
	}

	@GetMapping("/product3/{color}")
	public List<Product> getProductsByColor(@PathVariable String color) {
		return productservice.getProductsByColor(color);
	}

	@GetMapping("/product4/{priceAfterDiscount}")
	public List<Product> getProductsByPrice(@PathVariable double priceAfterDiscount) {
		return productservice.getProductsByPrice(priceAfterDiscount);
	}
}
