package com.internousdev.myEC.dto;

public class LoginDTO {

	private int userId;
	private String loginId;
	private String loginPassword;
	private String userName;
	private String mailAddress;
	private String phoneNumber;
	private String regiDate;
	private boolean loginFlg = false;


	public String getRegiDate() {
		return regiDate;
	}

	public void setRegiDate(String regiDate) {
		this.regiDate = regiDate;
	}

	public void setLoginId(String loginId){
		this.loginId = loginId;
	}

	public String getLoginId(){
		return loginId;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}
	public int getId() {
		return userId;
	}

	public void setId(int userId) {
		this.userId = userId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}


	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setLoginFlg(boolean loginFlg){
		this.loginFlg = loginFlg;
	}

	public boolean getLoginFlg(){
		return loginFlg;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



}
