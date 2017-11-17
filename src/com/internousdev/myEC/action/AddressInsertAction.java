package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.UserAddressDAO;
import com.internousdev.myEC.dto.UserAddressDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AddressInsertAction extends ActionSupport implements SessionAware{

	public UserAddressDAO userAddresDAO = new UserAddressDAO();

	public Map<String, Object> session;

	public String execute(){
		String result = ERROR;

		UserAddressDTO userAddressDTO = new UserAddressDTO();

		userAddressDTO = (UserAddressDTO)session.get("userAddressDTO");

		if((boolean)session.get("loginFlg")){
			userAddressDTO.setUserId((int)session.get("userId"));
			userAddresDAO.insertDB(userAddressDTO);

		}

		switch((String)session.get("pageTransition")){
		case "settlement":
			result = "gotoPayment";
			break;
		default :
			result = SUCCESS;
			break;
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
