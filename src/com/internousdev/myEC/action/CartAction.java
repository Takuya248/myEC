package com.internousdev.myEC.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.CartItemListDAO;
import com.internousdev.myEC.dao.DBUserCartListDAO;
import com.internousdev.myEC.dto.CartItemDTO;
import com.internousdev.myEC.dto.ItemInfoDTO;
import com.internousdev.myEC.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{

	public CartItemListDAO cartItemListDAO = new CartItemListDAO();
	public DBUserCartListDAO dbUserCartListDAO = new DBUserCartListDAO();
	public CartItemDTO cartItemDTO = new CartItemDTO();

	public Map<String, Object> session;
	public int buyItemId = 0;



	@SuppressWarnings("unchecked")
	public String execute(){

		ArrayList<ItemInfoDTO> cartItemInfoList = new ArrayList<>();


		//ログイン状態確認
		if(session.containsKey("loginUser")){

			//ログイン中のカート内アイテム処理

			//ログイン中ユーザーのカートをDBから取り出す
			LoginDTO loginDTO = (LoginDTO)session.get("loginUser");
			cartItemInfoList = dbUserCartListDAO.getCartData(loginDTO.getId());


			//同じアイテムがカート内にあったらカートのアイテム数をカウント
			boolean incrementSuccess = false;

			for(Iterator<ItemInfoDTO> iterator = cartItemInfoList.listIterator(); iterator.hasNext();){
				ItemInfoDTO itemInfoDTO = iterator.next();

				if(itemInfoDTO.getItemId() == buyItemId){
					itemInfoDTO.setCartItemStack(itemInfoDTO.getCartItemStack() + 1);

					incrementSuccess = true;

				}
			}

			if(!incrementSuccess && buyItemId == 0){
				cartItemInfoList.add(cartItemListDAO.getItemInfo(buyItemId));
			}

			dbUserCartListDAO.updateCartData(cartItemInfoList, loginDTO.getId());
			session.put("cartItemInfoList", cartItemInfoList);


			for(ItemInfoDTO itemInfoDTO: cartItemInfoList){

				cartItemDTO.setItemPrice(cartItemDTO.getItemPrice() + Integer.parseInt(itemInfoDTO.getItemPrice()) * itemInfoDTO.getCartItemStack());
				cartItemDTO.setItemStack(cartItemDTO.getItemStack() + itemInfoDTO.getCartItemStack());

			}

		}else{
			if(session.containsKey("cartItemInfoList")){

				cartItemInfoList = (ArrayList<ItemInfoDTO>)session.get("cartItemInfoList");

				boolean incrementSuccess = false;

				for(Iterator<ItemInfoDTO> iterator = cartItemInfoList.listIterator(); iterator.hasNext();){
					ItemInfoDTO itemInfoDTO = iterator.next();

					if(itemInfoDTO.getItemId() == buyItemId){
						itemInfoDTO.setCartItemStack(itemInfoDTO.getCartItemStack() + 1);

						incrementSuccess = true;

					}
				}

				//0なとき追加しない
				if(!incrementSuccess && buyItemId != 0){
					cartItemInfoList.add(cartItemListDAO.getItemInfo(buyItemId));
				}

			}else{
				cartItemInfoList.add(cartItemListDAO.getItemInfo(buyItemId));
			}

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


	public int getBuyItemId() {
		return buyItemId;
	}


	public void setBuyItemId(int buyItemId) {
		this.buyItemId = buyItemId;
	}


}


