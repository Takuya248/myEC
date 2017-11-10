package com.internousdev.myEC.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.DBUserCartListDAO;
import com.internousdev.myEC.dto.CartItemDTO;
import com.internousdev.myEC.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartListAction extends ActionSupport implements SessionAware{


	public CartItemDTO cartItemDTO = new CartItemDTO();
	public ItemInfoDTO itemInfoDTO = new ItemInfoDTO();

	public DBUserCartListDAO dbUserCartListDAO = new DBUserCartListDAO();



	public Map<String, Object> session;

public String execute(){

	ArrayList<ItemInfoDTO> cartItemInfoList = new ArrayList<>();

	if(session.containsKey("loginUser")){



	}else{

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

}
