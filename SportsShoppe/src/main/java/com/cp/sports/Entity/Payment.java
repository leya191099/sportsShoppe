package com.cp.sports.Entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	@Id
	
	private long paymentId;
	@Column(name = "type")
	private String type;
	@Column(name = "status")
	private String status;
	

	@ManyToOne(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="card_id",referencedColumnName = "ID")
	private Card card;
	
	public Payment() {
		super();
	}

	public Payment(long paymentId,String type, String status,Card card) {
		super();
		this.card =card;
		this.paymentId=paymentId;
		this.type = type;
		this.status = status;
		
	}


	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", card=" + card + "]";
	}

}