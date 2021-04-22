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
/****************************
 * @author Leya Varghese 
 * Description It is a service class that provides the
 *         services to add a Order, remove a order, update a order and get order
 *         and get all order details
 *Version 1.0 
 *Created Date 23-March-2021
 ****************************/
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepository iOrderRepository;

	/****************************
	 * Method :addOrder
	 * Description :To add the order to the database
	 * @param Orders - order to be added to the database
	 * @returns Orders - returns order after adding the order to database
	 * @throws OrderServiceException - It is raised when order already exists
	 * CreatedBy - Leya Varghese 
	 * Created Date-23-MAR-2021
	 ****************************/
	@Override
	public Orders addOrder(Orders order) {
		// TODO Auto-generated method stub
		Optional<Orders> order1 = iOrderRepository.findById(order.getOrderId());
		if (order1.isEmpty())
			return iOrderRepository.saveAndFlush(order);
		else
			throw new OrderServiceException("Order already exits");
//		return iOrderRepository.save(order);
	}

	/****************************
	 * Method :removeOrder
	 * Description :To remove the order from the database 
	 * @param id - id of order to be removed from the database
	 * @returns Order - returns void
	 * @throws OrderServiceException - It is raised when order does not exists
	 * CreatedBy - Leya Varghese 
	 * Created Date -23-MAR-2021
	 ****************************/
	@Override
	public Orders removeOrder(String id) {
		// TODO Auto-generated method stub
		Optional<Orders> order1 = iOrderRepository.findById(id);
		if (order1.isEmpty()) {
			throw new OrderServiceException("Order not found");
		} else
			iOrderRepository.delete(order1.get());
		return order1.get();
	}
	/****************************
	 * Method                           :updateOrder
	 * Description                      :To update the order in the database
	 * @param id,order                  - order to be updated and its id
	 * @returns Order                   - returns order after adding the order to database 
	 * @throws OrderServiceException   - It is raised when order is not found
	 * CreatedBy                        - Leya Varghese 
	 * Created Date                     - 23-MAR-2021
	 ****************************/
	@Override
	public Orders updateOrder(String id, Orders order) {
		// TODO Auto-generated method stub
		Optional<Orders> order1 = iOrderRepository.findById(id);
		if (order1.isEmpty()) {
			throw new OrderServiceException("Order not found");
		} else
			iOrderRepository.save(order);
		return order;

	}
	/****************************
	 * Method                           :getOrderDetails
	 * Description                      :To get the order details from the database
	 * @param id                        -To fetch the order from the database with id
	 *@returns Orders                   - returns order after fetching from the database
	 * @throws OrderServiceException    - It is raised when order does not exists
	 * CreatedBy                        -Leya Varghese
	 * Created Date                     - 23-MAR-2021
	 ****************************/
	@Override
	public Orders getOrderDetails(String id) throws OrderServiceException {
		// TODO Auto-generated method stub
		Optional<Orders> order1 = iOrderRepository.findById(id);
		if (order1.isEmpty())
			throw new OrderServiceException("Order not found");

		return order1.get();
	}
	/****************************
	 * Method                           :getAllOrders
	 * Description                      :To fetch all the orders from the database
	 *@returns List<Orders>             - returns orders after fetching from the database 
	 * @throws OrderServiceException   - It is raised when orders are not found
	 * CreatedBy                        - Leya Varghese
	 * Created Date                     - 23-MAR-2021
	 ****************************/
	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		List<Orders> order = iOrderRepository.findAll();
		if (order.isEmpty())
			throw new OrderServiceException("Orders not found");
		return order;
	}

}
