package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dto.PaymentUserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GuestUserInfoConfirmAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	public PaymentUserInfoDTO paymentUserInfoDTO = new PaymentUserInfoDTO();

	public String userName;
	public String mailAddress;
	public String phoneNumber;
	public String state;
	public String city;
	public String street;
	public String building;
	public String zipCode;

	public String execute(){

		paymentUserInfoDTO.setUserName(userName);
		paymentUserInfoDTO.setUserMailAddress(mailAddress);
		paymentUserInfoDTO.setUserPhoneNumber(phoneNumber);
		paymentUserInfoDTO.setState(state);
		paymentUserInfoDTO.setCity(city);
		paymentUserInfoDTO.setStreet(street);
		paymentUserInfoDTO.setBuilding(building);
		paymentUserInfoDTO.setZipCode(Integer.parseInt(zipCode));

		session.put("guestUserInfo", paymentUserInfoDTO);

		String result = SUCCESS;
		return result;

	}



	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getMailAddress() {
		return mailAddress;
	}



	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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



	public String getZipCode() {
		return zipCode;
	}



	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}



	public PaymentUserInfoDTO getPaymentUserInfoDTO() {
		return paymentUserInfoDTO;
	}



	public void setPaymentUserInfoDTO(PaymentUserInfoDTO paymentUserInfoDTO) {
		this.paymentUserInfoDTO = paymentUserInfoDTO;
	}



}
