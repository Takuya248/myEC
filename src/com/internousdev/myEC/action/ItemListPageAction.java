package com.internousdev.myEC.action;



import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.ItemListDAO;
import com.internousdev.myEC.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListPageAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	public String category = "all";
	public ArrayList<ItemInfoDTO> itemInfoList = new ArrayList<>();

	public String execute(){

		ItemListDAO itemListDAO = new ItemListDAO();

		ArrayList<ItemInfoDTO> itemDTOList = new ArrayList<ItemInfoDTO>();

		category="rod";
		itemDTOList = itemListDAO.getItemInfo(category);

		for(ItemInfoDTO  itemInfoDTO : itemDTOList){
			itemInfoList.add(itemInfoDTO);

		}

	String result = SUCCESS;

	return result;
}


	public ArrayList<ItemInfoDTO> getItemInfoList() {
		return itemInfoList;
	}


	public void setItemInfoList(ArrayList<ItemInfoDTO> itemInfoList) {
		this.itemInfoList = itemInfoList;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}



}
