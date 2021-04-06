package com.cp.sports.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.sports.dao.ICardRepository;
import com.cp.sports.dao.IPaymentRepository;
import com.cp.sports.Entity.Payment;
import com.cp.sports.Exception.PaymentServiceException;

@Service("paymentser")
@Transactional
/*********************************************************************************
 * @author      Pranathi Boyina 
 * Description  It is a service class that provides the
 *              services to add a payment, remove a payment, update a payment and
 *              get a payment, get all payments
 * Version      1.0 
 * Created Date 23-March-2021
 *********************************************************************************/
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private IPaymentRepository paymentRepository;
	@Autowired
	private ICardRepository cardRepository;
	/*******************************************************************************************
	 * Method                           : addPayment
	 * Description                      : To add the payment to the database
	 * @param payment                   - payment to be added to the database
	 * @returns payment                 - returns payment after adding the payment to database 
	 * @throws PaymenServiceException   - It is raised when payment already exists
	 * CreatedBy                        - Pranathi Boyina 
	 * Created Date                     - 23-MAR-2021
	 ********************************************************************************************/
	@Transactional
	public Payment addPayment(Payment payment) throws PaymentServiceException {
		Optional<Payment> Payment1 = paymentRepository.findById(payment.getPaymentId());
		if (Payment1.isEmpty()) {
			return paymentRepository.saveAndFlush(payment);
		} else {
			throw new PaymentServiceException("Payment already exists");
		}
	}
	/***********************************************************************************
	 * Method                           :removePayment
	 * Description                      :To remove the payment to the database
	 * @param payment                   - payment to be removed from the database
	 * @returns payment                 - returns payment which is removed
	 * @throws PaymentServiceException  - It is raised when payment does not exists
	 * CreatedBy                        - Pranathi Boyina
	 * Created Date                     - 23-MAR-2021
	 ************************************************************************************/
	@Override
	@Transactional
	public Payment removePayment(long id) throws PaymentServiceException {
		Optional<Payment> payment = paymentRepository.findById(id);
		if (payment.isEmpty()) {
			throw new PaymentServiceException("paymentId does not exist to delete");
		} else {
			Payment p = paymentRepository.getOne(id);
			paymentRepository.delete(payment.get());
			return payment.get();
		}
	}
	/******************************************************************************************
	 * Method                           : updatePayment
	 * Description                      : To update the payment in the database
	 * @param payment                   - Id in which to update and payment to be updated with
	 * @returns Payment                 - returns payment after adding the payment to database 
	 * @throws PaymentServiceException  - It is raised when payment not found
	 * CreatedBy                        - Pranathi Boyina
	 * Created Date                     - 23-MAR-2021
	 ******************************************************************************************/
	@Transactional
	public Payment updatePayment(long id, Payment payment) {
		Optional<Payment> payment1 = paymentRepository.findById(id);
		if (payment1.isEmpty()) {
			throw new PaymentServiceException("PaymentId not found");
		} else
			paymentRepository.saveAndFlush(payment);
		return payment;

	}
	/*****************************************************************************************
	 * Method                           :getPaymentDetails
	 * Description                      :To get the payment from the database
	 * @param paymentId                 -To fetch the payment from the database
	 * @returns Payment                 - returns payment after fetching from the database
	 * @throws PaymentServiceException  - It is raised when paymentId does not exists
	 * CreatedBy                        - Pranathi Boyina
	 * Created Date                     - 23-MAR-2021
	 ******************************************************************************************/
	@Transactional
	public Payment getPaymentDetails(long id) throws PaymentServiceException {
		// TODO Auto-generated method stub
		Optional<Payment> payment = paymentRepository.findById(id);
		if (payment.isEmpty()) {
			throw new PaymentServiceException("PaymentId does not exist");
		}
		return payment.get();
	}
	/******************************************************************************************	
	 * Method                           :getAllPaymentDetails
	 * Description                      :To get all the payment from the database
	 * @param null                      -
	 * @returns List<Payment>           - returns list of payments from the database 
	 * @throws PaymentServiceException  - It is raised when payments table is empty
	 * CreatedBy                        - Pranathi Boyina
	 * Created Date                     - 23-MAR-2021
	 *******************************************************************************************/
    @Transactional
	public List<Payment> getAllPaymentDetails() {
		// TODO Auto-generated method stub
		List<Payment> payment = paymentRepository.findAll();
		if (payment.isEmpty()) {
			throw new PaymentServiceException("Payments not found");
		}
		return payment;
	}

}
