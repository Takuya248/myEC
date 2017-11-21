package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.UserAddressDAO;
import com.internousdev.myEC.dao.UserInfoDAO;
import com.internousdev.myEC.dto.LoginDTO;
import com.internousdev.myEC.dto.UserAddressDTO;
import com.internousdev.myEC.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

	public LoginDTO loginDTO = new LoginDTO();
	public UserInfoDTO userInfoDTO = new UserInfoDTO();
	public UserAddressDTO userAddressDTO = new UserAddressDTO();



	public String execute(){

		String result = ERROR;

		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;

			UserInfoDAO userInfoDAO = new UserInfoDAO();
			UserAddressDAO userAddressDAO = new UserAddressDAO();

			userInfoDTO = userInfoDAO.getUserInfo(((LoginDTO)session.get("loginUser")).getId());
			userAddressDTO = userAddressDAO.getUserAddress(((LoginDTO)session.get("loginUser")).getId());


		}

		return result;

	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public UserInfoDTO getUserInfoDTO() {
		return userInfoDTO;
	}

	public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
		this.userInfoDTO = userInfoDTO;
	}

	public UserAddressDTO getUserAddressDTO() {
		return userAddressDTO;
	}

	public void setUserAddressDTO(UserAddressDTO userAddressDTO) {
		this.userAddressDTO = userAddressDTO;
	}

}
