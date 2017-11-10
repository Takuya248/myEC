package com.internousdev.myEC.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.CartItemListDAO;
import com.internousdev.myEC.dao.DBUserCartListDAO;
import com.internousdev.myEC.dto.CartItemDTO;
import com.internousdev.myEC.dto.ItemInfoDTO;
import com.internousdev.myEC.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartRemoveAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	public int removeIndex;

	public CartItemListDAO cartItemListDAO = new CartItemListDAO();
	public DBUserCartListDAO dbUserCartListDAO = new DBUserCartListDAO();

	@SuppressWarnings("unchecked")
	public String execute(){


		CartItemDTO cartItemDTO = new CartItemDTO();
		ArrayList<ItemInfoDTO> cartItemInfoList = new ArrayList<ItemInfoDTO>();


		if(session.containsKey("loginUser")){

			//ログイン中のカート内アイテム処理

			//ログイン中ユーザーのカートをDBから取り出す
			LoginDTO loginDTO = (LoginDTO)session.get("loginUser");
			cartItemInfoList = dbUserCartListDAO.getCartData(loginDTO.getId());

			cartItemInfoList.remove(removeIndex);

			dbUserCartListDAO.updateCartData(cartItemInfoList, loginDTO.getId());
			session.put("cartItemInfoList", cartItemInfoList);

			for(ItemInfoDTO itemInfoDTO: cartItemInfoList){
				cartItemDTO.setItemPrice(cartItemDTO.getItemPrice() + Integer.parseInt(itemInfoDTO.getItemPrice()) * itemInfoDTO.getCartItemStack());
				cartItemDTO.setItemStack(cartItemDTO.getItemStack() + itemInfoDTO.getCartItemStack());

			}

		}else{
			cartItemInfoList = (ArrayList<ItemInfoDTO>)session.get("cartItemInfoList");
			cartItemInfoList.remove(removeIndex);

			for(ItemInfoDTO itemInfoDTO: cartItemInfoList){
				cartItemDTO.setItemPrice(cartItemDTO.getItemPrice() + Integer.parseInt(itemInfoDTO.getItemPrice()) * itemInfoDTO.getCartItemStack());
				cartItemDTO.setItemStack(cartItemDTO.getItemStack() + itemInfoDTO.getCartItemStack());
			}

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
