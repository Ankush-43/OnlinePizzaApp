package com.cg.onlinepizza.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.Exceptions.CartIdNotFoundException;
import com.cg.onlinepizza.Exceptions.OrderAlreadyBookedException;
import com.cg.onlinepizza.Exceptions.OrderIdNotFoundException;
import com.cg.onlinepizza.dao.ICustomerRepository;
import com.cg.onlinepizza.dao.IPizzaOrderRepository;
import com.cg.onlinepizza.dao.ICartRepositoryDao;
import com.cg.onlinepizza.dao.ICouponRepositoryDao;
import com.cg.onlinepizza.model.Order;
import com.cg.onlinepizza.model.Cart;
import com.cg.onlinepizza.model.Coupan;
import com.cg.onlinepizza.model.Customer;

@Service
@Transactional
public class IPizzaOrderServiceImpl implements IPizzaOrderService {

	@Autowired
	IPizzaOrderRepository repo;

	@Autowired
	ICustomerRepository custdao;

	@Autowired
	ICartRepositoryDao cartrepo;
	
	@Autowired
	ICouponRepositoryDao coupondao;

	
	
	// Customer can check the Order Status by giving his customerId and orderId
	public Optional<Order> viewOrder(int customerId, int orderId) throws OrderIdNotFoundException {
		Optional<Customer> byId = custdao.findById(customerId);

		if (!byId.isPresent()) {
			System.out.println("Wrong Customer Id");
			return null;
		} else {
			if (!repo.existsById(orderId))
				throw new OrderIdNotFoundException();
			else {
				Order ord = repo.findById(orderId).get();
				
				double finalPrice = (ord.getCart().getTotal()) - (ord.getCoupan().getCoupanDiscount());
				System.out.println(finalPrice);
				ord.setFinalPrice(finalPrice);
				repo.save(ord);
				return repo.findById(orderId);
			}
		}
	}

	
	
	// Returns a list of all the orders
	@Override
	public List<Order> listAllOrder() {
		System.out.println("List all orders in service layers");
		List<Order> list = repo.findAll();
		return list;
	}

	// Customer can Update His Order
	@Override
	public Order updateOrder(Order ord) throws OrderIdNotFoundException {
		boolean b = repo.existsById(ord.getOrderId());
		if (!b) {
			throw new OrderIdNotFoundException();
		} else
			System.out.println("Update Order Successfully");
		return repo.save(ord);
	}

	
	
	
	
	// Customer can Delete The Particular Order
	public String cancelOrder(int orderid) throws OrderIdNotFoundException {
		if (!repo.existsById(orderid))
			throw new OrderIdNotFoundException();
		else
			repo.deleteById(orderid);

		return "Order Deleted Successfully";
	}

	
	
	
	// Customer can book his/her orders here by mentioning his Customer and Cart Id
	public String bookOrderInfo(int cartId, int customerId,int coupanId) throws CartIdNotFoundException{
		Optional<Customer> byId = custdao.findById(customerId);

		Optional<Cart> cartIde = cartrepo.findById(cartId);
		Optional<Coupan> coupanIde=coupondao.findById(coupanId);

		Order ord = new Order();
		if (!cartIde.isPresent()) {
			throw new CartIdNotFoundException("Cart not found");
		} else {
			ord.setOrderStatus("Booked");
			ord.setCustomer(byId.get());
			ord.setCart(cartIde.get());
			ord.setCoupan(coupanIde.get());
			repo.save(ord);
			return "Booked Order Successfully";
		}

	}





}
