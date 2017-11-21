package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dto.UserCreateDTO;
import com.internousdev.myEC.util.DoubleCheck;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoEntryAction extends ActionSupport implements SessionAware{


	public String pageFlg;
	public String newLoginId;
	public String newPassword;
	public String newUserName;
	public String newMailAddress;

	public UserCreateDTO userCreateDTO = new UserCreateDTO();

	public Map<String, Object> session;

	private DoubleCheck doubleCheck = new DoubleCheck();

	public boolean checkFlg;


	public String execute(){

		checkFlg = doubleCheck.idDoubleCheck(newLoginId);

		String result;

		if(checkFlg){

			result = ERROR;

		}else{

			userCreateDTO.setLoginId(newLoginId);
			userCreateDTO.setPassword(newPassword);
			userCreateDTO.setUserName(newUserName);
			userCreateDTO.setMailAddress(newMailAddress);


			if(newLoginId == "" && newPassword == "" && newUserName == "" && newMailAddress == ""){
				result = ERROR;
			}else{
				result = SUCCESS;
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




	public String getPageFlg() {
		return pageFlg;
	}


	public void setPageFlg(String pageFlg) {
		this.pageFlg = pageFlg;
	}


	public UserCreateDTO getUserCreateDTO() {
		return userCreateDTO;
	}


	public void setUserCreateDTO(UserCreateDTO userCreateDTO) {
		this.userCreateDTO = userCreateDTO;
	}




}
