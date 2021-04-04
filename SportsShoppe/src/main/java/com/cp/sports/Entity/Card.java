package com.cp.sports.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class Card {
	@Id
	private Long id;
	@Column(name = "card_name")
	private String cardName;
	@Column(name = "card_number")
	private String cardNumber;
	@Column(name = "expiry_date")
	private LocalDate expiryDate;
	@Column(name = "bank_name")
	private String bankName;

	public Card() {
		super();
	}

	public Card(Long id,String cardName, String cardNumber, LocalDate expiryDate, String bankName) {
		super();
		this.id=id;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.bankName = bankName;
	}
	

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	
	
	@Override
	public String toString() {
		return "Card [id=" + id + ", cardName=" + cardName + ", cardNumber=" + cardNumber + ", expiryDate=" + expiryDate
				+ ", bankName=" + bankName + "]";
	}

	
}
