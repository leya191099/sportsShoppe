package com.cp.sports.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity

public class Coupan {
	@Id
	private String coupanId;
	private String coupanName;
	private String coupanType;
	private String coupanDescription;
	public Coupan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coupan(String coupanId, String coupanName, String coupanType, String coupanDescription) {
		super();
		this.coupanId = coupanId;
		this.coupanName = coupanName;
		this.coupanType = coupanType;
		this.coupanDescription = coupanDescription;
	}
	@Override
	public String toString() {
		return "Coupan [coupanId=" + coupanId + ", coupanName=" + coupanName + ", coupanType=" + coupanType
				+ ", coupanDescription=" + coupanDescription + "]";
	}
	public String getCoupanId() {
		return coupanId;
	}
	public void setCoupanId(String coupanId) {
		this.coupanId = coupanId;
	}
	public String getCoupanName() {
		return coupanName;
	}
	public void setCoupanName(String coupanName) {
		this.coupanName = coupanName;
	}
	public String getCoupanType() {
		return coupanType;
	}
	public void setCoupanType(String coupanType) {
		this.coupanType = coupanType;
	}
	public String getCoupanDescription() {
		return coupanDescription;
	}
	public void setCoupanDescription(String coupanDescription) {
		this.coupanDescription = coupanDescription;
	}

}
