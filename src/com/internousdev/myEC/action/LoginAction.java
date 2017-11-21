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

	public DBUserCartListDAO dbUserCartListDAO = new DBUserCartListDAO();

	public int userId;
	public String loginId;
	public String loginPassword;



	@SuppressWarnings("unchecked")
	public String execute(){

		String result;

		if(session.containsKey("loginFlg")){

			userId = ((LoginDTO)session.get("loginUser")).getUserId();
			loginId = ((LoginDTO)session.get("loginUser")).getLoginId();


			result = SUCCESS;

		}else{
			loginDTO = loginDAO.getLoginUserInfo(loginId,loginPassword);

			session.put("userId", loginDTO.getId());
			session.put("loginId", loginDTO.getLoginId());
			session.put("loginFlg", loginDTO.getLoginFlg());

			session.put("loginUser",loginDTO);


		}

		if((boolean)session.get("loginFlg")){

			if(session.containsKey("cart")){
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

			result = SUCCESS;

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

}
