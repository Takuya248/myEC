package com.internousdev.myEC.action;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.LoginDAO;
import com.internousdev.myEC.dao.UserInfoInsertDAO;
import com.internousdev.myEC.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoInsertAction extends ActionSupport implements SessionAware{


	public Map<String, Object> session;
	public LoginDTO loginDTO = new LoginDTO();
	public LoginDAO loginDAO = new LoginDAO();



	public String execute(){

		String result = "gotoMypage";
		UserInfoInsertDAO userInfoInsertDAO = new UserInfoInsertDAO();

		userInfoInsertDAO.infoInsert(session.get("newLoginId").toString(), session.get("newPassword").toString(), session.get("newUserName").toString(), session.get("newPhoneNumber").toString(), session.get("newMailAddress").toString());

		String loginId = (String)session.get("newLoginId");
		String loginPassword = (String)session.get("newPassword");

		loginDTO = loginDAO.getLoginUserInfo(loginId,loginPassword);


		session.put("loginId", loginDTO.getLoginId());
		session.put("loginPassword", loginDTO.getLoginPassword());
		session.put("userName", loginDTO.getUserName());
		session.put("mailAddress", loginDTO.getMailAddress());
		session.put("phoneNumber", loginDTO.getPhoneNumber());
		session.put("regiDate", loginDTO.getRegiDate());
		session.put("loginFlg", loginDTO.getLoginFlg());

		session.put("loginUser",loginDTO);

		if((String)session.get("pageTransition") == "cart"){

			result = "gotoPayment";
			session.put("pageTransition", "settlement");

		}

		return result;
	}


	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
