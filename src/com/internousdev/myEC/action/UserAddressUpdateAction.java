package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.UserAddressDAO;
import com.internousdev.myEC.dto.LoginDTO;
import com.internousdev.myEC.dto.UserAddressDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserAddressUpdateAction extends ActionSupport implements SessionAware{

	public String phoneNumber;
	public String state;
	public String city;
	public String street;
	public String building;
	public String zipCode;
	public UserAddressDTO userAddressDTO = new UserAddressDTO();

	public Map<String, Object> session;

	public String execute(){

		UserAddressDAO userAddressDAO = new UserAddressDAO();

		String result = SUCCESS;

		userAddressDTO.setPhoneNumber(phoneNumber);
		userAddressDTO.setState(state);
		userAddressDTO.setCity(city);
		userAddressDTO.setStreet(street);
		userAddressDTO.setBuilding(building);
		userAddressDTO.setZipCode(Integer.parseInt(zipCode));
		userAddressDTO.setUserId(((LoginDTO)session.get("loginUser")).getId());

		userAddressDAO.updateAddress(userAddressDTO);


		return result;

	}


	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}
