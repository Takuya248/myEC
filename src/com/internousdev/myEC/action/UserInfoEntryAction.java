package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserInfoEntryAction extends ActionSupport implements SessionAware{

	public String newLoginId;
	public String newPassword;
	public String newUserName;
	public String newPhoneNumber;
	public String newMailAddress;

	public Map<String, Object> session;



	public String execute(){

		String result = ERROR;

		session.put("newLoginId_session", newLoginId);
		session.put("newPassword", newPassword);
		session.put("newUserName", newUserName);
		session.put("newPhoneNumber", newPhoneNumber);
		session.put("newMailAddress", newMailAddress);

		if(!(newLoginId.equals("")) && !(newPassword.equals("")) && !(newUserName.equals("")) && !(newPhoneNumber.equals("")) && !(newMailAddress.equals(""))){
			result = SUCCESS;
			System.out.println(session.get("newLoginId"));
		}else{
			result = ERROR;
		}
		return result;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getNewLoginId() {
		return newLoginId;
	}
	public void setNewLoginId(String newLoginId) {
		this.newLoginId = newLoginId;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getNewUserName() {
		return newUserName;
	}
	public void setNewUserName(String newUserName) {
		this.newUserName = newUserName;
	}
	public String getNewPhoneNumber() {
		return newPhoneNumber;
	}
	public void setNewPhoneNumber(String newPhoneNumber) {
		this.newPhoneNumber = newPhoneNumber;
	}
	public String getNewMailAddress() {
		return newMailAddress;
	}
	public void setNewMailAddress(String newMailAddress) {
		this.newMailAddress = newMailAddress;
	}


}
