package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.LoginDAO;
import com.internousdev.myEC.dao.UserInfoUpdateDAO;
import com.internousdev.myEC.dto.LoginDTO;
import com.internousdev.myEC.util.DoubleCheck;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoUpdateCompleteAction extends ActionSupport implements SessionAware{


	public Map<String, Object> session;



	public String updateField;
	public String newValue;
	public boolean checkFlg;





	public String execute(){
		LoginDTO loginDTO = new LoginDTO();
		LoginDAO loginDAO = new LoginDAO();

		DoubleCheck doubleCheck = new DoubleCheck();
		UserInfoUpdateDAO userInfoUpdateDAO = new UserInfoUpdateDAO();

		String result = null;


		switch(updateField){
		case "login_id":

			checkFlg = doubleCheck.idDoubleCheck(newValue);

			if(checkFlg){
				result = ERROR;

			}else{
				result = SUCCESS;

				userInfoUpdateDAO.userInfoUpdate(updateField, newValue, ((LoginDTO)session.get("loginUser")).getUserId());
				((LoginDTO)session.get("loginUser")).setLoginId(newValue);


			}

			break;

		case "login_pass":
			result = SUCCESS;

			userInfoUpdateDAO.userInfoUpdate(updateField, newValue, ((LoginDTO)session.get("loginUser")).getUserId());
			session.put("loginPassword", newValue);

			break;

		case "user_name":
			result = SUCCESS;

			userInfoUpdateDAO.userInfoUpdate(updateField, newValue, ((LoginDTO)session.get("loginUser")).getUserId());


			break;

		case "mail_add":
			result = SUCCESS;

			userInfoUpdateDAO.userInfoUpdate(updateField, newValue, ((LoginDTO)session.get("loginUser")).getUserId());

			break;

		}

		loginDTO = loginDAO.getLoginUserInfo(((LoginDTO)session.get("loginUser")).getUserId());
		session.put("loginUser", loginDTO);

		return result;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public boolean getCheckFlg() {
		return checkFlg;
	}

	public void setCheckFlg(boolean checkFlg) {
		this.checkFlg = checkFlg;
	}



}
