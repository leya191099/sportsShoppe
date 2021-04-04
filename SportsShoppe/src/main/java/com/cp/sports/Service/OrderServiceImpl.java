package com.cp.sports.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cp.sports.Entity.Orders;
import com.cp.sports.Exception.OrderServiceException;
import com.cp.sports.dao.IOrderRepository;
@Service

@Transactional
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private IOrderRepository iOrderRepository;
	@Override
	public Orders addOrder(Orders order){
		// TODO Auto-generated method stub
		Optional<Orders> order1=iOrderRepository.findById(order.getOrderId());
		if(order1.isEmpty())
			return iOrderRepository.saveAndFlush(order);			
		else
			throw new OrderServiceException("Order already exits");
//		return iOrderRepository.save(order);
		}
		

	@Override
	public Orders removeOrder(long id) {
		// TODO Auto-generated method stub
		Optional<Orders> order1=iOrderRepository.findById(id);
			if(order1.isEmpty()) {
				throw new OrderServiceException("Order not found");
			}else
				iOrderRepository.delete(order1.get());
			return order1.get();
		}

	@Override
	public Orders updateOrder(long id,Orders order) {
		// TODO Auto-generated method stub
		Optional<Orders> order1=iOrderRepository.findById(id);
			if(order1.isEmpty()){
				throw new OrderServiceException("Order not found");
			}else
				iOrderRepository.save(order);
			return order;
		
	}

	@Override
	public Orders getOrderDetails(long id) throws OrderServiceException {
		// TODO Auto-generated method stub
		Optional<Orders> order1=iOrderRepository.findById(id);
		if(order1.isEmpty())
			throw new OrderServiceException("Order not found");
		
			return order1.get();
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		List<Orders> order=iOrderRepository.findAll();
		if(order.isEmpty())
			throw new OrderServiceException("Orders not found");
		return order;
	}

}
