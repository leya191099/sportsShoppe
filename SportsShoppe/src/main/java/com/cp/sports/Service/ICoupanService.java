package com.cp.sports.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cp.sports.Entity.Coupan;
import com.cp.sports.Exception.CoupanServiceException;

public interface ICoupanService {
	public Coupan addCoupans(Coupan coupan);

	public  Coupan editCoupans(String coupanId, Coupan coupan); 

	public  Coupan removeCoupans(String coupanId) throws CoupanServiceException;
	
	public Coupan getCoupan(String coupanId) throws CoupanServiceException;

	public List<Coupan> getAllCoupans();

}
