package com.internousdev.myEC.util;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dto.ItemInfoDTO;

public class CartDifferenceSerch implements SessionAware{

	public Map<String, Object> session;
	private ArrayList<ItemInfoDTO> cartItemInfoList;

	public ArrayList<ItemInfoDTO> differenceSerch(ArrayList<ItemInfoDTO> cartItemInfoList){

		this.cartItemInfoList = cartItemInfoList;




		return cartItemInfoList;
	}





	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
