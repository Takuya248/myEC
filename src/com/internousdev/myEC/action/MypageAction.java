package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.LoginDAO;
import com.internousdev.myEC.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MypageAction extends ActionSupport implements SessionAware{

	public LoginDTO loginDTO = new LoginDTO();
	public LoginDAO loginDAO = new LoginDAO();
	private Map<String, Object> session;





	public String execute(){
		String result;

		loginDTO = (LoginDTO)session.get("loginUser");


		if((boolean)session.get("loginFlg")){
			result = SUCCESS;

		}else{
			result = ERROR;
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
