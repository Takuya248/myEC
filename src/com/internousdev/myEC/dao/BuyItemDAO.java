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
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				buyItemDTO.setId(resultSet.getInt("Id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
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
