package com.internousdev.myEC.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.DBUserCartListDAO;
import com.internousdev.myEC.dao.GetCartItemInfoListDAO;
import com.internousdev.myEC.dao.GetUserAddressInfoDAO;
import com.internousdev.myEC.dao.UserInfoDAO;
import com.internousdev.myEC.dto.CartInfoDTO;
import com.internousdev.myEC.dto.CartItemDTO;
import com.internousdev.myEC.dto.ItemInfoDTO;
import com.internousdev.myEC.dto.LoginDTO;
import com.internousdev.myEC.dto.PaymentUserInfoDTO;
import com.internousdev.myEC.dto.UserAddressDTO;
import com.internousdev.myEC.dto.UserInfoDTO;
import com.internousdev.myEC.util.CartItemCount;
import com.opensymphony.xwork2.ActionSupport;

public class PaymentConfirmAction extends ActionSupport implements SessionAware{

	public CartItemCount cartItemCount = new CartItemCount();

	public GetCartItemInfoListDAO getCartItemInfoListDAO = new GetCartItemInfoListDAO();
	public DBUserCartListDAO dbUserCartListDAO = new DBUserCartListDAO();

	public PaymentUserInfoDTO paymentUserInfoDTO = new PaymentUserInfoDTO();
	public CartInfoDTO cartInfoDTO = new CartInfoDTO();
	public ArrayList<CartItemDTO> cart = new ArrayList<CartItemDTO>();
	public ArrayList<ItemInfoDTO> itemInfoList = new ArrayList<ItemInfoDTO>();
	public String howToPay;
	public String card;
	public Map<String, Object> session;


	@SuppressWarnings("unchecked")
	public String execute(){

		if(session.containsKey("loginUser")){
			if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
				UserInfoDAO userInfoDAO = new UserInfoDAO();
				GetUserAddressInfoDAO getUserAddressInfoDAO = new GetUserAddressInfoDAO();

				UserInfoDTO userInfoDTO = userInfoDAO.getPaymentUserInfo(((LoginDTO)session.get("loginUser")).getId());
				UserAddressDTO userAddressDTO = getUserAddressInfoDAO.getAddressInfo(((LoginDTO)session.get("loginUser")).getId());

				paymentUserInfoDTO.setUserId(((LoginDTO)session.get("loginUser")).getId());
				paymentUserInfoDTO.setUserName(userInfoDTO.getUserName());
				paymentUserInfoDTO.setUserMailAddress(userInfoDTO.getUserMailAddress());
				paymentUserInfoDTO.setUserPhoneNumber(userAddressDTO.getPhoneNumber());
				paymentUserInfoDTO.setState(userAddressDTO.getState());
				paymentUserInfoDTO.setCity(userAddressDTO.getCity());
				paymentUserInfoDTO.setStreet(userAddressDTO.getStreet());
				paymentUserInfoDTO.setBuilding(userAddressDTO.getBuilding());
				paymentUserInfoDTO.setZipCode(userAddressDTO.getZipCode());
				paymentUserInfoDTO.setSelectedPayment(howToPay);

				session.put("howToPay", howToPay);

				cart = dbUserCartListDAO.getDBCartList(((LoginDTO)session.get("loginUser")).getId());

			}

		}else{

			paymentUserInfoDTO = (PaymentUserInfoDTO)session.get("guestUserInfo");

			paymentUserInfoDTO.setUserId((int)(Math.random() * 1000));
			paymentUserInfoDTO.setSelectedPayment(howToPay);

			session.put("guestUserInfo", paymentUserInfoDTO);

			session.put("howToPay", howToPay);
			if(howToPay == "card"){

				System.out.println(card);


			}
			cart = (ArrayList<CartItemDTO>)session.get("cart");
		}

		itemInfoList = getCartItemInfoListDAO.getItemInfo(cart);
		cartInfoDTO = cartItemCount.itemCount(itemInfoList);

		String result = SUCCESS;

		return result;

	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public PaymentUserInfoDTO getPaymentUserInfoDTO() {
		return paymentUserInfoDTO;
	}

	public void setPaymentUserInfoDTO(PaymentUserInfoDTO paymentUserInfoDTO) {
		this.paymentUserInfoDTO = paymentUserInfoDTO;
	}

	public String getHowToPay() {
		return howToPay;
	}

	public void setHowToPay(String howToPay) {
		this.howToPay = howToPay;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public ArrayList<ItemInfoDTO> getItemInfoList() {
		return itemInfoList;
	}

	public void setItemInfoList(ArrayList<ItemInfoDTO> itemInfoList) {
		this.itemInfoList = itemInfoList;
	}

	public CartInfoDTO getCartInfoDTO() {
		return cartInfoDTO;
	}

	public void setCartInfoDTO(CartInfoDTO cartInfoDTO) {
		this.cartInfoDTO = cartInfoDTO;
	}



}
