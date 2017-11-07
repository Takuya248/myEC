package com.internousdev.myEC.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.CartItemListDAO;
import com.internousdev.myEC.dto.CartItemDTO;
import com.internousdev.myEC.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{

	public CartItemListDAO cartItemListDAO = new CartItemListDAO();
	public CartItemDTO cartItemDTO = new CartItemDTO();
	public Map<String, Object> session;
	public String buyItemId;
	public ArrayList<ItemInfoDTO> cartItemInfoList = new ArrayList<>();


		@SuppressWarnings("unchecked")
		public String execute(){



			//セッションにカート情報があればリストに入れる
			if(session.containsKey("cartItemInfoList")){
				cartItemInfoList = (ArrayList<ItemInfoDTO>)session.get("cartItemInfoList");
			}else{
				cartItemInfoList.add(cartItemListDAO.getItemInfo(buyItemId));
			}


			for(ItemInfoDTO itemInfoDTO: cartItemInfoList){
				if(itemInfoDTO.getItemId().equals(buyItemId)){
					itemInfoDTO.setCartItemStack(itemInfoDTO.getCartItemStack() + 1);

				}
			}
			cartItemDTO.setItemPrice(cartItemDTO.getItemPrice() + Integer.parseInt(itemInfoDTO.getItemPrice()) * itemInfoDTO.getCartItemStack());
			cartItemDTO.setItemStack(cartItemDTO.getItemStack() + itemInfoDTO.getCartItemStack());



/*
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

				int itemPrice = Integer.parseInt(itemInfoDTO.getItemPrice());
				cartItemDTO.setItemPrice(cartItemDTO.getItemPrice()+ itemPrice * entry.getValue());
				cartItemDTO.setItemStack(cartItemDTO.getItemStack() + entry.getValue());

			}
*/
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


	public String getBuyItemId() {
		return buyItemId;
	}


	public void setBuyItemId(String buyItemId) {
		this.buyItemId = buyItemId;
	}


}
