package com.internousdev.myEC.dto;

public class ItemInfoDTO {

	private int itemId = 0;
	private String categoryId = "";
	private String itemName = "";
	private int itemPrice = 0;
	private int itemStock = 0;
	private int cartItemStack = 1;



	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemStock() {
		return itemStock;
	}
	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getCartItemStack() {
		return cartItemStack;
	}
	public void setCartItemStack(int cartItemStack) {
		this.cartItemStack = cartItemStack;
	}





}
