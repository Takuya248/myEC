package com.internousdev.myEC.dto;

public class LoginDTO {

	private String loginId;
	private String loginPassword;
	private String userName;
	private boolean loginFlg;


	public void setLoginId(String loginId){
		this.loginId = loginId;
	}

	public String getLoginId(){
		return loginId;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	public String getLoginPassWord(){
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

}
