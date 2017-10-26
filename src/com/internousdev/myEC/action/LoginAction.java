package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.LoginDAO;
import com.internousdev.myEC.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

	private LoginDTO loginDTO = new LoginDTO();
	public LoginDAO loginDAO = new LoginDAO();

	public String loginId;
	public String loginPassword;
	public String userName;
	public String mailAddress;
	public String phoneNumber;
	public String regiDate;

	public String execute(){
		String result = (String)session.get("result");
		loginDTO = loginDAO.getLoginUserInfo(loginId,loginPassword);
		userName = loginDTO.getUserName();
		mailAddress = loginDTO.getMailAddress();
		phoneNumber = loginDTO.getPhoneNumber();
		regiDate = loginDTO.getRegiDate();

		session.put("loginId", loginId);
		session.put("loginPassword", loginPassword);
		session.put("userName", userName);
		session.put("mailAddress", mailAddress);
		session.put("phoneNumber", phoneNumber);
		session.put("regiDate", regiDate);

		session.put("loginUser",loginDTO);

		if(((LoginDTO)session.get("loginUser")).getLoginFlg() || session.get("result") == SUCCESS){
			result = SUCCESS;
			String loginPasswordSc = loginPassword.replaceAll(".","*");
			session.put("loginPassSc", loginPasswordSc);

		}else{
			result = ERROR;
		}


		session.put("result", result);
		return result;
	}




	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}


}
