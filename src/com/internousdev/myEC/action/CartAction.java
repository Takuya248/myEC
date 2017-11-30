package com.internousdev.myEC.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.DBUserCartListDAO;
import com.internousdev.myEC.dao.GetCartItemInfoListDAO;
import com.internousdev.myEC.dto.CartInfoDTO;
import com.internousdev.myEC.dto.CartItemDTO;
import com.internousdev.myEC.dto.ItemInfoDTO;
import com.internousdev.myEC.dto.LoginDTO;
import com.internousdev.myEC.util.CartItemCount;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{

	public DBUserCartListDAO dbUserCartListDAO = new DBUserCartListDAO();
	public CartItemDTO cartItemDTO = new CartItemDTO();
	public CartInfoDTO cartInfoDTO = new CartInfoDTO();
	public ItemInfoDTO itemInfoDTO = new ItemInfoDTO();
	public CartItemCount cartItemCount = new CartItemCount();
	public GetCartItemInfoListDAO getCartItemInfoList = new GetCartItemInfoListDAO();

	public Map<String, Object> session;

	public int buyItemId = 0;
	public ArrayList<CartItemDTO> cart = new ArrayList<CartItemDTO>();
	public ArrayList<ItemInfoDTO> itemInfoList = new ArrayList<ItemInfoDTO>();


	@SuppressWarnings("unchecked")
	public String execute(){




		//ログイン状態確認
		if(session.containsKey("loginUser")){

			//ログイン中のカート内アイテム処理

			//ログイン中ユーザーのカートをDBから取り出す
			LoginDTO loginDTO = (LoginDTO)session.get("loginUser");
			cart = dbUserCartListDAO.getDBCartList(loginDTO.getId());


			//同じアイテムがカート内にあったらカートのアイテム数をカウント
			boolean incrementSuccess = false;


			for(CartItemDTO cartItemDTO : cart){
				if(cartItemDTO.getItemId() == buyItemId){
					cartItemDTO.setItemCount(cartItemDTO.getItemCount() + 1);
					dbUserCartListDAO.updateCartData(cartItemDTO, loginDTO.getId());

					incrementSuccess = true;
				}
			}

			if(!incrementSuccess && buyItemId != 0){
				CartItemDTO cartItemDTO = new CartItemDTO();
				cartItemDTO.setItemId(buyItemId);
				cart.add(cartItemDTO);

				dbUserCartListDAO.insertCartData(cartItemDTO, loginDTO.getId());
			}




		}else{
			if(session.containsKey("cart")){

				cart = (ArrayList<CartItemDTO>)session.get("cart");

				boolean incrementSuccess = false;

				for(CartItemDTO cartItemDTO : cart){
					if(cartItemDTO.getItemId() == buyItemId){
						cartItemDTO.setItemCount(cartItemDTO.getItemCount() + 1);

						incrementSuccess = true;
					}
				}

				if(!incrementSuccess && buyItemId != 0){
					CartItemDTO cartItemDTO = new CartItemDTO();
					cartItemDTO.setItemId(buyItemId);
					cart.add(cartItemDTO);
				}

			}else{
				CartItemDTO cartItemDTO = new CartItemDTO();
				cartItemDTO.setItemId(buyItemId);
				cart.add(cartItemDTO);
			}



			session.put("cart", cart);

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


	public int getBuyItemId() {
		return buyItemId;
	}


	public void setBuyItemId(int buyItemId) {
		this.buyItemId = buyItemId;
	}


	public CartInfoDTO getCartInfoDTO() {
		return cartInfoDTO;
	}


	public void setCartInfoDTO(CartInfoDTO cartInfoDTO) {
		this.cartInfoDTO = cartInfoDTO;
	}


	public ArrayList<CartItemDTO> getCart() {
		return cart;
	}


	public void setCart(ArrayList<CartItemDTO> cart) {
		this.cart = cart;
	}


	public ArrayList<ItemInfoDTO> getItemInfoList() {
		return itemInfoList;
	}


	public void setItemInfoList(ArrayList<ItemInfoDTO> itemInfoList) {
		this.itemInfoList = itemInfoList;
	}






}


