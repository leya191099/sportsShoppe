package com.cp.sports.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class IOrderDto {
@Id
@GeneratedValue
private int OrderId;
private double amount;
private LocalDate billingDate;
private int custId;
public IOrderDto() {
	super();
	// TODO Auto-generated constructor stub
}
public int getOrderId() {
	return OrderId;
}
public void setOrderId(int orderId) {
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
public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}
@Override
public String toString() {
	return "IOrderDto [OrderId=" + OrderId + ", amount=" + amount + ", billingDate=" + billingDate + ", custId="
			+ custId + "]";
}
public IOrderDto(int orderId, double amount, LocalDate billingDate, int custId) {
	super();
	OrderId = orderId;
	this.amount = amount;
	this.billingDate = billingDate;
	this.custId = custId;
}

}
