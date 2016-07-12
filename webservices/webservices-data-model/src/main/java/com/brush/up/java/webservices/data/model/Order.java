package com.brush.up.java.webservices.data.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Order")
public class Order {
	
	 private long number;
	 private int itemCount;
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	


}