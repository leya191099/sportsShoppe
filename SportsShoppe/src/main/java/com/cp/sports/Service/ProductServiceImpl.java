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
/****************************
 * @author G.Joslin Description It is a service class that provides the services
 *         to add a Product, remove a Product, update a Product and get a
 *         Product by name ,color,size and price
 * 
 *         Version 1.0 Created Date 24-March-2021
 ****************************/
public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductRepository productdao;
	/****************************
	 * Method :addProduct Description :To add the Product to the database
	 * 
	 * @param product - Product to be added to the database
	 * @returns Product - returns Product after adding the product to database
	 * @throws CoupanServiceException - It is raised when product already exists
	 *                                CreatedBy - G.Joslin Created Date -
	 *                                23-MAR-2021
	 ****************************/
	@Override
	public Product addProduct(Product product) {
		Optional<Product> product1 = productdao.findById(product.getProductId());
		if (product1.isEmpty()) {
			return productdao.saveAndFlush(product);
		} else {
			throw new ProductServiceException("Product already exists");
		}

	}

	/****************************
	 * Method :removeProduct Description :To remove the Product to the database
	 * 
	 * @param product - Product to be removed from the database
	 * @returns void - returns void
	 * @throws ProductServiceException - It is raised when Product does not exists
	 *                                 CreatedBy - G.Joslin Created Date -
	 *                                 23-MAR-2021
	 ****************************/

	@Override
	public void removeProduct(String id) {
		// TODO Auto-generated method stub
		Optional<Product> product1 = productdao.findById(id);
		if (product1.isEmpty()) {
			throw new ProductServiceException("Product doesnt exist to delete");
		} else
			productdao.delete(product1.get());

	}

	
	/****************************
	 * Method :updateProduct Description :To update the product in the database
	 * 
	 * @param product - product to be updated
	 * @returns product - returns product after updating the product to database
	 * @throws CoupanServiceException - It is raised when product not found
	 *                                CreatedBy - G,Joslin Created Date -
	 *                                23-MAR-2021
	 ****************************/
	@Override
	public Product updateProduct(String id, Product product) {
		Optional<Product> product1 = productdao.findById(id);
		if (product1.isEmpty()) {
			throw new ProductServiceException("Product not found");
		} else
			productdao.save(product);
		// TODO Auto-generated method stub
		return product;
	}

	/****************************
	 * Method :getProduct Description :To get the product from the database
	 * 
	 * @param product -To fetch the product from the database
	 * @returns product - returns product after fetching the database
	 * @throws CoupanServiceException - It is raised when product does not exists
	 *                                CreatedBy -G.Joslin Created Date - 23-MAR-2021
	 ****************************/

	@Override
	public Product getProduct(String id) throws ProductServiceException {
		Optional<Product> product = productdao.findById(id);
		if (product.isEmpty()) {
			throw new ProductServiceException("Given product id does not exists");
		}
		// TODO Auto-generated method stub
		return product.get();
	}

	/****************************
	 * Method :getAllProduct Description :To get all the product from the database
	 * 
	 * @param product -To fetch all the product from the database
	 * @returns Product - returns product after fetching the database
	 * @throws ProductServiceException - It is raised when product does not found
	 *                                 CreatedBy -G.Joslin Created Date -
	 *                                 23-MAR-2021
	 ****************************/

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> product = productdao.findAll();
		if (product.isEmpty()) {
			throw new ProductServiceException("Products not found");
		}
		return product;
	}

	
	/****************************
	 * Method :getProductsByName Description :To get the product byname from the
	 * database
	 * 
	 * @param product -To fetch the product by name from the database
	 * @returns Product - returns product after fetching the database
	 * @throws ProductServiceException - It is raised when product does not found
	 *                                 CreatedBy -G.Joslin Created Date -
	 *                                 23-MAR-2021
	 ****************************/
	@Override
	public List<Product> getProductsByName(String name) {
		// TODO Auto-generated method stub
		List<Product> product = productdao.findByProductName(name);
		if (product.isEmpty()) {
			throw new ProductServiceException("Products not found");
		}
		return product;
	}

	
	/****************************
	 * Method :getProductsBySize Description :To get the product by size from the
	 * database
	 * 
	 * @param product -To fetch the product by size from the database
	 * @returns Product - returns product after fetching the database
	 * @throws ProductServiceException - It is raised when product does not found
	 *                                 CreatedBy -G.Joslin Created Date -
	 *                                 23-MAR-2021
	 ****************************/
	@Override
	public List<Product> getProductsBySize(String sizes) {
		// TODO Auto-generated method stub
		List<Product> product = productdao.findBySizes(sizes);
		if (product.isEmpty()) {
			throw new ProductServiceException("Products with required sizes not found");
		}
		return product;
	}

	/****************************
	 * Method :getProductsByPrice Description :To get the product by price from the
	 * database
	 * 
	 * @param product -To fetch the product by price from the database
	 * @returns Product - returns product after fetching the database
	 * @throws ProductServiceException - It is raised when product does not found
	 *                                 CreatedBy -G.Joslin Created Date -
	 *                                 23-MAR-2021
	 ****************************/

	@Override
	public List<Product> getProductsByPrice(double priceAfterDiscount) {
		// TODO Auto-generated method stub
		List<Product> product = productdao.findByPriceAfterDiscount(priceAfterDiscount);
		if (product.isEmpty()) {
			throw new ProductServiceException("Products with mentioed price not found");
		}
		return product;
	}

	
	/****************************
	 * Method :getProductsByColor Description :To get the product by color from the
	 * database
	 * 
	 * @param product -To fetch the product by color from the database
	 * @returns Product - returns product after fetching the database
	 * @throws ProductServiceException - It is raised when product does not found
	 *                                 CreatedBy -G.Joslin Created Date -
	 *                                 23-MAR-2021
	 ****************************/
	@Override
	public List<Product> getProductsByColor(String color) {
		// TODO Auto-generated method stub
		List<Product> product = productdao.findByColor(color);
		if (product.isEmpty()) {
			throw new ProductServiceException("Products with mentioned color not found");
		}
		return product;
	}
	

}
