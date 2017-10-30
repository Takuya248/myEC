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
	public String loginPasswordSc;

	public String execute(){
		loginDTO = loginDAO.getLoginUserInfo(loginId,loginPassword);

		String result;

		session.put("loginId", loginDTO.getLoginId());
		session.put("loginPassword", loginDTO.getLoginPassword());
		session.put("userName", loginDTO.getUserName());
		session.put("mailAddress", loginDTO.getMailAddress());
		session.put("phoneNumber", loginDTO.getPhoneNumber());
		session.put("regiDate", loginDTO.getRegiDate());

		session.put("loginUser",loginDTO);


		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;
			loginPasswordSc = ((String)session.get("loginPassword")).replaceAll(".","*");


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

	public String getLoginPasswordSc() {
		return loginPasswordSc;
	}

	public void setLoginPasswordSc(String loginPasswordSc) {
		this.loginPasswordSc = loginPasswordSc;
	}


}
