package com.internousdev.myEC.dto;

public class LoginDTO {

	private int userId;
	private String loginId;
	private boolean loginFlg = false;




	public void setLoginId(String loginId){
		this.loginId = loginId;
	}

	public String getLoginId(){
		return loginId;
	}


	public int getId() {
		return userId;
	}

	public void setId(int userId) {
		this.userId = userId;
	}

	public void setLoginFlg(boolean loginFlg){
		this.loginFlg = loginFlg;
	}

	public boolean getLoginFlg(){
		return loginFlg;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


}
