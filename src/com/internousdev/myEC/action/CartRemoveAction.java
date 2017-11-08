package com.internousdev.myEC.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dto.CartItemDTO;
import com.internousdev.myEC.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartRemoveAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	public int removeIndex;


	@SuppressWarnings("unchecked")
	public String execute(){

		CartItemDTO cartItemDTO = new CartItemDTO();
		ArrayList<ItemInfoDTO> cartItemInfoList = (ArrayList<ItemInfoDTO>)session.get("cartItemInfoList");

		cartItemInfoList.remove(removeIndex);


		for(ItemInfoDTO itemInfoDTO: cartItemInfoList){
			cartItemDTO.setItemPrice(cartItemDTO.getItemPrice() + Integer.parseInt(itemInfoDTO.getItemPrice()) * itemInfoDTO.getCartItemStack());
			cartItemDTO.setItemStack(cartItemDTO.getItemStack() + itemInfoDTO.getCartItemStack());
		}


		session.put("cartItemDTO", cartItemDTO);
		session.put("cartItemInfoList", cartItemInfoList);


		String result = SUCCESS;

		return result;

	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getRemoveIndex() {
		return removeIndex;
	}

	public void setRemoveIndex(int removeIndex) {
		this.removeIndex = removeIndex;
	}

}
