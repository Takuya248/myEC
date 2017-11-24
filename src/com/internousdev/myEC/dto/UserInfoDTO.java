package com.internousdev.myEC.dto;

public class UserInfoDTO {

	private String UserName;
	private String LoginId;
	private String UserMailAddress;
	private String RegistrationDate;



	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserMailAddress() {
		return UserMailAddress;
	}
	public void setUserMailAddress(String userMailAddress) {
		UserMailAddress = userMailAddress;
	}

	public String getRegistrationDate() {
		return RegistrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		RegistrationDate = registrationDate;
	}
	public String getLoginId() {
		return LoginId;
	}
	public void setLoginId(String loginId) {
		LoginId = loginId;
	}


}
