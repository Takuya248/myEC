package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class HowToBuyAction extends ActionSupport implements SessionAware{

	public String select;
	public Map<String, Object> session;

	public String execute(){
		String result = ERROR;


		if(session.containsKey("loginUser")){

			result = "login";

		}else{
			switch(select){
			case "regi":

				result = "regi";
				session.put("pageTransition", "cart");
				break;

			case "notregi":

				result = "notregi";
				break;
			}
		}
		return result;

	}


	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public String getSelect() {
		return select;
	}


	public void setSelect(String select) {
		this.select = select;
	}



}
