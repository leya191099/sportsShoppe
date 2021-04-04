package com.cp.sports.Service;

import java.util.List;

import com.cp.sports.Entity.Payment;


public interface IPaymentService {
	public Payment addPayment(Payment payment);

	public Payment removePayment(long id);

	public Payment updatePayment(long id, Payment payment);

	public Payment getPaymentDetails(long id);

	public List<Payment> getAllPaymentDetails();
}
