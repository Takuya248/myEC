package com.internousdev.myEC.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.CartItemListDAO;
import com.internousdev.myEC.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	public String buyItemId;
	public CartItemListDAO cartItemListDAO = new CartItemListDAO();
	public ArrayList<ItemInfoDTO> cartItemInfoList = new ArrayList<>();


		@SuppressWarnings("unchecked")
		public String execute(){



			ArrayList<String> cartValue = new ArrayList<>();
			Map<String, Integer> cartItemList = new HashMap<>();
			int itemCount = 0;

			//セッションにカート情報があればリストに入れる
			if(session.containsKey("cartItemInfoList")){
				cartValue = (ArrayList<String>)session.get("cartValue");
				}

			cartValue.add(buyItemId);


			for(String s: cartValue){

				if(cartItemList.containsKey(s)){
					itemCount = cartItemList.get(s) + 1;
				}else{
					itemCount = 1;
				}

				cartItemList.put(s, itemCount);

			}



			for(Entry<String, Integer> entry: cartItemList.entrySet()){
				ItemInfoDTO itemInfoDTO = new ItemInfoDTO();

				itemInfoDTO = cartItemListDAO.getItemInfo(entry.getKey());
				itemInfoDTO.setCartItemStack(entry.getValue());

				cartItemInfoList.add(itemInfoDTO);
			}

			session.put("cartValue", cartValue);
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


	public String getBuyItemId() {
		return buyItemId;
	}


	public void setBuyItemId(String buyItemId) {
		this.buyItemId = buyItemId;
	}


	public ArrayList<ItemInfoDTO> getCartItemInfoList() {
		return cartItemInfoList;
	}


	public void setCartItemInfoList(ArrayList<ItemInfoDTO> cartItemInfoList) {
		this.cartItemInfoList = cartItemInfoList;
	}



}
