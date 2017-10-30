package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoSelectAction extends ActionSupport implements SessionAware{

	public LoginDTO loginDTO = new LoginDTO();
	public String updateField;
	public Map<String, Object> session;

	public String oldValue;
	public String fieldName;


	public String execute(){
		String result = SUCCESS;

		loginDTO = (LoginDTO)session.get("loginUser");

		switch(updateField){

		case "login_id":
			fieldName = "ログインID";
			oldValue = loginDTO.getLoginId();
			break;

		case "login_pass":
			fieldName = "ログインパスワード";
			oldValue = loginDTO.getLoginPassword();
			break;

		case "user_name":
			fieldName = "名前";
			oldValue = loginDTO.getUserName();
			break;

		case "mail_add":
			fieldName = "メールアドレス";
			oldValue = loginDTO.getMailAddress();
			break;

		case "phone_number":
			fieldName = "電話番号";
			oldValue = loginDTO.getPhoneNumber();
			break;

		}

		session.put("oldValue", oldValue);
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


	public String getOldValue() {
		return oldValue;
	}


	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}


}
