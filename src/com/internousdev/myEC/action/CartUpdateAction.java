package com.internousdev.myEC.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dto.CartItemDTO;
import com.internousdev.myEC.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartUpdateAction extends ActionSupport implements SessionAware{

	public CartItemDTO cartItemDTO = new CartItemDTO();
	public ItemInfoDTO itemInfoDTO = new ItemInfoDTO();
	public String listIndex;
	public int stackCountUpdate = 0;


	public ArrayList<ItemInfoDTO> cartItemInfoList = new ArrayList<>();

	public Map<String, Object> session;


	@SuppressWarnings("unchecked")
	public String execute(){


		ArrayList<ItemInfoDTO> cartItemInfoList = new ArrayList<>();
		int listIndexInt = Integer.parseInt(listIndex);

		cartItemInfoList = (ArrayList<ItemInfoDTO>)session.get("cartItemInfoList");
		cartItemInfoList.get(listIndexInt).setCartItemStack(stackCountUpdate);


		for(ItemInfoDTO itemInfoDTO: cartItemInfoList){

			cartItemDTO.setItemPrice(cartItemDTO.getItemPrice() + Integer.parseInt(itemInfoDTO.getItemPrice()) * itemInfoDTO.getCartItemStack());
			cartItemDTO.setItemStack(cartItemDTO.getItemStack() + itemInfoDTO.getCartItemStack());
		}


		session.put("cartItemDTO", cartItemDTO);
		session.put("cartItemInfoList", cartItemInfoList);

		String result = SUCCESS;
		return result;
	}


	public int getStackCountUpdate() {
		return stackCountUpdate;
	}

	public void setStackCountUpdate(int stackCountUpdate) {
		this.stackCountUpdate = stackCountUpdate;
	}

	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public String getListIndex() {
		return listIndex;
	}


	public void setListIndex(String listIndex) {
		this.listIndex = listIndex;
	}


	public ArrayList<ItemInfoDTO> getCartItemInfoList() {
		return cartItemInfoList;
	}


	public void setCartItemInfoList(ArrayList<ItemInfoDTO> cartItemInfoList) {
		this.cartItemInfoList = cartItemInfoList;
	}


}
