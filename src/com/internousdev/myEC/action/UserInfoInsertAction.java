package com.internousdev.myEC.action;


import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.DBUserCartListDAO;
import com.internousdev.myEC.dao.LoginDAO;
import com.internousdev.myEC.dao.UserInfoInsertDAO;
import com.internousdev.myEC.dto.CartItemDTO;
import com.internousdev.myEC.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoInsertAction extends ActionSupport implements SessionAware{


	public Map<String, Object> session;
	public LoginDTO loginDTO = new LoginDTO();
	public LoginDAO loginDAO = new LoginDAO();

	public String loginId;
	public String loginPassword;
	public String userName;
	public String mailAddress;
	public String submit;

	@SuppressWarnings("unchecked")
	public String execute(){

		String result = "gotoMypage";

		UserInfoInsertDAO userInfoInsertDAO = new UserInfoInsertDAO();


		//遷移先分岐
		switch(submit){
		case "confirm":

			result = "gotoMypage";
			userInfoInsertDAO.infoInsert(loginId, loginPassword, userName, mailAddress);

			loginDTO = loginDAO.getLoginUserInfo(loginId,loginPassword);
			session.put("loginUser",loginDTO);

			if((String)session.get("pageTransition") == "cart"){
				result = "gotoPayment";
				session.put("pageTransition", "cart");

				if(session.containsKey("cart")){
					DBUserCartListDAO dbUserCartListDAO = new DBUserCartListDAO();
					ArrayList<CartItemDTO> sessionCart = new ArrayList<CartItemDTO>();
					ArrayList<CartItemDTO> dbCartList = null;

					sessionCart = (ArrayList<CartItemDTO>)session.get("cart");
					dbCartList = dbUserCartListDAO.getDBCartList(loginDTO.getId());

					for(CartItemDTO sessionCartItemDTO : sessionCart){
						boolean addResult = false;

						for(CartItemDTO dbCartItemDTO : dbCartList){
							if(sessionCartItemDTO.getItemId() == dbCartItemDTO.getItemId()){

								dbCartItemDTO.setItemCount(dbCartItemDTO.getItemCount() + sessionCartItemDTO.getItemCount());
								dbUserCartListDAO.updateCartData(dbCartItemDTO, loginDTO.getId());

								addResult = true;
							}
						}

						if(!addResult){
							dbUserCartListDAO.insertCartData(sessionCartItemDTO, loginDTO.getId());

						}
					}
				}

			}

			break;

		case "return":
			result = "return";
			break;



		default :
			result = "return";
			break;

		}



		return result;
	}


	public void setSession(Map<String, Object> session){
		this.session = session;
	}


	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getMailAddress() {
		return mailAddress;
	}


	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}


	public String getLoginPassword() {
		return loginPassword;
	}


	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}


	public String getSubmit() {
		return submit;
	}


	public void setSubmit(String submit) {
		this.submit = submit;
	}

}
