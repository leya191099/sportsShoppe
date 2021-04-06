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
@Api(value = "Swagger2DemoRestController")
//Class Level Comment
/****************************
 * @author G.Joslin Description It is a Controller class that provides the
 *         Handler methods for adding new product
 * 
 *         Version 1.0 Created Date 22-March-2021
 ****************************/
public class ProductController {
	@Autowired
	private IProductService productservice;

	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product resultProduct = productservice.addProduct(product);
		return new ResponseEntity<Product>(resultProduct, HttpStatus.OK);
	}

	/****************************
	 * Method : addProduct Description : To add the product to the database
	 * 
	 * @param product     - product to be added to the database
	 * @param RequestBody - It maps the HttpRequest body to a transfer or domain
	 *                    object, enabling automatic deserialization of the inbounds
	 *                    HttpRequest body onto a Java object.
	 * @returns product - returns product after adding the product to database
	 * @throws ProductServiceException - It is raised when product already exists
	 *                                 CreatedBy - G.Joslin Created Date -
	 *                                 24-MAR-2021
	 ****************************/

	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable String id) throws ProductServiceException {
		productservice.removeProduct(id);
	}

	/****************************
	 * Method : deleteProduct Description : To delete the product from the database
	 * 
	 * @param product      - product is deleting from the database
	 * @param PathVariable - It maps the HttpRequest body to a transfer or domain
	 *                     object, enabling automatic deserialization of the
	 *                     inbounds HttpRequest body onto a Java object.
	 * @returns void - returns void
	 * @throws ProductServiceException - It is raised when product already exists
	 *                                 CreatedBy - G.Joslin Created Date -
	 *                                 24-MAR-2021
	 ****************************/

	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Product resultProduct = productservice.updateProduct(product.getProductId(), product);
		return new ResponseEntity<Product>(resultProduct, HttpStatus.OK);
	}

	/****************************
	 * Method : updateProduct Description : To update the product in the database
	 * 
	 * @param product - product to be updated
	 * @returns product - returns product after updating the product to database
	 * @throws CoupanServiceException - It is raised when product not found
	 *                                CreatedBy - G.Joslin Created Date -
	 *                                23-MAR-2021
	 ****************************/

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> findProduct(@PathVariable String id) throws ProductServiceException {
		Product resultProduct = productservice.getProduct(id);
		return new ResponseEntity<Product>(resultProduct, HttpStatus.OK);
	}

	/****************************
	 * Method : findProduct Description : To find the product from the database
	 * using id
	 * 
	 * @param product - To fetch the product from the database
	 * @returns Product - returns product after fetching the database
	 * @throws CoupanServiceException - It is raised when product does not exists
	 *                                CreatedBy - G.JoslinCreated Date - 23-MAR-2021
	 ****************************/

	@GetMapping("/product/all")
	public List<Product> getProducts() {
		return productservice.getAllProduct();
	}

	/****************************
	 * Method : getProduct Description : To get all the product from the database
	 * 
	 * @returns List<Product> - returns product after fetching the database
	 * @throws ProductServiceException - It is raised when product does not found
	 *                                 CreatedBy - G.Joslin Created Date -
	 *                                 23-MAR-2021
	 ****************************/

	@GetMapping("/product1/{name}")
	public List<Product> getProductsByName(@PathVariable String name) {

		return productservice.getProductsByName(name);
	}

	/****************************
	 * Method : getProductByName Description : To get the product by name from the
	 * database
	 * 
	 * @returns List<Product> - returns product after fetching the database
	 * @throws ProductServiceException - It is raised when product does not found
	 *                                 CreatedBy - G.Joslin Created Date -
	 *                                 23-MAR-2021
	 ****************************/

	@GetMapping("/product2/{sizes}")
	public List<Product> getProductsBySize(@PathVariable String sizes) {
		return productservice.getProductsBySize(sizes);
	}

	/****************************
	 * Method : getProductBySize Description : To get the product by size from the
	 * database
	 * 
	 * @returns List<Product> - returns product after fetching the database
	 * @throws ProductServiceException - It is raised when product does not found
	 *                                 CreatedBy - G.Joslin Created Date -
	 *                                 23-MAR-2021
	 ****************************/

	@GetMapping("/product3/{color}")
	public List<Product> getProductsByColor(@PathVariable String color) {
		return productservice.getProductsByColor(color);
	}

	/****************************
	 * Method : getProductByColor Description : To get the product by color from the
	 * database
	 * 
	 * @returns List<Product> - returns product after fetching the database
	 * @throws ProductServiceException - It is raised when product does not found
	 *                                 CreatedBy - G.Joslin Created Date -
	 *                                 23-MAR-2021
	 ****************************/

	@GetMapping("/product4/{priceAfterDiscount}")
	public List<Product> getProductsByPrice(@PathVariable double priceAfterDiscount) {
		return productservice.getProductsByPrice(priceAfterDiscount);
	}
	/****************************
	 * Method : getProductByPrice Description : To get the product by price after
	 * discount from the database
	 * 
	 * @returns List<Product> - returns product after fetching the database
	 * @throws ProductServiceException - It is raised when product does not found
	 *                                 CreatedBy - G.Joslin Created Date -
	 *                                 23-MAR-2021
	 ****************************/
}
