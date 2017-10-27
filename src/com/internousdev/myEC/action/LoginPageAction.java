package com.internousdev.myEC.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginPageAction extends ActionSupport{

	public String result;

	public String execute(){
		result = SUCCESS;

		return result;
	}

}
