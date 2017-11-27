package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.UserInfoDAO;
import com.internousdev.myEC.dto.LoginDTO;
import com.internousdev.myEC.dto.UserAddressDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserAddressSelectAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	UserAddressDTO userAddressDTO = new UserAddressDTO();

	public String execute(){
		String result = ERROR;

		UserInfoDAO userInfoDAO = new UserInfoDAO();

		if(userInfoDAO.getAddressFlg(((LoginDTO)session.get("loginUser")).getId())){
			result = "gotoPayment";

		}else{
			result = "gotoAddInsert";

			session.put("pageTransition", "addSelect");
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
