package com.cp.sports.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.sports.Entity.Orders;
import com.cp.sports.Exception.OrderServiceException;
import com.cp.sports.Service.IOrderService;
import com.cp.sports.dto.IOrderDto;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Swagger2DemoRestController")
@RequestMapping("/sport")
public class OrderController {

	@Autowired
	private IOrderService iOrderService;
	
	@PostMapping("/order")
	public Orders addOrder(@RequestBody Orders order) {
		return iOrderService.addOrder(order);
	}
	
	@PutMapping("/order")
	public ResponseEntity<Orders> updateOrder(@RequestBody Orders order) {
		return new ResponseEntity<Orders>(iOrderService.updateOrder(order.getOrderId(), order),HttpStatus.OK);
	}
	@GetMapping("/order/{id}")
	public ResponseEntity<Orders> getOrderDetails(@PathVariable long id) throws OrderServiceException{
		return new ResponseEntity<Orders>(iOrderService.getOrderDetails(id),HttpStatus.OK);
	}
	@DeleteMapping("/order/{id}")
	public Orders removeOrder(@PathVariable long id) throws OrderServiceException {
		iOrderService.removeOrder(id);
		return null;
	}
	@GetMapping("/order/all")
	public ResponseEntity<List<Orders>> getAllOrders(){
		return new ResponseEntity<List<Orders>>(iOrderService.getAllOrders(),HttpStatus.OK);
	}
	

}
