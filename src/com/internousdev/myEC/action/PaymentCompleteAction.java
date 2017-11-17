package com.internousdev.myEC.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.GetUserAddressInfoDAO;
import com.internousdev.myEC.dao.PaymentUserInfoDAO;
import com.internousdev.myEC.dao.UserInfoDAO;
import com.internousdev.myEC.dto.PaymentUserInfoDTO;
import com.internousdev.myEC.dto.UserAddressDTO;
import com.internousdev.myEC.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PaymentCompleteAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	public PaymentUserInfoDTO paymentUserInfoDTO = new PaymentUserInfoDTO();
	public PaymentUserInfoDAO paymentUserInfoDAO = new PaymentUserInfoDAO();

	public String execute(){

		if((boolean)session.get("loginFlg")){
			UserInfoDAO userInfoDAO = new UserInfoDAO();
			GetUserAddressInfoDAO getUserAddressInfoDAO = new GetUserAddressInfoDAO();

			UserInfoDTO userInfoDTO = userInfoDAO.getPaymentUserInfo((int)session.get("userId"));
			UserAddressDTO userAddressDTO = getUserAddressInfoDAO.getAddressInfo((int)session.get("userId"));

			paymentUserInfoDTO.setUserId((int)session.get("userId"));
			paymentUserInfoDTO.setCartId((int)Math.random() * 1000);
			paymentUserInfoDTO.setUserName(userInfoDTO.getUserName());
			paymentUserInfoDTO.setUserMailAddress(userInfoDTO.getUserMailAddress());
			paymentUserInfoDTO.setUserPhoneNumber(userInfoDTO.getUserPhoneNumber());
			paymentUserInfoDTO.setState(userAddressDTO.getState());
			paymentUserInfoDTO.setCity(userAddressDTO.getCity());
			paymentUserInfoDTO.setStreet(userAddressDTO.getStreet());
			paymentUserInfoDTO.setBuilding(userAddressDTO.getBuilding());
			paymentUserInfoDTO.setZipCode(userAddressDTO.getZipCode());
			paymentUserInfoDTO.setSelectedPayment((String)session.get("howToPay"));

			paymentUserInfoDAO.insertInfo(paymentUserInfoDTO);


		}else{

			paymentUserInfoDAO.insertInfo((PaymentUserInfoDTO)session.get("guetUserInfo"));



		}

		String result = SUCCESS;
		return result;

	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}
