package com.internousdev.myEC.dto;

public class ItemInfoDTO {

	private String categoryId;
	private String itemName;
	private String itemPrice;
	private String itemStock;


	public ItemInfoDTO(){}

	public ItemInfoDTO(String categoryId, String itemName, String itemPrice, String itemStock){
		this.categoryId = categoryId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemStock = itemStock;
	}



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



}
