package com.cp.sports.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
/**********
 * @author G. Jhansi 
 * Description It is entity class for the Address module
 * Version 1.0 
 * Created Date 23-March-2021
 **********/
public class Address {
@Id
	private String doorNo;
	private String street;
	private String area;
	private String city;
	private String state;
	private int pincode;
	public Address(String doorNo, String street, String area, String city, String state, int pincode) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", street=" + street + ", area=" + area + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + "]";
	}
	
}
