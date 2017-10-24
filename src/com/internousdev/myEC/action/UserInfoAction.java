package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

	public String execute(){

		String result = ERROR;

		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			System.out.println(session.get("login_ID"));
			result = SUCCESS;

		}

		return result;

	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
