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

import com.cp.sports.Entity.Coupan;
import com.cp.sports.Exception.CoupanServiceException;
import com.cp.sports.Service.ICoupanService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Swagger2DemoRestController")
@RequestMapping("/sport")
//Class Level Comment
/****************************
* @author Hari Chandana 
* Description It is a Controller class that provides the
*         Handler methods for adding new coupans
* Version 1.0 
* Created Date 22-March-2021
****************************/
public class CoupanController {
	@Autowired
	private ICoupanService iCoupanService;
	/****************************
	 * Method : insertCoupan 
	 * Description : To add the coupan to the database
	 * 
	 * @param coupan      - coupan to be added to the database
	 * @param RequestBody - It maps the HttpRequest body to a transfer or domain
	 *                    object, enabling automatic deserialization of the inbound
	 *                    HttpRequest body onto a Java object.
	 * @returns Coupan - returns coupan after adding the coupan to database
	 * @throws CoupanServiceException - It is raised when coupan already exists
	 *                                CreatedBy - A.Hari Chandana Created Date -
	 *                                24-MAR-2021
	 ****************************/
	@PostMapping("/coupan")
	public ResponseEntity<Coupan> insertCoupan(@RequestBody Coupan coupan){
		Coupan resultcoupan = iCoupanService.addCoupans(coupan);
		return new ResponseEntity<Coupan>(resultcoupan,HttpStatus.OK);
	}
	/****************************
	 * Method : deleteCoupan 
	 * Description : To delete the coupan from the database
	 * @param coupan       - coupan is deleting from the database
	 * @param PathVariable - It maps the HttpRequest body to a transfer or domain
	 *                     object, enabling automatic deserialization of the inbound
	 *                     HttpRequest body onto a Java object.
	 * @returns void - returns void
	 * @throws CoupanServiceException - It is raised when coupan already exists
	 *                                CreatedBy - A.Hari Chandana Created Date -
	 *                                24-MAR-2021
	 ****************************/
	@DeleteMapping("/coupan/{id}")
	public void deleteCoupan(@PathVariable String id) throws CoupanServiceException{
	iCoupanService.removeCoupans(id);
	}
	/****************************
	 * Method : editCoupans
	 * Description : To update the coupan in the database
	 * @param coupan - coupan to be updated
	 * @returns Coupan - returns coupan after updating the coupan to database
	 * @throws CoupanServiceException - It is raised when coupan not found CreatedBy
	 *                                - A.Hari Chandana Created Date - 23-MAR-2021
	 ****************************/
	@PutMapping("/coupan")
	public ResponseEntity<Coupan> editCoupans(@RequestBody Coupan coupan) {
		Coupan resultCustomer = iCoupanService.editCoupans(coupan.getCoupanId(),coupan);
		return new ResponseEntity<Coupan>(resultCustomer, HttpStatus.OK);
	}
	/****************************
	 * Method : findCoupan Description : To find the coupan from the database using
	 * id
	 * 
	 * @param coupan - To fetch the coupan from the database
	 * @returns Coupan - returns coupan after fetching the database
	 * @throws CoupanServiceException - It is raised when coupan does not exists
	 *                                CreatedBy - A.Hari Chandana Created Date -
	 *                                23-MAR-2021
	 ****************************/
	@GetMapping("/coupan/{id}")
	public ResponseEntity<Coupan> findCoupan(@PathVariable String id) throws CoupanServiceException{
		Coupan resultCoupan = iCoupanService.getCoupan(id);
		return new ResponseEntity<Coupan>(resultCoupan, HttpStatus.OK);
	}
	/****************************
	 * Method : getAllCoupan 
	 * Description : To get all the coupan from the database
	 * 
	 * @returns List<Coupan> - returns coupans after fetching the database
	 * @throws CoupanServiceException - It is raised when coupan does not found
	 *                                CreatedBy - A.Hari Chandana Created Date -
	 *                                23-MAR-2021
	 ****************************/
	@GetMapping("/coupan/all")
	public ResponseEntity<List<Coupan>> getAllCoupan(){
		List<Coupan> resultCoupan = iCoupanService.getAllCoupans();
		return new ResponseEntity<List<Coupan>>(resultCoupan, HttpStatus.OK);
	}
	

	
	
}
