package com.cp.sports.Entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

/****************************
 * @author Leya Varghese 
 * Description It is entity class for the Order module
 * Version 1.0 
 * Created Date 23-March-2021
 ****************************/
@Entity
public class Orders {
	@Id

	private String OrderId;
	private double amount;
	private LocalDate billingDate;
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name="userId",referencedColumnName = "userId")
	private Customer customer;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(String orderId, double amount, LocalDate billingDate, Customer customer) {
		super();
		OrderId = orderId;
		this.amount = amount;
		this.billingDate = billingDate;
		this.customer = customer;
	}

	public String getOrderId() {
		return OrderId;
	}

	public void setOrderId(String orderId) {
		OrderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Orders [OrderId=" + OrderId + ", amount=" + amount + ", billingDate=" + billingDate + ", customer="
				+ customer + "]";
	}

}
