package com.internousdev.myEC.dto;

public class OrderListDTO {

	private int itemId = 0;
	private int orderId = 0;
	private String itemName = "";
	private int itemCount = 1;
	private int itemPrice = 0;
	private String selectPayment = "";
	private String insertDate = "";



	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getSelectPayment() {
		return selectPayment;
	}
	public void setSelectPayment(String selectPayment) {
		this.selectPayment = selectPayment;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}





}
