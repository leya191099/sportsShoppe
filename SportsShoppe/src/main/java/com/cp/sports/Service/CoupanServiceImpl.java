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
/****************************
 * @author A.Hari Chandana Description It is a service class that provides the
 *         services to add a coupan, remove a coupan, update a coupan and
 *         get a coupan
 * 
 *         Version 1.0 Created Date 24-March-2021
 ****************************/
public class CoupanServiceImpl implements ICoupanService{
	
	@Autowired
	public ICoupanRepository iCoupanRepository;
	/****************************
	 * Method                           :addCoupan
	 * Description                      :To add the coupan to the database
	 * @param coupan                    - coupan to be added to the database
	 * @returns Coupan                   - returns coupan after adding the coupan to database 
	 * @throws CoupanServiceException   - It is raised when coupan already exists
	 * CreatedBy                        - A.Hari Chandana 
	 * Created Date                     - 23-MAR-2021
	 ****************************/
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

	/****************************
	 * Method                           :editCoupan
	 * Description                      :To update the coupan in the database
	 * @param coupan                    - coupan to be updated
	 *@returns Coupan                   - returns coupan after adding the coupan to database 
	 * @throws CoupanServiceException   - It is raised when coupan not found
	 * CreatedBy                        - A.Hari Chandana 
	 * Created Date                     - 23-MAR-2021
	 ****************************/
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
	/****************************
	 * Method                           :getCoupan
	 * Description                      :To get the coupan from the database
	 * @param coupan                    -To fetch the coupan from the database
	 *@returns Coupan                   - returns coupan after fetching the database
	 * @throws CoupanServiceException - It is raised when coupan does not exists
	 * CreatedBy                        -A.Hari Chandana
	 * Created Date                     - 23-MAR-2021
	 ****************************/
	@Override
	public Coupan getCoupan(String coupanId) throws CoupanServiceException{
		// TODO Auto-generated method stub
		Optional<Coupan> coupan = iCoupanRepository.findById(coupanId);
		if (coupan.isEmpty()) {
			throw new CoupanServiceException("Given coupanId does not exist");
		}
		return coupan.get();
	}
	/****************************
	 * Method                           :getAllCoupans
	 * Description                      :To get all the coupans from the database
	 * @param coupan                    -To fetch all the coupans from the database
	 *@returns Coupan                   - returns coupans after fetching the database 
	 * @throws CoupanServiceException   - It is raised when coupan does not found
	 * CreatedBy                        - A.Hari Chandana
	 * Created Date                     - 23-MAR-2021
	 ****************************/
	@Override
	public List<Coupan> getAllCoupans() {
		// TODO Auto-generated method stub
		List<Coupan> coupan = iCoupanRepository.findAll();
		if (coupan.isEmpty()) {
			throw new CoupanServiceException("Coupans not found");
		}
		return coupan;
	}

	/****************************
	 * Method                           :removeCoupan 
	 * Description                      :To remove the coupan to the database
	 * @param coupan                    - coupan to be removed from the database
	 *@returns void                     - returns void
	 * @throws CoupanServiceException   - It is raised when coupan does not exists
	 * CreatedBy                        - A.Hari Chandana 
	 * Created Date                     - 23-MAR-2021
	 ****************************/
	@Override
	public Coupan removeCoupans(String coupanId) throws CoupanServiceException {
		Optional<Coupan> coupan = iCoupanRepository.findById(coupanId);
		if (coupan.isEmpty())
			throw new CoupanServiceException("coupanId does not exist to delete");
		else
			iCoupanRepository.delete(coupan.get());
		return coupan.get();
	}


	
}
