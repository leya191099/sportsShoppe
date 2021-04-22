package com.cp.sports.Service;

import java.util.List;

import com.cp.sports.Entity.Orders;
import com.cp.sports.dto.IOrderDto;

public interface IOrderService {
	public Orders addOrder(Orders order);

	public Orders removeOrder(String id);

	public Orders updateOrder(String id,Orders order);

	public Orders getOrderDetails(String id);

	public List<Orders> getAllOrders();
}
