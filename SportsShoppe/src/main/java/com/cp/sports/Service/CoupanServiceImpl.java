package com.cp.sports.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cp.sports.Entity.Coupan;
import com.cp.sports.Exception.CoupanServiceException;
import com.cp.sports.dao.ICoupanRepository;



@Service
@Repository
@Transactional
public class CoupanServiceImpl implements ICoupanService{
	
	@Autowired
	public ICoupanRepository iCoupanRepository;
	
	@Override
	public Coupan addCoupans(Coupan coupan) {
		// TODO Auto-generated method stub
		Optional<Coupan> coupan1 = iCoupanRepository.findById(coupan.getCoupanId());
		if (coupan1.isEmpty()) {
			return iCoupanRepository.saveAndFlush(coupan);
		} else {
			throw new CoupanServiceException("Coupan already exists");
		}
	}

	
	@Override
	public Coupan editCoupans(String coupanId, Coupan coupan) {
		// TODO Auto-generated method stub
		Optional<Coupan> coupan1 = iCoupanRepository.findById(coupanId);
		if (coupan1.isEmpty()) {
			throw new CoupanServiceException("Coupan not found");
		}
		else
		iCoupanRepository.save(coupan);
		return coupan;
		
	}

	@Override
	public Coupan getCoupan(String coupanId) throws CoupanServiceException{
		// TODO Auto-generated method stub
		Optional<Coupan> coupan = iCoupanRepository.findById(coupanId);
		if (coupan.isEmpty()) {
			throw new CoupanServiceException("Given coupanId does not exist");
		}
		return coupan.get();
	}

	@Override
	public List<Coupan> getAllCoupans() {
		// TODO Auto-generated method stub
		List<Coupan> coupan = iCoupanRepository.findAll();
		if (coupan.isEmpty()) {
			throw new CoupanServiceException("Coupans not found");
		}
		return coupan;
	}


	@Override
	public Coupan removeCoupans(String coupanId) throws CoupanServiceException {
		Optional<Coupan> coupan = iCoupanRepository.findById(coupanId);
		if (coupan.isEmpty())
			throw new CoupanServiceException("coupanId does not exist to delete");
		else
			iCoupanRepository.delete(coupan.get());
		return null;
	}


	
}
