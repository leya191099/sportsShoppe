package com.cp.sports.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cp.sports.dao.IProductRepository;
import com.cp.sports.Entity.Product;
import com.cp.sports.Exception.ProductServiceException;

@Service
@Transactional
@Repository
public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductRepository productdao;

	@Override
	public Product addProduct(Product product) {
		Optional<Product> product1 = productdao.findById(product.getProductId());
		if (product1.isEmpty()) {
			return productdao.saveAndFlush(product);
		} else {
			throw new ProductServiceException("Product already exists");
		}

	}

	@Override
	public void removeProduct(String id) {
		// TODO Auto-generated method stub
		Optional<Product> product1=productdao.findById(id);
		if(product1.isEmpty()) {
			throw new ProductServiceException("Product doesnt exist to delete");
		}
		else 
			productdao.delete(product1.get());
		
	}

	@Override
	public Product updateProduct(String id, Product product) {
		Optional<Product> product1=productdao.findById(id);
		if(product1.isEmpty()) {
			throw new ProductServiceException("Product not found");
		}
		else
			productdao.save(product);
		// TODO Auto-generated method stub
		return product;
	}

	@Override
	public Product getProduct(String id) throws ProductServiceException {
		Optional<Product>product=productdao.findById(id);
		if(product.isEmpty()) {
			throw new ProductServiceException("Given product id does not exists");
		}
		// TODO Auto-generated method stub
		return product.get();
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> product= productdao.findAll();
		if(product.isEmpty()) {
			throw new ProductServiceException("Products not found");
		}
		return product;
	}

	@Override
	public List<Product> getProductsByName(String name) {
		// TODO Auto-generated method stub
		List<Product> product= productdao.findByProductName(name);
		if(product.isEmpty()) {
			throw new ProductServiceException("Products not found");
		}
		return product;
	}

	@Override
	public List<Product> getProductsBySize(String sizes) {
		// TODO Auto-generated method stub
		List<Product> product= productdao.findBySizes(sizes);
		if(product.isEmpty()) {
			throw new ProductServiceException("Products with required sizes not found");
		}
		return product;
	}

	@Override
	public List<Product> getProductsByPrice(double priceAfterDiscount) {
		// TODO Auto-generated method stub
		List<Product> product= productdao.findByPriceAfterDiscount(priceAfterDiscount);
		if(product.isEmpty()) {
			throw new ProductServiceException("Products with mentioed price not found");
		}
		return product;
	}

	@Override
	public List<Product> getProductsByColor(String color) {
		// TODO Auto-generated method stub
		List<Product> product= productdao.findByColor(color);
		if(product.isEmpty()) {
			throw new ProductServiceException("Products with mentioned color not found");
		}
		return product;
	}

}
