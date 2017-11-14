package com.internousdev.myEC.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.myEC.dto.CartItemDTO;
import com.internousdev.myEC.util.DBConnector;
import com.internousdev.myEC.util.DateUtil;

public class DBUserCartListDAO implements Serializable{

	private DateUtil dateUtil = new DateUtil();

	public ArrayList<CartItemDTO> getDBCartList(int userId){

		ArrayList<CartItemDTO> cart = new ArrayList<CartItemDTO>();

		try{
			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();

			//左結合
			String sql = "SELECT item_id, item_count, item_price "
					+ "FROM cartitem_info LEFT OUTER JOIN item_info "
					+ "ON cartitem_info.item_id = item_info.id WHERE user_id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				CartItemDTO cartItemDTO = new CartItemDTO();

				cartItemDTO.setItemId(resultSet.getInt("item_id"));
				cartItemDTO.setItemCount(resultSet.getInt("item_count"));
				cartItemDTO.setItemPrice(resultSet.getInt("item_price"));

				cart.add(cartItemDTO);
			}

			connection.close();

		}catch(SQLException e){
			e.printStackTrace();
		}

		return cart;

	}


	public void insertCartData(ArrayList<CartItemDTO> cart, int userId){
		try{
			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();

			for(CartItemDTO cartItemDTO : cart){
				String sql = "INSERT INTO cartitem_info ( user_id, item_id, item_count, update_date ) VALUE ( ?, ?, ?, ? )";

				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, userId);
				preparedStatement.setInt(2, cartItemDTO.getItemId());
				preparedStatement.setInt(3, cartItemDTO.getItemCount());
				preparedStatement.setString(4, dateUtil.getDate());
				preparedStatement.execute();
			}
			connection.close();

		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void updateCartData(ArrayList<CartItemDTO> cart, int userId){

		try{
			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();
			for(CartItemDTO cartItemDTO : cart){



				String sql = "UPDATE cartitem_info SET item_count = ? WHERE user_id = ? AND item_id = ?";

				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, cartItemDTO.getItemCount());
				preparedStatement.setInt(2, userId);
				preparedStatement.setInt(3, cartItemDTO.getItemId());
				preparedStatement.executeUpdate();

			}

			connection.close();

		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void deletCartData(int userId,int itemId){
		try{
			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();

			String sql = "DELETE FROM cartitem_info WHERE user_id = ? AND item_id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, itemId);
			preparedStatement.executeUpdate();

			connection.close();

		}catch(SQLException e){
			e.printStackTrace();
		}


	}

}

