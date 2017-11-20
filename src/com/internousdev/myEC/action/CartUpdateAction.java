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

public class CartUpdateAction extends ActionSupport implements SessionAware{

	public DBUserCartListDAO dbUserCartListDAO = new DBUserCartListDAO();
	public CartItemDTO cartItemDTO = new CartItemDTO();
	public CartInfoDTO cartInfoDTO = new CartInfoDTO();
	public ItemInfoDTO itemInfoDTO = new ItemInfoDTO();
	public CartItemCount cartItemCount = new CartItemCount();
	public GetCartItemInfoListDAO getCartItemInfoList = new GetCartItemInfoListDAO();

	public ArrayList<CartItemDTO> cart = new ArrayList<>();
	public ArrayList<ItemInfoDTO> itemInfoList = new ArrayList<ItemInfoDTO>();

	public Map<String, Object> session;

	public String listIndex;
	public int stackCountUpdate = 0;



	@SuppressWarnings("unchecked")
	public String execute(){

		int listIndexInt = Integer.parseInt(listIndex);

		if(session.containsKey("loginUser")){

			LoginDTO loginDTO = (LoginDTO)session.get("loginUser");
			cart = dbUserCartListDAO.getDBCartList(loginDTO.getId());
			cart.get(listIndexInt).setItemCount(stackCountUpdate);

			dbUserCartListDAO.updateCartData(cart.get(listIndexInt), loginDTO.getId());


			itemInfoList = getCartItemInfoList.getItemInfo(cart);
			cartInfoDTO = cartItemCount.itemCount(itemInfoList);


		}else{
			cart = (ArrayList<CartItemDTO>)session.get("cart");
			cart.get(listIndexInt).setItemCount(stackCountUpdate);

			itemInfoList = getCartItemInfoList.getItemInfo(cart);
			cartInfoDTO = cartItemCount.itemCount(itemInfoList);

		}

		session.put("cart", cart);

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
