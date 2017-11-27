package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dto.UserAddressDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AddressEditConfirmAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	public UserAddressDTO userAddressDTO = new UserAddressDTO();

	public String phoneNumber;
	public String state;
	public String city;
	public String street;
	public String building;
	public String zipCode;

	public String execute(){



		userAddressDTO.setState(phoneNumber);
		userAddressDTO.setState(state);
		userAddressDTO.setCity(city);
		userAddressDTO.setStreet(street);
		userAddressDTO.setBuilding(building);
		userAddressDTO.setZipCode(Integer.parseInt(zipCode));

		session.put("userAddressDTO", userAddressDTO);

		String result = SUCCESS;
		return result;


	}




	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
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




	public UserAddressDTO getUserAddressDTO() {
		return userAddressDTO;
	}




	public void setUserAddressDTO(UserAddressDTO userAddressDTO) {
		this.userAddressDTO = userAddressDTO;
	}



}
