package com.cp.sports.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.sports.Entity.Cart;
import com.cp.sports.Exception.ProductServiceException;
import com.cp.sports.Service.ICartService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/sports")
@Api(value = "Swagger2DemoRestController")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
	@Autowired
	private ICartService cartService;

	@PostMapping("/addCart")
	public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
		Cart resultCart = cartService.addToCart(cart);
		return new ResponseEntity<Cart>(resultCart, HttpStatus.OK);
	}

	@GetMapping("/cartItems/all")
	public List<Cart> getCart() {
		return cartService.getAllCart();
	}

	@DeleteMapping("/deletecart/{cartId}")
	public void deleteProduct(@PathVariable long cartId) throws ProductServiceException {
		cartService.removeCart(cartId);

	}
}
