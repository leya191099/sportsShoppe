package com.cp.sports.Service;


import java.util.List;

import com.cp.sports.Entity.Cart;



public interface ICartService {
	
	public Cart addToCart(Cart cart);

	public List<Cart> getAllCart();

	public void removeCart(long cart);
}