package com.internousdev.myEC.util;

import java.util.ArrayList;

import com.internousdev.myEC.dto.CartInfoDTO;
import com.internousdev.myEC.dto.ItemInfoDTO;

public class CartItemCount {



	public CartInfoDTO itemCount(ArrayList<ItemInfoDTO> itemInfoList){
		CartInfoDTO cartInfoDTO = new CartInfoDTO();


		for(ItemInfoDTO itemInfoDTO: itemInfoList){
			cartInfoDTO.setTotalPrice(cartInfoDTO.getTotalPrice() + itemInfoDTO.getItemPrice() * itemInfoDTO.getCartItemStack());
			cartInfoDTO.setTotalItemStack(cartInfoDTO.getTotalItemStack() + itemInfoDTO.getCartItemStack());

		}
		return cartInfoDTO;

	}
}
