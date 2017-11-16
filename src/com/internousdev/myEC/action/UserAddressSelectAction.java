package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.GetUserAddressInfoDAO;
import com.internousdev.myEC.dto.UserAddressDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserAddressSelectAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	UserAddressDTO userAddressDTO = new UserAddressDTO();

	public String execute(){
		String result = SUCCESS;

		GetUserAddressInfoDAO getUserAddressInfoDAO = new GetUserAddressInfoDAO();

		userAddressDTO = getUserAddressInfoDAO.getAddressInfo((int)session.get("userId"));

		if(userAddressDTO != null){

			session.put("userAddress", userAddressDTO);
			result = "exists";


		}else{

			session.put("pageTransition", "settlement");
			result = "notExists";

		}



		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}
