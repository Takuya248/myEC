package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.myEC.dto.BuyItemDTO;
import com.internousdev.myEC.util.DBConnector;

public class BuyItemDAO {

	private BuyItemDTO buyItemDTO = new BuyItemDTO();
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public BuyItemDTO getBuyItemInfo(){

		String sql = "SELECT Id, item_name,item_price FROM item_info";

		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				buyItemDTO.setId(rs.getInt("Id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getString("item_price"));
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return buyItemDTO;

	}
	public BuyItemDTO getBuyItemDTO(){
		return buyItemDTO;
	}

}
