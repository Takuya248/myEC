package com.internousdev.myEC.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.DBUserCartListDAO;
import com.internousdev.myEC.dao.GetCartItemInfoListDAO;
import com.internousdev.myEC.dao.GetOrderListDAO;
import com.internousdev.myEC.dao.GetUserAddressInfoDAO;
import com.internousdev.myEC.dao.PaymentCompletedCartDAO;
import com.internousdev.myEC.dao.PaymentGuestuserInfoDAO;
import com.internousdev.myEC.dao.UserInfoDAO;
import com.internousdev.myEC.dto.CartItemDTO;
import com.internousdev.myEC.dto.ItemInfoDTO;
import com.internousdev.myEC.dto.LoginDTO;
import com.internousdev.myEC.dto.PaymentUserInfoDTO;
import com.internousdev.myEC.dto.UserAddressDTO;
import com.internousdev.myEC.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PaymentCompleteAction extends ActionSupport implements SessionAware{

	public ArrayList<CartItemDTO> orderList = new ArrayList<CartItemDTO>();
	public ArrayList<ItemInfoDTO> itemInfoList = new ArrayList<ItemInfoDTO>();


	public Map<String, Object> session;
	public PaymentUserInfoDTO paymentUserInfoDTO = new PaymentUserInfoDTO();
	public PaymentGuestuserInfoDAO paymentGuestuserInfoDAO = new PaymentGuestuserInfoDAO();

	public UserInfoDAO userInfoDAO = new UserInfoDAO();
	public GetCartItemInfoListDAO getCartItemInfoListDAO = new GetCartItemInfoListDAO();
	public GetUserAddressInfoDAO getUserAddressInfoDAO = new GetUserAddressInfoDAO();
	public PaymentCompletedCartDAO paymentCompletedCartDAO = new PaymentCompletedCartDAO();
	public DBUserCartListDAO dbUserCartListDAO = new DBUserCartListDAO();
	public GetOrderListDAO getOrderListDAO = new GetOrderListDAO();




	@SuppressWarnings("unchecked")
	public String execute(){

		int userId = 0;


		if(session.containsKey("loginUser")){
			if(((LoginDTO)session.get("loginUser")).getLoginFlg()){

				userId = ((LoginDTO)session.get("loginUser")).getId();

				paymentCompletedCartDAO.insetCartInfo(userId, dbUserCartListDAO.getDBCartList(userId),(String)session.get("howToPay"));

				UserInfoDAO userInfoDAO = new UserInfoDAO();
				GetUserAddressInfoDAO getUserAddressInfoDAO = new GetUserAddressInfoDAO();

				UserInfoDTO userInfoDTO = userInfoDAO.getPaymentUserInfo(userId);
				UserAddressDTO userAddressDTO = getUserAddressInfoDAO.getAddressInfo(userId);

				paymentUserInfoDTO.setUserId(userId);
				paymentUserInfoDTO.setUserName(userInfoDTO.getUserName());
				paymentUserInfoDTO.setUserMailAddress(userInfoDTO.getUserMailAddress());
				paymentUserInfoDTO.setUserPhoneNumber(userAddressDTO.getPhoneNumber());
				paymentUserInfoDTO.setState(userAddressDTO.getState());
				paymentUserInfoDTO.setCity(userAddressDTO.getCity());
				paymentUserInfoDTO.setStreet(userAddressDTO.getStreet());
				paymentUserInfoDTO.setBuilding(userAddressDTO.getBuilding());
				paymentUserInfoDTO.setZipCode(userAddressDTO.getZipCode());
				paymentUserInfoDTO.setSelectedPayment((String)session.get("howToPay"));

				orderList = dbUserCartListDAO.getDBCartList(userId);
			}

		}else{
			paymentUserInfoDTO = (PaymentUserInfoDTO)session.get("guestUserInfo");

			userId  = paymentUserInfoDTO.getUserId();

			paymentGuestuserInfoDAO.insertInfo(paymentUserInfoDTO);
			paymentCompletedCartDAO.insetCartInfo(userId, (ArrayList<CartItemDTO>)session.get("cart"), (String)session.get("howToPay"));

			orderList = getOrderListDAO.getOrderList(userId);
		}

		itemInfoList = getCartItemInfoListDAO.getItemInfo(orderList);


		String result = SUCCESS;
		return result;

	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<CartItemDTO> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<CartItemDTO> orderList) {
		this.orderList = orderList;
	}

	public ArrayList<ItemInfoDTO> getItemInfoList() {
		return itemInfoList;
	}

	public void setItemInfoList(ArrayList<ItemInfoDTO> itemInfoList) {
		this.itemInfoList = itemInfoList;
	}

	public PaymentUserInfoDTO getPaymentUserInfoDTO() {
		return paymentUserInfoDTO;
	}

	public void setPaymentUserInfoDTO(PaymentUserInfoDTO paymentUserInfoDTO) {
		this.paymentUserInfoDTO = paymentUserInfoDTO;
	}



}
