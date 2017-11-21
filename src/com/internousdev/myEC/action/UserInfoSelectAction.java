package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.UserAddressDAO;
import com.internousdev.myEC.dao.UserInfoDAO;
import com.internousdev.myEC.dto.LoginDTO;
import com.internousdev.myEC.dto.UserAddressDTO;
import com.internousdev.myEC.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoSelectAction extends ActionSupport implements SessionAware{

	public LoginDTO loginDTO = new LoginDTO();
	public UserInfoDTO userInfoDTO = new UserInfoDTO();
	public UserAddressDTO userAddressDTO = new UserAddressDTO();

	public String updateField;
	public String oldValue;
	public String fieldName;

	public Map<String, Object> session;



	public String execute(){
		String result = SUCCESS;

		UserInfoDAO userInfoDAO = new UserInfoDAO();
		UserAddressDAO userAddressDAO = new UserAddressDAO();

		userInfoDTO = userInfoDAO.getUserInfo(((LoginDTO)session.get("loginUser")).getId());
		userAddressDTO = userAddressDAO.getUserAddress(((LoginDTO)session.get("loginUser")).getId());

		switch(updateField){

		case "login_id":
			fieldName = "ログインID";
			oldValue = userInfoDTO.getLoginId();
			break;

		case "login_pass":
			fieldName = "ログインパスワード";
			//oldValue =
			break;

		case "user_name":
			fieldName = "名前";
			oldValue = userInfoDTO.getUserName();
			break;

		case "mail_add":
			fieldName = "メールアドレス";
			oldValue = userInfoDTO.getUserMailAddress();
			break;

		case "phone_number":
			fieldName = "電話番号";
			oldValue = userAddressDTO.getPhoneNumber();
			break;
		case "address":
			fieldName = "住所";
			oldValue = userAddressDTO.getState() + " " + userAddressDTO.getCity() + " " + userAddressDTO.getStreet() + " " + userAddressDTO.getBuilding() + " " + userAddressDTO.getZipCode();
			break;
		}

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
