package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.LoginDAO;
import com.internousdev.myEC.dao.UserAddressDAO;
import com.internousdev.myEC.dao.UserInfoDAO;
import com.internousdev.myEC.dto.LoginDTO;
import com.internousdev.myEC.dto.UserAddressDTO;
import com.internousdev.myEC.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MypageAction extends ActionSupport implements SessionAware{

	public LoginDTO loginDTO = new LoginDTO();
	public UserInfoDTO userInfoDTO = new UserInfoDTO();
	public UserAddressDTO userAddressDTO = new UserAddressDTO();



	public UserInfoDAO userInfoDAO = new UserInfoDAO();
	public UserAddressDAO userAddressDAO = new UserAddressDAO();
	public LoginDAO loginDAO = new LoginDAO();
	private Map<String, Object> session;





	public String execute(){
		String result;

		loginDTO = (LoginDTO)session.get("loginUser");


		if(loginDTO.getLoginFlg()){
			result = SUCCESS;

			userInfoDTO = userInfoDAO.getUserInfo(((LoginDTO)session.get("loginUser")).getId());
			userAddressDTO = userAddressDAO.getUserAddress(((LoginDTO)session.get("loginUser")).getId());


		}else{
			result = ERROR;
		}


		return result;
	}





	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}





	public LoginDTO getLoginDTO() {
		return loginDTO;
	}





	public void setLoginDTO(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}





	public UserAddressDTO getUserAddressDTO() {
		return userAddressDTO;
	}





	public void setUserAddressDTO(UserAddressDTO userAddressDTO) {
		this.userAddressDTO = userAddressDTO;
	}

}
