package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoSelectAction extends ActionSupport implements SessionAware{

	public LoginDTO loginDTO = new LoginDTO();
	public String updateField;
	public Map<String, Object> session;

	public String fieldName;


	public String execute(){
		String result = SUCCESS;

		loginDTO = (LoginDTO)session.get("loginUser");

		switch(updateField){
		case "login_id":
			fieldName = "ログインID";
			session.put("oldValue", loginDTO.getLoginId());
			break;

		case "login_pass":
			session.put("oldValue", loginDTO.getLoginPassword());
			break;

		}
		session.put("updateField", updateField);

		return result;
	}


	public String getUpdateField() {
		return updateField;
	}

	public void setUpdateField(String updateField) {
		this.updateField = updateField;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public String getFieldName() {
		return fieldName;
	}


	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


}
