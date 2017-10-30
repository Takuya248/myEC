package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.UserInfoUpdateDAO;
import com.internousdev.myEC.dto.LoginDTO;
import com.internousdev.myEC.util.DoubleCheck;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoUpdateCompleteAction extends ActionSupport implements SessionAware{


	public UserInfoUpdateDAO userInfoUpdateDAO = new UserInfoUpdateDAO();
	public Map<String, Object> session;

	public LoginDTO loginDTO = new LoginDTO();

	private DoubleCheck doubleCheck = new DoubleCheck();

	public String newValue;
	public boolean checkFlg;





	public String execute(){

		String result = null;

		loginDTO = (LoginDTO)session.get("loginUser");


		if(session.get("updateField").equals("login_id")){

			checkFlg = doubleCheck.idDoubleCheck(newValue);

			if(checkFlg){
				result = ERROR;

			}else{
				result = SUCCESS;

				session.put("newValue", newValue);

				loginDTO.setLoginId(newValue);

				int succ = userInfoUpdateDAO.userInfoUpdate((String)session.get("updateField"), (String)session.get("newValue"), (String)session.get("loginId"), (String)session.get("loginPassword"));
				session.put("loginId", newValue);

				System.out.println(succ);
			}

		}else{
			switch((String)session.get("updateField")){

			case "login_pass":
				result = SUCCESS;

				session.put("newValue", newValue);

				loginDTO.setLoginPassword(newValue);

				userInfoUpdateDAO.userInfoUpdate((String)session.get("updateField"), (String)session.get("newValue"), (String)session.get("loginId"), (String)session.get("loginPassword"));
				session.put("loginPassword", newValue);

				break;

			case "user_name":
				result = SUCCESS;

				session.put("newValue", newValue);

				loginDTO.setUserName(newValue);

				userInfoUpdateDAO.userInfoUpdate((String)session.get("updateField"), (String)session.get("newValue"), (String)session.get("loginId"), (String)session.get("loginPassword"));
				session.put("userNmae", newValue);

				break;

			case "mail_add":
				result = SUCCESS;

				session.put("newValue", newValue);

				loginDTO.setMailAddress(newValue);

				userInfoUpdateDAO.userInfoUpdate((String)session.get("updateField"), (String)session.get("newValue"), (String)session.get("loginId"), (String)session.get("loginPassword"));
				session.put("mailAddress", newValue);

				break;

			case "phone_number":
				result = SUCCESS;

				session.put("newValue", newValue);

				loginDTO.setPhoneNumber(newValue);

				userInfoUpdateDAO.userInfoUpdate((String)session.get("updateField"), (String)session.get("newValue"), (String)session.get("loginId"), (String)session.get("loginPassword"));
				session.put("phoneNumber", newValue);

				break;

			}
		}

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
