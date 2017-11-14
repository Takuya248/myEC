package com.internousdev.myEC.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.DBUserCartListDAO;
import com.internousdev.myEC.dao.LoginDAO;
import com.internousdev.myEC.dto.CartItemDTO;
import com.internousdev.myEC.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

	private LoginDTO loginDTO = new LoginDTO();
	public LoginDAO loginDAO = new LoginDAO();

	public DBUserCartListDAO dbUserCartList = new DBUserCartListDAO();

	public String loginId;
	public String loginPassword;
	public String loginPasswordSc;



	@SuppressWarnings("unchecked")
	public String execute(){

		if(session.containsKey("loginFlg")){

			loginId = (String)session.get("loginId");
			loginPassword = (String)session.get("loginPassword");

		}

		loginDTO = loginDAO.getLoginUserInfo(loginId,loginPassword);

		String result = SUCCESS;



		session.put("loginId", loginDTO.getLoginId());
		session.put("loginPassword", loginDTO.getLoginPassword());
		session.put("userName", loginDTO.getUserName());
		session.put("mailAddress", loginDTO.getMailAddress());
		session.put("phoneNumber", loginDTO.getPhoneNumber());
		session.put("regiDate", loginDTO.getRegiDate());
		session.put("loginFlg", loginDTO.getLoginFlg());

		session.put("loginUser",loginDTO);


		if((boolean)session.get("loginFlg")){

			//loginPasswordSc = ((String)session.get("loginPassword")).replaceAll(".","*");

			if(session.containsKey("cart")){
				ArrayList<CartItemDTO> sessionCart = new ArrayList<CartItemDTO>();
				ArrayList<CartItemDTO> dbCartList = null;

				sessionCart = (ArrayList<CartItemDTO>)session.get("cart");
				dbCartList = dbUserCartList.getDBCartList(loginDTO.getId());

				if(dbCartList == null){
					dbUserCartList.insertCartData(sessionCart,loginDTO.getId());

				}
			}

		}else{
			result = ERROR;
		}



		System.out.println(session.get("loginFlg"));
		return result;
	}




	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public String getLoginPasswordSc() {
		return loginPasswordSc;
	}

	public void setLoginPasswordSc(String loginPasswordSc) {
		this.loginPasswordSc = loginPasswordSc;
	}


}
