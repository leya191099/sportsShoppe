package com.cp.sports.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
/****************************
 * @author Leya Varghese 
 * Description It is a Controller class that provides the
 *         Handler methods for manipulating the orders in the database 
 *Version 1.0 
 *Created Date 22-March-2021
 ****************************/
public class OrderController {

	@Autowired
	private IOrderService iOrderService;

	/****************************
	 * Method : addOrder 
	 * Description : To add the order to the database
	 * @param Orders      - order to be added to the database
	 * @param RequestBody - It maps the HttpRequest body to a transfer or domain object
	 * @PostMapping: It  is used to handle POST type of request method
	 * @returns Orders - returns order after adding the order to database 
	 * CreatedBy- Leya Varghese 
	 * Created Date -24-MAR-2021
	 ****************************/
	@PostMapping("/add")
	public ResponseEntity<Orders> addOrder(@RequestBody Orders order) {
		return new ResponseEntity<Orders>(iOrderService.addOrder(order),HttpStatus.OK);
	}

	/****************************
	 * Method : updateOrder 
	 * Description : To update the order in the database
	 * @param order - order to be updated
	 * @PutMapping:  It  is used to handle PUT type of request method
	 * @returns Orders - returns order after updating the order to database
	 * CreatedBy- Leya Varghese 
	 * Created Date - 23-MAR-2021
	 ****************************/
	@PutMapping("/update")
	public ResponseEntity<Orders> updateOrder(@RequestBody Orders order) {
		return new ResponseEntity<Orders>(iOrderService.updateOrder(order.getOrderId(), order), HttpStatus.OK);
	}

	/****************************
	 * Method : getOrderDetails 
	 * Description : To get the order from the database using id
	 * @param id- To fetch the order from the database with id
	 * @param PathVariable - It  is used for data passed in the URI and transfer its values to parameter variables.
	 * @GetMapping: It is used to is used to handle GET type of request method.
	 * @returns Orders - returns order after fetching from the database 
	 * CreatedBy -Leya Varghese 
	 * Created Date - 23-MAR-2021
	 ****************************/
	@GetMapping("/get/{id}")
	public ResponseEntity<Orders> getOrderDetails(@PathVariable String id) throws OrderServiceException {
		return new ResponseEntity<Orders>(iOrderService.getOrderDetails(id), HttpStatus.OK);
	}

	/****************************
	 * Method : removeOrder 
	 * Description : To remove the order from the database 
	 * @param id           - order with id is removed from the database
	 * @param PathVariable - It  is used for data passed in the URI and transfer its values to parameter variables.
	 * @DeleteMapping:It is used to handle DELETE type of request method.
	 * @returns Orders - returns null 
	 * CreatedBy - Leya Varghese 
	 * Created Date -24-MAR-2021
	 ****************************/
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Orders> removeOrder(@PathVariable String id) throws OrderServiceException {
		
		return new ResponseEntity<Orders>(iOrderService.removeOrder(id),HttpStatus.OK);
	}

	/****************************
	 * Method : getAllOrders 
	 * Description : To get all the orders from the database
	 * @GetMapping: It is used to is used to handle GET type of request method.
	 * @returns List<Orders> - returns list of orders after fetching the database
	 * CreatedBy - Leya Varghese 
	 * Created Date - 23-MAR-2021
	 ****************************/
	@GetMapping("/all")
	public ResponseEntity<List<Orders>> getAllOrders() {
		return new ResponseEntity<List<Orders>>(iOrderService.getAllOrders(), HttpStatus.OK);
	}

}
