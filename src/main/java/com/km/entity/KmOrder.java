package com.km.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KmOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	
	private String item;
	private String buyer;
	
	
	public int getorderId() {
		return orderId;
	}
	public void setorderId(int orderId) {
		this.orderId = orderId;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public KmOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KmOrder(String item, String buyer) {
		super();
		//this.id = id;
		this.item = item;
		this.buyer = buyer;
	}
	@Override
	public String toString() {
		return "Order [id=" + orderId + ", item=" + item + ", buyer=" + buyer + "]";
	}
	
	
}
