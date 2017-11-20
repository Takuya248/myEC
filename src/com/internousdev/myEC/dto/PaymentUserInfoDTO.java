package com.internousdev.myEC.dto;

public class PaymentUserInfoDTO {
	private int userId = 0;
	private String UserName = "";
	private String UserMailAddress = "";
	private String UserPhoneNumber = "";
	private String state = "";
	private String city = "";
	private String street = "";
	private String building = "";
	private int zipCode = 0;
	public String selectedPayment = "";
	private String RegistrationDate = "";


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserMailAddress() {
		return UserMailAddress;
	}
	public void setUserMailAddress(String userMailAddress) {
		UserMailAddress = userMailAddress;
	}
	public String getUserPhoneNumber() {
		return UserPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		UserPhoneNumber = userPhoneNumber;
	}
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
	public String getRegistrationDate() {
		return RegistrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		RegistrationDate = registrationDate;
	}
	public String getSelectedPayment() {
		return selectedPayment;
	}
	public void setSelectedPayment(String selectedPayment) {
		this.selectedPayment = selectedPayment;
	}

}
