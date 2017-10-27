package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.UserInfoUpdateDAO;
import com.internousdev.myEC.util.DoubleCheck;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoUpdateCompleteAction extends ActionSupport implements SessionAware{

	public UserInfoUpdateDAO userInfoUpdateDAO = new UserInfoUpdateDAO();
	public Map<String, Object> session;

	private DoubleCheck doubleCheck = new DoubleCheck();

	public String newValue;


	public String execute(){
		String result;

		if((String)session.get("updateField") == "login_id"){


			if(doubleCheck.idDoubleCheck((String)session.get("newValue"))){

				result = ERROR;

			}else{

				result = SUCCESS;

				session.put("newValue", newValue);

				int successUpdate = userInfoUpdateDAO.userInfoUpdate((String)session.get("updateField"), (String)session.get("newValue"), (String)session.get("oldValue"));

				System.out.println(successUpdate);
			}


		}else{

			result = SUCCESS;

			session.put("newValue", newValue);

			int successUpdate = userInfoUpdateDAO.userInfoUpdate((String)session.get("updateField"), (String)session.get("newValue"), (String)session.get("oldValue"));

			System.out.println(successUpdate);
		}

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



}
