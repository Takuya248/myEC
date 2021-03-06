package com.internousdev.myEC.dto;

public class UserAddressDTO {

	private int userId = 0;
	private String phoneNumber = "";
	private String state = "";
	private String city = "";
	private String street = "";
	private String building = "";
	private int zipCode = 0;
	private boolean addressRegiFlg = false;




	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isAddressRegiFlg() {
		return addressRegiFlg;
	}
	public void setAddressRegiFlg(boolean addressRegiFlg) {
		this.addressRegiFlg = addressRegiFlg;
	}



}
