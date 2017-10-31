package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginPageAction extends ActionSupport implements SessionAware{


	public Map<String, Object> session;


	public String execute(){

		String result;

		if(session.containsKey("loginFlg")){
			result = ERROR;

		}else{
			result = SUCCESS;

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
