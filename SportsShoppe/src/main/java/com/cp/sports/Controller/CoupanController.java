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
public class CoupanController {
	@Autowired
	private ICoupanService iCoupanService;

	@PostMapping("/coupan")
	public ResponseEntity<Coupan> insertCoupan(@RequestBody Coupan coupan){
		Coupan resultcoupan = iCoupanService.addCoupans(coupan);
		return new ResponseEntity<Coupan>(resultcoupan,HttpStatus.OK);
	}
	
	@DeleteMapping("/coupan/{id}")
	public void deleteCoupan(@PathVariable String id) throws CoupanServiceException{
	iCoupanService.removeCoupans(id);
	}
	
	@PutMapping("/coupan")
	public ResponseEntity<Coupan> editCoupans(@RequestBody Coupan coupan) {
		Coupan resultCustomer = iCoupanService.editCoupans(coupan.getCoupanId(),coupan);
		return new ResponseEntity<Coupan>(resultCustomer, HttpStatus.OK);
	}
	
	@GetMapping("/coupan/{id}")
	public ResponseEntity<Coupan> findCoupan(@PathVariable String id) throws CoupanServiceException{
		Coupan resultCoupan = iCoupanService.getCoupan(id);
		return new ResponseEntity<Coupan>(resultCoupan, HttpStatus.OK);
	}
	
	@GetMapping("/coupan/all")
	public ResponseEntity<List<Coupan>> getAllCoupan(){
		List<Coupan> resultCoupan = iCoupanService.getAllCoupans();
		return new ResponseEntity<List<Coupan>>(resultCoupan, HttpStatus.OK);
	}
	

	
	
}
