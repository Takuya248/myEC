package com.internousdev.myEC.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.DBUserCartListDAO;
import com.internousdev.myEC.dao.GetCartItemInfoList;
import com.internousdev.myEC.dto.CartInfoDTO;
import com.internousdev.myEC.dto.CartItemDTO;
import com.internousdev.myEC.dto.ItemInfoDTO;
import com.internousdev.myEC.dto.LoginDTO;
import com.internousdev.myEC.util.CartItemCount;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementAction extends ActionSupport implements SessionAware{
	public DBUserCartListDAO dbUserCartListDAO = new DBUserCartListDAO();
	public CartItemDTO cartItemDTO = new CartItemDTO();
	public CartInfoDTO cartInfoDTO = new CartInfoDTO();
	public ItemInfoDTO itemInfoDTO = new ItemInfoDTO();
	public CartItemCount cartItemCount = new CartItemCount();
	public GetCartItemInfoList getCartItemInfoList = new GetCartItemInfoList();

	public Map<String, Object> session;

	public ArrayList<CartItemDTO> cart = new ArrayList<CartItemDTO>();
	public ArrayList<ItemInfoDTO> itemInfoList = new ArrayList<ItemInfoDTO>();




	@SuppressWarnings("unchecked")
	public String execute(){

		if(session.containsKey("loginUser")){

			LoginDTO loginDTO = (LoginDTO)session.get("loginUser");
			cart = dbUserCartListDAO.getDBCartList(loginDTO.getId());

		}else{

				cart = (ArrayList<CartItemDTO>)session.get("cart");

		}

		itemInfoList = getCartItemInfoList.getItemInfo(cart);
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



	public CartInfoDTO getCartInfoDTO() {
		return cartInfoDTO;
	}



	public void setCartInfoDTO(CartInfoDTO cartInfoDTO) {
		this.cartInfoDTO = cartInfoDTO;
	}



	public ArrayList<ItemInfoDTO> getItemInfoList() {
		return itemInfoList;
	}



	public void setItemInfoList(ArrayList<ItemInfoDTO> itemInfoList) {
		this.itemInfoList = itemInfoList;
	}



}
