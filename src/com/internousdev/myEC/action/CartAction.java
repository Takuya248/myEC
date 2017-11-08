package com.internousdev.myEC.action;

import java.util.ArrayList;
import java.util.Iterator;
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




			if(session.containsKey("cartItemInfoList")){
				cartItemInfoList = (ArrayList<ItemInfoDTO>)session.get("cartItemInfoList");

				boolean incrementSuccess = false;

				for(Iterator<ItemInfoDTO> iterator = cartItemInfoList.listIterator(); iterator.hasNext();){
					ItemInfoDTO itemInfoDTO = iterator.next();

					if(itemInfoDTO.getItemId().equals(buyItemId)){
						itemInfoDTO.setCartItemStack(itemInfoDTO.getCartItemStack() + 1);

						incrementSuccess = true;


					}else if(!iterator.hasNext() && !incrementSuccess){
						//cartItemInfoList.add(cartItemListDAO.getItemInfo(buyItemId));
						incrementSuccess = false;
					}

				}

				if(!incrementSuccess){
					cartItemInfoList.add(cartItemListDAO.getItemInfo(buyItemId));
				}

				for(ItemInfoDTO itemInfoDTO: cartItemInfoList){

					cartItemDTO.setItemPrice(cartItemDTO.getItemPrice() + Integer.parseInt(itemInfoDTO.getItemPrice()) * itemInfoDTO.getCartItemStack());
					cartItemDTO.setItemStack(cartItemDTO.getItemStack() + itemInfoDTO.getCartItemStack());
				}

			}else{
				cartItemInfoList.add(cartItemListDAO.getItemInfo(buyItemId));

				cartItemDTO.setItemPrice(Integer.parseInt(cartItemInfoList.get(0).getItemPrice())* cartItemInfoList.get(0).getCartItemStack());
				cartItemDTO.setItemStack(cartItemInfoList.get(0).getCartItemStack());

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


	public String getBuyItemId() {
		return buyItemId;
	}


	public void setBuyItemId(String buyItemId) {
		this.buyItemId = buyItemId;
	}


}
