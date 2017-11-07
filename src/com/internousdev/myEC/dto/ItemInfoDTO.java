package com.internousdev.myEC.dto;

public class ItemInfoDTO {

	private String itemId = "";
	private String categoryId;
	private String itemName;
	private String itemPrice;
	private String itemStock;
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
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemStock() {
		return itemStock;
	}
	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public int getCartItemStack() {
		return cartItemStack;
	}
	public void setCartItemStack(int cartItemStack) {
		this.cartItemStack = cartItemStack;
	}





}
