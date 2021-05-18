package com.cg.onlinepizza.service;

import java.util.Optional;

import com.cg.onlinepizza.Exceptions.CartIdNotFoundException;
import com.cg.onlinepizza.Exceptions.OrderIdNotFoundException;
import com.cg.onlinepizza.model.Order;

public interface IPizzaOrderService {
	
    
    String bookOrderInfo(int cartId,int customerId,int coupanId )throws CartIdNotFoundException;
	
	Order updateOrder(Order ord); //done

	String cancelOrder(int orderId) throws OrderIdNotFoundException; //done

    Iterable<Order> listAllOrder();//done

    Optional<Order> viewOrder(int customerId,int orderId) throws OrderIdNotFoundException; //done

	
    
    
    
}


