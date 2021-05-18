package com.cg.onlinepizza.service;

import java.util.Map;

import com.cg.onlinepizza.Exceptions.CustomerIdNotFoundException;
import com.cg.onlinepizza.Exceptions.ItemIdNotFoundException;
import com.cg.onlinepizza.Exceptions.PizzaIdNotFoundException;
import com.cg.onlinepizza.model.Cart;
import com.cg.onlinepizza.model.CartItem;

public interface ICartService {

	public Cart createCart(int customerId)throws CustomerIdNotFoundException;
	public CartItem updateCartQuantity(int customerId, int itemId, int quantity)throws CustomerIdNotFoundException,ItemIdNotFoundException;
	public String deleteCartItem(int customerId, int itemId)throws CustomerIdNotFoundException,ItemIdNotFoundException;
	public String clearCart(int customerId)throws CustomerIdNotFoundException;
	public CartItem addPizzaToCart(int customerId, Map<String, Object> requestData)throws CustomerIdNotFoundException,PizzaIdNotFoundException;
	
}
