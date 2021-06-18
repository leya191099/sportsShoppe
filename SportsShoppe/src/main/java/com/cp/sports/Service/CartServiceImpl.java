package com.cp.sports.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.sports.Entity.Cart;
import com.cp.sports.Exception.ProductServiceException;
import com.cp.sports.dao.ICartRepository;

@Service
public class CartServiceImpl implements ICartService {
	@Autowired
	private ICartRepository cartDao;

	@Override
	public Cart addToCart(Cart cart) {
		// TODO Auto-generated method stub
		Optional<Cart> cart1 = cartDao.findById(cart.getCartId());

		return cartDao.saveAndFlush(cart);
		// return cartDao.saveAndFlush(cart);

	}

	@Override
	public List<Cart> getAllCart() {
		// TODO Auto-generated method stub
		List<Cart> cart = cartDao.findAll();
		if (cart.isEmpty()) {
			throw new ProductServiceException("Cart is empty");
		}
		return cart;
	}

	@Override
	public void removeCart(long cartId) {
		Optional<Cart> cart1 = cartDao.findById(cartId);
		if (cart1.isEmpty()) {
			throw new ProductServiceException("Item doesnt exist to delete in cart");
		} else
			cartDao.delete(cart1.get());
		
	}

}
