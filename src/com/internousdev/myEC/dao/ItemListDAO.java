package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.myEC.dto.ItemInfoDTO;
import com.internousdev.myEC.util.DBConnector;

public class ItemListDAO{

	public ArrayList<ItemInfoDTO> getItemInfo(String category){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		ArrayList<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();

		try{
			String sql = "SELECT * FROM item_info WHERE category_id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, category);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				ItemInfoDTO itemInfoDTO = new ItemInfoDTO();



				itemInfoDTO.setItemId(resultSet.getInt("id"));
				itemInfoDTO.setCategoryId(resultSet.getString("category_id"));
				itemInfoDTO.setItemName(resultSet.getString("item_name"));
				itemInfoDTO.setItemPrice(resultSet.getInt("item_price"));
				itemInfoDTO.setItemStock(resultSet.getInt("item_stock"));

				itemList.add(itemInfoDTO);
			}

			connection.close();

		}catch(SQLException e){
			e.printStackTrace();

		}
		return itemList;

	}


}
