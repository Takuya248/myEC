package com.internousdev.myEC.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.LoginDAO;
import com.internousdev.myEC.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session = new HashMap<>();

	private LoginDTO loginDTO = new LoginDTO();
	public LoginDAO loginDAO = new LoginDAO();

	public String loginId;
	public String loginPassword;


	public String execute(){

		String result = ERROR;

		loginDTO = loginDAO.getLoginUserInfo(loginId,loginPassword);

		if((LoginDTO)session.)
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public Map<String,Object> getSession(){
		return session;
	}
}
