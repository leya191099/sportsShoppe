package com.cp.sports.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cp.sports.Entity.Product;

@SpringBootTest
public class IProductServiceTest {
	@Autowired
	private IProductService productservice;

	Product product = new Product("1234", "football shoes", "shoes", "very good shoe", "adidas", "brown", "6", "655",
			15, 410, true, LocalDate.parse("2021-03-31"));

	@Test
	void updateProductTest() {
		System.out.println(productservice.updateProduct("1234", product));
		assertEquals(
				"Product [productId=1234, productName=football shoes, category=shoes, description=very good shoe, brand=adidas, color=brown, size=6, mrp=655, discount=15, priceAfterDiscount=410.0, inStock=true, estimatedDelivery=2021-03-31]",
				productservice.updateProduct("1234", product).toString());
	}

	@Test
	void addProductTest() {
		Product product = new Product("1235", "football shoes", "shoes", "very good shoe", "adidas", "brown", "6",
				"655", 15, 410, true, LocalDate.parse("2021-03-31"));
		productservice.addProduct(product);
		assertNotNull(product.getProductId());
		System.out.println(productservice.getProduct("1235"));
//			System.out.println(productservice.getAllProduct().size());
	}

	@Test
	void getIdTest1() {

		assertEquals("football shoes", productservice.getProduct("1234").getProductName().toString());
	}

	@Test
	void getPriceTest() {

		assertEquals(410, productservice.getProduct("1234").getPriceAfterDiscount());
	}

	@Test
	void getColorTest() {
		assertEquals("brown", productservice.getProduct("1234").getColor());
	}

	@Test
	void getSizeTest() {
		assertEquals("6", productservice.getProduct("1234").getSize());
	}

}
