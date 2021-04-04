package com.cp.sports.Service;

import java.util.List;

import com.cp.sports.Entity.Orders;
import com.cp.sports.dto.IOrderDto;

public interface IOrderService {
	public Orders addOrder(Orders order);

	public Orders removeOrder(long id);

	public Orders updateOrder(long id,Orders order);

	public Orders getOrderDetails(long id);

	public List<Orders> getAllOrders();
}
