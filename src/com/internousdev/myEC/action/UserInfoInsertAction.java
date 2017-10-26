package com.internousdev.myEC.action;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.UserInfoInsertDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoInsertAction extends ActionSupport implements SessionAware{


	public Map<String, Object> session;

	private String result;

	public String execute(){

		UserInfoInsertDAO userInfoInsertDAO = new UserInfoInsertDAO();

		userInfoInsertDAO.infoInsert(session.get("newLoginId").toString(), session.get("newPassword").toString(), session.get("newUserName").toString(), session.get("newPhoneNumber").toString(), session.get("newMailAddress").toString());

		result = SUCCESS;

		return result;
	}


	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
