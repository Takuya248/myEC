package com.internousdev.myEC.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class MypageAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session = new HashMap<>();

	public String execute(){

		String result = SUCCESS;

		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
