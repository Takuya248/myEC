package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.myEC.dto.CartItemDTO;
import com.internousdev.myEC.dto.ItemInfoDTO;
import com.internousdev.myEC.util.DBConnector;

public class GetCartItemInfoListDAO {

	public ArrayList<ItemInfoDTO> getItemInfo(ArrayList<CartItemDTO> cart){

		ArrayList<ItemInfoDTO> itemInfoList = new ArrayList<ItemInfoDTO>();

		try{
			for(CartItemDTO cartItemDTO : cart){
				DBConnector dbConnector = new DBConnector();
				Connection connection = dbConnector.getConnection();


				String sql = "SELECT * FROM item_info WHERE id = ?";

				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, cartItemDTO.getItemId());
				ResultSet resultSet = preparedStatement.executeQuery();

				if(resultSet.next()){
					ItemInfoDTO itemInfoDTO = new ItemInfoDTO();

					itemInfoDTO.setItemId(resultSet.getInt("id"));
					itemInfoDTO.setCategoryId(resultSet.getString("category_id"));
					itemInfoDTO.setItemName(resultSet.getString("item_name"));
					itemInfoDTO.setItemPrice(resultSet.getInt("item_price"));
					itemInfoDTO.setItemStock(resultSet.getInt("item_stock"));
					itemInfoDTO.setCartItemStack(cartItemDTO.getItemCount());

					itemInfoList.add(itemInfoDTO);
				}

				connection.close();
			}




		}catch(SQLException e){

			e.printStackTrace();
		}

		return itemInfoList;

	}
}
