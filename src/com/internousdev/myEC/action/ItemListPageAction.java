package com.internousdev.myEC.action;



import java.util.ArrayList;
import java.util.List;

import com.internousdev.myEC.dao.ItemListDAO;
import com.internousdev.myEC.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListPageAction extends ActionSupport{

	public List<String[]> itemInfoList = new ArrayList<String[]>();


	public String execute(){

		ItemListDAO itemListDAO = new ItemListDAO();

		String[] itemInfoValue = new String[2];

		List<ItemInfoDTO> itemDTOList = new ArrayList<>();

		itemDTOList = itemListDAO.getItemInfo("rod");

		for(ItemInfoDTO  itemInfoDTO : itemDTOList){
			itemInfoDTO = new ItemInfoDTO();
			int listCount = 0;
			int arrayCount = 0;

			itemInfoValue[0] = itemInfoDTO.getItemName();
			itemInfoValue[1] = itemInfoDTO.getItemPrice();
			itemInfoValue[2] = itemInfoDTO.getItemStock();
		}



	System.out.println((itemDTOList.get(1)).getItemName());

	String result = SUCCESS;

	return result;
}


	public List<String[]> getItemInfoList() {
		return itemInfoList;
	}


	public void setItemInfoList(List<String[]> itemInfoList) {
		this.itemInfoList = itemInfoList;
	}

}
