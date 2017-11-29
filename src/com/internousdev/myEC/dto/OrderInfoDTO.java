package com.internousdev.myEC.dto;

public class OrderInfoDTO {

	private int orderId = 0;
	private String insertDate = "";


	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}


}
