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

public class CartRemoveAction extends ActionSupport implements SessionAware{

	public DBUserCartListDAO dbUserCartListDAO = new DBUserCartListDAO();
	public CartItemDTO cartItemDTO = new CartItemDTO();
	public CartInfoDTO cartInfoDTO = new CartInfoDTO();
	public ItemInfoDTO itemInfoDTO = new ItemInfoDTO();
	public CartItemCount cartItemCount = new CartItemCount();
	public GetCartItemInfoList getCartItemInfoList = new GetCartItemInfoList();

	public ArrayList<CartItemDTO> cart = new ArrayList<>();
	public ArrayList<ItemInfoDTO> itemInfoList = new ArrayList<ItemInfoDTO>();

	public Map<String, Object> session;

	public int removeIndex;



	@SuppressWarnings("unchecked")
	public String execute(){





		if(session.containsKey("loginUser")){

			//ログイン中のカート内アイテム処理

			//ログイン中ユーザーのカートをDBから取り出す
			LoginDTO loginDTO = (LoginDTO)session.get("loginUser");
			cart = dbUserCartListDAO.getDBCartList(loginDTO.getId());

			dbUserCartListDAO.deletCartData(loginDTO.getId(), cart.get(removeIndex).getItemId());

			cart.remove(removeIndex);

			itemInfoList = getCartItemInfoList.getItemInfo(cart);
			cartInfoDTO = cartItemCount.itemCount(itemInfoList);


			dbUserCartListDAO.updateCartData(cart, loginDTO.getId());
			session.put("cart", cart);


		}else{
			cart = (ArrayList<CartItemDTO>)session.get("cart");

			cart.remove(removeIndex);

			itemInfoList = getCartItemInfoList.getItemInfo(cart);
			cartInfoDTO = cartItemCount.itemCount(itemInfoList);

			session.put("cart", cart);
		}

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
