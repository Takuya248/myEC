package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.util.DoubleCheck;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoEntryAction extends ActionSupport implements SessionAware{


	public String pageFlg;
	public String newLoginId;
	public String newPassword;
	public String newUserName;
	public String newPhoneNumber;
	public String newMailAddress;
	public String newAddress;

	public Map<String, Object> session;

	private DoubleCheck doubleCheck = new DoubleCheck();

	public boolean checkFlg;


	public String execute(){

		checkFlg = doubleCheck.idDoubleCheck(newLoginId);

		String result;

		if(checkFlg){

			result = ERROR;

		}else{

			session.put("newLoginId", newLoginId);
			session.put("newPassword", newPassword);
			session.put("newUserName", newUserName);
			session.put("newPhoneNumber", newPhoneNumber);
			session.put("newMailAddress", newMailAddress);

			if(!(newLoginId.equals("")) && !(newPassword.equals("")) && !(newUserName.equals("")) && !(newPhoneNumber.equals("")) && !(newMailAddress.equals(""))){
				result = SUCCESS;
			}else{
				result = ERROR;
			}
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


	public boolean getCheckFlg() {
		return checkFlg;
	}


	public void setCheckFlg(boolean checkFlg) {
		this.checkFlg = checkFlg;
	}


	public String getNewAddress() {
		return newAddress;
	}


	public void setNewAddress(String newAddress) {
		this.newAddress = newAddress;
	}


	public String getPageFlg() {
		return pageFlg;
	}


	public void setPageFlg(String pageFlg) {
		this.pageFlg = pageFlg;
	}




}
