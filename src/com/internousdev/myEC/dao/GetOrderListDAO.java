package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.myEC.dto.CartItemDTO;
import com.internousdev.myEC.util.DBConnector;

public class GetOrderListDAO {

	public ArrayList<CartItemDTO> getOrderList(int userId){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		ArrayList<CartItemDTO> orderList = new ArrayList<CartItemDTO>();

		try{
			String sql = "SELECT * FROM order_list WHERE user_id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				CartItemDTO cartItemDTO = new CartItemDTO();

				cartItemDTO.setItemId(resultSet.getInt("item_id"));
				cartItemDTO.setItemCount(resultSet.getInt("item_count"));

				orderList.add(cartItemDTO);

			}

		}catch(SQLException e){
			e.printStackTrace();

		}
		return orderList;

	}

}
