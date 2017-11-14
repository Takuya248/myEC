package com.internousdev.myEC.dto;

public class CartInfoDTO {

	private int totalPrice = 0;
	private int totalItemStack = 0;


	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getTotalItemStack() {
		return totalItemStack;
	}
	public void setTotalItemStack(int totalItemStack) {
		this.totalItemStack = totalItemStack;
	}



}
